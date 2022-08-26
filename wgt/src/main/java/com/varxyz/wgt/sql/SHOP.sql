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
INSERT INTO shop VALUES('123-456-789', 'testShopName', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('123-456-789', 'testMenu', 'testIntro', 1000, '1234');
INSERT INTO shop VALUES('111-111-111', 'testShopName2', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('111-111-111', 'testMenu2', 'testIntro', 12000, '1234');
INSERT INTO menu VALUES('111-111-111', 'testMenu2', 'testIntro2', 22000, '1234');
INSERT INTO shop VALUES('222-222-222', 'testShopName3', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('222-222-222', 'testMenu3', 'testIntro3', 22000, '1234');
INSERT INTO shop VALUES('122-222-222', 'testShopName4', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('122-222-222', 'testMenu4', 'testIntro3', 22000, '1234');

CREATE TABLE menu (
	businessNumber		VARCHAR(13) 	NOT NULL,
	menuName			VARCHAR(20)		NOT NULL DEFAULT '-',
	menuIntro			VARCHAR(100)	NOT NULL DEFAULT '-',
	menuPrice			INT(6)			NOT NULL DEFAULT 0,
	menuImg				VARCHAR(10)		NOT NULL DEFAULT 'default',
	CONSTRAINT Shop_Name_FK
	FOREIGN KEY(businessNumber) REFERENCES shop(businessNumber)
);

-- 테스트 코드
INSERT INTO shop VALUES('123-456-789', 'testShopName', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('123-456-789', 'testMenu', 'testIntro', 1000, '1234');
INSERT INTO shop VALUES('111-111-111', 'testShopName2', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('111-111-111', 'testMenu2', 'testIntro', 12000, '1234');
INSERT INTO menu VALUES('111-111-111', 'testMenu2', 'testIntro2', 22000, '1234');
INSERT INTO shop VALUES('222-222-222', 'testShopName3', '053-111-123', '1234', '1234', '1234', '1234', '1234', '1', '1', '1234');
INSERT INTO menu VALUES('222-222-222', 'testMenu3', 'testIntro3', 22000, '1234');

DELETE FROM shop ;
DELETE FROM MENU ;

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

SELECT * FROM menu WHERE menuName = 'test10' AND businessNumber = '123-456-789';
