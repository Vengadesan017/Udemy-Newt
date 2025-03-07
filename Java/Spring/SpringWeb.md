# Spring MVC , Spring Web
## Servlet
- use web container or servlet container to run
- Like Apache Tomcat
- servlet manage the request and response
- steps
  - external tomcat (web.xml to map url and method by mention the class as @webServlet("/hello"))
  - download apachae tomcat
  - run Startup.sh file
  - place all the code in web folder
  - create package as .war
  - - or use embedded tomcat for development
    - Create project in intellij
    - add dependenacy like jakarta.servlet and tomcat embed
    - create class and extends HttpServlet
      - create service method with HttpSerletRequest , HttpServletResponse as para
      - mention the class as @webServlet("/hello")
    - to run go to main method and create obj for Tomcat with new then tomcat_obj.start()
    - this start run and end, to Continoue the running call setServer().await() obj
    - in map the url
      - create context_obj from addContext("PATH",null"dir")
      - then CREATE Servlet Tomcat.addServlet(context_obj,"Your_servelt_name_FOR_Servel_class_name", new Servel_class_name
      - then map url to serlet by context.addServletMappingDecoded("/url","Your_servelt_name_FOR_Servel_class_name")
    - send response
      - res.getWritter()println("Hello world")  // or create obj of gerWriter frm PrintWriter as out
      - for html res.setCOntentType("text/html");
    - main
      ```
        public static void main( String[] args ) throws LifecycleException
        {
            System.out.println( "Hello World!" );
            
            Tomcat tomcat=new Tomcat();
            tomcat.setPort(8080);  //change the default post number
            
            
            Context context=tomcat.addContext("", null);
            Tomcat.addServlet(context,"HelloServlet",new HelloServlet());
            context.addServletMappingDecoded("/hello", "HelloServlet");
            
            tomcat.start();
            tomcat.getServer().await();
        }

      ```
    - my Servlet
     ```
      public class HelloServlet extends HttpServlet {
      	
      /**
      	 * 
      	 */
      	private static final long serialVersionUID = 1L;
      
      public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
      	System.out.println("In Service");
      	res.setContentType("text/html");
      	
      	PrintWriter out=res.getWriter();
      	
      	out.println("<h2><b>Hello World</h2></b>");
      	
      	
      	//res.getWriter().println("Hello World");
      }	

     ```

## MVC with spring boot
- view technolagy use JSP to return a html pages (jakarta server pages) embed with java in html
- MVC ( servlet - controller , jsp - view , object(plain old java object) - model )
- the jsp it converted into servlet and run in tomcat
- Create web using spring boot
  1. go start spring io create project the add dependenacy ( spring web  ) generate run
  2. in project run at 8080
  3. Create view - to create home page create dir like webapp and inside this create index.jsp
    ```
    <%@page language="java" %>

    <html>
        <head>
            <link rel="stylesheet" type="text/css" href="style.css">
        </head>
        </body>
            <h2>Telusko Calculator</h2>
    
             <form action="addAlien">
                    <label for="aid">Enter Id :</label>
                    <input type="text" id="aid" name="aid"><br>
                    <label for="aname">Enter Name :</label>
                    <input type="text" id="aname" name="aname"><br>
                    <input type="submit" value="Submit">
                </form>
    
        </body>
    </html>
    ``` 
  5. to create contoller create HomeController with @Controller ,inside this create function with return index.jsp and with @REquestMapping("/")
  ```
    @Controller
    public class HomeController {
    
    	@ModelAttribute("course")      // <p> use as var ${course} ....</p>
    	public String courseName() {
    		return "Java";
    	}
    	
    	
    	@RequestMapping("/")
    	public String home() {
    		// System.out.println("Home method called");
    		return "index";
    	}
    
    	@RequestMapping("add")
    	public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {
    
    		int result = num1 + num2;
    		mv.addObject("result",result);
    		mv.setViewName("result");
    
    		return mv;
    	}
    	
    	
    
    	@RequestMapping("addAlien")
    	//public String addAlien(Alien alien) {
    	public String addAlien(@ModelAttribute("alien1") Alien alien) {   // in jsp get the value as ${alien1}
           
    		return "result";
    	}
    
    }
  ``` 
  6. but it dounload the page instead of loading so add dependency like tocat-jasper to convert the jsp to servlet
  ```
		<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper</artifactId>
			<version>10.1.17</version>
		</dependency>
  ```
  7. open the url
  8. create single controller for all create update delete read
  9. to set data from user in controller
      1. use req.gerParameter("num1") by adding HttpServletRequest req as para
        - int num1 = Integer.parseInt(req.getParameter("num1");
        - use seesion to add result to jsp page
          - session.setAtrribute("result",num1); before return
          - in jsp <h1> num21 : <%= session.getAttribute("result") %>  </h1>   //or use jsp Standard library
          - in jsp use jspsl <h1> num21 : ${result}  </h1>
      2. use directly num1 and num2 by add (int num1 , int num2 , HttpSession session) // but num1 and num2 is name from form it other name
      3. use directly num1 and num2 with @RequestParam
         - by add (@RequestParam("num1") int num , @RequestParam("num2") int numm, HttpSession session) // but num1 and num2 is name from form it other name
      3. use model instead of HttpSession session
         - model.addAttribute("result",result);
      3. use ModelAndVIew instead of model to bind the result and jsp file 
         - mv.addObject("result",result);
         - mv.setViewName("index");
         - return mv
  10. setting prefix and suffix in Application.property file to easy loading jsp file
      ```
      spring.mvc.view.prefix=/views/
      spring.mvc.view.suffix=.jsp
      ```
  11. put css file in webapp folder or static folder in application.properties
  12. use @MOdelAttribute to get data from html and create obj for model with this data
## MVC without spring boot
- addition configuration need
- steps
  1. download external tomcat and extract
  2. dowload eclipse java ee version
  3. create new maven project with catalog of maven-archetype-webapp

     
