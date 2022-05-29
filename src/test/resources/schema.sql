create table if not exists member
(
    id bigint auto_increment not null,
    email varchar(255) not null unique,
    name varchar(10) not null,
    password varchar(255) not null,
    primary key(id)
);
