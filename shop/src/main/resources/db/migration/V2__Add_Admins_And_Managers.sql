INSERT INTO users_tbl (user_id, archive_fld, email_fld, name_fld, password_fld, role_fld, bucket_bucket_id)
values (1, false, 'admin@mail.ru', 'admin', 'admin', 'ADMIN', null);
INSERT INTO users_tbl (user_id, archive_fld, email_fld, name_fld, password_fld, role_fld, bucket_bucket_id)
values (2, false, 'manager@mail.ru', 'manager', 'manager', 'MANAGER', null);
INSERT INTO users_tbl (user_id, archive_fld, email_fld, name_fld, password_fld, role_fld, bucket_bucket_id)
values (3, false, 'super@mail.ru', 'superman', 'superpass', 'SUPER_ADMIN', null);

ALTER SEQUENCE user_seq RESTART WITH 4;
