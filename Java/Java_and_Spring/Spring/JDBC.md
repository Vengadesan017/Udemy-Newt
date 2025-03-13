# Spring JDBC 
- H2 ( default db with driver / no config needed) JDBCTemplete
- steps
  - goto start spring io
  - create package
  - add dependancy search JDBC API , H2 database
  - generate
  - open project
  - create layers
  - create model like student
  - create service like StudentService
  - in main create Applicationcontext and ment for obj for student and studentService
  - Add anotation like @Companent, @Service
  - create repo folder and class or create obj in service and generate setter and getter and auto wire for setter
  - add anotation @Repository
  - Create save func in repo and call in service
  - create getStudents class in service and call from main with List<Student> type
  - -
  - create obj for jdbc template in repo class and add auto wired in setter
    ```
    public void save(Student s){
        System.out.println("saving " + s);
        String sql = "Insert into student ( id , name, marks ) values (?, ?, ?)";
        int rows = jdbc.update(sql, s.getId(),s.getName(),s.getMarks() );
        System.out.println(rows);
    }
    ```
  - create Schema.sql in resources to create the schema for all the table ( only for h2 )
    ```
    create table student (
        id int primary key,
        name varchar(50),
        marks int
    )
    ```
  - create Data.sql in resources to create the data for all the table  ( only for h2 )
    ```
    insert into student (id, name marks) values (10, 'Babu', 21)
    insert into student (id, name marks) values (10, 'Babuu', 21)
    insert into student (id, name marks) values (10, 'Babuuu', 21)
    ``` 
  - select data from table using Rowmapper in jdbc.query(sql ,rowmapper)
    ```
          public List<Student> findAll() {
          
          String sql="select * from student"; RowMapper<Student> mapper=new
          RowMapper<Student>() {
          
          @Override public Student mapRow(ResultSet rs, int rowNum) throws SQLException
          { Student s=new Student(); s.setRollNo(rs.getInt("rollno"));
          s.setName(rs.getString("name")); s.setMarks(rs.getInt("marks")); return s; }
          }; return jdbc.query(sql, mapper); }
    ```
- connect to postgre db
  - add postgree db dependenacy
  - edit the application.properties in resources
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/spring
    spring.datasource.username=postgres
    spring.datasource.password=123456
    spring.datasource.driver-class-name=org.postgresql.Driver
    ```
