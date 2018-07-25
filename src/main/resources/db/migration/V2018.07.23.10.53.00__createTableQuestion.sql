create table if not exists question(
quest_id int auto_increment,
quest_text varchar (750) not null,
username varchar (50) not null,
primary key(quest_id)
);

insert into question(quest_text,username)
values(
'How can I save formatted text in controller without breaking MVC?',
'Alex'
),

('How to control the content (text) to display in a $form->input?',
'Robert Harvey'
),

('How do I get PHP errors to display?',
'CptEric'
),

('How can I get column names from a table in SQL Server?',
'Albert88'
),

('How to export data from postgresql to .csv file using jdbc?',
'User1058'
);