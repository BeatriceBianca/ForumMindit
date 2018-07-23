create table if not exists answer(
ans_id int auto_increment,
q_id int not null,
username varchar (255) not null,
ans_text varchar (750) not null,
primary key(ans_id)
)