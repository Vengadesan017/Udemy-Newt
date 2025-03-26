# use APEX work space for this courese
- create workspace request
- then check mail for activation
# Oracle APEX  ==> instance name : FOR_SQL_COURSE
- use sql Workshop > SQL commands
- for sample datas
  - sql Workshop > Utilities > Sample datasets > iinstall emp/dep
-  to check the db and table
  - sql workshop > object Browser


```sql
create table stores
(
    store_id number not null,
    city varchar(50)
)

insert into stores(store_id, city) VALUES (1, 'Chennai')

select * from stores

insert all
into stores(store_id, city) VALUES (1, 'Chennai')
into stores(store_id, city) VALUES (2, 'Chennai2')
into stores(store_id, city) VALUES (3, 'Chennai3')

-- with primary key
create table products
(
    product_id number not null,
    name varchar(50),
    product_cost number(5,2),
    product_retail number(5,2),
    product_type varchar(10),
    store_id number not null,

    constraint product_pk primary key (product_id)
)


-- insert to multiple table with  conditional insert 
insert all
when sal <= 1500 then
    INTO tb_1 (id, name, date_of) values (empno, ename, hiredate)
when sal BETWEEN 1501 AND 2500 then 
    INTO tb_2 (id, name, date_of) values (empno, ename, hiredate)
when sal  > 2500 then
    INTO tb_3 (id, name, date_of) values (empno, ename, hiredate)


-- alter
DESCRIBE products  -- to view the structure
ALTER TABLE products
    MODIFY name varchar2(50) not null

ALTER TABLE products
    RENAME COLUMN name to product_name;

ALTER TABLE employees
    ADD store_id number;

-- update
UPDATE employees
SET store_id = 3
WHERE ename in ('KING', 'BLAKE', 'CLARK')


-- merge
merge the two table into new table
MERGE INTO existing_customers c
USING new_customers n
ON (c.customer_id = n.customer_id)
WHEN MATCHED THEN
    UPDATE SET
    c.first_name = n.first_name,
    c.last_name = n.last_name,
    c.address_state = n.address_state,
    c.email_address = n.email_address
DELETE WHERE c.first_name = 'John'
WHEN NOT MATCHED THEN
    INSERT (c.customer_id, c.first_name, c.last_name, c.address_state, c.email_address)
    VALUES (n.customer_id, n.first_name, n.last_name, n.address_state, n.email_address)


- Sequence
create sequence product_seq
  minvalue 1
  maxvalue 9999
  start with 1
  increment by 1
  cache 20;

select product_seq.nextval from dual

-- delete , drop truncate
DELETE FROM DEPT WHERE deptno = 40

ALTER TABLE emp
DROP CONSTRAINT EMP_DEPT_FK

TRUNCATE TABLE emp

DROP TABLE dept

-- indexes
CREATE INDEX emp_name_idx
    ON employees (ename)

CREATE INDEX emp_name_idx
    ON employees (ename, job)

CREATE UNIQUE INDEX emp_job_idx 
    ON employees (job)

DROP INDEX emp_job_idx

-- --- --  system table
select * from all_tables
select * from all_tab_columns
select * from all_objexts
SELECT * FROM user_objects

-- pseudo column
-- rowid in any table (physical address of a row)
select rowid,ename from emp

-- delete duplicates
DELETE FROM stores
WHERE rowid NOT IN (
SELECT MIN(rowid)
FROM stores
GROUP BY store_id, city
)


-- -- -- -- -- view
CREATE VIEW managers_v 
AS SELECT * FROM employees
WHERE job = 'MANAGER'

CREATE VIEW super_employees AS

SELECT store_id, MAX(sal) sal
FROM employees
GROUP BY store_id

SELECT * from super_employees

drop view super_employees


-- Privileges
grand revoke role

grand select on product to user1
```
