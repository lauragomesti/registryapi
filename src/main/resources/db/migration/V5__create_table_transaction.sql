create table transaction (
    id bigint auto_increment primary key,
    id_payment bigint,
    agency_type  varchar(255),
    transaction_operation enum('FINISHED', 'PROCESSING', 'REVERSED', 'CANCELLED'),
    foreign key (id_payment) references payment(id)
);
