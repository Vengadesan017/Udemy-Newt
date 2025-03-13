# Java based config
- alternate for xml baesd config for beans
1. create AppConfig.java in config package with @Configuration
2. in this class create public method in type of your class like public Sample sample(){} and return new Sample() and iin top add @Bean
   ```

    @Configuration
    @ComponentScan("com.vengat")
    public class AppConfig {
    
    	
    	
    	
    	@Bean
    	public Alien desktop(Computer com) //@Qualifier("desktop")
    	{
    		Alien obj= new Alien();
    		obj.setAge(25);
    		obj.setCom(com);
    		return obj;
    		
    	}
   
    	@Bean(name="custom_name")
    	public Alien desktop(Computer com) //@Qualifier("desktop")
    	{
    		Alien obj= new Alien();
    		obj.setAge(25);
    		obj.setCom(com);
    		return obj;
    		
    	}
   
    	@Bean(name="custom_name", "custom_name2")
    	public Alien desktop(Computer com) //@Qualifier("desktop")
    	{
    		Alien obj= new Alien();
    		obj.setAge(25);
    		obj.setCom(com);
    		return obj;
    		
    	}
    	}
   ```
4. in main method add applicationContext with AppConfig.class
5. mention for bean Sample sam = context.getBean(Desktop.class);
6. call function sam.func();
```
import com.telusko.config.AppConfig;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Alien obj1 = context.getBean(Alien.class);
	   System.out.println(obj1.getAge());
		obj1.code();

		
		
		
		
		
//		Desktop dt = context.getBean("desktop", Desktop.class);   // desktop name is bean name to mention( method name is bean name)
//		dt.compile();
//		Desktop dt = context.getBean("custom_name", Desktop.class);   // rename the method name
//		dt.compile();
//
//		Desktop dt1 = context.getBean("desktop", Desktop.class);
//		dt1.compile();

		
		
		
	}
}
```
7. Scope
   - in Appconfig.java in funtion mention @scope("prototype")
8. Auto wiring
```
//	@Bean
//	public Alien alien(@Autowired Computer com) 
//	{
//		Alien obj= new Alien();
//		obj.setAge(25);
//		obj.setCom(com);               // auto wiring thr obj
//		return obj;
//	}
//	@Bean
//	@Primary
//	public Laptop laptop() {
//		return new Laptop();
//	}
////	@Bean(name = {"Beast","desktop","com1"})
//	@Bean
//	public Desktop desktop() {
//		return new Desktop();
//	}
```
9. Qualifierd and primary annotation
    - "@Qualifier" is used to explicitly specify which bean to inject when multiple beans of the same type exist
    - "@Primary" marks a default bean that will be injected if no specific qualifier is provided
```
//	@Bean
//	public Alien alien(@Qualifier("desktop") Computer com) //@Qualifier("desktop")
//	{
//		Alien obj= new Alien();
//		obj.setAge(25);
//		obj.setCom(com);               // auto wiring thr obj
//		return obj;
//	}
//       
//	@Bean
//	@Primary
//	public Laptop laptop() {
//		return new Laptop();
//	}
```
10. Component stereotype annotation
    - to avaoid the manual config in java based config file
    - simplly add @compannet in top of class to mention
    - then add @ComponentScan(com.vengat)
    - autowiring
      - add @Autowired and @Quilifier("Conponent_name_of_ref_class") in obj inside the @Component class
      - Injection
        - field    - @Autowired in top of ref obj
        - constructor  - @Autowired in top of Con func
        - setter   - @Autowired in top setter 
    - Qualifier
  	- mention @Qualifier("Conponent_name_of_ref_class") 
    - primary
  	- mention @Primary
    - Scope
  	- mention @Scope("Prototype")
    - Value
  	- mention @Value("21") on top og private int age;
