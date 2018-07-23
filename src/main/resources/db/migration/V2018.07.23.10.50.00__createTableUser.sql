create table if not exists user(
user_id int auto_increment,
first_name varchar (255) not null,
last_name varchar (255) not null,
username varchar (255) not null,
password varchar(255) not null,
primary key(user_id)
)