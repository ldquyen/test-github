CREATE DATABASE FlowerManagement

CREATE TABLE Customer(
	CusID int identity(1,1) Primary Key not null,
	Email varchar(35) not null,
	Password varchar(14) not null,
	Name nvarchar(30) not null,
	Address nvarchar(50) not null,
	Phone nvarchar(10) not null,
	CusStatus bit not null
)

CREATE TABLE Account(
	AccID nvarchar(4) Primary Key not null, 
	Email varchar(35) not null,
	Password varchar(14) not null,
	Role varchar(10) not null
)

CREATE TABLE [Order] (
    OrderID int identity(1,1) PRIMARY KEY not null,
    OrderDate datetime null,
    OrderStatus int not null,
	ShipperID nvarchar(4) null,
    CusID int, 
    FOREIGN KEY(CusID) REFERENCES Customer(CusID),  
	FOREIGN KEY(ShipperID) REFERENCES Account(AccID)
)

CREATE TABLE Feedback(
	FeedbackID int identity(1,1) PRIMARY KEY not null,
	FeedbackDate datetime null,
	Comment nvarchar(200) null,
	CusID int,
	OrderID int,
	FOREIGN KEY(CusID) REFERENCES Customer(CusID),
	FOREIGN KEY(OrderID) REFERENCES [Order](OrderID)
)

CREATE TABLE Category(
	CatID int identity(1,1) PRIMARY KEY not null,
	CatName nvarchar(20) not null
)

CREATE TABLE Item(
    ItemID int identity(1,1) not null PRIMARY KEY,
    ItemName nvarchar(20) not null,
    Price float not null,
    ItemStatus int not null,
	FileIMG varchar(100) null,
    CatID int,
    FOREIGN KEY(CatID) REFERENCES Category(CatID)
)

CREATE TABLE OrderDetail(
    OrderDetailID int identity(1,1) PRIMARY KEY not null,
    Quantity int not null,
    OrderDetailPrice float not null,
    ItemID int,
    OrderID int, 
    FOREIGN KEY(ItemID) REFERENCES Item(ItemID),
    FOREIGN KEY(OrderID) REFERENCES [Order](OrderID) 
)



DROP DATABASE FlowerManagement
DROP TABLE [dbo].[Account]
DROP TABLE [dbo].[Category]
DROP TABLE [dbo].[Customer]
DROP TABLE [dbo].[Feedback]
DROP TABLE [dbo].[Item]
DROP TABLE [dbo].[Order]