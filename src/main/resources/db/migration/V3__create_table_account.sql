create table account (
    id_agency bigint,
    account_number int,
    balance double,
    status_account enum('active', 'inactive'),
    id_client bigint,
    primary key (id_agency, account_number),
    foreign key (id_agency) references agency(id),
    foreign key (id_client) references client(id)
);
