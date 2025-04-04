# JSP and Servlet
- download tomcat and eclipse
- create project 
  - web > Dynamic web project or maven project > pom.xml
  - add tomcat from apache
  - in java in main create the servlet
- Servelt Container
- contrainer : tomcat , jetty - to preocess the request
  - web app
    - servlet
      - load servlet class
      - create instance of servlet
      - call the servlets inti() method
      - when new request
        - call the servlets SERVICE() method
        - call the servlets DESTROY() method
- create html and jsp file web folder
  - it con open directly in as .html
- JSP elements
  - <%= 2*5 %>   --  expression
  - <% out.println("Hello"); %>    -- scriptlet
  - <%! public int count = 0; %>    -- declaration var and method also
  - <%@ page.. %>                   -- directive
  - <%-- comments --%>
- Annotation
  - @WebServlet("/home") in top of class
- read para meter of url
  - use request.getParameter("q")
- load file and class asn jsp
  - <%@ include file="file.txt" %>
  - <%@ page import="org.ven.hello" %>
    - <%= new Hello().demo %>
  - <jsp:include page="filename"/>
  - <jsp:forward page="filename"/>
## Forms
- add jakarta.servlet-api dependency
- create forms.jsp file
  - create form as get or post method
- create submit.jsp file
  - show the collect data like <%= request.getParameter("name") %>
- create Controller call as servlet with extending the HttpServlet
  - mention <%= request.getContextPath() %>/controller in action in form
  - in controller class
    - doGet method
    - doPost method
## Beans
- create User.java in source folder
- in jsp
  - <jsp:usebean id="user" class="org.student.User"><jsp:useBean>  
  - <jsp:getProperty property="first_name" name="user"/>
  - in usebean
    - add scope="application" or page request to maintain the session at diff way
## Session management
- create the session when the user enter username password correctly
- read and write cookie
- logout function for cookie
- add bootstrap template
- install mysql server
- create class for dbconfig
  - add connect dtring
  - then DriverManager.gerConnection()

- project
  - new maven project
    - apache.mavenwebapp2
  -  add mysql , jakarta servelt , jakarta jps dependency , hibernate orm , hibernate entoty manager
  -  update the maven project
```
--   controller
--  add notation for class
@WebServlet("/site") and extends extends HttpServlet


-- get
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page").toLowerCase();
		switch (page) {

		case "listusers":
			listusers(request, response);
			break;

		case "adduser":
			adduser(request, response);
			break;
		case "updateuser":
			updateuser(request, response);
			break;
			
		case "deleteuser":
			new UsersModel().deleteUser(Integer.parseInt(request.getParameter("user_id")));
			listusers(request, response);
			break;

		default:
			request.setAttribute("title", "Error page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}


-- post
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String form = request.getParameter("form").toLowerCase();
		switch (form) {

		case "adduseroperation":
			User user = new User(request.getParameter("username"), request.getParameter("email"));
			new UsersModel().addUser(user);
			listusers(request, response);
			break;

		case "updateuseroperation":
			User updated_user = new User(Integer.parseInt(request.getParameter("user_id")),
					request.getParameter("username"), request.getParameter("email"));
			new UsersModel().updateUser(updated_user);
			listusers(request, response);
			break;

		default:
			request.setAttribute("title", "Error page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;

		}
	}



```

  
