create table payment (
    id bigint auto_increment primary key,
    id_origin_account bigint,
    id_destination_account bigint,
    transaction_status enum('COMPLETED', 'PROCESSING', 'ERROR', 'CANCELLED'),
    data_hora timestamp,
    payment_amount double,
    foreign key (id_origin_account) references account(id_agency),
    foreign key (id_destination_account) references account(id_agency)
);
