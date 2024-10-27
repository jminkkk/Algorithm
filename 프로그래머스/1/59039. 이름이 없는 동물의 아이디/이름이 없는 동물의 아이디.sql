-- 각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

SELECT ANIMAL_ID 
FROM ANIMAL_INS
WHERE NAME IS NULL 
ORDER BY ANIMAL_ID;