# Trigger
- used to enforce business rules , validation check , auditing , data transformation
- types
  - DML trigger
    - Before
    - After
    - Instead of -- for views
  - DDL trigger
    - used to track the cjanges
  - Logon Logoff trigger
    - Used to capture events , user logs on or logs off from the database
  - COmpound trigger
    - before and after trigger combination
    - share the variables
- Trigger event
  - insert, update , delete
- Trigger timing
  - Before or after
- trigger bidy
  - block of code
```sql
CREATE [OR REPLACE] TRIGGER trigger_name
    {BEFORE | AFTER | INSTEAD OF} 
    {INSERT | UPDATE | DELETE} 
    ON table_name
    [FOR EACH ROW] -- (optional for row-level triggers)
    [disable]
    BEGIN
        -- Trigger logic (PL/SQL block)
    END;

alter table employees disable all triggers
alter trigger employees_trigger disable
alter trigger employees_trigger enable
alter trigger employees_trigger compile
select * from user_triggers

create or replace trigger first_trigger 
before insert or update on employees
begin
  dbms_output.put_line('An insert or update occurred in employees_copy table!.');
end;

set SERVEROUTPUT on
update employees set salary = salary + 100;



create or replace trigger before_statement_emp_cpy 
before insert or update on employees
begin
  dbms_output.put_line('Before Statement Trigger is Fired!.');
end;
----------------- sql queries used in this lecture
update employees set salary = salary + 100 where employee_id = 101;


---  old and new 
create or replace trigger before_row_emp_cpy 
before insert or update or delete on employees
referencing old as O new as N
for each row
begin
  dbms_output.put_line('Before Row Trigger is Fired!.');
  dbms_output.put_line('The Salary of Employee '||:o.employee_id
    ||' -> Before:'|| :o.salary||' After:'||:n.salary);
end;


---  condidtioning
create or replace trigger before_row_emp_cpy 
before insert or update or delete on employees_copy 
referencing old as O new as N
for each row
begin
  dbms_output.put_line('Before Row Trigger is Fired!.');
  dbms_output.put_line('The Salary of Employee '||:o.employee_id
    ||' -> Before:'|| :o.salary||' After:'||:n.salary);
  if inserting then
    dbms_output.put_line('An INSERT occurred on employees_copy table');
  elsif deleting then
    dbms_output.put_line('A DELETE occurred on employees_copy table');
  elsif updating ('salary') then
    dbms_output.put_line('A DELETE occurred on the salary column');
  elsif updating then
    dbms_output.put_line('An UPDATE occurred on employees_copy table');
  end if;
end;

-- error handling
  elsif deleting then
    raise_application_error(-20001,'You cannot delete from the employees_copy table..');

-- of and when
create or replace trigger prevent_high_salary
before insert or update of salary on employees_copy 
for each row
when (new.salary > 50000)
begin
  raise_application_error(-20006,'A salary cannot be higher than 50000!.');
end;


-- instead trigger for views
----------------- creating a complex view -----------------
CREATE OR REPLACE VIEW VW_EMP_DETAILS AS
  SELECT UPPER(DEPARTMENT_NAME) DNAME, MIN(SALARY) MIN_SAL, MAX(SALARY) MAX_SAL 
    FROM EMPLOYEES_COPY JOIN DEPARTMENTS_COPY
    USING (DEPARTMENT_ID)
    GROUP BY DEPARTMENT_NAME;
----------------- updating the complex view -----------------
UPDATE VW_EMP_DETAILS SET DNAME = 'EXEC DEPT' WHERE
  UPPER(DNAME) = 'EXECUTIVE';
----------------- Instead of trigger -----------------
CREATE OR REPLACE TRIGGER EMP_DETAILS_VW_DML
  INSTEAD OF INSERT OR UPDATE OR DELETE ON VW_EMP_DETAILS
  FOR EACH ROW
  DECLARE
    V_DEPT_ID PLS_INTEGER;
  BEGIN


--- compound trigger
CREATE OR REPLACE TRIGGER compound_trigger_example
FOR INSERT OR UPDATE OR DELETE ON employees
COMPOUND TRIGGER

    -- Declare variables to store interim data
    v_old_salary NUMBER;

    -- BEFORE INSERT trigger logic
    BEFORE INSERT IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Before Insert Trigger');
    END BEFORE INSERT;

    -- BEFORE UPDATE trigger logic
    BEFORE UPDATE IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Before Update Trigger');
    END BEFORE UPDATE;

    -- AFTER UPDATE trigger logic
    AFTER UPDATE IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('After Update Trigger');
    END AFTER UPDATE;

END compound_trigger_example;
```
- Mutating error
  - row-level trigger tries to query or modify the same table that caused the trigger to fire
```sql
CREATE OR REPLACE TRIGGER check_salary
AFTER INSERT ON employees
FOR EACH ROW
DECLARE
    v_salary NUMBER;
BEGIN
    -- Trying to query the same table (employees) in an AFTER INSERT trigger
    SELECT salary INTO v_salary
    FROM employees
    WHERE employee_id = :NEW.employee_id;  -- This causes a mutating table error
END;


-- solution
- use temp table or collection
- statement level trigger
- compound trigger

```
