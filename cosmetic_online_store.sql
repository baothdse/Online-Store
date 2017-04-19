create database if not exists cosmetic_online_store;

use cosmetic_online_store;

create table Product (
productId int not null auto_increment,
productName varchar(255) not null,
introduction text,
productKind varchar(255),
brand varchar(255),
price varchar(20),
productQuantity int,
addedDate date,
addedTime time,
soldQuantity int,
primary key (productId)
);

create table Image (
imageId int not null auto_increment,
link text,
primary key (imageId)
);

create table ProductImage (
productId int,
imageId int,
primary key (productId, imageId),
constraint fk_product foreign key (productId) references Product(productId),
constraint fk_image foreign key (imageId) references Image(imageId)
);

create table Discount (
discountId int not null auto_increment,
discountCode varchar(20),
startDate date, 
endDate date,
amount varchar(5),
primary key (discountId)
);

create table ProductDiscount (
productId int,
discountId int,
primary key (productId, discountId),
constraint fk_product_discount foreign key (productId) references Product(productId),
constraint fk_discount foreign key (discountId) references Discount(discountId)
);

create table SelectedProduct (
selectedId int not null auto_increment,
quantity int,
productId int,
primary key(selectedId),
constraint fk_selected foreign key (productId) references Product(productId)
);

create table User (
userId int not null auto_increment,
username varchar(255),
password varchar(255),
firstName varchar(255),
lastName varchar(255),
address varchar(255),
city varchar(255),
email varchar(255),
phone varchar(20),
roleId int,
primary key(userId)
);

create table Cart (
cartId int not null auto_increment,
totalPrice varchar(20),
note text,
userId int,
primary key (cartId),
constraint fk_customer foreign key (userId) references User(userId)
);

create table SelectedProductCart (
selectedId int, 
cartId int,
primary key (selectedId, cartId),
constraint fk_selected_cart foreign key (selectedId) references SelectedProduct(selectedId),
constraint fk_cart foreign key (cartId) references Cart(cartId)
);

