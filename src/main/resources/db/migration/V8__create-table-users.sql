create table users(

    id bigint not null auto_increment,
    cpfcnpj varchar(100) not null,
    password(255) not null,

    primary key(id)

);