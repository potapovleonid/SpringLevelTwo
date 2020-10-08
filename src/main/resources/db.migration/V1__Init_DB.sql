-- USER
create table user_seq
    (next_val bigint)
    engine=InnoDB;

insert into user_seq
    values ( 1 );

create table users_tbl
    (user_id bigint not null,
    archive_fld bit,
    email_fld varchar(255),
    name_fld varchar(255),
    password_fld varchar(255),
    role_fld varchar(255),
    bucket_bucket_id bigint,
    primary key (user_id))
    engine=InnoDB;

-- BUCKET
create table bucket_products
    (bucket_id bigint not null,
    product_id bigint not null)
    engine=InnoDB;

create table bucket_seq
    (next_val bigint)
    engine=InnoDB;

insert into bucket_seq
    values ( 1 );

create table buckets_tbl
    (bucket_id bigint not null,
    user_id bigint, primary key (bucket_id))
    engine=InnoDB;

-- CATEGORY
create table categories_tbl
    (category_id bigint not null,
    title_fld varchar(255),
    primary key (category_id))
    engine=InnoDB;

create table category_seq
    (next_val bigint)
    engine=InnoDB;

insert into category_seq
    values ( 1 );

-- ORDER DETAILS
create table order_details_tbl
    (order_detail_id bigint not null,
    amount_fld decimal(19,2),
    price_fld decimal(19,2),
    order_id bigint,
    product_id bigint,
    primary key (order_detail_id))
    engine=InnoDB;

create table order_details_seq
    (next_val bigint)
    engine=InnoDB;

insert into order_details_seq
    values ( 1 );

-- ORDER
create table order_seq
    (next_val bigint)
    engine=InnoDB;


insert into order_seq
    values ( 1 );

create table orders_tbl
    (order_id bigint not null,
    address_fld varchar(255),
    changed_fld datetime(6),
    created_fld datetime(6),
    status_fld varchar(255),
    summ_fld decimal(19,2),
    user_user_id bigint,
    primary key (order_id))
    engine=InnoDB;

-- PRODUCT
create table product_seq
    (next_val bigint)
    engine=InnoDB;

insert into product_seq
    values ( 1 );

create table products_categories
    (product_id bigint not null,
    category_id bigint not null)
    engine=InnoDB;

create table products_tbl
    (product_id bigint not null,
    price_fld double precision,
    title_fld varchar(255),
    primary key (product_id))
    engine=InnoDB;

-- ALTER

alter table bucket_products add constraint FKpr1k7tk7i0orlefrsvc6oypwy foreign key (product_id) references products_tbl (product_id)
alter table bucket_products add constraint FKejswpho61ms1v5eselgw5p2nj foreign key (bucket_id) references buckets_tbl (bucket_id)
alter table buckets_tbl add constraint FK5fmxd234trk46gchv7xju7q8v foreign key (user_id) references users_tbl (user_id)
alter table order_details_tbl add constraint FKfwnnigadhgbh3bh385822gwpu foreign key (order_id) references orders_tbl (order_id)
alter table order_details_tbl add constraint FKtjcy582393gb2wdq0w7lurrbe foreign key (product_id) references products_tbl (product_id)
alter table orders_tbl add constraint FKh6fqhpsyoltqgyylvlx3jqt20 foreign key (user_user_id) references users_tbl (user_id)
alter table products_categories add constraint FKa7w660fwjy06u3ph2ndwvh9u0 foreign key (category_id) references categories_tbl (category_id)
alter table products_categories add constraint FKeg6p7g3chbonvfq9w3rp5eh9c foreign key (product_id) references products_tbl (product_id)
alter table users_tbl add constraint FK53mjhkkckldgbb75045av15xt foreign key (bucket_bucket_id) references buckets_tbl (bucket_id)