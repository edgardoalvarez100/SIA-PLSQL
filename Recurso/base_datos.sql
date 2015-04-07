/************ Update: Tables ***************/

/******************** Add Table: sia_asignaturas ************************/

/* Build Table Structure */
CREATE TABLE sia_asignaturas
(
	asi_codigo INTEGER NOT NULL,
	asi_nombre VARCHAR2(50) NOT NULL,
	asi_estado INTEGER NOT NULL,
	asi_creditos INTEGER NOT NULL,
	asi_horas_teoricas INTEGER NOT NULL,
	asi_horas_practicas INTEGER NOT NULL,
	asi_horas_independientes INTEGER NOT NULL,
	asi_tipo VARCHAR2(1) NOT NULL
);

/* Table Items: sia_asignaturas */
ALTER TABLE sia_asignaturas ADD CONSTRAINT pksia_asignaturas
	PRIMARY KEY (asi_codigo);

/******************** Add Table: sia_estudiantes ************************/

/* Build Table Structure */
CREATE TABLE sia_estudiantes
(
	est_codigo INTEGER NOT NULL,
	est_nombres VARCHAR2(32) NOT NULL,
	est_apellidos VARCHAR2(30) NOT NULL,
	est_telefono INTEGER NOT NULL,
	est_identificacion INTEGER UNIQUE NOT NULL,
	est_estado INTEGER NOT NULL,
	est_direccion VARCHAR2(40) NULL,
	est_cod_matricula INTEGER NOT NULL
);

/* Table Items: sia_estudiantes */
ALTER TABLE sia_estudiantes ADD CONSTRAINT pksia_estudiantes
	PRIMARY KEY (est_codigo);

/******************** Add Table: sia_notas ************************/

/* Build Table Structure */
CREATE TABLE sia_notas
(
	not_codigo INTEGER NOT NULL,
	not_1_corte FLOAT NULL,
	not_2_corte FLOAT NULL,
	not_3_corte FLOAT NULL,
	pro_codigo INTEGER NOT NULL,
	not_definitiva FLOAT NULL
);

/* Table Items: sia_notas */
ALTER TABLE sia_notas ADD CONSTRAINT pksia_notas
	PRIMARY KEY (not_codigo);

/******************** Add Table: sia_proyecciones ************************/

/* Build Table Structure */
CREATE TABLE sia_proyecciones
(
	asi_codigo INTEGER NOT NULL,
	pro_codigo INTEGER NOT NULL,
	pro_estado INTEGER NOT NULL,
	est_codigo INTEGER NOT NULL
);

/* Table Items: sia_proyecciones */
ALTER TABLE sia_proyecciones ADD CONSTRAINT pksia_proyecciones
	PRIMARY KEY (pro_codigo);

/******************** Add Table: sia_usuarios ************************/

/* Build Table Structure */
CREATE TABLE sia_usuarios
(
	usu_codigo INTEGER NOT NULL,
	usu_usuario VARCHAR2(40) NOT NULL,
	usu_pass VARCHAR2(40) NOT NULL,
	usu_estado INTEGER NOT NULL
);

/* Table Items: sia_usuarios */
ALTER TABLE sia_usuarios ADD CONSTRAINT pksia_usuarios
	PRIMARY KEY (usu_codigo);


/************ Add Foreign Keys to Database ***************/

/************ Foreign Key: fk_notas_proyecciones ***************/
ALTER TABLE sia_notas ADD CONSTRAINT fk_notas_proyecciones
	FOREIGN KEY (pro_codigo) REFERENCES sia_proyecciones (pro_codigo);

/************ Foreign Key: fk_mat_asi_estudiantes ***************/
ALTER TABLE sia_proyecciones ADD CONSTRAINT fk_mat_asi_estudiantes
	FOREIGN KEY (est_codigo) REFERENCES sia_estudiantes (est_codigo);

/************ Foreign Key: fk_pro_asi_asignaturas ***************/
ALTER TABLE sia_proyecciones ADD CONSTRAINT fk_pro_asi_asignaturas
	FOREIGN KEY (asi_codigo) REFERENCES sia_asignaturas (asi_codigo);

	
CREATE SEQUENCE inc_codigo_estudiante
INCREMENT BY 1
START WITH 10000
MAXVALUE 99999
CYCLE
NOCACHE
NOORDER;


CREATE SEQUENCE inc_estudiante_pk
INCREMENT BY 1
START WITH 0001
NOCACHE
NOORDER;


CREATE SEQUENCE inc_asignatura_pk
INCREMENT BY 1
START WITH 0001
NOCACHE
NOORDER;


CREATE SEQUENCE inc_notas_pk
INCREMENT BY 1
START WITH 0001
NOCACHE
NOORDER;

CREATE SEQUENCE inc_proyeccion_pk
INCREMENT BY 1
START WITH 0001
NOCACHE
NOORDER;

INSERT INTO sia_usuarios values(1, 'admin', 'admin', 1);

/*** FUNCIONES ***/
CREATE OR REPLACE
FUNCTION fn_suma_creditos(cod_estudiante NUMBER) 
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

CREATE OR REPLACE
FUNCTION fn_multiplicacion(cod_estudiante NUMBER) 
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

/******** suma credito por tipo asignatura ********/
CREATE OR REPLACE 
FUNCTION fn_suma_credi_tipo(tipo VARCHAR2) 
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


CREATE OR REPLACE 
FUNCTION fn_cantidad_asi_tipo(tipo VARCHAR2) 
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

CREATE OR REPLACE
FUNCTION fn_suma_creditos_aprov(cod_estudiante NUMBER) 
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

CREATE OR REPLACE
FUNCTION fn_suma_creditos_reprov(cod_estudiante NUMBER) 
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