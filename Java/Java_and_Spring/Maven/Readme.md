# Maven
- project management tool
- manage jar file (dependency)
- manage project ( complie > run > test > packaging > deploying)
- alters ( gradle , ivy )
- go mvnrepository.com to copy the dependencies
- then add the paste into pom.xml file (project object model) inside the dependencies tag then reload to download
- pom.xml
  - each dependency consist of GAV grp id , artifact id , version id
  - the actual things in effective pom (super pom)
```
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->

    <dependencies>
      <dependency>
          <groupId>org.postgresql</groupId>
          <artifactId>postgresql</artifactId>
          <version>42.7.4</version>
      </dependency>
```
- Maven Archetype -  default templeting
  - when creating the project choose the maven archetype by choose maven central catalog then choose spring-boot-jersery in archetype
- work flow
  - first when you create the dependency it serach locally in m2 folder in documents
  - if not there then download from network and sove inlocal
