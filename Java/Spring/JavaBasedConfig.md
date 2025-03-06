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
