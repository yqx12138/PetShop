CREATE DATABASE PetShop

GO

CREATE DATABASE PetShopOrders

GO

USE PETSHOP

GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Account]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Account]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[BannerData]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[BannerData]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Category]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Category]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Inventory]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Inventory]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Item]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Item]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Product]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Product]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Profile]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Profile]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Supplier]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Supplier]
GO

CREATE TABLE [dbo].[Account] (
	[UserId] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[password] [varchar] (20) COLLATE Chinese_PRC_CI_AS NULL ,
	[Email] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[FirstName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[LastName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Status] [varchar] (2) COLLATE Chinese_PRC_CI_AS NULL ,
	[Addr1] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Addr2] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[City] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[State] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Zip] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Country] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Phone] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[BannerData] (
	[FavCategory] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BannerData] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Category] (
	[CatId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Name] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Descn] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Inventory] (
	[ItemId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Qty] [int] NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Item] (
	[ItemId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ProductId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ListPrice] [decimal](10, 2) NULL ,
	[UnitCost] [decimal](10, 2) NULL ,
	[Supplier] [int] NULL ,
	[Status] [varchar] (2) COLLATE Chinese_PRC_CI_AS NULL ,
	[Attr1] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Attr2] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Attr3] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Attr4] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Attr5] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Product] (
	[ProductId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Category] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Name] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Descn] [varchar] (255) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Profile] (
	[UserId] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[FavCategory] [varchar] (30) COLLATE Chinese_PRC_CI_AS NULL ,
	[MyListOpt] [int] NULL ,
	[BannerOpt] [int] NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Supplier] (
	[SuppId] [int] NOT NULL ,
	[Name] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Status] [varchar] (2) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Addr1] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Addr2] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[City] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[State] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[Zip] [varchar] (5) COLLATE Chinese_PRC_CI_AS NULL ,
	[Phone] [varchar] (40) COLLATE Chinese_PRC_CI_AS NULL 
) ON [PRIMARY]
GO

USE PETSHOPORDERS

GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[LineItem]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[LineItem]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[OrderStatus]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[OrderStatus]
GO

if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[Orders]') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table [dbo].[Orders]
GO

CREATE TABLE [dbo].[LineItem] (
	[OrderId] [int] NOT NULL ,
	[LineNum] [int] NOT NULL ,
	[ItemId] [varchar] (10) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Quantity] [int] NOT NULL ,
	[UnitPrice] [decimal](10, 2) NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[OrderStatus] (
	[OrderId] [int] NOT NULL ,
	[LineNum] [int] NOT NULL ,
	[Timestamp] [datetime] NOT NULL ,
	[Status] [varchar] (2) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Orders] (
	[OrderId] [int] IDENTITY (1, 1) NOT NULL ,
	[UserId] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[OrderDate] [datetime] NOT NULL ,
	[ShipAddr1] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipAddr2] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[ShipCity] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipState] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipZip] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipCountry] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillAddr1] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillAddr2] [varchar] (80) COLLATE Chinese_PRC_CI_AS NULL ,
	[BillCity] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillState] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillZip] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillCountry] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Courier] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[TotalPrice] [decimal](10, 2) NOT NULL ,
	[BillToFirstName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[BillToLastName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipToFirstName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ShipToLastName] [varchar] (80) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[CreditCard] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[ExprDate] [datetime] NOT NULL ,
	[CardType] [varchar] (40) COLLATE Chinese_PRC_CI_AS NOT NULL ,
	[Locale] [varchar] (20) COLLATE Chinese_PRC_CI_AS NOT NULL 
) ON [PRIMARY]
GO

insert into [PetShop].[dbo].[Category] values('BIRDS','Birds','null')
insert into [PetShop].[dbo].[Category] values('CATS','Cats','null')
insert into [PetShop].[dbo].[Category] values('DOGS','Dogs','null')
insert into [PetShop].[dbo].[Category] values('FISH','Fish','null')
insert into [PetShop].[dbo].[Category] values('REPTILES','Reptiles','null')

GO

insert into [PetShop].[dbo].[Inventory] values('EST-1',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-10',9975)
insert into [PetShop].[dbo].[Inventory] values('EST-11',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-12',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-13',9989)
insert into [PetShop].[dbo].[Inventory] values('EST-14',9997)
insert into [PetShop].[dbo].[Inventory] values('EST-15',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-16',9999)
insert into [PetShop].[dbo].[Inventory] values('EST-17',9999)
insert into [PetShop].[dbo].[Inventory] values('EST-18',9996)
insert into [PetShop].[dbo].[Inventory] values('EST-19',9985)
insert into [PetShop].[dbo].[Inventory] values('EST-2',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-20',9999)
insert into [PetShop].[dbo].[Inventory] values('EST-21',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-22',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-23',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-24',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-25',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-26',9998)
insert into [PetShop].[dbo].[Inventory] values('EST-27',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-28',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-3',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-4',9999)
insert into [PetShop].[dbo].[Inventory] values('EST-5',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-6',9997)
insert into [PetShop].[dbo].[Inventory] values('EST-7',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-8',10000)
insert into [PetShop].[dbo].[Inventory] values('EST-9',9999)

GO

insert into [PetShop].[dbo].[Item] values('EST-1','FI-SW-01',16.50,10.00,1,'P','Large','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-10','K9-DL-01',18.50,12.00,1,'P','Spotted Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-11','RP-SN-01',18.50,12.00,1,'P','Venomless','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-12','RP-SN-01',18.50,12.00,1,'P','Rattleless','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-13','RP-LI-02',18.50,12.00,1,'P','Green Adult','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-14','FL-DSH-01',58.50,12.00,1,'P','Tailless','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-15','FL-DSH-01',23.50,12.00,1,'P','Tailed','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-16','FL-DLH-02',93.50,12.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-17','FL-DLH-02',93.50,12.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-18','AV-CB-01',193.50,92.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-19','AV-SB-02',15.50,2.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-2','FI-SW-01',16.50,10.00,1,'P','Small','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-20','FI-FW-02',5.50,2.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-21','FI-FW-02',5.29,1.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-22','K9-RT-02',135.50,100.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-23','K9-RT-02',145.49,100.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-24','K9-RT-02',255.50,92.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-25','K9-RT-02',325.29,90.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-26','K9-CW-01',125.50,92.00,1,'P','Adult Male','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-27','K9-CW-01',155.29,90.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-28','K9-RT-01',155.29,90.00,1,'P','Adult Female','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-3','FI-SW-02',18.50,12.00,1,'P','Toothless','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-4','FI-FW-01',18.50,12.00,1,'P','Spotted','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-5','FI-FW-01',18.50,12.00,1,'P','Spotless','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-6','K9-BD-01',18.50,12.00,1,'P','Male Adult','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-7','K9-BD-01',18.50,12.00,1,'P','Female Puppy','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-8','K9-PO-02',18.50,12.00,1,'P','Male Puppy','null','null','null','null')
insert into [PetShop].[dbo].[Item] values('EST-9','K9-DL-01',18.50,12.00,1,'P','Spotless Male Puppy','null','null','null','null')

GO

insert into [PetShop].[dbo].[Product] values('AV-CB-01','BIRDS','Amazon Parrot','<img align="absmiddle" src="Images/Pets/bird1.jpg">Great companion for up to 75 years')
insert into [PetShop].[dbo].[Product] values('AV-SB-02','BIRDS','Finch','<img align="absmiddle" src="Images/Pets/bird2.jpg">Great stress reliever')
insert into [PetShop].[dbo].[Product] values('FI-FW-01','FISH','Koi','<img align="absmiddle" src="Images/Pets/fish3.jpg">Freshwater fish from Japan')
insert into [PetShop].[dbo].[Product] values('FI-FW-02','FISH','Goldfish','<img align="absmiddle" src="Images/Pets/fish4.jpg">Freshwater fish from China')
insert into [PetShop].[dbo].[Product] values('FI-SW-01','FISH','Angelfish','<img align="absmiddle" src="Images/Pets/fish1.jpg">Saltwater fish from Australia')
insert into [PetShop].[dbo].[Product] values('FI-SW-02','FISH','Tiger Shark','<img align="absmiddle" src="Images/Pets/fish2.jpg">Saltwater fish from Australia')
insert into [PetShop].[dbo].[Product] values('FL-DLH-02','CATS','Persian','<img align="absmiddle" src="Images/Pets/cat2.jpg">Friendly house cat, doubles as a princess')
insert into [PetShop].[dbo].[Product] values('FL-DSH-01','CATS','Manx','<img align="absmiddle" src="Images/Pets/cat1.jpg">Great for reducing mouse populations')
insert into [PetShop].[dbo].[Product] values('K9-BD-01','DOGS','Bulldog','<img align="absmiddle" src="Images/Pets/dog1.jpg">Friendly dog from England')
insert into [PetShop].[dbo].[Product] values('K9-CW-01','DOGS','Chihuahua','<img align="absmiddle" src="Images/Pets/dog6.jpg">Great companion dog')
insert into [PetShop].[dbo].[Product] values('K9-DL-01','DOGS','Dalmation','<img align="absmiddle" src="Images/Pets/dog3.jpg">Great dog for a fire station')
insert into [PetShop].[dbo].[Product] values('K9-PO-02','DOGS','Poodle','<img align="absmiddle" src="Images/Pets/dog2.jpg">Cute dog from France')
insert into [PetShop].[dbo].[Product] values('K9-RT-01','DOGS','Golden Retriever','<img align="absmiddle" src="Images/Pets/dog4.jpg">Great family dog')
insert into [PetShop].[dbo].[Product] values('K9-RT-02','DOGS','Labrador Retriever','<img align="absmiddle" src="Images/Pets/dog5.jpg">Great hunting dog')
insert into [PetShop].[dbo].[Product] values('RP-LI-02','REPTILES','Iguana','<img align="absmiddle" src="Images/Pets/reptile2.jpg">Friendly green friend')
insert into [PetShop].[dbo].[Product] values('RP-SN-01','REPTILES','Rattlesnake','<img align="absmiddle" src="Images/Pets/reptile1.jpg">Doubles as a watch dog')

GO

insert into [PetShop].[dbo].[Supplier] values(1,'XYZ Pets','AC','600 Avon Way','','Los Angeles','CA','94024','212-947-0797')
insert into [PetShop].[dbo].[Supplier] values(2,'ABC Pets','AC','700 Abalone Way','','San Francisco','CA','94024','415-947-0797')
