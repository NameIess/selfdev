-- DROP IF TABLE EXISTS Contact;

CREATE TABLE Contact (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    first_name  VARCHAR (60) NOT NULL ,
    last_name   VARCHAR (40) NOT NULL ,
    birth_date  DATE ,
    description VARCHAR (2000) ,
    photo       BLOB ,
    version     INT NOT NULL DEFAULT 0 ,
    UNIQUE UQ_CONTACT_1 (first_name, last_name)
);