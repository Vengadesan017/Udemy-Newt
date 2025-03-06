# Spring Framework
- light weight
- contain JDBC , Hibernate, Web tool
- used for enterprise level project
- Spring is a Ecosystem
  - microservices
  - reactive
  - cloud
  - web app
  - severless
  - event driven
  - batch
- IOC ( principle )
  - Inversion of control
  - focus in business logic rather then the obj create maintain destroy
  - the IOC Containter manage the obj
- DI ( design pattern )
  - Dependency Injection
  - in IOC containter inject the one obj to another obj
  - it create obj but we need to mention

## Spring - 6 vs Spring boot -3
- spring boot is opinionated framework which create structute for you project hello world
- because spring takes lot of config to hello world
- spring is responsible to create obj that obj is called a bean
- 

## Spring Project
- eclipse
  - install spring 4 in warket space
  - create spring starter project with dependency
- intellij
  - go to start.sptin.io create sptiing project structure and download as zip
  - open in extract and open the project
- Steps using spring framework
  1. create structure
  2. run project
  3. Create DI
     - create your class
     - call the class from @SpringBootApplication
     - create applicationcontext obj from Spring application
     - @Component in class top to mention ID to create the obj to this class
     - @Autowired in second class for auto creating obj in container

## Manual method
1. create in maven archetype
2. create the class
3. create obj for ApplicationContext to auto create the obj
```
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  // create a container
    	Alien obj =(Alien) context.getBean("alien1");  // or
    	Alien obj = context.getBean("alien1",Alien.class);  

    	System.out.println(obj.code());
```
4. Add dependenct of spring
5. create spring.xml in resources
```
// add definition
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--	<bean id="alien1" class="com.telusko.Alien" scope="singleton">  -->
	
<!--	<bean id="alien1" class="com.telusko.Alien" autowire="byName"> -->
	<bean id="alien1" class="com.telusko.Alien" autowire="byType"> 
	
		<property name="age" value="21"/>		
 	<!--<property name="com" ref="com2"/>   -->    
	 <property name="com" >
	 <!-- Inner Bean  for restrict access only from the parent-->
	 <bean id="com1" class="com.telusko.Laptop" primary="true">
	</bean> 
	  </property>   


<!--		<constructor-arg value="21"></constructor-arg>
		<constructor-arg ref="lap1"></constructor-arg> -->
		
<!--		<constructor-arg type="com.telusko.Laptop" ref="lap1"/>
		<constructor-arg type="int" value="21"/> -->
		
<!--		<constructor-arg index="1" ref="lap1"/>
		<constructor-arg index="0" value="21"/> -->
		
<!--		<constructor-arg name="lap" ref="lap1"/>
		<constructor-arg name="age" value="21"/> -->
		
		
	</bean>
	

	<!--  <bean id="com1" class="com.telusko.Laptop" primary="true">
	</bean>  -->
	
<!-- <bean class="com.telusko.Desktop" lazy-init="true"> </bean>-->	 
	 
	
</beans>
```
6. Object creation
   - the the bean tag with class name in xal will create the obj to clss when the ApplicationContext class is created
   - if you mention two times it creaet a one obj for aliean ` <bean id="alien1" class="com.telusko.Alien" > <bean id="alien1" class="com.telusko.Alien"  `
7.Scope
   - if you two diff obj but it share the data because the comman from alien1 obj ` Alien obj =(Alien) context.getBean("alien1");     	Alien obj2 =(Alien) context.getBean("alien1"); `
   - TO Avoid this mention a scope
     - singleton  -- default
     - prototype  -- create new obj when user mention the in getbean
     - request
     - session
8. Setter injection
   - this assign the value to the variable thorough setter
   ` 	 <bean id="com1" class="com.telusko.Laptop" primary="true"> <property name="age" Value="21"
	</bean>   `
   - ref attribute
    - like setter injection for class
     ```
      <bean id="com1" class="com.telusko.Aliaan">
      <property name="lap" ref="lap1"
	    </bean>
       <bean id="lap1" class="com.telusko.Laptop">
	      </bean>
     private int age;
      private laptop lap;
     ```
9. Constructure injection
    - like setter injection but create construture instead of setter
     ```
     <bean>
    <constructor-arg value="21"></constructor-arg>
    		<constructor-arg ref="lap1"></constructor-arg >   error because error occured
     
     <constructor-arg type="com.telusko.Laptop" ref="lap1"/>
		<constructor-arg type="int" value="21"/>


    	<constructor-arg index="1" ref="lap1"/>      // index to mention the column no.
    		<constructor-arg index="0" value="21"/>
     </bean>
     ```
10. Interface
    - create interface
    - create class with implement
    - mention the obj to access the interface
11. Auto wiring
    - byName ` <bean id="alien1" class="com.telusko.Alien" autowire="byName">        <bean id="com" class="com.telusko.Aliaan"> com obj in ALien`
    - byType  `       <bean id="com1" class="com.telusko.Aliaan" primary="true"> `

12. Lazy init
    - obj is created only when the obj is used
    `       <bean id="com1" class="com.telusko.Aliaan" lazy-init="true"> `
### Annaotation
- @SprintGootApplication - manage all the congifuration and start the main by run()
- @component
- @Autowire
- @Values
- @Quilifier
- @primary
- ...
### Layer
- in server
  - Controller ( URL )
  - service ( business logic )
  - Repository ( data base through DAO )data access object
### Service 
- create service package (folder)
- inside this create sampleService classs
- and create a obj in main method Sampleservice service = context.getBean(SampleService.class);service.addSample(sam);
- Mention the service @Service at top of Class name its like and same as @Component
### Repository
- crearte SampleRepository.java in repo folder package
- inside this create function like save and mention the class as @Repository
