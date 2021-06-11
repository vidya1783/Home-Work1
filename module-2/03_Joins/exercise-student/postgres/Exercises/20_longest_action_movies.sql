-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT
       title, max(length_minutes)AS length_time, release_date
FROM 
     movie
     
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id  
 
WHERE 
     genre_name = 'Action'
     
GROUP BY
     title, release_date;
     
ORDER BY
       length_time DESC,
       release_date DESC;
 