-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)

SELECT  person_name
FROM person


JOIN movie ON person.person_id = movie.director_id
JOIN collection ON movie.collection_id = collection.collection_id

WHERE collection_name = 'Back to the Future Collection';