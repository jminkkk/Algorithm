SELECT d.ID, IFNULL((SELECT count(*) FROM ECOLI_DATA e WHERE e.PARENT_ID = d.ID), 0) AS CHILD_COUNT
FROM ECOLI_DATA d
ORDER BY ID;