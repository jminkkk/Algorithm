SELECT DISTINCT(id), email, first_name, last_name
FROM developers
   JOIN skillcodes ON (developers.skill_code & skillcodes.code) > 0
WHERE name = 'C#' OR name = 'Python'
ORDER BY id;