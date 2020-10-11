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

alter table bucket_products add constraint bucket_products_fk_product foreign key (product_id) references products_tbl (product_id);
alter table bucket_products add constraint bucket_products_fk_bucket foreign key (bucket_id) references buckets_tbl (bucket_id);
alter table buckets_tbl add constraint buckets_tbl_fk_user foreign key (user_id) references users_tbl (user_id);
alter table order_details_tbl add constraint order_details_tbl_fk_order foreign key (order_id) references orders_tbl (order_id);
alter table order_details_tbl add constraint order_details_tbl_fk_product foreign key (product_id) references products_tbl (product_id);
alter table orders_tbl add constraint orders_tbl_fk_user foreign key (user_user_id) references users_tbl (user_id);
alter table products_categories add constraint products_categories_fk_category foreign key (category_id) references categories_tbl (category_id);
alter table products_categories add constraint products_categories_fk_product foreign key (product_id) references products_tbl (product_id);
alter table users_tbl add constraint users_tbl_fk_bucket foreign key (bucket_bucket_id) references buckets_tbl (bucket_id);