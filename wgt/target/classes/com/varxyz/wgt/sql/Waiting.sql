CREATE TABLE Waiting(
	barName			VARCHAR(20)		PRIMARY KEY,
	num_people		BIGINT			NOT NULL,
	userId			VARCHAR(20)		NOT NULL,
	regDate			TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT Waiting_userId_FK FOREIGN KEY (userId) REFERENCES User(userId)
);

SELECT * FROM Waiting;

DROP TABLE Waiting;

INSERT INTO Waiting VALUES ("미러볼", 3, "psg", regDate);
INSERT INTO User VALUES ("sssssg06", "1234", "박상규", "980618", "01034903180", "대구요");
--------------------------------------------------------------------------------------------------

UPDATE Account SET balance = 1000000 WHERE customerId = 'lty';
UPDATE Account A INNER JOIN Customer C ON A.customerId = C.id 
DELETE FROM Category WHERE name = '';
SET A.balance = 1000000 WHERE A.accountNum = '539-11-1187' AND C.passwd = '1234';
alter table Menu add picture VARCHAR(100) not null;