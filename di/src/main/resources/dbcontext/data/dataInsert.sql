INSERT INTO CONTACT (first_name, last_name, birth_date) VALUES
	('Chris', 'Schaefer',	'1981-05-03'),
	('Scott', 'Tiger',		'1990-11-02'),
	('John', 'Smith', 		'1964-02-28');

INSERT INTO CONTACT_TEL_DETAIL (contact_id, tel_type, tel_number) VALUES
	(1, 'Mobile',	'1234567890'),
	(1, 'Home',		'1234567890'),
	(2, 'Home',		'1234567890');

INSERT INTO HOBBY (hobby_id) VALUES
	('Swimming'),
	('Jogging'),
	('Programming'),
	('Movies'),
	('Reading');
    
INSERT INTO CONTACT_HOBBY_DETAIL (contact_id, hobby_id) VALUES
	(1, 'Swimming'),
	(1, 'Movies'),
	(2, 'Swimming');

INSERT INTO CAR (license_plate, manufacturer, manufacture_date) VALUES
  ('LICENCE-1001', 'Ford', '1980-07-30'),
  ('LICENCE-1002', 'Toyota', '1992-12-30'),
  ('LICENCE-1003', 'ВМW', '2003-1-6');