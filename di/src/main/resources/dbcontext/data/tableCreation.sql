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

CREATE TABLE HOBBY (
	hobby_id	VARCHAR(20) NOT NULL PRIMARY KEY
);

CREATE TABLE CONTACT_HOBBY_DETAIL (
	contact_id	INT NOT NULL,
	hobby_id 	VARCHAR(20) NOT NULL,
    PRIMARY KEY (contact_id, hobby_id),
    FOREIGN KEY (contact_id) REFERENCES CONTACT (id) ON DELETE CASCADE,
    FOREIGN KEY (hobby_id) REFERENCES HOBBY (hobby_id)
);

CREATE TABLE CONTACT_AUDIT (
  id				            INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
    first_name		      VARCHAR(60) NOT NULL,
    last_name		        VARCHAR(40)	NOT NULL,
    birth_date		      DATE,
    version			        INT NOT NULL DEFAULT 0,
    created_by          VARCHAR(20),
    created_date        TIMESTAMP,
    last_modified_by    VARCHAR(20),
    last_modified_date  TIMESTAMP,
    UNIQUE UQ_CONTACT_AUDIT_1 (first_name, last_name)
);

CREATE TABLE CAR (
  id                    INT NOT NULL AUTO_INCREMENT	PRIMARY KEY,
  license_plate         VARCHAR(20) NOT NULL,
  manufacturer          VARCHAR(20) NOT NULL,
  manufacture_date      DATE NOT NULL,
  age                   INT NOT NULL DEFAULT 0,
  version               INT NOT NULL DEFAULT 0,

  UNIQUE UQ_CAR_1 (license_plate)
)