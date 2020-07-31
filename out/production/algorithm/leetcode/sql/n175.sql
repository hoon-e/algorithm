-- https://leetcode.com/problems/combine-two-tables/

SELECT P.firstName, P.LastName, A.city, A.State FROM
Person as P
LEFT JOIN Address as A
ON P.PersonId = A.PersonId;

-- LEFT JOIN을 이용하여 PersonId를 가지고 LEFT JOIN을 수행한다.