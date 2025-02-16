create table agency (
    id bigint auto_increment primary key,
    name varchar(255),
    agency_number int unique not null
);
