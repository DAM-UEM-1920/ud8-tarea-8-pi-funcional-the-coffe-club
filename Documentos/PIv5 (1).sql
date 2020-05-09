DROP TABLE tutor CASCADE CONSTRAINTS;
DROP TABLE centro CASCADE CONSTRAINTS;
DROP TABLE empresa CASCADE CONSTRAINTS;
DROP TABLE grupo CASCADE CONSTRAINTS;
DROP TABLE alumno CASCADE CONSTRAINTS;
DROP TABLE practica CASCADE CONSTRAINTS;
DROP TABLE colabora CASCADE CONSTRAINTS;
DROP TABLE gestiona CASCADE CONSTRAINTS;
DROP TABLE pertenece CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE ejerce CASCADE CONSTRAINTS;


CREATE TABLE alumno (
    dni         VARCHAR2(9 CHAR) NOT NULL,
    nombre      VARCHAR2(25 CHAR) NOT NULL,
    apellidos   VARCHAR2(55 CHAR) NOT NULL,
    num_exp     NUMBER(15) NOT NULL,
    nacionalidad VARCHAR2(25 CHAR) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    e_mail      VARCHAR2(50 CHAR), 
    telefono    NUMBER(9)
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( num_exp );

CREATE TABLE centro (
    cod_centro   NUMBER(1) NOT NULL,
    localidad    VARCHAR2(25 CHAR) NOT NULL,
    director     VARCHAR2(25 CHAR) NOT NULL,
    dat          VARCHAR2(25 CHAR) NOT NULL
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( cod_centro );

CREATE TABLE colabora (
    centro_cod_centro   NUMBER(1) NOT NULL,
    empresa_cif         VARCHAR2(15 CHAR) NOT NULL,
    numconv             NUMBER NOT NULL,
    anexo_1             VARCHAR2(50 CHAR) ,
    fecha               DATE NOT NULL
);

ALTER TABLE colabora ADD CONSTRAINT colabora_pk PRIMARY KEY ( centro_cod_centro,
                                                              empresa_cif );

CREATE TABLE empresa (
    cif         VARCHAR2(15 CHAR) NOT NULL,
    nombre      VARCHAR2(20 CHAR) NOT NULL,
    direccion   VARCHAR2(30 CHAR) NOT NULL,
    telefono    NUMBER(12) NOT NULL,
    localidad   VARCHAR2(50 CHAR) NOT NULL,
    e_mail VARCHAR2(30 CHAR),
    representantes VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( cif );

CREATE TABLE gestiona (
    tutor_dni_tutor   VARCHAR2(9 CHAR) NOT NULL,
    grupo_cod_grupo   NUMBER(5) NOT NULL,
    ano_acad         VARCHAR2(12 CHAR) NOT NULL,
    anexo_2_2         DATE 
);

ALTER TABLE gestiona ADD CONSTRAINT gestiona_pk PRIMARY KEY ( tutor_dni_tutor,
                                                              grupo_cod_grupo );

CREATE TABLE grupo (
    cod_grupo        NUMBER(5) NOT NULL,
    nom_grupo        VARCHAR2(50 CHAR) NOT NULL,
    clave_ciclo      NUMBER(10) NOT NULL,
    nombre_ciclo     VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( cod_grupo );

CREATE TABLE pertenece (
    alumno_num_exp     NUMBER(15) NOT NULL,
    grupo_cod_grupo   NUMBER(5) NOT NULL,
    ano_acad    VARCHAR2(12 CHAR) NOT NULL
 );

ALTER TABLE pertenece ADD CONSTRAINT pertenece_pk PRIMARY KEY (grupo_cod_grupo, alumno_num_exp);

CREATE TABLE practica (
    empresa_cif      VARCHAR2(15 CHAR) NOT NULL,
    alumno_num_exp   NUMBER(15) NOT NULL,
    anexo_2_1        DATE ,
    anexo_3          DATE ,
    anexo_7          DATE ,
    anexo_8          DATE ,
    fecha_ini        DATE ,
    fecha_fin        DATE ,
    ano_acad         VARCHAR2(12 CHAR) NOT NULL,
    horario          VARCHAR2(50 CHAR) ,
    tutore           VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE practica ADD CONSTRAINT practica_pk PRIMARY KEY ( empresa_cif,  alumno_num_exp );
    
CREATE TABLE users (
    usr                 VARCHAR2(15 CHAR) NOT NULL,
    pwd                 VARCHAR2(15 CHAR) NOT NULL,
    rol                 VARCHAR2(10 CHAR) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( usr );                                                        

CREATE TABLE tutor (
    dni_tutor           VARCHAR2(9 CHAR) NOT NULL,
    nombre              VARCHAR2(25 CHAR) NOT NULL,
    apellidos           VARCHAR2(50 CHAR) NOT NULL,
    centro_cod_centro   NUMBER(1)NOT NULL,
    e_mail              VARCHAR2(50 CHAR) NOT NULL,
    area                VARCHAR2(50 CHAR) NOT NULL
);


ALTER TABLE tutor ADD CONSTRAINT tutor_pk PRIMARY KEY ( dni_tutor );

CREATE TABLE ejerce (
    e_usr_users         VARCHAR2(15 CHAR) NOT NULL,
    e_dni_tutor         VARCHAR2(9 CHAR)
);

ALTER TABLE ejerce ADD CONSTRAINT ejerce_pk PRIMARY KEY ( e_usr_users, e_dni_tutor );



ALTER TABLE colabora
    ADD CONSTRAINT colabora_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro );

ALTER TABLE colabora
    ADD CONSTRAINT colabora_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif );

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_grupo_fk FOREIGN KEY ( grupo_cod_grupo )
        REFERENCES grupo ( cod_grupo );

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_tutor_fk FOREIGN KEY ( tutor_dni_tutor )
        REFERENCES tutor ( dni_tutor );

ALTER TABLE practica
    ADD CONSTRAINT practica_alumno_fk FOREIGN KEY ( alumno_num_exp )
        REFERENCES alumno ( num_exp );

ALTER TABLE practica
    ADD CONSTRAINT practica_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif );

ALTER TABLE tutor
    ADD CONSTRAINT tutor_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro );

ALTER TABLE pertenece
    ADD CONSTRAINT grupo_fk FOREIGN KEY ( grupo_cod_grupo ) 
        REFERENCES grupo(cod_grupo);

ALTER TABLE pertenece  
    ADD CONSTRAINT alumno_fk FOREIGN KEY ( alumno_num_exp ) 
        REFERENCES alumno(num_exp);

ALTER TABLE ejerce
    ADD CONSTRAINT ejerce_users_fk FOREIGN KEY ( e_usr_users )
        REFERENCES users(usr);

ALTER TABLE ejerce
    ADD CONSTRAINT ejerce_tutor_fk FOREIGN KEY ( e_dni_tutor )
        REFERENCES tutor (dni_tutor) ;


INSERT INTO alumno(dni, nombre, apellidos, num_exp,nacionalidad,fecha_nacimiento, e_mail, telefono) VALUES('594131t', 'Juan', 'Perez Garcia',1523547, 'Español','8/1/93', 'juanPerez@gmail.com', 698742361);
INSERT INTO alumno(dni, nombre, apellidos, num_exp,nacionalidad,fecha_nacimiento, e_mail, telefono) VALUES('449162s', 'Pablo', 'Perez Ayuso',1226547, 'Ecuatoriano', '2/18/90','pabloayuso@gmail.com', 623659879);
INSERT INTO alumno(dni, nombre, apellidos, num_exp,nacionalidad,fecha_nacimiento, e_mail, telefono) VALUES('111896o', 'Fabiola', 'Yoquese Nobita',1336547, 'Mongol', '9/13/95', 'nobitaseque@gmail.com', 644444361);
INSERT INTO alumno(dni, nombre, apellidos, num_exp,nacionalidad,fecha_nacimiento, e_mail, telefono) VALUES('447893p', 'Nico', 'Fiesta Fiesta',256987, 'Canadiense', '11/6/98', 'nikointhejoke@gmail.com', 687562361);
INSERT INTO alumno(dni, nombre, apellidos, num_exp,nacionalidad,fecha_nacimiento) VALUES('657894r', 'Miguel', 'Perchita Donrramon',897556, 'Frances', '9/16/90');

INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(1, 'Villaviciosa', 'Ana','Yorya');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(2, 'Leganes', 'Ana Maria','Iggy');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(3, 'Villacodigo', 'Alberto','Castelo');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(4, 'Alcorcon', 'Jose','Grillo');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(5, 'Alcornoque', 'Alguien','Berto');

INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, e_mail, representantes) VALUES('dfkj3156', 'algo S.A.', 'c/Miseria Nº69', 666666666, 'Las Penas', 'algo@algo.es','Carlos');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, e_mail, representantes) VALUES('oemd5698', 'algomas S.A.', 'c/Misericorda Nº39', 64789632, 'Los Lisiados', 'algomas@gmail.com', 'Luis');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, e_mail, representantes) VALUES('aned4236', 'otracosa S.A.', 'c/Estafa Nº2', 667778889, 'Los Listos', 'otracosa@cosa.com', 'Alex');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, e_mail, representantes) VALUES('awod1236', 'Mariposa S.A.', 'c/Perpetua Nº6', 67896541, 'Los Tontos', 'MariposaRosa@hotmail.com', 'Ionut');
INSERT INTO empresa(cif, nombre, direccion, telefono, localidad, e_mail, representantes) VALUES('iqie4568', 'Alcatraz S.A.', 'c/Nosesale Nº1', 6796314, 'La Isla', 'Carcel@Alcatraz.es', 'Ivan');

INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(3, 'DAMnificados', 0043, 'DAM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(1, 'ASIR123', 0039, 'ASIF');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(2, 'Enfermeros123', 0112, 'Enfermeria');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(4, 'DAWdeesta', 0021, 'DAW');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(5, 'TAFADtofurius', 0001, 'TAFAD');


INSERT INTO users(usr, pwd, rol) VALUES('tutorA','abc123','TUTOR');
INSERT INTO users(usr, pwd, rol) VALUES('tutorB','def456','TUTOR');
INSERT INTO users(usr, pwd, rol) VALUES('tutorC','ghi789','TUTOR');
INSERT INTO users(usr, pwd, rol) VALUES('tutorD','qtr569','TUTOR');
INSERT INTO users(usr, pwd, rol) VALUES('tutorE','ter489','TUTOR');
INSERT INTO users(usr, pwd, rol) VALUES('Ana','mal598','ADMIN');

INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro, e_mail, area) VALUES('159863p', 'Juan Carlos', 'Monedero Vacio', 4, 'email@deprueba.net', 'informática');
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro, e_mail, area) VALUES('236598w', 'Raul', 'Danos OtroDia', 4, 'email@deprueba.net', 'salud');
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro, e_mail, area) VALUES('789546q', 'Pedro', 'Exponed Omorid', 4, 'email@deprueba.net', 'filosofía');
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro, e_mail, area) VALUES('123698a', 'Ernesto', 'Con Calma', 3, 'email@deprueba.net', 'informática');
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro, e_mail, area) VALUES('965481f', 'Juan Jose', 'Gallego Cachondo', 3, 'email@deprueba.net', 'arquitectura');

INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'dfkj3156', 154895, '22/7/15', '11/10/17');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'oemd5698', 159647, '23/10/19', '10/11/01');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(1,'aned4236', 258974, '25/9/15', '9/21/20');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(3,'awod1236', 577851, '22/7/13', '11/10/18');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(2,'dfkj3156', 654897, '6/4/16', '12/10/17');

INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, ano_acad) VALUES('159863p',3, '7/22/20', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, ano_acad) VALUES('236598w',1, '10/21/19', '2018/2019');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, ano_acad) VALUES('789546q',2, '7/12/20', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, ano_acad) VALUES('123698a',4, '5/23/17', '2016/2017');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, anexo_2_2, ano_acad) VALUES('965481f',5, '6/29/20', '2019/2020');

INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore, ano_acad) 
    VALUES('dfkj3156', 1523547, '7/22/15', '7/22/15', '7/22/15', '7/22/15', '7/22/15', '10/22/15', 'de 9 a 5', 'Dolores Fuertes de Barriga', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore, ano_acad) 
    VALUES('oemd5698', 1226547, '4/12/19', '4/12/19', '4/12/19', '4/12/19', '4/12/19', '9/12/19', 'de 9 a 5', 'Juan De Dios', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore, ano_acad) 
    VALUES('iqie4568', 1336547, '5/21/17', '5/21/17', '5/21/17', '5/21/17', '5/21/17', '10/21/17', 'de 5 a 9', 'Maria Delapaloma', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore, ano_acad) 
    VALUES('awod1236', 256987, '8/31/19', '8/31/19', '8/31/19', '8/31/19', '8/31/19', '12/31/19', 'de 5 a 9', 'Jorge Linux Lover', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, horario,tutore, ano_acad) 
    VALUES('aned4236', 897556, '5/15/05', '5/15/05', '5/15/05', '5/15/05', '5/15/05', '7/15/05', 'de 9 a 5', 'Sergio Benito Camela', '2019/2020');

INSERT INTO pertenece(ano_acad, alumno_num_exp, grupo_cod_grupo) VALUES ('2019/2020', 1523547, 3);
INSERT INTO pertenece(ano_acad, alumno_num_exp, grupo_cod_grupo) VALUES ('2019/2020', 1226547, 3);
INSERT INTO pertenece(ano_acad, alumno_num_exp, grupo_cod_grupo) VALUES ('2019/2020', 1336547, 2);
INSERT INTO pertenece(ano_acad, alumno_num_exp, grupo_cod_grupo) VALUES ('2019/2020', 256987, 5);
INSERT INTO pertenece(ano_acad, alumno_num_exp, grupo_cod_grupo) VALUES ('2019/2020', 897556, 4);

INSERT INTO ejerce(e_usr_users, e_dni_tutor) VALUES('tutorA', '159863p');
INSERT INTO ejerce(e_usr_users, e_dni_tutor) VALUES('tutorB', '236598w');
INSERT INTO ejerce(e_usr_users, e_dni_tutor) VALUES('tutorC', '789546q');
INSERT INTO ejerce(e_usr_users, e_dni_tutor) VALUES('tutorD', '123698a');
INSERT INTO ejerce(e_usr_users, e_dni_tutor) VALUES('tutorE', '965481f');
REM
REM ***************************** SELECT USADA EN EL LOGIN *****************************
REM "SELECT rol FROM COFFE.users WHERE usr = " + "'" + usr + "'" + " AND pwd = " + "'" + pwd+ "'"
REM ************************************************************************************
REM
REM ***************************** SELECT USADA EN Alumnos *****************************
REM
REM
REM
REM
REM
REM
REM
REM
REM
REM
REM
REM
REM
