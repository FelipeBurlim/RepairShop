CREATE TABLE repairs (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         entry_date VARCHAR(10) NOT NULL,
                         exit_date VARCHAR(10),
                         mechanic_name VARCHAR(100) NOT NULL,
                         mechanic_years_of_experience INT,
                         vehicle_make VARCHAR(100) NOT NULL,
                         vehicle_model VARCHAR(100) NOT NULL,
                         vehicle_year VARCHAR(4) NOT NULL,
                         PRIMARY KEY(id)
);