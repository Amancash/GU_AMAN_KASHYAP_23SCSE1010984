# Write your MySQL query statement below
select (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary desc 
    limit 1 OFFSET 1
    ) As SecondHighestSalary;