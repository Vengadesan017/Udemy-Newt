# Hibarnate
- ORM Framework - Object-Relational Mapping
- increase productivity
- create class for table as blue print and create obj and access the table
- basically bibernate use jdbc to in behind the scenes
## steps
- Add dependencies
- create class in package with private attribute and getter and setter and toString
- then create obj for clss and store values
- Mainly then create session factor to open the session
- before this create configuration obj use this for session factory and this obj for opensession
- then finally save the session with obj which is created for blue print class
- -- it show the error for not connect to jdbc
- so create hibernate.cfg.xml file and in this create session factory with db criver , url, username , password
- then define @Entity in that blue print class
- then call the configuration with addAnnotatachClass(com.venagt.BluePrient.class)
- in Blueprint class mention @id for id attribute
- then commit the transaction before saving
- finally in hibernate.cfg.xml file mention suto create update delete the models
- to view configuration in hiber..xml file add poperty like show_sql and format_sql as true
- optional to mention the db type in hibernate file as property
- the save method show wraning to use persist instead of save and also close the session

### Summary
1. In pom.xml
   - Add dependencies like hibernate, postgre sql
    ```
      <?xml version="1.0" encoding="UTF-8"?>
      <project xmlns="http://maven.apache.org/POM/4.0.0"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
          <modelVersion>4.0.0</modelVersion>
      
          <groupId>com.vengat</groupId>
          <artifactId>javaHibernate</artifactId>
          <version>1.0-SNAPSHOT</version>
      
          <properties>
              <maven.compiler.source>23</maven.compiler.source>
              <maven.compiler.target>23</maven.compiler.target>
              <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          </properties>
          <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
      
      
          <dependencies>
          <dependency>
              <groupId>org.postgresql</groupId>
              <artifactId>postgresql</artifactId>
              <version>42.7.3</version>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
          <dependency>
              <groupId>org.hibernate.orm</groupId>
              <artifactId>hibernate-core</artifactId>
              <version>6.6.3.Final</version>
          </dependency>
      </dependencies>
      </project>
    ```
2. In hibernate.cfg.xml in resources dir
   - Add Session-factory  and also add database type like dialect , auto create auto up
   ```
    <hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
        <session-factory>
            <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
            <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/java_spring</property>
            <property name="hibernate.connection.username">postgres</property>
            <property name="hibernate.connection.password">123456</property>
    
            <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
            <property name="hibernate.hbm2ddl.auto">update</property>
            <property name="hibernate.show_sql">true</property>
            <property name="hibernate.format_sql">true</property>
    
        </session-factory>
    </hibernate-configuration>
   
   ```
3. Create entity class with getter setter tostring id
```
package com.vengat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
    private int rollNo;
    private String sName;
    private int sAge;

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }


    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }

}
```
4. In main class
   - create obj for stdent class
   - create SessionFactory
   - create session
   - create Transaction
   - save (persist) session with that object
   - commit Transaction
   - close session
   - close session Factory
```
        s1.setRollNo(106);
        s1.setsName("Avni");
        s1.setsAge(21);


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Student.class)
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(s1);


        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);

```
## Fetching data
## Update 
## delete
## rename
## embeddable - like extending the table
- one to one
- one to many -- use thired table
- many to many -- use thired table

## Eagar Fetching and lazy Fetching
- in embedded table when you use get(Stuened.class,101) it   return from onle student not from laptop - Lazy fetch
- when you sout the obj it will return all the data from two data
- to define in @OneTOMany(fetch = FetchType.EAGER)  || .LAZY

## Caching
- when repeatedly use same seesion is return the value from the cache memory not from db so create neww session obj to refresh
- we can also conntect to session but need third party tools
## HQL (Hibernate query Language)
- read session.find(Student.class,101); pk id
- delete session.remove(student_onj);
- create session.persist(student_onj);
- update session.merge(student_onj);
- gfetch

