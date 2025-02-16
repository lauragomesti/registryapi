create table client(
    id bigint auto_increment primary key,
    address_street varchar(255),
    address_district varchar(255),
    address_cep varchar(20),
    address_number varchar(50),
    address_complement varchar(255),
    address_city varchar(255),
    address_uf varchar(10),
    type_client enum('pj', 'pf'),
    cpfcnpj varchar(20) unique not null
);
