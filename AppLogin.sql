Drop database if exists DBRegistro;
Create database DBRegistro;
use DBRegistro;

Create table Persona(
codigoPersona int not null auto_increment,
DPI varchar (15) not null,
nombrePersona varchar (200) not null,
primary key PK_codigoPersona (codigoPersona)
); 

insert into Persona (DPI, nombrePersona)values('514898256134','Julio Samuel Isaac Lima Donis');
insert into Persona (DPI, nombrePersona)values('895146521947','Alejandro Carrillo García');
insert into Persona (DPI, nombrePersona)values('321546975984','José Marcos Ajuchán Chiquitó');
insert into Persona (DPI, nombrePersona)values('596314525241','Diego Jhonatan Chiyal Tzaj');
insert into Persona (DPI, nombrePersona)values('986532548165','Allan Rodrigo Hernández López');
insert into Persona (DPI, nombrePersona)values('361548795216','Heber Obdulio Ajbal Muj ');
insert into Persona (DPI, nombrePersona)values('020215480241','Pedro Luis Alvarez Gonzalez');
insert into Persona (DPI, nombrePersona)values('986521547865','Javier Alejandro Dubón Ubedo');
insert into Persona (DPI, nombrePersona)values('615249378105','Jose David Batres Garcia');
insert into Persona (DPI, nombrePersona)values('118905613264','Jairo Daniel Corona Boch');
insert into Persona (DPI, nombrePersona)values('691591732846','Néstor Alejandro Reina Méndez');

select * from Persona;

create table Rol(
codigoRol int not null,
nombreRol varchar(150) not null,
primary key PK_codigoRol(codigoRol)
);
insert into Rol(codigoRol, nombreRol)values(1,'Administrador');
insert into Rol(codigoRol, nombreRol)values(2,'Usuario');


create table Usuario(
codigoUsuario int not null auto_increment,
usuario varchar(150) not null,
contraseña varchar(150) not null,
codigoRol int not null, 	
primary key PK_codigoUsuario (codigoUsuario),
constraint FK_Usuario_Rol foreign key (codigoRol) references Rol(codigoRol)
);

insert into Usuario(Usuario, contraseña,codigoRol) values('a','1',1);
insert into Usuario(Usuario, contraseña,codigoRol) values('aa','2',2);


select * from Usuario;

#select * from usuarios where nombreUsuario='a' and passwordUsuario=1 and rolUsuario=1