create table if not exists user(
user_id int auto_increment,
first_name varchar (255) not null,
last_name varchar (255) not null,
username varchar (255) not null,
password varchar(255) not null,
primary key(user_id)
);

insert into user(first_name,last_name,username,password)
values(
'Alexander',
'Mclean',
'Alex',
'1234'
),


('Robert',
'Harvey',
'Robert Harvey',
'2345'
),


('Eric',
'Long',
'CptEric',
'3456'
),

('Albert',
'Green',
'Albert88',
'4567'
),

('Anonymous',
'User',
'User1058',
'5678'
);