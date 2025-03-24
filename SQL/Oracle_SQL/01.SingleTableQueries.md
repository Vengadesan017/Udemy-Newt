# Queries for single table
```sql
select * from EMP;
select job from EMP;
select distinct job from EMP;
select distinct job from EMP where job = 'MANGER';
select distinct job from EMP where job = 'MANGER' and comm != 300;
select * from EMP where job != 'MANAGER';
select * from EMP where 1=1;

-- > < >= <= = != <>
select * from EMP where sal < comm;


-- Condition adn procedence 
SELECT * FROM EMP WHERE ( COMM IS NULL
AND SAL > 1100 AND SAL < 5000
AND SAL <> 3000 )
OR COMM = 0


SELECT * FROM EMP
WHERE ( COMM IS NULL or COMM = 0)
AND SAL > 1100 AND SAL < 5000
AND SAL <> 3000


SELECT * FROM EMP
WHERE JOB = 'SALESMAN'
AND (COMM = 300 OR COMM > 1100)


SELECT * FROM EMP 
WHERE JOB LIKE 'S%'


SELECT * FROM EMP 
WHERE JOB LIKE '%GER'

--- Aliasing
SELECT ENAME "EMPLOYEE NAME", SAL SALARY, COMM as COMMISSION
FROM EMP;

-- concatenating or pipes ||
SELECT 'hello my name is ' || ename as "concatenated value"
FROM EMP
WHERE job = 'MANAGER'


SELECT ename || ' makes $' || sal || ' per month' as "employee income"
FROM EMP


-- order by 
SELECT *
FROM emp
ORDER BY ENAME


SELECT *
FROM emp
ORDER BY SAL


-- descending order
SELECT *
FROM emp
ORDER BY SAL DESC

-- multiple order by but give high priority fot first then second
SELECT DEPTNO, SAL, ENAME
FROM EMP
ORDER BY DEPTNO, SAL


SELECT *
FROM EMP
ORDER BY DEPTNO, SAL


--  filters
SELECT supplier_name , state ,city, total_spent FROM suppliers where state = "Georgia" or state = "California";

SELECT supplier_name , total_spent, state ,city FROM suppliers where total_spent between 35000 and 95000;

SELECT supplier_name,total_spent,city , state FROM suppliers where supplier_name like '%wo%' and ('%i%' or '%I%');

SELECT ename, job, sal FROM employees where (comm is null or comm = 0) and ( sal > 1100 and sal < 5000) and sal != 3000;

SELECT ename, job, sal,comm FROM employees where comm > 1000 and job = "SALESMAN";

SELECT ename FROM employees where job != "MANAGER" AND JOB != "SALESMAN" and sal >= 2000 ;

SELECT ename, hiredate FROM employees where deptno = 20 or deptno = 30;
```
