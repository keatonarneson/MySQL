-- 1. I want to know how many employees with each title were born after 1965-01-01.
SELECT titles.title AS "Title", COUNT(titles.title) AS "Num of Emp Born after 1965-01-01"
FROM employees
INNER JOIN titles ON employees.emp_no = titles.emp_no
WHERE employees.birth_date > '1965-01-01'
GROUP BY titles.title;

-- 2. I want to know the average salary per title.
SELECT titles.title AS "Title", AVG(salaries.salary) AS "Average Salary"
FROM titles
INNER JOIN salaries ON titles.emp_no = salaries.emp_no
GROUP BY titles.title;

-- 3. How much money was spent on salary for the marketing department between the years 1990 and 1992?
SELECT departments.dept_name AS "DEPT NAME", SUM(salaries.salary) AS "TOTAL SALARY"
FROM departments
INNER JOIN dept_emp ON dept_emp.dept_no = departments.dept_no 
INNER JOIN salaries ON salaries.emp_no = dept_emp.emp_no
WHERE dept_emp.from_date > '1990-01-01' AND dept_emp.to_date < '1992-12-31'
  AND departments.dept_name = 'Marketing'
GROUP BY departments.dept_name;