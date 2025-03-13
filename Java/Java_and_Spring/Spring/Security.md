# Security is must
- top ten OWASP security risk
### project
1. add dependemcy spring Web, Spring Security, Spring Boot Devtool
2. create controller
3. use default login form is from Spring Security
   - default username : user
   - password is shown in terminal
   - see the another filter inbelow to password ( filter chain - between servlet container and servlet
   - session id
     - in inspectin network in request in header can see the session id
     - to print seesion id from server
       ```
        public String home(HttpServletRequest req)
         {
           return request.getSession().getId();
       }
     - SETTING username and password
       - in application.properties add apring.security.user.name=vengat && .password=123456
     - IN postman
       - in authorization tab select basic Auth type
     - CSRF
       - csrf is implement for put post delete but not for get
       - so postman work with get not with others
       - get csrf token gor post, put, ..
       ```
       -- controller
      	List<Student> students=new ArrayList<>(List.of(
      			new Student(1,"Navin","Java"),
      			new Student(2,"Kiran","Blockchain")
      			));
      	
      	@GetMapping("csrf-token")
      	public CsrfToken getCsrfToken(HttpServletRequest request) {
      		return (CsrfToken) request.getAttribute("_csrf");
      	}
      	
      	
      	
      	
      	
      	@GetMapping("students")
      	public List<Student> getStudents(){
      		return students;
      	}
      	@PostMapping("students")
      	public void addStudent(@RequestBody Student student) {
      		students.add(student);
      	}

       -- inpost man
        in header add key accept : application?json and X-CSRF-TOKEN :  paste from get method
       ```
       - set property to restrict the cross csrf request
         - server.serlet.session.cookie.same-site=strict
4. Statefull vs stateless rest api
     - statefull api maintain the session 
     - stateless api do not maintain the session
5. Security Configuration
   - create config package
   - in this create SecurityFilterChain with HttpSecurity to manage the security of server
     - disble CSRF and Auth and session as stateless
     ```
      @Configuration
      @EnableWebSecurity
      public class SecurityConfig {
      
      	@Bean
      	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      		
      		http.csrf(customizer->customizer.disable());
      		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
      		http.httpBasic(Customizer.withDefaults());
      		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
      		
      		return http.build();
      	}
      }

     -- same in with out lanbda
		
		   Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new
		   Customizer<CsrfConfigurer<HttpSecurity>>() {
		   
		   @Override public void customize(CsrfConfigurer<HttpSecurity> configurer) {
		   
		   configurer.disable(); } };
		   
		   Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		   AuthorizationManagerRequestMatcherRegistry> custHttp = new
		   Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		   AuthorizationManagerRequestMatcherRegistry>() {
		   
		   @Override public void customize(
		   AuthorizeHttpRequestsConfigurer<HttpSecurity>.
		   AuthorizationManagerRequestMatcherRegistry registry) {
		   registry.anyRequest().authenticated();
		   
		   } };
		   
		   http.authorizeHttpRequests(custHttp); http.csrf(custCsrf);
		 
     ```
6. Users from Database
     1. Define your own UserDetailService ( hard coded users )
     ```
    		@Bean
    		public UserDetailsService userDetailsService() {
    			
    			UserDetails user=User
    					.withDefaultPasswordEncoder()
    					.username("navin")
    					.password("n@123")
    					.roles("USER")
    					.build();
    			
    			UserDetails  admin=User
    					.withDefaultPasswordEncoder()
    					.username("admin")
    					.password("admin@789")
    					.roles("ADMIN")
    					.build();
    			
    			return new InMemoryUserDetailsManager(user,admin);
		  }
     ```
     2. create table
     3. create Auth provider like DAO - Data Access Object
     ```

    	@Autowired
    	private UserDetailsService userDetailsService;
    	
    	@Bean
    	public AuthenticationProvider authProvider() {
    		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    		provider.setUserDetailsService(userDetailsService);
    		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    		return provider;
    	}
     ```
     4. paste the obj of your model in auth provider
     5. create repo in dao package and service for user details
     6. create UserPrincipal(notify about account) in model package and pass obj to service
     7. hash the password
        - algorithm
          - MD5
          - SHA256 - easy to generate
          - Bcrypt - hard to hack - repeated encrpting based on rounds
        - Create obj for BCryptPasswordEncoder with round and version
        - in service change the passsword value by calling SetPassword with obj.encod(get)
     8. Verify the hashed password for login
        - change the setPasswordEncoder with obj of BcryptPasswordEncoder in security config file
8. Security in project
   - Cross origin
   - add dependence of sring security
     - login
     - create package fo config
