## Cursor 
- pointing to the data
- connot go back to cursor
- types
  - Implicit
  - Explicit
    - Declare
    - open
    - fetch
    - check
    - close
    ```sql

      declare
        cursor c_emps is select first_name,last_name from employees;
        v_first_name employees.first_name%type;
        v_last_name employees.last_name%type;
      begin
        open c_emps;
        fetch c_emps into v_first_name,v_last_name;
        fetch c_emps into v_first_name,v_last_name;
        fetch c_emps into v_first_name,v_last_name;
        dbms_output.put_line(v_first_name|| ' ' || v_last_name);
        fetch c_emps into v_first_name,v_last_name;
        dbms_output.put_line(v_first_name|| ' ' || v_last_name);
        close c_emps;
      end;

    -- with records
      declare
        type r_emp is record (  v_first_name employees.first_name%type,
                                 v_last_name employees.last_name%type);
        v_emp r_emp;
        cursor c_emps is select first_name,last_name from employees;
      begin
        open c_emps;
        fetch c_emps into v_emp;
        dbms_output.put_line(v_emp.v_first_name|| ' ' || v_emp.v_last_name);
        close c_emps;
      end;

    -- looping
      declare
        cursor c_emps is select * from employees where department_id = 30;
        v_emps c_emps%rowtype;
      begin
        open c_emps;
        -- for i in 1..6 loop
        -- for i in c_emps loop
        for i in (select * from employees where department_id = 30) loop
          fetch c_emps into v_emps;
          dbms_output.put_line(v_emps.employee_id|| ' ' ||v_emps.first_name|| ' ' ||v_emps.last_name);
        end loop;
        close c_emps;
      end;
      --
      declare
        cursor c_emps is select * from employees where department_id = 30;
        v_emps c_emps%rowtype;
      begin
        open c_emps;
        fetch c_emps into v_emps;
        while c_emps%found loop
          dbms_output.put_line(v_emps.employee_id|| ' ' ||v_emps.first_name|| ' ' ||v_emps.last_name);
          fetch c_emps into v_emps;
          --exit when c_emps%notfound;
        end loop;
        close c_emps;
      end;
      
      -- declare
        cursor c_emps is select * from employees where department_id = 30;
        v_emps c_emps%rowtype;
      begin
        open c_emps;
        loop
          fetch c_emps into v_emps;
          exit when c_emps%notfound;
          dbms_output.put_line(v_emps.employee_id|| ' ' ||v_emps.first_name|| ' ' ||v_emps.last_name);
        end loop;
        close c_emps;
      end;

    -- parametered
      declare
        cursor c_emps (p_dept_id number , p_job_id varchar2) is select first_name,last_name,job_id,department_name 
                          from employees join departments using (department_id)
                          where department_id = p_dept_id
                          and job_id = p_job_id;
        v_emps c_emps%rowtype;
      begin
          for i in c_emps(50,'ST_MAN') loop
            dbms_output.put_line(i.first_name|| ' ' ||i.last_name|| ' - ' || i.job_id);
          end loop;
          dbms_output.put_line(' - ');
          for i in c_emps(80,'SA_MAN') loop
            dbms_output.put_line(i.first_name|| ' ' ||i.last_name|| ' - ' || i.job_id);
          end loop;
      end;    
    ```
## Exceptions
- use to handle the run time erro r
- types
- predefined
  - NO_DATA_FOUND   -  SELECT INTO statement returns no rows.
  - TOO_MANY_ROWS   -  SELECT INTO statement returns more than one row.
  - ZERO_DIVIDE     
  - VALUE_ERROR     -  too large or incompatible with the variable's data type
  - OTHERS           - catch-all exception
- user defined
  - declare as exception
  - call
    - raise vv
    - raise_application_error(-1212,"")
```sql
declare
  v_name varchar2(6);
  v_department_name varchar2(100);
begin
  select first_name into v_name from employees where employee_id = 100;
  select department_id into v_department_name from employees where first_name = v_name;
  dbms_output.put_line('Hello '|| v_name || '. Your department id is : '|| v_department_name );
exception
  when no_data_found then
    dbms_output.put_line('There is no employee with the selected id');
  when too_many_rows then
    dbms_output.put_line('There are more than one employees with the name '|| v_name);
    dbms_output.put_line('Try with a different employee');
end;

-- user defiin
declare
too_high_salary exception;
v_salary_check pls_integer;
begin
  select salary into v_salary_check from employees where employee_id = 100;
  if v_salary_check > 20000 then
    raise too_high_salary;
  end if;
  --we do our business if the salary is under 2000
  dbms_output.put_line('The salary is in an acceptable range');
exception
  when too_high_salary then
  dbms_output.put_line('This salary is too high. You need to decrease it.');
end;


-- non predefined oracle exception
declare
  not_valid_email exception;
  pragma exception_init(not_valid_email,-01402);
begin
  UPDATE employees_copy set email = 'test' where employee_id = 100;
exception
  when not_valid_email then
    dbms_output.put_line('That is not a valid email address!');
end;

--  user define with raise
set SERVEROUTPUT on;
declare
too_high_salary exception;
v_salary_check pls_integer;
begin
  select salary into v_salary_check from employees where employee_id = 100;
  if v_salary_check < 20000 then
    raise too_high_salary;
  end if;
  dbms_output.put_line('The salary is in an acceptable range');
exception
  when too_high_salary then
  dbms_output.put_line('This salary is too high. You need to decrease it.');
end;


- using raise_application_error for msg with error id
declare
too_high_salary exception;
v_salary_check pls_integer;
begin
  select salary into v_salary_check from employees where employee_id = 100;
  if v_salary_check > 20000 then
    --raise too_high_salary;
 raise_application_error(-20243,'The salary of the selected employee is too high!');
  end if;
  --we do our business if the salary is under 2000
  dbms_output.put_line('The salary is in an acceptable range');
exception
  when too_high_salary then
  dbms_output.put_line('This salary is too high. You need to decrease it.');
end;


--  update
declare
  cursor c_emps is select employee_id,first_name,last_name,department_name
      from employees join departments using (department_id)
      where employee_id in (100,101,102)
      for update of employees.phone_number, 
      departments.location_id wait 5;
begin
   for r_emps in c_emps loop
    update employees set phone_number = 3
      where employee_id = r_emps.employee_id; 
  end loop; 
  open c_emps;
end;

select * from employees

-- using where current
declare
  cursor c_emps is select * from employees 
                    where department_id = 30 for update;
begin
  for r_emps in c_emps loop
    update employees set salary = salary + 60
          where current of c_emps;
  end loop;  
end;

-- reference -- which can be dynamically assign in sql query

```

    
