## Stored Procedure

```sql
create or REPLACE procedure increase_salaries as
    cursor c_emps is select * from employees for update;
    v_salary_increase number := 1.10;
    v_old_salary number;
begin
    for r_emp in c_emps loop
      v_old_salary := r_emp.salary;
      r_emp.salary := r_emp.salary * v_salary_increase + r_emp.salary * nvl(r_emp.commission_pct,0);
      update employees set row = r_emp where current of c_emps;
      dbms_output.put_line('The salary of : '|| r_emp.employee_id 
                            || ' is increased from '||v_old_salary||' to '||r_emp.salary);
    end loop;
end;

EXECUTE increase_salaries;

begin
  dbms_output.put_line('Increasing the salaries!...');
  INCREASE_SALARIES;
  INCREASE_SALARIES;
  INCREASE_SALARIES;
  INCREASE_SALARIES;
  dbms_output.put_line('All the salaries are successfully increased!...');
end;

-- in and out parameter
CREATE OR REPLACE PROCEDURE increase_salaries (
    v_salary_increase IN NUMBER,  -- Percentage increase (e.g., 0.10 for 10%)
    v_department_id IN PLS_INTEGER,  -- Department ID to target
    v_rows_updated OUT PLS_INTEGER  -- OUT parameter to return number of updated rows
) AS
    CURSOR c_emps IS 
        SELECT * 
        FROM employees 
        WHERE department_id = v_department_id 
        FOR UPDATE;
    
    v_old_salary NUMBER;
BEGIN
    v_rows_updated := 0;

    FOR r_emp IN c_emps LOOP
        v_old_salary := r_emp.salary;

        r_emp.salary := r_emp.salary * v_salary_increase + r_emp.salary * NVL(r_emp.commission_pct, 0);

        UPDATE employees 
        SET salary = r_emp.salary 
        WHERE CURRENT OF c_emps;
        
        v_rows_updated := v_rows_updated + 1;

        DBMS_OUTPUT.PUT_LINE('The salary of employee ID: ' || r_emp.employee_id || 
                             ' is increased from ' || v_old_salary || ' to ' || r_emp.salary);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Procedure finished executing!');

END increase_salaries;

EXECUTE increase_salaries(1.2,30);

DECLARE
    v_updated_rows PLS_INTEGER;
BEGIN
    increase_salaries(0.10, 30, v_updated_rows); 
    DBMS_OUTPUT.PUT_LINE('Number of rows updated: ' || v_updated_rows);
END;


-- named parameters
CREATE OR REPLACE PROCEDURE update_employee_salary (
    emp_id IN NUMBER,
    new_salary IN NUMBER,
    department_id IN NUMBER DEFAULT 10  -- Default value for department_id
) IS
BEGIN
    UPDATE employees
    SET salary = new_salary
    WHERE employee_id = emp_id
    AND department_id = department_id;
    COMMIT;
END;

BEGIN
    -- Named Notation: Specify parameter names explicitly
    update_employee_salary(
        emp_id => 101, 
        department_id => 10, 
        new_salary => 5500
    );
END;

```
## function
- no out para
- return  values
- not able to table create , commit rollback , ddl, dml
```sql
CREATE OR REPLACE FUNCTION my_function 
    (parameter1 IN VARCHAR2 )
    RETURN VARCHAR2
IS
BEGIN
    RETURN parameter1;
END my_function;


BEGIN
DBMS_OUTPUT.PUT_LINE(my_function('Haiii hello'));
end;

--  overloading
CREATE OR REPLACE FUNCTION my_fumction 
    (parameter1 IN NUMBER)
    RETURN NUMBER 
IS
BEGIN
    RETURN parameter1;
END my_fumction;
/


BEGIN
    -- Calling the function with one parameter (a string)
    DBMS_OUTPUT.PUT_LINE(my_function('Haiii hello'));

    -- Calling the function with one parameter (a number)
    DBMS_OUTPUT.PUT_LINE(my_fumction(200));
END;


--  Exceptions
create or replace function get_emp(emp_num employees.employee_id%type) return employees%rowtype is
  emp employees%rowtype;
 begin
   select * into emp from employees where employee_id = emp_num;
  return emp;
 exception
  when no_data_found then
    dbms_output.put_line('There is no employee with the id '|| emp_num);
    raise no_data_found;
  when others then
    dbms_output.put_line('Something unexpected happened!.');
 return null;
 end;
 
DECLARE
  emp_record employees%rowtype; 
BEGIN

  emp_record := get_emp(11);  
  
  -- If employee is found, display the details
  IF emp_record.employee_id IS NOT NULL THEN
    dbms_output.put_line('Employee ID: ' || emp_record.employee_id);
    dbms_output.put_line('Employee Name: ' || emp_record.first_name || ' ' || emp_record.last_name);
    dbms_output.put_line('Employee Job: ' || emp_record.job_id);
    dbms_output.put_line('Employee Salary: ' || emp_record.salary);
  ELSE
    dbms_output.put_line('No employee found with the given ID');
  END IF;
END;

-- regular & pipelined
- regular -- return a complete set of data in a collection, such as a nested table or varray
- pipelined -- return data row-by-row, pipelining the result to the caller, don't have to store all rows in memory before returning them

-- regular table
CREATE TYPE t_day AS OBJECT (
  v_date DATE,
  v_day_number INT
);
----------------- creating a nested table type
CREATE TYPE t_days_tab IS TABLE OF t_day;
 
----------------- creating a regular table function
CREATE OR REPLACE FUNCTION f_get_days(p_start_date DATE , p_day_number INT) 
              RETURN t_days_tab IS
v_days t_days_tab := t_days_tab();
BEGIN
 FOR i IN 1 .. p_day_number LOOP
  v_days.EXTEND();
  v_days(i) := t_day(p_start_date + i, to_number(to_char(p_start_date + i, 'DDD')));
 END LOOP;
 RETURN v_days;
END;
----------------- querying from the regular table function
select * from table(f_get_days(sysdate,1000000));
----------------- querying from the regular table function without the table operator
select * from f_get_days(sysdate,1000000);


-- pipeline table
----------------- creating a pipelined table function
create or replace function f_get_days_piped (p_start_date date , p_day_number int) 
              return t_days_tab PIPELINED is
begin
 for i in 1 .. p_day_number loop
  PIPE ROW (t_day(p_start_date + i,
                  to_number(to_char(p_start_date + i,'DDD'))));
 end loop;
 RETURN;
end;
----------------- querying from the pipelined table function
select * from f_get_days_piped(sysdate,1000000)

```
