        -- 8. The area of the state with the smallest population in the "Northeast" census region. Name the column 'smallest_northeast_area'.
-- Expected answer is around 4,000
-- (1 row)

SELECT
       area AS smallest_northeast_area
FROM
        state
WHERE population= 1059361 AND census_region = 'Northeast'
GROUP BY
      area




LIMIT 1;
