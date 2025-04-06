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

        DECLARE
           CURSOR emp_cursor IS
              SELECT ename FROM emp WHERE deptno = 10;
           v_ename emp.ename%TYPE;
        BEGIN
           OPEN emp_cursor;
           LOOP
              FETCH emp_cursor INTO v_ename;
              EXIT WHEN emp_cursor%NOTFOUND;
              DBMS_OUTPUT.PUT_LINE(v_ename || ' ' || v_ename);
           END LOOP;
           CLOSE emp_cursor;
        END;
        
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



```

    
