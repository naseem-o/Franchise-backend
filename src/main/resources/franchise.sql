CREATE TABLE franchise
(
    id BIGINT(19) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    applicant_name VARCHAR(100),
    id_number VARCHAR(100) NOT NULL,
    birth_date DATE,
    contact_address MEDIUMTEXT,
    contact_phone VARCHAR(20),
    contact_email VARCHAR(100),
    previous_experience MEDIUMTEXT,
    intrest_brand VARCHAR(100),
    investment DOUBLE(40,2),
    geographical_area VARCHAR(100),
    additional_notes MEDIUMTEXT,
    created_date TIMESTAMP,
    updated_date TIMESTAMP
);
CREATE UNIQUE INDEX franchise_id_number_uindex ON franchise (id_number);
CREATE UNIQUE INDEX franchise_id_uindex ON franchise (id);


CREATE TABLE hibernate_sequence
(
    next_val BIGINT(20)
);