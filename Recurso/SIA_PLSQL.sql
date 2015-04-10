/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : PLUS SIA
Source Server Version : 100200
Source Host           : 184.154.42.20:1521
Source Schema         : SIA

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2015-04-10 16:37:18
*/


-- ----------------------------
-- Table structure for "SIA"."SIA_ASIGNATURAS"
-- ----------------------------
DROP TABLE "SIA"."SIA_ASIGNATURAS";
CREATE TABLE "SIA"."SIA_ASIGNATURAS" (
"ASI_CODIGO" NUMBER NOT NULL ,
"ASI_NOMBRE" VARCHAR2(50 BYTE) NOT NULL ,
"ASI_ESTADO" NUMBER NOT NULL ,
"ASI_CREDITOS" NUMBER NOT NULL ,
"ASI_HORAS_TEORICAS" NUMBER NOT NULL ,
"ASI_HORAS_PRACTICAS" NUMBER NOT NULL ,
"ASI_HORAS_INDEPENDIENTES" NUMBER NOT NULL ,
"ASI_TIPO" VARCHAR2(1 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SIA_ASIGNATURAS
-- ----------------------------
INSERT INTO "SIA"."SIA_ASIGNATURAS" VALUES ('2', 'MATEMATICA 1', '1', '2', '2', '2', '4', 'A');
INSERT INTO "SIA"."SIA_ASIGNATURAS" VALUES ('3', 'REDES 1', '1', '4', '2', '4', '6', 'B');
INSERT INTO "SIA"."SIA_ASIGNATURAS" VALUES ('1', 'CALCULO VECTORIAL', '1', '4', '3', '3', '6', 'A');

-- ----------------------------
-- Table structure for "SIA"."SIA_ESTUDIANTES"
-- ----------------------------
DROP TABLE "SIA"."SIA_ESTUDIANTES";
CREATE TABLE "SIA"."SIA_ESTUDIANTES" (
"EST_CODIGO" NUMBER NOT NULL ,
"EST_NOMBRES" VARCHAR2(32 BYTE) NOT NULL ,
"EST_APELLIDOS" VARCHAR2(30 BYTE) NOT NULL ,
"EST_TELEFONO" NUMBER NOT NULL ,
"EST_IDENTIFICACION" NUMBER NOT NULL ,
"EST_ESTADO" NUMBER NOT NULL ,
"EST_DIRECCION" VARCHAR2(40 BYTE) NULL ,
"EST_COD_MATRICULA" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SIA_ESTUDIANTES
-- ----------------------------
INSERT INTO "SIA"."SIA_ESTUDIANTES" VALUES ('1', 'DANIEL', 'BARROS PIÑERES', '123456', '1143116275', '1', 'CL 82 N 38-82', '201510000');
INSERT INTO "SIA"."SIA_ESTUDIANTES" VALUES ('3', 'EDGARDO JOSE', 'ALVAREZ BERDUGO', '3728672', '1143116274', '1', 'CL 45A 24-56', '201510001');
INSERT INTO "SIA"."SIA_ESTUDIANTES" VALUES ('4', 'WILSON', 'SALAZAR ORTIZ', '3697524', '123456', '0', 'CL 93 47-101 LOCAL 301', '201510002');

-- ----------------------------
-- Table structure for "SIA"."SIA_NOTAS"
-- ----------------------------
DROP TABLE "SIA"."SIA_NOTAS";
CREATE TABLE "SIA"."SIA_NOTAS" (
"NOT_CODIGO" NUMBER NOT NULL ,
"NOT_1_CORTE" FLOAT NULL ,
"NOT_2_CORTE" FLOAT NULL ,
"NOT_3_CORTE" FLOAT NULL ,
"PRO_CODIGO" NUMBER NOT NULL ,
"NOT_DEFINITIVA" FLOAT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SIA_NOTAS
-- ----------------------------

-- ----------------------------
-- Table structure for "SIA"."SIA_PROYECCIONES"
-- ----------------------------
DROP TABLE "SIA"."SIA_PROYECCIONES";
CREATE TABLE "SIA"."SIA_PROYECCIONES" (
"ASI_CODIGO" NUMBER NOT NULL ,
"PRO_CODIGO" NUMBER NOT NULL ,
"PRO_ESTADO" NUMBER NOT NULL ,
"EST_CODIGO" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SIA_PROYECCIONES
-- ----------------------------

-- ----------------------------
-- Table structure for "SIA"."SIA_USUARIOS"
-- ----------------------------
DROP TABLE "SIA"."SIA_USUARIOS";
CREATE TABLE "SIA"."SIA_USUARIOS" (
"USU_CODIGO" NUMBER NOT NULL ,
"USU_USUARIO" VARCHAR2(40 BYTE) NOT NULL ,
"USU_PASS" VARCHAR2(40 BYTE) NOT NULL ,
"USU_ESTADO" NUMBER NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SIA_USUARIOS
-- ----------------------------
INSERT INTO "SIA"."SIA_USUARIOS" VALUES ('1', 'admin', 'admin', '1');

-- ----------------------------
-- Procedure structure for "SIA"."ACTUALIZAR_ASIGNATURA"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."ACTUALIZAR_ASIGNATURA"(
cod NUMBER, 
descr VARCHAR2, 
credi NUMBER, 
ht NUMBER, 
hp NUMBER, 
hi NUMBER, 
tip VARCHAR2, 
respuesta OUT NUMBER) AS
BEGIN
respuesta :=0;
UPDATE sia_asignaturas
SET ASI_CREDITOS=credi, 
ASI_HORAS_INDEPENDIENTES=hi, 
ASI_HORAS_PRACTICAS=hp,
ASI_HORAS_TEORICAS=ht,
ASI_TIPO=tip,
 ASI_NOMBRE=descr
WHERE  
 ASI_ESTADO=1 AND ASI_CODIGO=cod;
respuesta :=1;
END;
/

-- ----------------------------
-- Procedure structure for "SIA"."ACTUALIZAR_ESTUDIANTE"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."ACTUALIZAR_ESTUDIANTE" (
nomb IN VARCHAR2, 
ape IN VARCHAR2, 
tel IN NUMBER, 
ident IN NUMBER,
direc IN VARCHAR2, 
cod_ma IN NUMBER,
respuesta OUT NUMBER)
AS
BEGIN
respuesta :=0;
UPDATE SIA_ESTUDIANTES 
SET est_nombres=nomb, est_apellidos=ape, est_direccion=direc, est_telefono=tel, est_identificacion=ident 
WHERE est_estado=1 AND est_cod_matricula=cod_ma;
respuesta :=1;
END ACTUALIZAR_ESTUDIANTE;
/

-- ----------------------------
-- Procedure structure for "SIA"."BUSCAR_ASIGNATURA"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."BUSCAR_ASIGNATURA" (
codi IN NUMBER, 
respuesta OUT SYS_REFCURSOR)
AS
BEGIN
OPEN respuesta FOR 
SELECT * 
FROM SIA_ASIGNATURAS 
WHERE ASI_ESTADO=1 and ASI_CODIGO=codi;

END BUSCAR_ASIGNATURA;
/

-- ----------------------------
-- Procedure structure for "SIA"."BUSCAR_ESTUDIANTE_COD"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."BUSCAR_ESTUDIANTE_COD" (
codi IN NUMBER, 
respuesta OUT SYS_REFCURSOR)
AS
BEGIN
OPEN respuesta FOR 
SELECT * 
FROM sia_estudiantes 
WHERE est_estado=1 and est_cod_matricula=codi;

END BUSCAR_ESTUDIANTE_COD ;
/

-- ----------------------------
-- Procedure structure for "SIA"."ELIMINAR_ESTUDIANTE"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."ELIMINAR_ESTUDIANTE" (
cod_ma IN NUMBER,
respuesta OUT NUMBER)
AS
BEGIN
respuesta :=0;
UPDATE SIA_ESTUDIANTES 
SET EST_ESTADO=0 
WHERE est_estado=1 AND est_cod_matricula=cod_ma;
respuesta :=1;
END ELIMINAR_ESTUDIANTE;
/

-- ----------------------------
-- Procedure structure for "SIA"."GUARDAR_ASIGNATURA"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."GUARDAR_ASIGNATURA"(
descr VARCHAR2, 
credi NUMBER, 
ht NUMBER, 
hp NUMBER, 
hi NUMBER, 
tip VARCHAR2, 
respuesta OUT NUMBER) AS
BEGIN
respuesta :=0;
INSERT INTO sia_asignaturas 
VALUES(INC_ASIGNATURA_PK.NextVal, descr, 1, credi, ht,hp, hi,tip);
respuesta :=1;
END;
/

-- ----------------------------
-- Procedure structure for "SIA"."GUARDAR_ESTUDIANTE"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."GUARDAR_ESTUDIANTE" (
nomb IN VARCHAR2,
apell IN VARCHAR2,
tel IN NUMBER, 
ident IN NUMBER,
direc IN VARCHAR2, 
codigo IN NUMBER,
resultado OUT VARCHAR2)
AS
temp NUMBER;
BEGIN

resultado :=0;
INSERT INTO SIA_ESTUDIANTES 
VALUES(INC_ESTUDIANTE_PK.NextVal, 
nomb, 
apell, 
tel,
ident,
1,
direc,
codigo);
SELECT INC_CODIGO_ESTUDIANTE.NextVal INTO temp FROM DUAL;
resultado :=1;

END GUARDAR_ESTUDIANTE;
/

-- ----------------------------
-- Procedure structure for "SIA"."LOGUEAR"
-- ----------------------------
CREATE OR REPLACE PROCEDURE "SIA"."LOGUEAR" (usu IN VARCHAR2, pass IN VARCHAR2, resultado OUT VARCHAR2)
AS
BEGIN
SELECT USU_PASS INTO resultado from SIA_USUARIOS WHERE USU_USUARIO=usu AND USU_PASS=pass;

EXCEPTION 
WHEN NO_DATA_FOUND THEN
DBMS_OUTPUT.PUT_LINE('ERROR');
END LOGUEAR;
/

-- ----------------------------
-- Function structure for "SIA"."FN_CANTIDAD_ASI_TIPO"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_CANTIDAD_ASI_TIPO"(tipo VARCHAR2) 
RETURN NUMBER
IS
  result NUMBER;
BEGIN
SELECT COUNT(*) INTO result
FROM  SIA_ASIGNATURAS a
WHERE a.asi_tipo=tipo AND a.ASI_ESTADO=1
GROUP BY a.asi_tipo;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."FN_MULTIPLICACION"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_MULTIPLICACION"(cod_estudiante NUMBER) 
RETURN FLOAT
IS
  result FLOAT;
BEGIN
SELECT sum(asi_creditos*not_definitiva)INTO result
FROM SIA_NOTAS n 
INNER JOIN SIA_PROYECCIONES p ON n.PRO_CODIGO=p.PRO_CODIGO
INNER JOIN SIA_ASIGNATURAS a ON p.ASI_CODIGO=a.ASI_CODIGO
INNER JOIN SIA_ESTUDIANTES e ON e.EST_CODIGO=p.EST_CODIGO
WHERE e.EST_CODIGO = cod_estudiante AND e.est_estado=1;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."FN_SUMA_CREDI_TIPO"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_SUMA_CREDI_TIPO"(tipo VARCHAR2) 
RETURN NUMBER
IS
  result NUMBER;
BEGIN
SELECT SUM(asi_creditos) INTO result
FROM  SIA_ASIGNATURAS a
WHERE a.asi_tipo=tipo AND a.ASI_ESTADO=1
GROUP BY a.asi_tipo;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."FN_SUMA_CREDITOS"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_SUMA_CREDITOS"(cod_estudiante NUMBER) 
RETURN NUMBER
IS
  result NUMBER;
BEGIN
  SELECT SUM(asi_creditos) INTO result
 FROM SIA_NOTAS n 
INNER JOIN SIA_PROYECCIONES p ON n.PRO_CODIGO=p.PRO_CODIGO
INNER JOIN SIA_ASIGNATURAS a ON p.ASI_CODIGO=a.ASI_CODIGO
INNER JOIN SIA_ESTUDIANTES e ON e.EST_CODIGO=p.EST_CODIGO
WHERE e.EST_CODIGO = cod_estudiante AND e.est_estado=1;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."FN_SUMA_CREDITOS_APROV"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_SUMA_CREDITOS_APROV"(cod_estudiante NUMBER) 
RETURN NUMBER
IS
  result NUMBER;
BEGIN
  SELECT SUM(asi_creditos) INTO result
 FROM SIA_NOTAS n 
INNER JOIN SIA_PROYECCIONES p ON n.PRO_CODIGO=p.PRO_CODIGO
INNER JOIN SIA_ASIGNATURAS a ON p.ASI_CODIGO=a.ASI_CODIGO
INNER JOIN SIA_ESTUDIANTES e ON e.EST_CODIGO=p.EST_CODIGO
WHERE e.EST_CODIGO = cod_estudiante AND e.est_estado=1 AND n.NOT_DEFINITIVA >=3;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."FN_SUMA_CREDITOS_REPROV"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."FN_SUMA_CREDITOS_REPROV"(cod_estudiante NUMBER) 
RETURN NUMBER
IS
  result NUMBER;
BEGIN
  SELECT SUM(asi_creditos) INTO result
 FROM SIA_NOTAS n 
INNER JOIN SIA_PROYECCIONES p ON n.PRO_CODIGO=p.PRO_CODIGO
INNER JOIN SIA_ASIGNATURAS a ON p.ASI_CODIGO=a.ASI_CODIGO
INNER JOIN SIA_ESTUDIANTES e ON e.EST_CODIGO=p.EST_CODIGO
WHERE e.EST_CODIGO = cod_estudiante AND e.est_estado=1 AND n.NOT_DEFINITIVA <3;
  return(result);
EXCEPTION 
WHEN NO_DATA_FOUND THEN
  return 0;
END ;
/

-- ----------------------------
-- Function structure for "SIA"."ULTIMA_ASIGNATURA"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."ULTIMA_ASIGNATURA" RETURN NUMBER AS
  result NUMBER;
BEGIN

SELECT NVL(LAST_NUMBER, 0) 
INTO result 
FROM user_sequences 
WHERE SEQUENCE_NAME = 'INC_ASIGNATURA_PK';

return(result);

EXCEPTION 
WHEN NO_DATA_FOUND THEN
RETURN 0;
END;
/

-- ----------------------------
-- Function structure for "SIA"."ULTIMO_ESTUDIANTE"
-- ----------------------------
CREATE OR REPLACE FUNCTION "SIA"."ULTIMO_ESTUDIANTE" RETURN NUMBER AS
  result NUMBER;
BEGIN

SELECT NVL(LAST_NUMBER, 0) 
INTO result 
FROM user_sequences 
WHERE SEQUENCE_NAME = 'INC_CODIGO_ESTUDIANTE';

return(result);

EXCEPTION 
WHEN NO_DATA_FOUND THEN
RETURN 0;
END;
/

-- ----------------------------
-- Sequence structure for "SIA"."INC_ASIGNATURA_PK"
-- ----------------------------
DROP SEQUENCE "SIA"."INC_ASIGNATURA_PK";
CREATE SEQUENCE "SIA"."INC_ASIGNATURA_PK"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 4
 NOCACHE ;

-- ----------------------------
-- Sequence structure for "SIA"."INC_CODIGO_ESTUDIANTE"
-- ----------------------------
DROP SEQUENCE "SIA"."INC_CODIGO_ESTUDIANTE";
CREATE SEQUENCE "SIA"."INC_CODIGO_ESTUDIANTE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999
 START WITH 10003
 NOCACHE 
 CYCLE ;

-- ----------------------------
-- Sequence structure for "SIA"."INC_ESTUDIANTE_PK"
-- ----------------------------
DROP SEQUENCE "SIA"."INC_ESTUDIANTE_PK";
CREATE SEQUENCE "SIA"."INC_ESTUDIANTE_PK"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 5
 NOCACHE ;

-- ----------------------------
-- Sequence structure for "SIA"."INC_NOTAS_PK"
-- ----------------------------
DROP SEQUENCE "SIA"."INC_NOTAS_PK";
CREATE SEQUENCE "SIA"."INC_NOTAS_PK"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1
 NOCACHE ;

-- ----------------------------
-- Sequence structure for "SIA"."INC_PROYECCION_PK"
-- ----------------------------
DROP SEQUENCE "SIA"."INC_PROYECCION_PK";
CREATE SEQUENCE "SIA"."INC_PROYECCION_PK"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999
 START WITH 1
 NOCACHE ;

-- ----------------------------
-- Indexes structure for table SIA_ASIGNATURAS
-- ----------------------------

-- ----------------------------
-- Checks structure for table "SIA"."SIA_ASIGNATURAS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_NOMBRE" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_ESTADO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_CREDITOS" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_HORAS_TEORICAS" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_HORAS_PRACTICAS" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_HORAS_INDEPENDIENTES" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD CHECK ("ASI_TIPO" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "SIA"."SIA_ASIGNATURAS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_ASIGNATURAS" ADD PRIMARY KEY ("ASI_CODIGO");

-- ----------------------------
-- Indexes structure for table SIA_ESTUDIANTES
-- ----------------------------

-- ----------------------------
-- Uniques structure for table "SIA"."SIA_ESTUDIANTES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD UNIQUE ("EST_IDENTIFICACION");

-- ----------------------------
-- Checks structure for table "SIA"."SIA_ESTUDIANTES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_NOMBRES" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_APELLIDOS" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_TELEFONO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_IDENTIFICACION" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_ESTADO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD CHECK ("EST_COD_MATRICULA" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "SIA"."SIA_ESTUDIANTES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_ESTUDIANTES" ADD PRIMARY KEY ("EST_CODIGO");

-- ----------------------------
-- Indexes structure for table SIA_NOTAS
-- ----------------------------

-- ----------------------------
-- Checks structure for table "SIA"."SIA_NOTAS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_NOTAS" ADD CHECK ("NOT_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_NOTAS" ADD CHECK ("PRO_CODIGO" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "SIA"."SIA_NOTAS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_NOTAS" ADD PRIMARY KEY ("NOT_CODIGO");

-- ----------------------------
-- Indexes structure for table SIA_PROYECCIONES
-- ----------------------------

-- ----------------------------
-- Checks structure for table "SIA"."SIA_PROYECCIONES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD CHECK ("ASI_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD CHECK ("PRO_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD CHECK ("PRO_ESTADO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD CHECK ("EST_CODIGO" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "SIA"."SIA_PROYECCIONES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD PRIMARY KEY ("PRO_CODIGO");

-- ----------------------------
-- Indexes structure for table SIA_USUARIOS
-- ----------------------------

-- ----------------------------
-- Checks structure for table "SIA"."SIA_USUARIOS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_USUARIOS" ADD CHECK ("USU_CODIGO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_USUARIOS" ADD CHECK ("USU_USUARIO" IS NOT NULL);
ALTER TABLE "SIA"."SIA_USUARIOS" ADD CHECK ("USU_PASS" IS NOT NULL);
ALTER TABLE "SIA"."SIA_USUARIOS" ADD CHECK ("USU_ESTADO" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table "SIA"."SIA_USUARIOS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_USUARIOS" ADD PRIMARY KEY ("USU_CODIGO");

-- ----------------------------
-- Foreign Key structure for table "SIA"."SIA_NOTAS"
-- ----------------------------
ALTER TABLE "SIA"."SIA_NOTAS" ADD FOREIGN KEY ("PRO_CODIGO") REFERENCES "SIA"."SIA_PROYECCIONES" ("PRO_CODIGO");

-- ----------------------------
-- Foreign Key structure for table "SIA"."SIA_PROYECCIONES"
-- ----------------------------
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD FOREIGN KEY ("EST_CODIGO") REFERENCES "SIA"."SIA_ESTUDIANTES" ("EST_CODIGO");
ALTER TABLE "SIA"."SIA_PROYECCIONES" ADD FOREIGN KEY ("ASI_CODIGO") REFERENCES "SIA"."SIA_ASIGNATURAS" ("ASI_CODIGO");
