

CREATE TABLE RTETNBBS
(
	NO                    CHAR(20) NULL,
	DATE                  DATE NULL,
	CN                    VARCHAR2(4000) NULL,
	SJ                    VARCHAR2(60) NULL
)
;



ALTER TABLE RTETNBBS
	ADD  PRIMARY KEY (NO)
;



CREATE TABLE IDS
(	
	TABLE_NAME 	VARCHAR2(16) NULL,
	NEXT_ID		NUMBER(30) NULL
)
;



ALTER TABLE IDS
	ADD  PRIMARY KEY (TABLE_NAME)
;


INSERT INTO IDS VALUES ("RTETNBBS", 1);