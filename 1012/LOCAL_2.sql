-- 222222222222222222

SELECT * FROM store_information;

DELETE FROM STORE_INFORMATION WHERE STORE_ID   = 10;

COMMIT;

UPDATE STORE_INFORMATION
SET STORE_NAME   = 'BBB'
WHERE STORE_ID   = 10;