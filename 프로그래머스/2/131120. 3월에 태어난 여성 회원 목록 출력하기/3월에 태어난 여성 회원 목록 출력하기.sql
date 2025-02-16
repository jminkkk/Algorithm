-- 코드를 입력하세요
SELECT m.MEMBER_ID, m.MEMBER_NAME, m.GENDER, DATE_FORMAT(m.DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH 
FROM MEMBER_PROFILE m
WHERE DATE_FORMAT(m.DATE_OF_BIRTH, '%m') = '03'
AND m.GENDER = 'W'
AND m.TLNO IS NOT NULL
ORDER BY m.MEMBER_ID;