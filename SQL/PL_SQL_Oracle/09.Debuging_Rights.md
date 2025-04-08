# Debuging
- compile for debug > debug
  - confirm the subprograms and variables
  - slove the error like
    - trigger conflits
    - network error
  - in prefernece
    - in degugger
      - select step over or step into and post
      - step over for select line to debug
      - step into for degub from the first line
  -  recompile for debug to run the print statement in calling area
```sql
  -- Granding debug privileges to user
  GRANT DEBUG CONNECT SESSION TO hr;
GRANT DEBUG ANY PROCEDURE TO hr;
 
BEGIN
    dbms_network_acl_admin.append_host_ace
         (host=>'127.0.0.1',
          ace => sys.xs$ace_type(privilege_list => sys.xs$name_list('JDWP'),
                                 principal_name => 'HR',
                                 principal_type => sys.xs_acl.ptype_db) );
END;



--- sample code for anonymous block
DECLARE
  CURSOR c_emps IS 
  SELECT * FROM employees_copy;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Update started at : '|| systimestamp);
    FOR r_emp IN c_emps LOOP
        IF NVL(r_emp.commission_pct,0) = 0 THEN
            UPDATE employees_copy SET commission_pct = 0.3 WHERE employee_id = r_emp.employee_id;
        end if;
    END LOOP;
 dbms_output.put_line('Update finished at : '|| systimestamp);
 ROLLBACK;
END;
```
# manageing security for definer rights and invoker rights
- Definer rights ( default behavior)
  - object (procedure, function, or package) executes with the privileges of the owner (the definer) of the object, not the privileges of the user who is calling (invoking) the object
- Invoker Rights
  - object executes with the privileges of the user who is calling (invoking) the procedure, function, or package
- AUTHID for security
  - AUTHID DEFINER (default): The procedure runs with the definer’s privileges
  - AUTHID INVOKER: The procedure runs with the invoker’s privileges
```sql
-- Definer Rights (default)
CREATE OR REPLACE PACKAGE employee_pkg AUTHID DEFINER AS
    PROCEDURE show_salary(emp_id IN NUMBER);
END employee_pkg;

-- Invoker Rights
CREATE OR REPLACE PACKAGE employee_pkg AUTHID INVOKER AS
    PROCEDURE show_salary(emp_id IN NUMBER);
END employee_pkg;


```
- Grand and revoke
```
-- Grant SELECT privilege on the "employees" table to user "scott"
GRANT SELECT ON employees TO scott;

-- Grant SELECT, INSERT privileges on the "employees" table to role "hr_role"
GRANT SELECT, INSERT ON employees TO hr_role;

-- Grant EXECUTE privilege on a procedure "update_salary" to user "admin"
GRANT EXECUTE ON update_salary TO admin;

-- Grant SELECT privilege with the ability to grant to others
GRANT SELECT ON employees TO scott WITH GRANT OPTION;


-- Revoke SELECT privilege on the "employees" table from user "scott"
REVOKE SELECT ON employees FROM scott;

-- Revoke SELECT privilege from the role "hr_role"
REVOKE SELECT ON employees FROM hr_role;

-- Revoke EXECUTE privilege on procedure "update_salary" from user "admin"
REVOKE EXECUTE ON update_salary FROM admin;

```
- CBAC
  - context basedaccess controll
  - mechanism that allows you to define security policies based on dynamic context
  - fine-grained access control
  - it takes user roles and privileges , session parameter , row level security
```sql
CREATE OR REPLACE FUNCTION department_policy (schema IN VARCHAR2, object IN VARCHAR2)
   RETURN VARCHAR2 IS
BEGIN
   -- Return a predicate for row-level access control
   RETURN 'department_id = ' || USER;  -- Example: Allow access to rows based on the user
END department_policy;
/

BEGIN
   DBMS_RLS.ADD_POLICY(
      object_schema => 'hr', 
      object_name   => 'employees', 
      policy_name   => 'department_policy',
      function_schema => 'hr', 
      function_name => 'department_policy', 
      statement_types => 'SELECT');
END;
/


SELECT * FROM hr.employees;  -- Only shows rows where department_id = user (context-based).


```
