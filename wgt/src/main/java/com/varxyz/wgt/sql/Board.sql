CREATE TABLE Board(
   number		BIGINT			PRIMARY KEY AUTO_INCREMENT,
   title		VARCHAR(100)	NOT NULL,
   content		VARCHAR(150)	NOT NULL,
   likecount	INT				DEFAULT 0,
   regDate		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
   imgname		VARCHAR(100)	DEFAULT NULL,
   userId		VARCHAR(20)		NOT NULL,
   CONSTRAINT Board_userId_FK FOREIGN KEY (userId) REFERENCES User(userId)
);

SELECT * FROM Board ORDER BY regDate DESC;

SELECT * FROM Board;

DROP TABLE Board;

SELECT DATE_FORMAT(regDate,'%y년 %m월 %d일 %H시 %i분') AS DATE FROM Board;

CREATE TABLE Like(
   likecount	BIGINT			AUTO_INCREMENT,
   userId		VARCHAR(20),
   number 		BIGINT,
   likecheck	INT				DEFAULT 0,
   CONSTRAINT primary key (likecount), 
   FOREIGN KEY (userId) REFERENCES User(userId) on delete cascade
);
