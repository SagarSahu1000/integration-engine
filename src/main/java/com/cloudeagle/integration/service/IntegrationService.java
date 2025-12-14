package com.cloudeagle.integration.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeagle.integration.client.GenericApiClient;
import com.cloudeagle.integration.entity.ApiEndpoint;
import com.cloudeagle.integration.entity.ExternalApp;
import com.cloudeagle.integration.entity.FieldMapping;
import com.cloudeagle.integration.entity.TempUser;
import com.cloudeagle.integration.repository.ApiEndpointRepository;
import com.cloudeagle.integration.repository.ExternalAppRepository;
import com.cloudeagle.integration.repository.FieldMappingRepository;
import com.cloudeagle.integration.repository.TempUserRepository;
import com.jayway.jsonpath.JsonPath;

@Service
public class IntegrationService {

    @Autowired
    ExternalAppRepository appRepo;
    @Autowired
    ApiEndpointRepository endpointRepo;
    @Autowired
    FieldMappingRepository mappingRepo;
    @Autowired
    TempUserRepository userRepo;
    @Autowired
    GenericApiClient client;

    public List<TempUser> fetchUsers(Long appId, String token) {

        ExternalApp app = appRepo.findById(appId)
                .orElseThrow();

        ApiEndpoint endpoint = endpointRepo
                .findByAppIdAndName(appId, "LIST_USERS")
                .orElseThrow();

        String response = client.call(
                app.getBaseUrl(),
                endpoint.getEndpointPath(),
                token
        );

        JSONObject json = new JSONObject(response);
        JSONObject resource = json.getJSONObject("resource");

        List<FieldMapping> mappings = mappingRepo.findByAppId(appId);

        TempUser user = new TempUser();
        user.setSourceApp(app.getName());

        for (FieldMapping m : mappings) {
            Object value = JsonPath.read(
                    resource.toString(),
                    "$." + m.getSourcePath().replace("resource.", "")
            );

            switch (m.getTargetField()) {
                case "email" ->
                    user.setEmail(value.toString());
                case "name" ->
                    user.setName(value.toString());
                case "externalId" ->
                    user.setExternalId(value.toString());
            }
        }

        userRepo.save(user);
        return List.of(user);
    }
}
