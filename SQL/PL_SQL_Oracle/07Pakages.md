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
