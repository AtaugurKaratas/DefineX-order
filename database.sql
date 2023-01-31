create table customer(
id serial primary key,
name varchar(100),
surname varchar(100),
registration_date date);

create table category(
id serial primary key,
name varchar(100));

create table sector(
id serial primary key,
name varchar(100));

create table company(
id serial primary key,
name varchar(100),
sector_id int references sector(id));

create table product(
id serial primary key,
name varchar(100),
price decimal,
category_id int references category(id),
company_id int references company(id));

create table order_table(
id serial primary key,
product_id int references product(id),
product_count int,
customer_id int references customer(id));

create table bill(
id serial primary key,
total_price decimal,
bill_date date,
customer_id int references customer(id),
company_id int references company(id));
