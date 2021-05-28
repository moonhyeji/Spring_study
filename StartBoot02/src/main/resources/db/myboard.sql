DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYBOARD(

MYNO NUMBER PRIMARY KEY,
MYNAME VARCHAR2(500) NOT NULL,
MYTITLE VARCHAR2(500) NOT NULL,
MYCONTENT VARCHAR2(500) NOT NULL,
MYDATE DATE NOT NULL

);
SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;
