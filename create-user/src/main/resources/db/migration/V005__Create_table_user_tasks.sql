CREATE TABLE user_tasks (
  task_id BIGINT NOT NULL,
   user_id BIGINT NOT NULL
);

ALTER TABLE user_tasks ADD CONSTRAINT uc_user_tasks_task UNIQUE (task_id);

ALTER TABLE user_tasks ADD CONSTRAINT fk_usetas_on_task FOREIGN KEY (task_id) REFERENCES task (id);

ALTER TABLE user_tasks ADD CONSTRAINT fk_usetas_on_user FOREIGN KEY (user_id) REFERENCES user (id);