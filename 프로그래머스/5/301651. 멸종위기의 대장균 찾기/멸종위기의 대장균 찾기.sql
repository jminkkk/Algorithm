-- 코드를 작성해주세요
WITH RECURSIVE a1 AS (SELECT id, parent_id, 1 AS gen
                       FROM ecoli_data
                       WHERE parent_id IS NULL

                       UNION ALL

                       SELECT e.id, e.parent_id, a1.gen + 1 AS gen
                       FROM ecoli_data e
                                JOIN a1 ON a1.id = e.parent_id)

SELECT count(1) as 'count', a.gen as GENERATION
FROM a1 a
LEFT JOIN a1 d ON a.ID = d.PARENT_ID
WHERE d.id IS NULL
GROUP BY GENERATION
ORDER BY GENERATION