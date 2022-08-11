CREATE TABLE test(
name 		VARCHAR(25) 	NOT NULL,
address		VARCHAR(100)	NOT NULL PRIMARY KEY
)

SELECT * FROM test;

INSERT INTO test VALUES('고영희식당', '대구 중구 달구벌대로 2109-10');
INSERT INTO test VALUES('뜨돈', '대구 중구 달구벌대로 2109-30');
DROP TABLE test