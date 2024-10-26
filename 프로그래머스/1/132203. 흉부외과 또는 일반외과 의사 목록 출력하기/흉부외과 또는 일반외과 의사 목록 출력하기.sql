-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD = 'GS' OR MCDP_CD = 'CS'
ORDER BY HIRE_YMD DESC, DR_NAME;