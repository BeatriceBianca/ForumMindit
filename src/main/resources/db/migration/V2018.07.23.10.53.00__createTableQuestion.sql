create table if not exists question(
quest_id int auto_increment,
username varchar (255) NOT NULL,
quest_text varchar (750) not null,
primary key(quest_id)
)