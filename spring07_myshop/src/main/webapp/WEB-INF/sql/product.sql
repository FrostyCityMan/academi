create table product (
    product_code int primary key,
    product_name varchar(255) not null,
    description varchar(255) not null,
    price int default 0,
    filename varchar(500)

);

--create sequence
create sequence product_seq;