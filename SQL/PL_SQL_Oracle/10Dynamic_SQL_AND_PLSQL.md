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
    - execute immediate command
    - open-for , fetch and close statment
  - DBMS_SQL package
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

```

## Dynamic PLSQL
