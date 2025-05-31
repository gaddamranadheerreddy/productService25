ALTER TABLE st_users
    MODIFY avg_rating DOUBLE NOT NULL;

ALTER TABLE categories
    MODIFY name VARCHAR (255) NOT NULL;

ALTER TABLE st_users
    MODIFY number_ofhr INT NOT NULL;

ALTER TABLE st_users
    MODIFY user_type INT NULL;