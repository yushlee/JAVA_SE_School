INSERT INTO BANK_ACCOUNT (NAME, PASSWORD, BALANCE, FUNMONEY) values('Wendy', 1234, 30000, 300.123);

-- ��ĳ��s�e�����d�ߥH�T�{�n��s����ƽd��
SELECT * FROM BANK_ACCOUNT WHERE NAME = 'Wendy';

UPDATE BANK_ACCOUNT SET BALANCE = 888 WHERE NAME = 'Wendy';

ROLLBACK;