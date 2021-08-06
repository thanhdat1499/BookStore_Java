CREATE DATABASE BookStore

USE BookStore

CREATE TABLE Category(  categoryId int  NOT NULL PRIMARY KEY,
         categoryName nvarchar(50),
		 CategoryStatus int
		 )
CREATE TABLE Book( BookId int NOT NULL PRIMARY KEY,
         BookName nvarchar(50),
         BookDescription nvarchar(50),
         Author nvarchar(20),
         Images nvarchar(20),
         Quantity int,
         Price int,
         CreateDate date,
         BookStatus int,
  
         categoryId int FOREIGN KEY
                                        REFERENCES Category(categoryId))

CREATE TABLE Account( UserID int NOT NULL PRIMARY KEY,
		  UserName nvarchar(50),
		  Password nvarchar(50),
		  FullName nvarchar(50),
		  Address nvarchar(50),
		  Phone nvarchar(50),
		  Role int,
		  CreateDate date,
		  Status int
)

CREATE TABLE DiscountCode(  DisId int  NOT NULL PRIMARY KEY,
         DisName nvarchar(50),
		 CreateDate date,
		 DisPercent int
		 )
CREATE TABLE DiscountUsed( Id int NOT NULL PRIMARY KEY,
         UserId int,
         discountId int FOREIGN KEY
                                        REFERENCES DiscountCode(DisId))


CREATE TABLE OrderBook( OrderId int NOT NULL PRIMARY KEY,
		 CreateDate date,
		 TotalPrice float,
		 UserId int FOREIGN KEY
                                        REFERENCES Account(UserId),
         discountId int FOREIGN KEY
                                        REFERENCES DiscountCode(DisId))

CREATE TABLE OrderDetail( OrderDetailId int NOT NULL PRIMARY KEY,
		 BookName nvarchar(50),
		 BookPrice int,
		 BoughtQuantity int,
		 OrderId int FOREIGN KEY
                                        REFERENCES OrderBook(OrderId),
         BookId int FOREIGN KEY
                                        REFERENCES Book(BookId))