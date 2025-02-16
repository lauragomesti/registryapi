create table transaction (
    id bigint auto_increment primary key,
    id_payment bigint,
    transaction_operation enum('finished', 'processing', 'reversed', 'cancelled'),
    foreign key (id_payment) references payment(id)
);
