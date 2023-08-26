CREATE TABLE USERS
(
    NAME         VARCHAR(40),
    SURNAME      VARCHAR(40),
    EMAIL        VARCHAR(40),
    BIRTHDATE    DATE,
    PHONE_NUMBER VARCHAR(20),
    USER_ROLE    VARCHAR(20),
    USERNAME     VARCHAR(20) not null
        constraint "USERS_pk"
            primary key,
    PASSWORD     VARCHAR(20),
    ACTIVITY_1 BOOLEAN,
    ACTIVITY_2 BOOLEAN,
    ACTIVITY_3 BOOLEAN
);

INSERT INTO USERS VALUES ('Admin', 'Admin', 'admin@gmail.com', '2000-01-01', '33366699', 'AMMINISTRATORE', 'admin', '37Adm1n!', 'false', 'false', 'false');

CREATE TABLE DONATIONS
(
    USERNAME     VARCHAR(20) not null
        primary key,
    VALUE_DONATION INT,
    DATE_DONATION DATE
);