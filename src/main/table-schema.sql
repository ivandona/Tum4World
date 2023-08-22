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
    PASSWORD     VARCHAR(20)
);

INSERT INTO USERS VALUES ('Admin', 'Admin', 'admin@gmail.com', '2000-01-01', '33366699', 'AMMINISTRATORE', 'Admin', 'password');