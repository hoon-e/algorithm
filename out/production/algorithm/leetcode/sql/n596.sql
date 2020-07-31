-- https://leetcode.com/problems/classes-more-than-5-students/

-- CLASS로 묶고, student의 중복을 허용하지 않은 카운트가 5이상인 학급을 출력한다.
SELECT class FROM courses
GROUP BY class HAVING COUNT(DISTINCT student) >= 5;