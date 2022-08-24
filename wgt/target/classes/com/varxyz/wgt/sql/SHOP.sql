CREATE TABLE shop (
	businessNumber		VARCHAR(13) 	PRIMARY KEY,
	shopName 			VARCHAR(50) 	NOT NULL,
	shopTel				VARCHAR(13)		NOT NULL,
	shopPostCode		VARCHAR(50)		NOT NULL,
	shopAddress			VARCHAR(50)		NOT NULL,
	shopDetailAddress	VARCHAR(50)		NOT NULL,
	shopExtraAddress	VARCHAR(50)		DEFAULT '없음',
	shopHours			VARCHAR(20)		NOT NULL,
	shopTables			VARCHAR(2)		NOT NULL,
	shopMaxPeoples		VARCHAR(2)		NOT NULL,
	shopImg				VARCHAR(10)		NOT NULL DEFAULT 'default'
);

CREATE TABLE menu (
	businessNumber		VARCHAR(13) 	NOT NULL,
	menuName			VARCHAR(20)		NOT NULL DEFAULT '-',
	menuIntro			VARCHAR(100)	NOT NULL DEFAULT '-',
	menuPrice			INT(6)			NOT NULL DEFAULT 0,
	menuImg				VARCHAR(10)		NOT NULL DEFAULT 'default',
	CONSTRAINT Shop_Name_FK
	FOREIGN KEY(businessNumber) REFERENCES shop(businessNumber)
);

DELETE FROM shop WHERE businessNumber = '000-000-000';
DELETE FROM MENU WHERE businessNumber = '222-222-222';

SELECT * FROM shop;
SELECT * FROM MENU;

DROP TABLE shop;
DROP TABLE menu;

SELECT s.BUSINESS_NUMBER,
	   s.SHOP_NAME,
	   s.SHOP_TEL,
	   s.SHOP_ADDRESS,
	   s.SHOP_HOURS,
	   s.SHOP_IMG,
	   m.SHOP_MENU_NAME,
	   m.SHOP_MENU_INTRO,
	   m.SHOP_MENU_PRICE,
	   m.SHOP_MENU_IMG
	   FROM shop s INNER JOIN
menu m WHERE s.BUSINESS_NUMBER = '123-4568-7891';

SELECT * FROM shop WHERE BUSINESS_NUMBER = '123-456-789';

SELECT businessNumber FROM menu;

--가게 추가
INSERT INTO shop VALUES('999-99-9999', 'testShopName', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');

--메뉴 추가
INSERT INTO menu VALUES('999-99-9999', 'testMenu', 'testIntro', 1000, '1234');
