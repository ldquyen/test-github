
INSERT INTO Account (AccID, Email, Password, Role)
VALUES
    ('A001', 'admin1@gmail.com', 'admin01', 'admin'),
    ('A002', 'admin2@gmail.com', 'admin02', 'admin'),
    ('S001', 'shipper1@gmail.com', 'shipper01', 'shipper'),
    ('S002', 'shipper2@gmail.com', 'shipper02', 'shipper'),
    ('S003', 'shipper3@gmail.com', 'shipper03', 'shipper')

INSERT INTO Customer (Email, Password, Name, Address, Phone, CusStatus)
VALUES
  ('customer1@gmail.com', 'password1', 'Customer 1', '123 HANOI', '1234567890', 0),
  ('customer2@gmail.com', 'password2', 'Customer 2', '456 NHA TRANG', '2345678901', 0),
  ('abcxyz@gmail.com', 'abcxyz', 'MALISA', '789 HCM CITY', '3456789012', 0);

  INSERT INTO [Category] ([CatName]) 
  VALUES 
  ('HOA GIA'),
  ('HOA HONG'),
  ('HOA LAN')

 INSERT INTO [Item] ([ItemName],[Price],[ItemStatus],[FileIMG],[CatID])
  VALUES 
  ('HOA HONG DEN', 100, 50, 'img/hoahongden.jpg',2),
  ('HOA HONG BACH HO', 999, 10,'img/hoahongtrang.jpg', 2),
  ('HOA HONG SAPA', 200, 30,'img/hoahongsapa.jpg', 2),
  ('HOA LAN DOT BIEN', 9999, 5,'', 3)  

INSERT INTO [Order] (OrderDate, OrderStatus, CusID)
VALUES
	('2023-10-10', 1, 1),
    ('2023-10-28', 1, 1),
    ('2023-10-29', 1, 2), 
    ('2023-10-30', 1, 3)



