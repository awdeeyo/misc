/* KEVIN LE */
/* 1 */
SELECT UserID, Occupation 
FROM   VIEWER;

/* 2 */
UPDATE MOVIE
SET MovieTitle='Happily Scared'
WHERE comedy=1 OR horror=1;

/* 3 */
SELECT UserID FROM VIEWER
WHERE Gender='M' and Age>30;
/* 4 */
SELECT Occupation FROM VIEWER
WHERE 
Occupation<>'student'
and Occupation<>'lawyer' 
and Occupation<>'educator'
ORDER BY Occupation DESC;
/* 5 */
SELECT MovieTitle
FROM MOVIE
WHERE MovieTitle LIKE '%1982%'
ORDER BY MovieTitle ASC;
/* 6 */
SELECT UserID, AVG(Rating) FROM RATING
WHERE 3>(SELECT AVG(Rating) FROM RATING)
GROUP BY UserID;

/* 7 */
SELECT Occupation, MAX(Age)
FROM VIEWER
GROUP BY Occupation;

/* 8 */
SELECT Occupation, COUNT(*)
FROM VIEWER
WHERE Occupation NOT IN ('student', 'educator')
GROUP BY Occupation;

/* 9 */
/* There is a large decimal, so please move
 the cursor all the way to the left */
SELECT Gender, AVG(Age)
FROM VIEWER
GROUP BY Gender;
/* 10 */
SELECT Occupation FROM VIEWER
WHERE 40>(SELECT AVG(Age) FROM VIEWER)
GROUP BY Occupation;

