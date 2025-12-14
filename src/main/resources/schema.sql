CREATE TABLE external_app (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    base_url VARCHAR(255),
    auth_type VARCHAR(20)
);

CREATE TABLE api_endpoint (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    app_id BIGINT,
    name VARCHAR(50),                 
    endpoint_path VARCHAR(255),
    http_method VARCHAR(10),
    pagination_type VARCHAR(20)
);


CREATE TABLE field_mapping (
    id BIGINT PRIMARY KEY,
    app_id BIGINT,
    source_path VARCHAR(255),
    target_field VARCHAR(50)
);

CREATE TABLE temp_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    external_id VARCHAR(255),
    name VARCHAR(100),
    email VARCHAR(100),
    source_app VARCHAR(50)
);
