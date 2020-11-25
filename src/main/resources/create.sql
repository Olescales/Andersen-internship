create table USERS
(
    ID       INT auto_increment,
    LOGIN    CHAR not null,
    PASSWORD CHAR not null,
    constraint USERS_PK
        primary key (ID)
);

create unique index USERS_ID_UINDEX
    on USERS (ID);

create unique index USERS_LOGIN_UINDEX
    on USERS (LOGIN);

create table USER_ROLE
(
    ID   INT auto_increment,
    NAME CHAR not null,
    constraint USER_ROLE_PK
        primary key (ID)
);

create unique index USER_ROLE_ID_UINDEX
    on USER_ROLE (ID);

create unique index USER_ROLE_NAME_UINDEX
    on USER_ROLE (NAME);

create table USERS_HAS_ROLES
(
    USER_ID INT not null,
    ROLE_ID INT not null,
    constraint USERS_HAS_ROLES_USERS_ID_FK
        foreign key (USER_ID) references USERS (ID),
    constraint USERS_HAS_ROLES_USER_ROLE_ID_FK
        foreign key (ROLE_ID) references USER_ROLE (ID)
);