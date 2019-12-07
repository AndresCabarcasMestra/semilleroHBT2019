CREATE TABLE "DB_SEMILLERO"."ROL"
( "rol_id" NUMBER(3,0) NOT NULL ENABLE,
"ROLNOMBRE" VARCHAR(50 BYTE) NOT NULL ENABLE,
"ROLESTADO" VARCHAR(50 BYTE),
CONSTRAINT "ROL_PK" PRIMARY KEY ("rol_id"),
CONSTRAINT "ROL_R_1" CHECK(ROLESTADO IN ('ACTIVO','INACTIVO'))
);


create sequence "SEC_ROL" minvalue 1 start with 1 increment by 2;

--Notas a tener en cuenta
--con las siguientes consultas utilizamos unique para evitar que se guarden 
--nombres y roles repetidos en la base de datos


 alter table personaje
 add constraint UQ_personaje_pers_nombre
 unique (pers_nombre);
 
 alter table ROL
 add constraint UQ_ROL_ROLNOMBRE
 unique (ROLNOMBRE);
