## Packages
- group procedure , function , variables, cursors into single unit
- improve modularity , maintainablility ,performance , encapsulating logic
- parts
  - packeage specification
  - package body
```sql
-- Package specification
CREATE OR REPLACE PACKAGE employee_pkg IS
   PROCEDURE greet_employee(p_employee_name IN VARCHAR2);
   FUNCTION get_employee_salary(p_employee_id IN NUMBER) RETURN NUMBER;
   v_department_id NUMBER;
END employee_pkg;

-- Package body
CREATE OR REPLACE PACKAGE BODY employee_pkg IS
   PROCEDURE greet_employee(p_employee_name IN VARCHAR2) IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('Hello, ' || p_employee_name || '!');
   END greet_employee;
   FUNCTION get_employee_salary(p_employee_id IN NUMBER) RETURN NUMBER IS
      v_salary NUMBER;
   BEGIN
      SELECT salary INTO v_salary
      FROM employees
      WHERE employee_id = p_employee_id;
      RETURN v_salary;
   END get_employee_salary;
END employee_pkg;

-- Calling the procedure from the package
EXEC employee_pkg.greet_employee('John Doe');
SELECT employee_pkg.get_employee_salary(100) FROM dual;

```
- Visibility
  - Public Visibility (objects declared in the package specification)
    - procedure , d=function , record , constants variables
  - Private Visibility (objects declared in the package body)
```sql
CREATE OR REPLACE PACKAGE employee_pkg IS
    -- Public variables
    v_department_id NUMBER;

    -- Public procedure
    PROCEDURE get_employee_name (emp_id IN NUMBER);
    
    -- Public function
    FUNCTION get_employee_salary (emp_id IN NUMBER) RETURN NUMBER;
END employee_pkg;
/

SET SERVEROUTPUT ON




CREATE OR REPLACE PACKAGE BODY employee_pkg IS
    -- Private variables (only visible within the package body)
    v_private_variable NUMBER := 100;
    
    -- Private procedure (only accessible within the package body)
    PROCEDURE private_procedure IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('This is a private procedure');
    END private_procedure;
    
    -- Implementation of public procedure
    PROCEDURE get_employee_name (emp_id IN NUMBER) IS
        v_employee_name VARCHAR2(100);
    BEGIN
        SELECT first_name || ' ' || last_name
        INTO v_employee_name
        FROM employees
        WHERE employee_id = emp_id;
        
        DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_employee_name);
    END get_employee_name;
    
    -- Implementation of public function
    FUNCTION get_employee_salary (emp_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary
        INTO v_salary
        FROM employees
        WHERE employee_id = emp_id;
        
        RETURN v_salary;
    END get_employee_salary;
    -- This will give an error because private_procedure is private to the package body
--    EXEC employee_pkg.private_procedure;
END employee_pkg;
/



-- Calling the public procedure
EXEC employee_pkg.get_employee_name(100);

-- Calling the public function
SELECT employee_pkg.get_employee_salary(100) FROM dual;

-- This will give an error because private_procedure is private to the package body
EXEC employee_pkg.private_procedure;


```
- Illegal Object Reference
  - Accessing a private ..
  - Referencing an object that doesn’t exist
  - Wrong scoping in packages
- Forwarding declaration
  - Calling second procedure before it is fully defined
- package initialization
  - loaded in memory on first call
  - uninitializes variable are null by default
  - initialized variable will be overrrideen with 
```sql
CREATE OR REPLACE PACKAGE employee_pkg IS
    PROCEDURE init_package;
    PROCEDURE print_hello;
END employee_pkg;
/

CREATE OR REPLACE PACKAGE BODY employee_pkg IS
    -- Variable to hold some initialization state
    v_initialized BOOLEAN := FALSE;

    -- Package initialization logic
    PROCEDURE init_package IS
    BEGIN
        IF NOT v_initialized THEN
            DBMS_OUTPUT.PUT_LINE('Package initialized');
            v_initialized := TRUE;  -- Set the flag to prevent re-initialization
        END IF;
    END init_package;
    
    -- Public procedure
    PROCEDURE print_hello IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Hello from the package!');
    END print_hello;

    -- This section is executed only once when the package is first loaded
    BEGIN
        init_package;  -- Call initialization procedure
    END;
    
    exec employee_pkg.init_package
    exec employee_pkg.print_hello

```
- persistence state
  - the global variables in a package that retain their values between calls
  - variables do not reset when you exit a PL/SQL block
  - Instead, they hold their values between subsequent executions of the package
  - the data is persistence in every session not in package restart
```sql
CREATE OR REPLACE PACKAGE employee_pkg IS
    PROCEDURE increment_counter;
    PROCEDURE display_counter;
END employee_pkg;
/

CREATE OR REPLACE PACKAGE BODY employee_pkg IS
    -- Persistent state variable
    v_counter NUMBER := 0;

    PROCEDURE increment_counter IS
    BEGIN
        v_counter := v_counter + 1;
    END increment_counter;

    PROCEDURE display_counter IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Counter: ' || v_counter);
    END display_counter;
END employee_pkg;

exec employee_pkg.display_counter;
exec employee_pkg.increment_counter;
```
- Collections
  - use nesed table , varray , associative array
```sql
CREATE OR REPLACE PACKAGE employee_pkg IS
    -- Declare a collection (nested table)
    TYPE emp_id_table IS TABLE OF NUMBER;
    v_emp_ids emp_id_table;
    
    PROCEDURE add_employee_id (emp_id IN NUMBER);
    PROCEDURE print_employee_ids;
END employee_pkg;
/
CREATE OR REPLACE PACKAGE BODY employee_pkg IS
    -- Add employee_id to the collection
    PROCEDURE add_employee_id (emp_id IN NUMBER) IS
    BEGIN
        -- Initialize the collection if it's not already initialized
        IF v_emp_ids IS NULL THEN
            v_emp_ids := emp_id_table();  -- Initialize the collection as an empty nested table
        END IF;

        -- Add the employee_id to the collection
        v_emp_ids := v_emp_ids MULTISET UNION emp_id_table(emp_id); 
    END add_employee_id;

    -- Print all employee IDs in the collection
    PROCEDURE print_employee_ids IS
    BEGIN
        -- Initialize the collection if it's not already initialized
        IF v_emp_ids IS NULL THEN
            v_emp_ids := emp_id_table();  -- Initialize the collection as an empty nested table
        END IF;

        FOR i IN 1..v_emp_ids.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE('Employee ID: ' || v_emp_ids(i));
        END LOOP;
    END print_employee_ids;
END employee_pkg;
/


exec employee_pkg.add_employee_id(10)
EXEC employee_pkg.print_employee_ids;

```
-- view package
- ` select * from user_source where type = 'PACKAGE BODY'`
