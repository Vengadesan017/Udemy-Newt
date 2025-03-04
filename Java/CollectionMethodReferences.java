import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student{
	private String name;
	private int age;
	public Student(String nam) {
		this.name = nam;
		//TODO Auto-generated constructor stub
		}
	public Student() {
		//TODO Auto-generated constructor stub
		}
	}
	public class CollectionMethodReferences {
		public static void main(String[] args) {
			List<String> names=Arrays.asList("dfsd","john", "Segar");
			// List<String> upName = names.Stream().map(String::toUpperCase).toList();
			// System.out.println(names);
	
			names.forEach(System.out::println);    // method referencer
	
			
			List<Student> students= new ArrayList<>();
			// for ( String nam : names){
			// 	students.add(new Student(nam));
			// }
			students = names.stream().map(Student::new).toList();
			System.out.println(students);
	
	}
}
