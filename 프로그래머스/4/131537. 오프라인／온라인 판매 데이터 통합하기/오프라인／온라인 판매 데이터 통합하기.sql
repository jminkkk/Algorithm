-- 2022년 3월의 오프라인/온라인 상품 판매 데이터의 판매 날짜, 상품ID, 유저ID, 판매량을 출력
-- OFFLINE_SALE 테이블의 판매 데이터의 USER_ID 값은 NULL 로 표시
# SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
# FROM ONLINE_SALE
# WHERE SALES_DATE LIKE '2022-03%'
# UNION
# SELECT SALES_DATE, PRODUCT_ID, NULL, SALES_AMOUNT
# FROM OFFLINE_SALE
# WHERE SALES_DATE LIKE '2022-03%'
# ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;
SELECT Date_format(sales_date, '%Y-%m-%d') SALES_DATE,
       product_id,
       user_id,
       sales_amount
FROM   online_sale
WHERE  sales_date LIKE '2022-03%'
UNION
SELECT Date_format(sales_date, '%Y-%m-%d') SALES_DATE,
       product_id,
       NULL,
       sales_amount
FROM   offline_sale
WHERE  sales_date LIKE '2022-03%'
ORDER  BY 1, 2, 3



-- ONLINE_SALE
-- ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
-- 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일
-- SALES_DATE, USER_ID, PRODUCT_ID 조합에 대해서는 하나

-- OFFLINE_SALE
-- OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
-- 오프라인 상품 판매 ID, 상품 ID, 판매량, 판매일
-- SALES_DATE, PRODUCT_ID에 대해서는 하나