-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

SELECT
      person_name, birthday
FROM
     person

JOIN movie ON person.person_id = movie.director_id

WHERE
    ( birthday >= '1/1/1950' AND birthday <='12/31/1950') AND
    (release_date >='1/1/1985' AND release_date <= '12/31/1985' ) ;