create table if not exists answer(
ans_id int auto_increment,
q_id int not null,
username varchar (255) not null,
ans_text varchar (750) not null,
primary key(ans_id)
);

insert into answer(q_id,username,ans_text)
values(
'1',
'Alex',
'So, following @ndm suggestion here is what I did:
    $vars = [/* my viewVars here */]
    $view = new ViewBuilder();
    $content = $view->setTemplate("path_to_my_template")
        ->setLayout(false) // I need an empty layout
        ->setHelpers([Number])  // I need some additional helper
        ->build($vars)  //here I pass my vars to the template
        ->render();'
),

(
'2',
'Robert Harvey',
'If you want to add a string in as the value of the input, try this to make the input hidden, and set the value.:
echo $form->input(my label text,array(value=>the value string,type=>hidden));'
),


(
'3',
'CptEric',
'This always works for me:
ini_set(display_errors, 1);
ini_set(display_startup_errors, 1);
error_reporting(E_ALL);'
),


(
'4',
'Albert88',
'You can obtain this information and much, much more by querying the Information Schema views.
This sample query:
SELECT *
FROM Northwind.INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = NCustomers'
),


(
'5',
'User1058',
'The error shows ERROR: must be superuser to COPY to or from a file
It seems that the current user is not having enough permissions to write the file.
Provide permissions to the write location for the user or execute the program from a user account which has sufficient privileges to write to the file.
'
);