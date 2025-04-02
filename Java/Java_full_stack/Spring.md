# Spring
-  download java jdk , eclipse, tomcat
-  add spring core , spring context dependency
### Dependency Injection (DI) and Inversion of Control (IoC)
- IOC
  - principle which control of program is inverted
  - types
    - Dependency Injection (DI) - The most commonly used form of IoC ( in spring)
    - Event-based IoC - Where the control is given to an event handler or listener
    - Factory-based IoC - Where object creation is delegated to a factory class
  - types of dependency injection
    - constructor injection
    - setter injection
    - interface injection
```
interface Engine {
    void start();
}
class GasEngine implements Engine {
    public void start() {
        System.out.println("Gas Engine starting...");
    }
}
class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Electric Engine starting...");
    }
}
class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}
public class Main {
    public static void main(String[] args) {
        Engine gasEngine = new GasEngine();
        Car car = new Car(gasEngine);  // Injecting the dependency
        car.drive();

        Engine electricEngine = new ElectricEngine();
        car = new Car(electricEngine);  // Injecting a different dependency
        car.drive();
    }
}
```
- getBeans
  - create obj for annotationCOnfigApplicationCOntext
  - with that obj contexy.getBean(Car.Class) and must metion the class as @Component
  - with that obj contexy.getBean("vv",Car.Class) and must metion the class as @Component("vv")   --  also called as Qualifier  and mention @Qualifier("vv2") below to autowire
  - with that obj contexy.getBean("GasEngine car",Car.Class) and must metion the class as @Component

### Autowire
- use Auto wire annotation like @Autowired in top of Engine engine
- use Qualifier or primary to find
### Beans
- to manage all the beans put is all in the single file like in @Configuration @ComponentScan("package")
  - list all the class with @Bean("class_name") public EV ev() { return new ev();}
### Spring MVC
- add spring core ,  spring context , spring-webmvc , spring-web, spring-bean, jakarta.servlet dependency
- then config the xml file
### Restfull
- status code
  - 1xx informational
    - 100 continue
    - 102 processing
  - 2xx successful
    - 200 of
    - 202 created
  - 3xx redirection
    - 301 move permenently
    - 304 not modified
  - 4xx client error
    - 403 forbidden
    - 404 not found
  - 5xx server error
    - 500 internal server
    - 503 service unavailable
- REQUEST methods
  - read - get 200 404 500
  - delete - delete 200 204 404 500
  - create - post 201 400 500
  - update - put 200 400 404 500
- HATEOAS - (Hypermedia as the Engine of Application State)
  - live server return json based file or static file to client
- SOAP - (Simple Object Access Protocol)
  - xml based protocal to transfer the data between the server and client



