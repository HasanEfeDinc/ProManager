CREATE TABLE `user`(
                       id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                       email VARCHAR(128) UNIQUE KEY,
                       password VARCHAR(255)
);

CREATE TABLE project (
                         id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                         title VARCHAR(32),
                         `description` LONGTEXT
);

CREATE TABLE user_project(
                             user_id INT,
                             project_id INT,
                             is_admin BOOLEAN,
                             write_access BOOLEAN,
                             read_access BOOLEAN,
                             FOREIGN KEY (user_id) REFERENCES user(id),
                             FOREIGN KEY (project_id) REFERENCES project(id),
                             PRIMARY KEY (user_id,project_id)
);

CREATE TABLE functional_requirement (
                                        project_id INT ,
                                        body VARCHAR(255),
                                        FOREIGN KEY (project_id) REFERENCES project(id),
                                        PRIMARY KEY (project_id,body)
);

CREATE TABLE non_functional_requirement (
                                            project_id INT ,
                                            body VARCHAR(255),
                                            FOREIGN KEY (project_id) REFERENCES project(id),
                                            PRIMARY KEY (project_id,body)
);
CREATE TABLE task (
                      project_id INT ,
                      body VARCHAR(255),
                      assigned_id INT,
                      deadline DATETIME,
                      FOREIGN KEY (project_id) REFERENCES project(id),
                      FOREIGN KEY (assigned_id) REFERENCES user(id),
                      PRIMARY KEY (project_id,body)
);