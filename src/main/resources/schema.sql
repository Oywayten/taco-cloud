create table if not exists Doner_Order
(
    id              identity,
    delivery_Name   varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City   varchar(50) not null,
    delivery_State  varchar(2)  not null,
    delivery_Zip    varchar(10) not null,
    cc_number       varchar(16) not null,
    cc_expiration   varchar(5)  not null,
    cc_cvv          varchar(3)  not null,
    placed_at       timestamp   not null
);

create table if not exists Doner
(
    id             identity,
    name           varchar(50) not null,
    doner_order     bigint      not null,
    doner_order_key bigint      not null,
    created_at     timestamp   not null
);

comment on column Doner.doner_order_key is 'Doner sequence number in the order';

create table if not exists Ingredient_Ref
(
    ingredient varchar(4) not null,
    doner       bigint     not null,
    doner_key   bigint     not null
);

comment on column Ingredient_Ref.doner_key is 'Sequence number of the ingredient in the doner';

create table if not exists Ingredient
(
    id   varchar(4)  not null,
    name varchar(25) not null,
    type varchar(10) not null
);
