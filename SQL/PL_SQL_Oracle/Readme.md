# PL/SQL Architechure
- Physical Architecture
  - PL/SQL Engine run on the top of SQL Engine
- Logical Architecture
  - co operate with SQL ENgine
  - enable subprogram
  - dynamic queries
  - Case Insensitivity
  - Optimizer
  - enable oop
  - web development
### Pluggable database
- the container db cdb1 contain root block andg store the meta data
- the root block had multiple pluggable dbs
## IN cmd
```sql
sqlplus / as sysdba;
alter session set container=orclpdb;
alter pluggable database open;
alter pluggable database orclpdb save state;
alter user hr identified by hr account unlock;

```
## Download 
- oracle express
- oracle sql developer
- live server
  - https://livesql.oracle.com/
## default user
- system
- sys  - highest privilege user
- connection
  - protocal - tcp
  - port - 1521
  - service name - orcpdb mostly for that base container
 
## load sample data
- download the data
```sql
sqlplus sys/123@localhost:1521/orclpdb as sysdba;
alter pluggable database open;
alter pluggable database orclpdb save state;
create or replace directory import_dir as 'C:\SAMPLE_SCHEMAS';
exit
impdp system/123@localhost:1521/orclpdb schemas=hr directory=import_dir dumpfile=EXPORTED_SAMPLE_SCHEMAS.dmp logfile=import.log remap_tablespace=EXAMPLE:USERS
impdp system/123@localhost:1521/orclpdb schemas=sh directory=import_dir dumpfile=EXPORTED_SAMPLE_SCHEMAS.dmp logfile=import.log remap_tablespace=EXAMPLE:USERS
impdp system/123@localhost:1521/orclpdb schemas=oe directory=import_dir dumpfile=EXPORTED_SAMPLE_SCHEMAS.dmp logfile=import.log remap_tablespace=EXAMPLE:USERS
impdp system/123@localhost:1521/orclpdb schemas=pm directory=import_dir dumpfile=EXPORTED_SAMPLE_SCHEMAS.dmp logfile=import.log remap_tablespace=EXAMPLE:USERS
impdp system/123@localhost:1521/orclpdb schemas=ix directory=import_dir dumpfile=EXPORTED_SAMPLE_SCHEMAS.dmp logfile=import.log remap_tablespace=EXAMPLE:USERS
sqlplus sys/123@localhost:1521/orclpdb as sysdba;
alter user hr identified by hr account unlock;
alter user sh identified by 123 account unlock;
alter user oe identified by 123 account unlock;
alter user pm identified by 123 account unlock;
alter user ix identified by 123 account unlock;
/

```

### BLock 
- declare  - optional
- begin     - mandatory
- exception   - optional
- end;          - mandatory
#### Types
- anonymous block  - null between begin and end
- procedures
- functions
### pl out put
```sql
set SERVEROUTPUT on;
begin
dbms_output.put_line('Hello');
end;
```
### commands
``` 
lsnrctl status   -- to see poer and hostin cmd
sqlplus / as sysdba
 sqlplus username/password@//<hostname>:<port>/<service_name>
sqlplus admin/password@//192.168.1.100:1521/XE

SELECT USER FROM DUAL;  -- to see user
SELECT username FROM dba_users;

```
### Key Points:
- CDB (Container Database): The root database that contains multiple PDBs.
- PDB (Pluggable Database): A self-contained, portable database that is part of the CDB.
- Common User: A user that is defined at the CDB level and can be used across all PDBs.
- Local User: A user that exists only within a specific PDB.
### In sql developer
- lishener problemmmmmm
```sql
sqlplus system/123456

SHOW PARAMETER container;

CONNECT sys/123456 AS SYSDBA;

ALTER SESSION SET CONTAINER = hr;

show pdbs


CREATE PLUGGABLE DATABASE HR
ADMIN USER HR IDENTIFIED BY 123456
ROLES = (DBA)
FILE_NAME_CONVERT = ('D:\TOOLS\ORACLE\ORADATA\XE\PDBSEED\', 'D:\TOOLS\ORACLE\ORADATA\XE\PDBHR\');

ALTER SESSION SET CONTAINER = HR;
SHOW CON_NAME;

DROP USER C##HR CASCADE;
CREATE USER C##hr IDENTIFIED BY 123456;
GRANT CREATE SESSION, CREATE TABLE, CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE, CREATE TRIGGER,UNLIMITED TABLESPACE TO hr;

```
