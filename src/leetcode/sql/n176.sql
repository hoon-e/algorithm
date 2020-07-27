-- https://leetcode.com/problems/second-highest-salary/submissions/

-- IFNULL(EXP1, EXP2) 함수, NULL이 아니라면 EXP1을 리턴 / NULL이라면 EXP2를 리턴
-- 위에서 특정 행까지만 출력 / OFFSET 0부터 시작하여 OFFSET부터 시작하여 결과값을 리턴
SELECT IFNULL(
    (SELECT DISTINCT Salary FROM Employee
     ORDER BY Salary DESC
     LIMIT 1 OFFSET 1), NULL) as SecondHighestSalary;

-- 또 다른 해답
-- Employee에서 월급을 출력하는데, 내림차순으로 정렬하여 최대값보다 작은 값을 출력한다.
Select
    (SELECT Salary
    FROM Employee
    WHERE Salary < (SELECT max(Salary) FROM Employee)
    ORDER BY Salary DESC
    LMIIT 1) AS SecondHighestSalary;