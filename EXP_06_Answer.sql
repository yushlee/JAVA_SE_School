-- �m���D�K�ѵ�(�D�ؤ@)
--  �d�߱���p�U�G
--  1.�U�ȡG�d�ߵ��G�ư��¦W���U��
--  2.�U�ȡG�P�ɦ��b�u�P�ګȡv�B�u�����s�v�ʶR
--  3.���O���B�G�ʶR�������B�b�u�P�ګȡv�j��ε��� 500�B�u�����s�v�j��ε��� 1000
--  4.����϶��G2017-10 ~ 2017-12
--  �j�M���G���G�U�Ȩ����Ҧr���B�m�W�B������X
SELECT CUS.CUS_IDENTIFIER_ID, CUS.CUS_NAME, CUS.CUS_PHONE_ENUMBER 
FROM CUSTOMER CUS, 
(
      (
            -- �j�M�u�P�ګȡv�ŦX�U��
            SELECT CO.CUS_IDENTIFIER_ID
                FROM COFFEE_CUSTOMER_ORDER CO
                -- ����϶��G2017-10 ~ 2017-12
                WHERE CO.ORDER_DATE  BETWEEN '2017-10-01' AND '2017-12-31'
                -- �ʶR�������B�b�u�P�ګȡv�j��ε��� 500
                HAVING AVG(CO.ORDER_AMOUNT) >= 500
                GROUP BY CO.CUS_IDENTIFIER_ID
        )
      INTERSECT  -- �U�ȡG�P�ɦ��b�u�P�ګȡv�B�u�����s�v�ʶR
      (
            -- �j�M�u�����s�v�ŦX�U��
            SELECT BO.CUS_IDENTIFIER_ID
                  FROM BOOK_CUSTOMER_ORDER BO
                  -- ����϶��G2017-10 ~ 2017-12
                  WHERE BO.ORDER_DATE  BETWEEN '2017-10-01' AND '2017-12-31'
                  -- �ʶR�������B�b�u�����s�v�j��ε��� 1000
                  HAVING AVG(BO.ORDER_AMOUNT) >= 1000
                  GROUP BY BO.CUS_IDENTIFIER_ID
      )
      MINUS -- �U�ȡG�d�ߵ��G�ư��¦W���U��
      (
            SELECT CUS.CUS_IDENTIFIER_ID FROM CUSTOMER CUS
            WHERE CUS.IS_DIFFICULT_CUS = '1'
      )
) MATCH_CUS
WHERE CUS.CUS_IDENTIFIER_ID = MATCH_CUS.CUS_IDENTIFIER_ID;

----------------------------------------------------------------------------------------------------

-- �m���D�K�ѵ�(�D�ؤG)
/*
�d�߱���p�U�G
1.�p�����G�U�ȩ�u�P�ګȡv�B�u�����s�v�Ҧ����O�`�X�ʤ���(�p�ƲĤ@��)
2.�z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
�j�M���G���G�U�Ȩ����Ҧr���B�m�W�B������X�B���O�`�X�B���O�`�X�ʤ���B�o��ө��s���B�o��ө��W�١B�o��ө����O����
�Ƶ��G
(1)�o��ө����U�ȩ�u�P�ګȡv�ʶR���Ƴ̰����ө�
SQL�귽�Ѧ� https://www.w3resource.com/sql/aggregate-functions/max-count.php
(2) ���G�̮��O�`�X�ʤ���Ƨ�(����)
*/
SELECT CUS.CUS_IDENTIFIER_ID, CUS.CUS_NAME, CUS.CUS_PHONE_ENUMBER,
CUS_ORDER_AMT.CUS_TOTAL_AMT,
ROUND(
   CUS_ORDER_AMT.CUS_TOTAL_AMT / SUM_ORDER_AMT.SUM_TOTAL_AMT * 100 , 1
) AMOUNT_PROPORTION,
MAX_CONSUME_STORE.STORE_ID, MAX_CONSUME_STORE.STORE_NAME, MAX_CONSUME_STORE.STORE_COUNT
FROM (
        -- �U�O�U�ȩ�u�P�ګȡv�B�u�����s�v���O�[�`
        SELECT  AI_AMT.CUS_IDENTIFIER_ID, 
        (AI_AMT.BOOK_ORDER_AMT + SI_AMT.COFFEE_ORDER_AMT) CUS_TOTAL_AMT
        FROM (
                  -- �u�����s�v
                  SELECT BO.CUS_IDENTIFIER_ID, SUM(BO.ORDER_AMOUNT) BOOK_ORDER_AMT
                    FROM  AMAZON_INC AI,  BOOK_CUSTOMER_ORDER BO
                    WHERE  AI.STORE_ID = BO.BOOK_STORE_ID
                    -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
                    AND EXISTS (
                        SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
                        HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
                        AND MRT.STATION_ID = AI.STORE_MRT
                        GROUP BY MRT.STATION_ID)
                    GROUP BY BO.CUS_IDENTIFIER_ID
        ) AI_AMT,
        (
                  -- �u�P�ګȡv
                  SELECT CO.CUS_IDENTIFIER_ID, SUM(CO.ORDER_AMOUNT) COFFEE_ORDER_AMT
                    FROM  STARBUCKS_INC SI,  COFFEE_CUSTOMER_ORDER CO
                    WHERE  SI.STORE_ID = CO.COFFEE_STORE_ID
                    -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
                    AND EXISTS (
                        SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
                        HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
                        AND MRT.STATION_ID = SI.STORE_MRT
                        GROUP BY MRT.STATION_ID)
                    GROUP BY CO.CUS_IDENTIFIER_ID
        ) SI_AMT
        WHERE AI_AMT.CUS_IDENTIFIER_ID = SI_AMT.CUS_IDENTIFIER_ID
) CUS_ORDER_AMT,
(
        -- �U�ȩ�u�P�ګȡv�B�u�����s�v�������O�[�`
        SELECT  SUM(AI_AMT.BOOK_ORDER_AMT + SI_AMT.COFFEE_ORDER_AMT)  SUM_TOTAL_AMT
        FROM (
                  -- �u�����s�v
                  SELECT BO.CUS_IDENTIFIER_ID, SUM(BO.ORDER_AMOUNT) BOOK_ORDER_AMT
                    FROM  AMAZON_INC AI,  BOOK_CUSTOMER_ORDER BO
                    WHERE  AI.STORE_ID = BO.BOOK_STORE_ID
                    -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
                    AND EXISTS (
                        SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
                        HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
                        AND MRT.STATION_ID = AI.STORE_MRT
                        GROUP BY MRT.STATION_ID)
                    GROUP BY BO.CUS_IDENTIFIER_ID
        ) AI_AMT,
        (
                  -- �u�P�ګȡv
                  SELECT CO.CUS_IDENTIFIER_ID, SUM(CO.ORDER_AMOUNT) COFFEE_ORDER_AMT
                    FROM  STARBUCKS_INC SI,  COFFEE_CUSTOMER_ORDER CO
                    WHERE  SI.STORE_ID = CO.COFFEE_STORE_ID
                    -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
                    AND EXISTS (
                        SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
                        HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
                        AND MRT.STATION_ID = SI.STORE_MRT
                        GROUP BY MRT.STATION_ID)
                    GROUP BY CO.CUS_IDENTIFIER_ID
        ) SI_AMT
        WHERE AI_AMT.CUS_IDENTIFIER_ID = SI_AMT.CUS_IDENTIFIER_ID
) SUM_ORDER_AMT, 
(
        -- �o��ө����U�ȩ�u�P�ګȡv�ʶR���Ƴ̰����ө�
        SELECT MAX_STORE_BUY_COUNT.CUS_IDENTIFIER_ID, SI.STORE_ID, SI.STORE_NAME,
        MAX_STORE_BUY_COUNT.STORE_COUNT
        FROM (        
              SELECT  CO1.CUS_IDENTIFIER_ID, CO1.COFFEE_STORE_ID,
                    COUNT (CO1.COFFEE_STORE_ID) STORE_COUNT
                    FROM COFFEE_CUSTOMER_ORDER CO1
                    GROUP BY CO1.CUS_IDENTIFIER_ID, CO1.COFFEE_STORE_ID
                    HAVING COUNT (CO1.COFFEE_STORE_ID)= (
                          SELECT  MAX(  COUNT(CO2.COFFEE_STORE_ID)  ) COUNT_STORE
                            FROM COFFEE_CUSTOMER_ORDER CO2 
                            WHERE CO2.CUS_IDENTIFIER_ID = CO1.CUS_IDENTIFIER_ID
                            GROUP BY CO2.CUS_IDENTIFIER_ID, CO2.COFFEE_STORE_ID
                    )
        ) MAX_STORE_BUY_COUNT, STARBUCKS_INC SI
        WHERE MAX_STORE_BUY_COUNT.COFFEE_STORE_ID = SI.STORE_ID
) MAX_CONSUME_STORE, CUSTOMER CUS
WHERE CUS_ORDER_AMT.CUS_IDENTIFIER_ID = CUS.CUS_IDENTIFIER_ID
AND CUS_ORDER_AMT.CUS_IDENTIFIER_ID = MAX_CONSUME_STORE.CUS_IDENTIFIER_ID
ORDER BY AMOUNT_PROPORTION DESC;


-- WITH AS�g�k�����X�A
WITH CUS_ORDER_AMT AS (
    -- �U�O�U�ȩ�u�P�ګȡv�B�u�����s�v���O�[�`
    SELECT  AI_AMT.CUS_IDENTIFIER_ID, 
    (AI_AMT.BOOK_ORDER_AMT + SI_AMT.COFFEE_ORDER_AMT) CUS_TOTAL_AMT
    FROM (
      -- �u�����s
      SELECT BO.CUS_IDENTIFIER_ID, SUM(BO.ORDER_AMOUNT) BOOK_ORDER_AMT
        FROM  AMAZON_INC AI,  BOOK_CUSTOMER_ORDER BO
        WHERE  AI.STORE_ID = BO.BOOK_STORE_ID
        -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
        AND EXISTS (
            SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
            HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
            AND MRT.STATION_ID = AI.STORE_MRT
            GROUP BY MRT.STATION_ID)
        GROUP BY BO.CUS_IDENTIFIER_ID
    ) AI_AMT,
    (
      -- �u�P�ګȡv
      SELECT CO.CUS_IDENTIFIER_ID, SUM(CO.ORDER_AMOUNT) COFFEE_ORDER_AMT
        FROM  STARBUCKS_INC SI,  COFFEE_CUSTOMER_ORDER CO
        WHERE  SI.STORE_ID = CO.COFFEE_STORE_ID
        -- �z�����G�j�M���ө��d��,�ݦs�b���B��B�H�ƹF1100�H���H�W
        AND EXISTS (
            SELECT MRT.STATION_ID FROM MRT_TRANSIT_TRAFFIC MRT 
            HAVING SUM(MRT.TRAFFIC_PEOPLE_QUANTITY) > 1100
            AND MRT.STATION_ID = SI.STORE_MRT
            GROUP BY MRT.STATION_ID)
        GROUP BY CO.CUS_IDENTIFIER_ID
    ) SI_AMT
    WHERE AI_AMT.CUS_IDENTIFIER_ID = SI_AMT.CUS_IDENTIFIER_ID
) ,
SUM_ORDER_AMT AS (
  SELECT SUM(CUS_TOTAL_AMT) SUM_TOTAL_AMT FROM CUS_ORDER_AMT
) ,
MAX_CONSUME_STORE AS (
    -- �o��ө����U�ȩ�u�P�ګȡv�ʶR���Ƴ̰����ө�
    SELECT MAX_STORE_BUY_COUNT.CUS_IDENTIFIER_ID, SI.STORE_ID, SI.STORE_NAME,
    MAX_STORE_BUY_COUNT.STORE_COUNT
    FROM (
		  -- �~�d��:�d�ߥX�C���U�ȩ�C�������U�O���O����
          SELECT  CO1.CUS_IDENTIFIER_ID, CO1.COFFEE_STORE_ID,
                COUNT (CO1.COFFEE_STORE_ID) STORE_COUNT
                FROM COFFEE_CUSTOMER_ORDER CO1
                GROUP BY CO1.CUS_IDENTIFIER_ID, CO1.COFFEE_STORE_ID
                HAVING COUNT (CO1.COFFEE_STORE_ID)= (
					  -- ���d��:�d�ߨC�@���U�ȳ̦h�����O����
                      SELECT  MAX(  COUNT(CO2.COFFEE_STORE_ID)  ) COUNT_STORE
                        FROM COFFEE_CUSTOMER_ORDER CO2 
                        WHERE CO2.CUS_IDENTIFIER_ID = CO1.CUS_IDENTIFIER_ID
                        GROUP BY CO2.CUS_IDENTIFIER_ID, CO2.COFFEE_STORE_ID
                )
    ) MAX_STORE_BUY_COUNT, STARBUCKS_INC SI
    WHERE MAX_STORE_BUY_COUNT.COFFEE_STORE_ID = SI.STORE_ID
)
SELECT CUS.CUS_IDENTIFIER_ID, CUS.CUS_NAME, CUS.CUS_PHONE_ENUMBER,
CUS_ORDER_AMT.CUS_TOTAL_AMT,
ROUND(
   CUS_ORDER_AMT.CUS_TOTAL_AMT / SUM_ORDER_AMT.SUM_TOTAL_AMT * 100 , 1
) AMOUNT_PROPORTION,
MAX_CONSUME_STORE.STORE_ID, MAX_CONSUME_STORE.STORE_NAME, MAX_CONSUME_STORE.STORE_COUNT
FROM CUS_ORDER_AMT, SUM_ORDER_AMT, MAX_CONSUME_STORE, CUSTOMER CUS
WHERE CUS_ORDER_AMT.CUS_IDENTIFIER_ID = CUS.CUS_IDENTIFIER_ID
AND CUS_ORDER_AMT.CUS_IDENTIFIER_ID = MAX_CONSUME_STORE.CUS_IDENTIFIER_ID
ORDER BY AMOUNT_PROPORTION DESC;