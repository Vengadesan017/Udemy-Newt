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
## Script
```sql
sqlplus / as sysdba;
alter session set container=orclpdb;
alter pluggable database open;
alter pluggable database orclpdb save state;
alter user hr identified by hr account unlock;

```
