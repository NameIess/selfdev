CREATE TABLE CONTACT (
	id				INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
    first_name		VARCHAR(60) NOT NULL,
    last_name		VARCHAR(40)	NOT NULL,
    birth_date		DATE,
    version			INT NOT NULL DEFAULT 0,
    UNIQUE	uq_contact_1 (first_name, last_name)
);

CREATE TABLE CONTACT_TEL_DETAIL (
	id				INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
    contact_id		INT NOT NULL,
    tel_type		VARCHAR(20)	NOT NULL,
    tel_number		VARCHAR(20)	NOT NULL,
    version			INT NOT NULL DEFAULT 0,
    UNIQUE	uq_contact_tel_detail_1 (contact_id, tel_type),
    FOREIGN KEY (contact_id) REFERENCES CONTACT(id)
);