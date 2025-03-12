# Hiring project
- go start spring add spring web , lombok ( for annotation)
- in jsp for for loop <c: forEach var="jobPost" items="${jobposts}"> ${jobPost},${jobPost.title}</c:forEach>
- in model class not need to create the gettter and setter and constructor in file instead use lombok
  ```
  // model
   @Data // for getter and setter
   @NoArgsConstructor    // for constructor
   @AllArgsConstructor    // for constructor
  @Component
  public class JobPost {
  
  
  	private int postId;
  	private String postProfile; 
  	private String postDesc;
  	private Integer reqExperience;
  	private List<String> postTechStack;
  	
  
  }
  ```
- jsp files
  ```
  // add jobs
  <%@ page language="java" contentType="text/html; charset=UTF-8"
  		 pageEncoding="UTF-8"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
					<form action="handleForm" method="post">
						<div class="mb-1">
							<label for="postId" class="form-label">Post ID</label>
							<input type="text" class="form-control" id="postId"
								   name="postId" required>
						</div>

						<div class="mb-1">
							<label for="postProfile" class="form-label">Post Profile</label>
							<input type="text" class="form-control" id="postProfile" name="postProfile" required>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

  
  // to view all
  <%@ page language="java" contentType="text/html; charset=UTF-8"
           pageEncoding="UTF-8" isELIgnored="false"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:forEach var="jobPost" items="${jobPosts}">

            <div class="col mb-4">
                <div class="card border-dark bg-dark text-white">
                    <div class="card-body">
                        <h5 class="card-title">${jobPost.postProfile}</h5>
          </c:forEach>

  //Success page
  <%
      JobPost myJobPost = (JobPost) request.getAttribute("jobPost");
  %>
  
  
  <div class="container mt-5">
      <h2 class="mb-4 text-center font-weight-bold">Job Post Details</h2>
      <div class="row justify-content-center">
          <div class="col-md-6">
              <div class="card border-dark bg-dark text-white">
                  <div class="card-body">
                      <h5 class="card-title"><%= myJobPost.getPostProfile() %></h5>
                      <p class="card-text">
                          <strong>Description:</strong>
                          <%= myJobPost.getPostDesc() %>
                      </p>
                      <p class="card-text">
                          <strong>Experience Required:</strong>
                          <%= myJobPost.getReqExperience() %> years
                      </p>
                      <p class="card-text">
                          <strong>Tech Stack:</strong>
                      <ul>
                          <% for (String tech : myJobPost.getPostTechStack()) { %>
                          <li><%= tech %></li>
                          <% } %>
                      </ul>
                      </p>
                  </div>
                  <div class="card-footer">
                      <!-- Optional footer content -->
                  </div>
              </div>
          </div>
      </div>
  </div>

  ```
- use @PoastMapping("namee") or @GetMapping("namee") or @RequestMapping("namee", POST) for post form  submission
- use @ResponseBogy to retuen the data as api call by return service.getAllJobs();
  ```
  @Controller
  public class JobController {
  
      @Autowired
      private JobService service;
  
  
      @GetMapping({"/", "home"})
      public String home() {
          return "home";                // it is a view name    
      }                                  // use @ResponseBogy to retuen the data as api call by return service.getAllJobs();
  
  
      @GetMapping("addjob")
      public String addJob() {
          return "addjob";
      }
  
  
      @PostMapping("handleForm")
      public String handleForm(JobPost jobPost) {
          service.addJob(jobPost);
          return "success";
  
      }
  
      @GetMapping("viewalljobs")
      public String viewJobs(Model m) {
          List<JobPost> jobs = service.getAllJobs();
          m.addAttribute("jobPosts", jobs);
  
          return "viewalljobs";
      }
  
  }
  ```
- use service to store in array not now in db
  ```
  @Service
  public class JobService {
      @Autowired
      public JobRepo repo;
      // method to add a jobPost
      public void addJob(JobPost jobPost) {
          repo.addJob(jobPost);
  
      }
      //method to return all JobPosts
      public List<JobPost> getAllJobs() {
          return repo.getAllJobs();
      }
  }
  ```
  - repo to upgrade to db jus change this classes only
    ```
    
    @Repository
    public class JobRepo {
    
    
        // ArrayList to store JobPost objects
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
    
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
    
    
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
    
    
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
    
    
                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
    
    
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));
    
        // method to return all JobPosts
        public List<JobPost> getAllJobs() {
            return jobs;
        }
    
        // method to save a job post object into arrayList
        public void addJob(JobPost job) {
            jobs.add(job);
            System.out.println(jobs);
    
        }
    
    
    }
    ```
  - DTO -Data transfer Object ( repo - service - controller )
  - use model in controller to send data to view

# Spring REST API 
1. start spring io > spring web , lombok , postgreeSQL driver
2. create hello world to post man from Controller
   - create HelloCOntroller.java
   - mention as @RestController
     - mention @GetMapping("/hello")
   - create productController.java  ( move this 2 contoller to controller package )
   - mention as @RestController and @RequestMapping("/api")
     - mention @GetMapping("/api/products")
   - chnage the return type fo controller when is need to return the list of rows from db as List<Produc>
3. Create model package
   - inside create product class and mention as @Entity @Data @NoArgContructor @AllArgsConstructor
   - add dependancy for data-jpa
   - in that class create column as attribute
   - in resource in appplication.properties config the postgreSQL
4. create service package
   - create ProductService class and create obj by @Autowire for this in controller
   - in this create obj for repo and Autowiried
   - with this obj call findall() inside the getAllproducts
5. create repo package
   - inthis create the productRepo interface which implements the JpaRepository<Product , Integer>    -- jpaRepo is typeed pass the type of model with pk type
6. Load data and run react then add crossOrigin to api controller
