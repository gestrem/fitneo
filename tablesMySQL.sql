-----Users----
create table mainuser(
idUser int not null auto_increment,
userFirstName varchar(25) not null,
userLastName varchar(25) not null,
userAdresse varchar(50) not null,
userCity varchar(25) not null,
userCP varchar(5) not null,
userEmail varchar(50) not null unique,
passwordUser varchar(255) not null,
roleAdmin boolean not null,
roleParticipant boolean not null,
roleMember boolean not null,
roleManager boolean not null,
userAnswer varchar(50) not null,
idQuestion int not null,
PRIMARY KEY (idUser)
);

-- Notifications

create table notification(
idNotification int not null auto_increment,
receiver int not null,
sender int not null,
isread boolean not null,
isCreationDemand boolean not null,
primary key (idNotification),
key FK_notification_sender (sender),
key FK_notification_receiver (receiver)
);
ALTER TABLE `notification`
	ADD CONSTRAINT FK_notification_sender FOREIGN KEY (sender) REFERENCES mainuser (idUser);
ALTER TABLE `notification`
	ADD CONSTRAINT FK_notification_receiver FOREIGN KEY (receiver) REFERENCES mainuser (idUser);

-- UserOrder

create table Userorder (
id_purchase_command int not null auto_increment,
command_date date not null ,
idUser int not null,
primary key (id_purchase_command),
key FK_order_user(idUser)
);
ALTER TABLE `Userorder`
	ADD CONSTRAINT FK_order_user FOREIGN KEY (idUser) REFERENCES mainuser (idUser);

--Product

create table ProductType (
id_producttype int not null auto_increment,
productPrice float not null,
availableProductQuantity int not null,
DiscountMember int not null,
id_category int not null ,
primary key (id_producttype),
key FK_product_category(id_category)
);
ALTER TABLE `ProductType`
	ADD CONSTRAINT FK_product_category FOREIGN KEY (id_category) REFERENCES categoryProduct (id_category);

--Category

create table categoryProduct(
id_category int not null auto_increment,
categoryLabel varchar(50),
id_super_category int not null,
primary key (id_category),
key FK_category_categoryParent(id_super_category)
);
ALTER TABLE `categoryProduct`
	ADD CONSTRAINT FK_category_categoryParent FOREIGN KEY (id_super_category) REFERENCES categoryProduct (id_category);

--Basket ---

create table basket(
idBasket int not null auto_increment,
idUser int not null unique,
primary key(idBasket),
key FK_basket_user(idUser)
);
ALTER TABLE `basket`
	ADD CONSTRAINT FK_basket_user FOREIGN KEY (idUser) REFERENCES mainuser (idUser);
	
--CommandLine

create table CommandLine(
id_producttype int not null,
id_basket int not null,
quantity int not null,
primary key (id_producttype, id_basket),
key FK_commandLine_product(id_producttype),
key FK_commandLine_basket(id_basket)
);
ALTER TABLE `CommandLine`
	ADD CONSTRAINT FK_commandLine_product FOREIGN KEY (id_producttype) REFERENCES ProductType(id_producttype);
ALTER TABLE `CommandLine`
	ADD CONSTRAINT FK_commandLine_basket FOREIGN KEY (id_basket) REFERENCES basket (idBasket);

------Activity------

create table activity (
idActivity int not null auto_increment,
activityName varchar(25) not null,
shortActivityDesc varchar(250) not null,
detailedActivityDesc varchar(500),
manager int not null,
primary key (idActivity),
key FK_activity_manager(manager)
);
ALTER TABLE `activity`
	ADD CONSTRAINT FK_activity_manager FOREIGN KEY (manager) REFERENCES mainuser (idUser);

------Event--------

create table event (
idEvent int not null auto_increment,
eventName varchar(50),
eventDate date not null,
eventPrice float,
idroom int not null,
participant int not null,
primary key (idEvent),
key FK_event_room (idroom),
key FK_event_participant(participant)
);
ALTER TABLE `event`
	ADD CONSTRAINT FK_event_room FOREIGN KEY (idroom) REFERENCES room (idRoom);
ALTER TABLE `event`
	ADD CONSTRAINT FK_event_participant FOREIGN KEY (participant) REFERENCES mainuser (idUser);

--Participe --
create table inscription (
idmember int not null,
idevent int not null,
dateinscription date not null,
primary key(idmember, idevent),
key FK_inscription_user(idmember),
key FK_inscription_event(idevent)
);
ALTER TABLE `inscription`
	ADD CONSTRAINT FK_inscription_user FOREIGN KEY (idmember) REFERENCES mainuser (idUser);
ALTER TABLE `inscription`
	ADD CONSTRAINT FK_inscription_event FOREIGN KEY (idevent) REFERENCES event (idEvent);

------Room--------

create table room (
idRoom int not null auto_increment,
roomArea varchar(50) not null,
roomType varchar(25) not null,
capacity int,
primary key(idRoom)
);

------AccesoryType--------

create table accessoryType (
idAccessoryType int not null auto_increment,
accessoryName varchar(50) not null,
primary key (idAccessoryType)
);

------Room Accessory--------

create table roomAccessory(
idroom int not null,
idAccessoryType int not null,
quantity int not null,
primary key(idroom, idAccessoryType),
key FK_roomAccessory_room (idroom),
key FK_roomAccessory_accessory (idAccessoryType)
);
ALTER TABLE `roomAccessory`
	ADD CONSTRAINT FK_roomAccessory_room FOREIGN KEY (idroom) REFERENCES room (idRoom);
ALTER TABLE `roomAccessory`
	ADD CONSTRAINT FK_roomAccessory_accessory FOREIGN KEY (idAccessoryType) REFERENCES accessoryType (idAccessoryType);