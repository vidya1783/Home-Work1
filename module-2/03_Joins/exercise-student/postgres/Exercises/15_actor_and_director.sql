-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)

SELECT DISTINCT
        movie.title, person.person_name
FROM
        movie
INNER JOIN
        person ON movie.director_id = person.person_id
INNER JOIN
        movie_actor ON movie.movie_id = movie_actor.movie_id
WHERE person_id = actor_id;