# Servers
- create Frontend in seperate server
- create java bankend server and serve data to both mobile app and web app
# Rest
- when client request the data the server give the current state(value ) for data like age 12
- that state is transfered so it called Representation state transfer(REST)
- use Noun (GET, POST..)
- JSON or XML
## http methods
- get to read data
- post to create data and also update
- put to update the data
- delete
## react UI
- run fake backend server
  - npm install -g json-server
  - json-server --watch db.json --port 8000  // backend is read
  - use axios.get('url'); get the data
  - in backend controler use @CrossOrigin(origins = "http:/localhoast:3000")
- run FRONTNEND server
  - npm install
  - view package.json in react
  - use axios url to fetch the data
## Post man
- instead of react to eacy the backend process
- use URI - uniform resource identy
- to send data as post method
  - change the method type
  - in body select the data type like raw , binary , jsaon
- PUT
  - change the method type
  - change the url
  - in bady page change the data
## Controller
- path variable to select a perticular data Use {} in
  ```
  @GetMapping("jobPost/{postId}")
  publick jobPost getJob(@PAthVariable("postId") int postId){
    return service.getJob(postId);
  ```
- requestbody for post method
    ```
    @PostMapping('kjgjh")
    public void addjob(@RequestBody jobPOst jobPOst){
      return service.addJob(postId);
    }
    ```
- Content Negotiation - USE jackson package to convert the list of data into a json are xml are other else
  - add dependency in pom.xml
  - then in postman i header add key as Accep and value as application/xml
  - iin controller to restrict the data output use use path="jobPost", produces =("appication/json"} in @GetMapping()
### Repo
```

@Repository
public class JobRepo {

	// arrayList to store store JobPost objects
	List<JobPost> jobs = new ArrayList<>();

	// ****************************************************************************

	// constructor->injecting objects into ArrayList defined above.
	public JobRepo() {

		// Java Developer Job Post
		jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
				List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

		// Frontend Developer Job Post
		jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
				3, List.of("HTML", "CSS", "JavaScript", "React")));

		// Data Scientist Job Post
		jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
				List.of("Python", "Machine Learning", "Data Analysis")));

		// Network Engineer Job Post
		jobs.add(new JobPost(4, "Network Engineer",
				"Design and implement computer networks for efficient data communication", 5,
				List.of("Networking", "Cisco", "Routing", "Switching")));

		// Mobile App Developer Job Post
		jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
				List.of("iOS Development", "Android Development", "Mobile App")));

	}

	
	
	
	// method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return jobs;
	}

	
	
	// method to save a job post object into arrayList
	public void addJob(JobPost job) {
		jobs.add(job);

	}

	
	
	
	//method to get a job by postId
	public JobPost getJob(int postId) {
		for (JobPost job : jobs) {
			if (job.getPostId() == postId) {
				return job;
			}
		}

		return null;
	}




	public void updateJob(JobPost jobPost) {
		for (JobPost jobPost1 : jobs) {
			if (jobPost1.getPostId() == jobPost.getPostId()) {
				
				jobPost1.setPostProfile(jobPost.getPostProfile());
				jobPost1.setPostDesc(jobPost.getPostDesc());
				jobPost1.setReqExperience(jobPost.getReqExperience());
				jobPost.setPostTechStack(jobPost.getPostTechStack());
				
			}
		}

		
	}




	public void deleteJob(int postId) {
		for (JobPost jobPost : jobs) {
			if (jobPost.getPostId() == postId) {
				jobs.remove(jobPost);
				
			}
		}

		
		
	}

}
```
###
```

@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return repo.getAllJobs();

		
	}
	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public void addJob(JobPost jobPost) {
		 repo.addJob(jobPost);
	
	}





	public JobPost getJob(int postId) {
		
		return repo.getJob(postId);
	}





	public void updateJob(JobPost jobPost) {
	repo.updateJob(jobPost);
		
	}





	public void deleteJob(int postId) {
		repo.deleteJob(postId);
		
	}

	
}
```
### model
```
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {


	private int postId;
	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	private List<String> postTechStack;
	

}
```
### Controller
```

@RestController	
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
		
	}
	
	@GetMapping("/jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}

	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	
	
}
```

# Sprin Data JPA - Java Persistence API
- you can write a code in jpa and then swith to any dm managing tools like hibernate to avoid the recoding the lot of code when you swith to another tools
- standard Java specification for managing relational data in Java applications
- facilitating object-relational mapping (ORM) and simplifying database interactions. It allows developers to map Java objects to database tables in a standard
