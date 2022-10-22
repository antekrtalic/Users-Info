CREATE TABLE user_roles (
  roles_id BIGINT NOT NULL,
   users_id BIGINT NOT NULL,
   CONSTRAINT pk_user_roles PRIMARY KEY (roles_id, users_id)
);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES roles (id);

ALTER TABLE user_roles ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (users_id) REFERENCES user (id);