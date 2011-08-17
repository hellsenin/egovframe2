
insert into rtetccode (
   CODE_ID
  ,CODE_NM
  ,DC
) VALUES (
   'CODE01'  
  ,'ROLE_ADMIN' 
  ,'관리자 코드' 
);

insert into rtetccode (
   CODE_ID
  ,CODE_NM
  ,DC
) VALUES (
   'CODE02'  -- CODE_ID
  ,'ROLE_USER'  -- CODE_NM
  ,'사용자 코드'  -- DC
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNBBS'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNGOODS'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNGOODSIMAGE'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNCART'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNCTGRY'  -- TABLE_NAME
  ,6   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNMBER'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

insert into ids (
   TABLE_NAME
  ,NEXT_ID
) VALUES (
   'RTETNPURCHSLIST'  -- TABLE_NAME
  ,1   -- NEXT_ID
);

commit;

INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/brd/.*\Z','CODE02');
INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/dlv/.*\Z','CODE02');
INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/pcs/.*\Z','CODE02');
INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/dlv/selectAllListPurchase.do\Z','CODE01');
INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/gds/insertGoodsView.do\Z','CODE01');
INSERT into rtetnauth(URL,MNGR_SE) VALUES ('\A/springrest/.*\Z','CODE01');


INSERT INTO RTETNCTGRY(CTGRY_ID,CTGRY_NM,DC) VALUES ('CATEGORY-00000000001','가전','테스트1');
INSERT INTO RTETNCTGRY(CTGRY_ID,CTGRY_NM,DC) VALUES ('CATEGORY-00000000002','스포츠','테스트2');
INSERT INTO RTETNCTGRY(CTGRY_ID,CTGRY_NM,DC) VALUES ('CATEGORY-00000000003','의류','테스트3');
INSERT INTO RTETNCTGRY(CTGRY_ID,CTGRY_NM,DC) VALUES ('CATEGORY-00000000004','식품','테스트4');
INSERT INTO RTETNCTGRY(CTGRY_ID,CTGRY_NM,DC) VALUES ('CATEGORY-00000000005','컴퓨터','테스트5');



INSERT INTO RTETNDLVYINFO (
   DLVY_SE
  ,DLVY_STTUS
) VALUES (
   '10'  -- DLVY_SE
  ,'준비중'  -- DLVY_STTUS
);

INSERT INTO RTETNDLVYINFO (
   DLVY_SE
  ,DLVY_STTUS
) VALUES (
   '11'  -- DLVY_SE
  ,'배송중'  -- DLVY_STTUS
);
INSERT INTO RTETNDLVYINFO (
   DLVY_SE
  ,DLVY_STTUS
) VALUES (
   '12'  -- DLVY_SE
  ,'발송완료'  -- DLVY_STTUS
);
commit;