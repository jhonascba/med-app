CREATE TABLE med_api.tb_address(
    id SERIAL PRIMARY KEY NOT NULL,
    address_type VARCHAR(10) NOT NULL,
    name VARCHAR(25) NOT NULL,
    number VARCHAR(8) NOT NULL,
    complement VARCHAR(20) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    state VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

CREATE TABLE med_api.tb_patient(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(150) NOT NULL,
    birthdate DATE NOT NULL,
    rg VARCHAR(14),
    cpf CHAR(11) NOT NULL,
    email VARCHAR(30),
    mother_name VARCHAR(150),
    father_name VARCHAR(150),
    phone_number1 VARCHAR(20),
    phone_number2 VARCHAR(20),
    active BOOLEAN NOT NULL,
    address_id BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    FOREIGN KEY (address_id) REFERENCES med_api.tb_address(id)
);
