# Write your MySQL query statement below

SELECT e.unique_id, y.name
FROM Employees y
LEFT JOIN EmployeeUNI e
ON e.id = y.id;