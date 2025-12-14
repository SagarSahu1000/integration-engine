INSERT INTO external_app (id, name, base_url, auth_type)
VALUES (1, 'Calendly', 'https://api.calendly.com', 'BEARER');

INSERT INTO api_endpoint (app_id, name, endpoint_path, http_method, pagination_type)
VALUES
(1, 'LIST_USERS', '/users/me', 'GET', 'NONE');

INSERT INTO field_mapping (id, app_id, source_path, target_field) VALUES
(1, 1, 'resource.email', 'email'),
(2, 1, 'resource.name', 'name'),
(3, 1, 'resource.uri', 'externalId');
