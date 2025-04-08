# Dynamic SQL
## Static SQL
- stages
  - parse > bind > Execute > fetch
- parse at compile time
## Dynamic SQL
- constructor and executed at runtime
- use case
  - table and columns are not know at runtime
  - query with parameter but not hard coded
- methods
  - native dynamic sql statement
    - execute immediate command ( easier , efficient)
    - open-for , fetch and close statment  ( for  explicit cursor)
  - DBMS_SQL package ( low level api for d sql and cursor , flexibility, more code)
```sql
CREATE OR REPLACE PROCEDURE prc_create_table_dynamic 
    (p_table_name IN VARCHAR2, p_col_specs IN VARCHAR2) IS
BEGIN
    EXECUTE IMMEDIATE 'CREATE TABLE '||p_table_name||' ('||p_col_specs||')';
END;
/
EXEC prc_create_table_dynamic('dynamic_temp_table', 'id NUMBER PRIMARY KEY, name VARCHAR2(100)');
/
SELECT * FROM dynamic_temp_table;
/
CREATE OR REPLACE PROCEDURE prc_generic (p_dynamic_sql IN VARCHAR2) IS
BEGIN
    EXECUTE IMMEDIATE p_dynamic_sql;
END;
/
EXEC prc_generic('drop table dynamic_temp_table');
/
EXEC prc_generic('drop procedure PRC_CREATE_TABLE_DYNAMIC');
/
DROP PROCEDURE prc_generic;


DECLARE
   v_table_name VARCHAR2(30) := 'employees';
   v_emp_id     NUMBER := 101;  -- Dynamic employee ID
   v_sql        VARCHAR2(1000);
   v_name       VARCHAR2(100);
BEGIN
   -- Construct the dynamic SQL query with a bind variable
   v_sql := 'SELECT first_name || '' '' || last_name FROM ' || v_table_name || ' WHERE employee_id = :emp_id';
   
   -- Execute the dynamic SQL and bind the value of v_emp_id
   EXECUTE IMMEDIATE v_sql INTO v_name USING v_emp_id;
   
   DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_name);
ENDECLARE 
    v_affected_rows PLS_INTEGER;
    v_first_name VARCHAR2(100);
BEGIN
    v_affected_rows := update_names(2,'KING',v_first_name);
    dbms_output.put_line(v_affected_rows|| ' row updated!');
    dbms_output.put_line(v_first_name);
END;
/
CREATE OR REPLACE FUNCTION update_names (ID IN VARCHAR2, last_name IN VARCHAR2, first_name OUT VARCHAR2) RETURN PLS_INTEGER IS
    v_dynamic_sql VARCHAR2(200);
BEGIN
    v_dynamic_sql := 'UPDATE names SET last_name = :1 WHERE id = :2 RETURNING name INTO :3' ;
    EXECUTE IMMEDIATE v_dynamic_sql USING last_name, ID RETURNING INTO first_name;
    RETURN SQL%rowcount;
END;


--- using clause
CREATE OR REPLACE FUNCTION update_names (ID IN VARCHAR2, last_name IN VARCHAR2, first_name OUT VARCHAR2) RETURN PLS_INTEGER IS
    v_dynamic_sql VARCHAR2(200);
BEGIN
    -- Construct the dynamic SQL query with RETURNING INTO for first_name
    v_dynamic_sql := 'UPDATE employees SET last_name = :1 WHERE employee_id = :2 RETURNING first_name INTO :3';
    
    -- Execute the dynamic SQL with proper bind variables
    EXECUTE IMMEDIATE v_dynamic_sql USING last_name, ID, OUT first_name;
    
    -- Return the number of rows affected by the update
    RETURN SQL%ROWCOUNT;
END;
/


DECLARE
   v_first_name VARCHAR2(100);
   v_rows_updated PLS_INTEGER;
BEGIN
   -- Call the function with appropriate parameters
   v_rows_updated := update_names('100', 'new_name', v_first_name);

   -- Output the result
   DBMS_OUTPUT.PUT_LINE('Rows updated: ' || v_rows_updated);
   DBMS_OUTPUT.PUT_LINE('Updated first name: ' || v_first_name);
END;
/


-- using with into and

DECLARE
   v_table_name VARCHAR2(30) := 'employees';
   v_emp_id     NUMBER := 101;  -- Dynamic employee ID
   v_sql        VARCHAR2(1000);
   v_name       VARCHAR2(100);
BEGIN
   -- Construct the dynamic SQL query with a bind variable
   v_sql := 'SELECT first_name || '' '' || last_name FROM ' || v_table_name || ' WHERE employee_id = :emp_id';
   
   -- Execute the dynamic SQL and bind the value of v_emp_id
   EXECUTE IMMEDIATE v_sql INTO v_name USING v_emp_id;
   
   DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_name);
ENDECLARE 
    v_affected_rows PLS_INTEGER;
    v_first_name VARCHAR2(100);
BEGIN
    v_affected_rows := update_names(2,'KING',v_first_name);
    dbms_output.put_line(v_affected_rows|| ' row updated!');
    dbms_output.put_line(v_first_name);
END;
/
CREATE OR REPLACE FUNCTION update_names (ID IN VARCHAR2, last_name IN VARCHAR2, first_name OUT VARCHAR2) RETURN PLS_INTEGER IS
    v_dynamic_sql VARCHAR2(200);
BEGIN
    v_dynamic_sql := 'UPDATE names SET last_name = :1 WHERE id = :2 RETURNING name INTO :3' ;
    EXECUTE IMMEDIATE v_dynamic_sql USING last_name, ID RETURNING INTO first_name;
    RETURN SQL%rowcount;
END;


--- using with bulk collect into
DECLARE
   TYPE t_name IS TABLE OF VARCHAR2(20);
   names   t_name;
BEGIN
    EXECUTE IMMEDIATE 'SELECT distinct first_name FROM employees'
        BULK COLLECT INTO names;
    FOR i IN 1..names.COUNT LOOP
        dbms_output.put_line(names(i));
    END LOOP;
END;
/
CREATE TABLE employees_copy AS SELECT * FROM employees; 
/
DECLARE
   TYPE t_name IS TABLE OF VARCHAR2(20);
   names   t_name;
BEGIN
    EXECUTE IMMEDIATE 'UPDATE employees_copy SET salary = salary + 1000 WHERE department_id = 30 RETURNING first_name INTO :a'
        RETURNING BULK COLLECT INTO names;
    FOR i IN 1..names.COUNT LOOP
        dbms_output.put_line(names(i));
    END LOOP;
END;
/
DROP TABLE employees_copy;




-- open, for, fetch
DECLARE
  TYPE emp_cur_type  IS REF CURSOR;
  emp_cursor      emp_cur_type;
  emp_record      employees%rowtype;
BEGIN
  OPEN emp_cursor FOR 'SELECT * FROM employees WHERE job_id = :job' USING 'IT_PROG';
  LOOP
    FETCH emp_cursor INTO emp_record;
    EXIT WHEN emp_cursor%notfound;
    dbms_output.put_line(emp_record.first_name||emp_record.last_name);
  END LOOP;
  CLOSE emp_cursor;
END;



--DBMS_SQL package
- funtion
   - open_cursor() . execute(C_id) > fetch_rows(id)
- procedure
   - parse(c_id, statement, edition > close_cursor(c_id)


DECLARE
    v_table_name VARCHAR2(20) := 'employees_copy';
    v_cursor_id PLS_INTEGER;
    v_affected_rows PLS_INTEGER;
BEGIN
    v_cursor_id := dbms_sql.open_cursor;
    dbms_sql.parse(v_cursor_id, 'update '||v_table_name||' set salary=salary+500',dbms_sql.NATIVE);
    v_affected_rows := dbms_sql.EXECUTE(v_cursor_id);
    dbms_output.put_line(v_affected_rows|| ' rows are updated by dbms_sql!');
    dbms_sql.close_cursor(v_cursor_id);
END;

----
create or replace PROCEDURE prc_method4_example (p_table_name IN VARCHAR2) IS
    TYPE t_columns IS TABLE OF user_tab_columns%rowtype INDEX BY PLS_INTEGER;
    v_columns               t_columns;
    v_columns_with_commas   VARCHAR2(32767);
    v_number_value          NUMBER;
    v_string_value          VARCHAR2(32767);
    v_date_value            DATE;
    v_output_string         VARCHAR2(32767);
    cur_dynamic             INTEGER;
BEGIN
    SELECT * BULK COLLECT INTO v_columns FROM user_tab_columns WHERE table_name = upper(p_table_name);
    v_columns_with_commas:=v_columns(1).column_name;
    FOR i IN 2..v_columns.COUNT LOOP
        v_columns_with_commas:=v_columns_with_commas||','||v_columns(i).column_name;
    END LOOP;
    cur_dynamic := dbms_sql.open_cursor;
    dbms_sql.parse(cur_dynamic,'SELECT '||v_columns_with_commas||' FROM '||p_table_name,dbms_sql.NATIVE);
     FOR idx IN 1..v_columns.COUNT LOOP
        IF v_columns(idx).data_type = 'NUMBER' THEN
            dbms_sql.define_column(cur_dynamic,idx,1);
        ELSIF v_columns(idx).data_type IN ('VARCHAR2','VARCHAR','CHAR') THEN
            dbms_sql.define_column(cur_dynamic,idx,'dummy text',v_columns(idx).char_length);
        ELSIF v_columns(idx).data_type = 'DATE' THEN
            dbms_sql.define_column(cur_dynamic,idx,sysdate);
        END IF;
        v_output_string:=v_output_string||'  '||rpad(v_columns(idx).column_name,20);
     END LOOP;
     dbms_output.put_line(v_output_string);
     v_number_value:=dbms_sql.execute(cur_dynamic);
     WHILE dbms_sql.fetch_rows(cur_dynamic) > 0 LOOP
        v_output_string:=NULL;
        FOR t IN 1..v_columns.COUNT LOOP
            IF v_columns(T).data_type = 'NUMBER' THEN
                dbms_sql.column_value(cur_dynamic,t,v_number_value);
                v_output_string := v_output_string||'  '||rpad(nvl(to_char(v_number_value),' '),20);
            ELSIF v_columns(T).data_type IN ('VARCHAR2','VARCHAR','CHAR') THEN
                dbms_sql.column_value(cur_dynamic,t,v_string_value);
                v_output_string := v_output_string||'  '||rpad(nvl(to_char(v_string_value),' '),20);
            ELSIF v_columns(T).data_type = 'DATE' THEN
                dbms_sql.column_value(cur_dynamic,t,v_date_value);
                v_output_string := v_output_string||'  '||rpad(nvl(to_char(v_date_value),' '),20);
            END IF;
        END LOOP;
        dbms_output.put_line(v_output_string);
     END LOOP;
END;

begin
prc_method4_example('employees');
end;
```
