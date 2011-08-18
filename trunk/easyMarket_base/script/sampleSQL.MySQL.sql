﻿DROP TABLE IF EXISTS  RTETNBBS ;

CREATE TABLE RTETNBBS (
  NO   CHAR(20)      NOT NULL,
  DATE DATETIME      NULL,
  CN   VARCHAR(4000) NULL,
  SJ   VARCHAR(60)   NULL
  PRIMARY KEY (NO)
);

DROP TABLE IF EXISTS  IDS ;

CREATE TABLE IDS (
  TABLE_NAME VARCHAR(16)   NOT NULL,
  NEXT_ID DECIMAL(30)      NOT NULL,
  PRIMARY KEY (TABLE_NAME) 
);

INSERT INTO IDS VALUES('RTETNBBS',1);

COMMIT;