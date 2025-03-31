# Java full stack
- java + JSP & servlet + hibernate + spring + RESTful + JS + React
- go studyeasy.org to get 6 months free in intellji any but one product for 6 months

## Java
- Composite
  - use class name as data type of var
- interface
  - abstract method
- types of nexted class
  - static
  - non static
- non static inner class
  - class a contain the class b
  - in main class
  - create obj in A then return the obj to class
  - call by main_obj.A_obj_return_method().B_methods()
- static inner class
  - class a contain the class b as static class
  - in main class
  - create obj in A 
  - call by main_obj.B_class_name.B_methods()
- Anonymous obj
  - not save in var directly use
- Scanner
  - Scanner scan = new Scanner(System.in)
  - scan.nextLine() ... next()...
  - scanner.close()
- static variable
  - when var is created as static
  - then the value is common for all the obj is not vari
- static
 - Static members are shared across all instances of the class.
 - Static methods cannot access non-static variables or methods (i.e., instance variables/methods).
 - Static blocks are executed only once when the class is loaded into memory
- final
 -  Final Variables- Once assigned, the value cannot be changed
 - Final Methods- Cannot be overridden by subclasses
 - Final Classes - Cannot be inherited by other classes
- package
  - can also use package_name.class_name instyead of class_name obj = new
- Scope
  - Local Scope
  - Instance Scope
  - Class (Static) Scope
  - Block Scope (Within loops, if statements,
- Access Specifiers
  - public
    - variable, method, or class is accessible from any other class, both within the same package and outside the package
  - protected
    - accessible within the same package and by subclasses (even if they are in different packages)
  - private
    - accessible only within the class in which it is declared
  - default (no modifier)
    - accessible only within the same package
- Access Modifiers
  - Static
  - Final
  - Abstract
- String handling
  - functions
    - str_var.length()
    - .charAt(1)
    - .substring(2)
    - .toUpperCase()
    - .equals(srt2)
    - .....
  - literal string and striing obj
- Exceptions
 - try block
   - This is where you place code that might throw an exception.
 - catch block
   - This is where you handle the exception if one is thrown.
 - finally block
   - This is an optional block that will always execute whether an exception is thrown or not (used for cleanup activities like closing resources).
 - throw keyword
   - Used to explicitly throw an exception.
 - throws keyword
   - Used to declare exceptions that a method may throw
 - CHecked Exception
   - checked at compile-time by the Java compiler
   - handle by try- catch or throws
 - un Checked Exceptions
   - not checked at compile-time by the Java compile
   - like NullPointerException, ArrayIndexOutOfBoundsException
  ```java
      try {
          
      } catch (NullPointerException  e1) {
     
      } catch (ArithmeticException  e2) {
         
      } 
      } catch (Exception  e2) {
         
      } finally {
          
            }


      if () {
        throw new OurOwnException("Our Own msg");
       }
  ```
- printf formating
  - System.out.printf("%5d", 42);  // Outputs: "   42" (padded with 3 spaces)
  - ystem.out.printf("%.2f", 3.14159);
- Enum
  - to set a predefined constants
```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
main(){
        for (Day day : Day.values()) {
            System.out.println(day);
        }
}

```
- Array
    - int[] numbers = {1, 2, 3, 4, 5};
    - int[] numbers; number = new int[5];
  - Mutidimentional array
    - int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
  - array copy
    - int[] num_copy =  new int[5]; System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length
  - Array of obj
    -  Student[] students = {new Student("Alice", 20),new Student("Bob", 22),new Student("Ch
  - call by value
    - passing the value in function call only if you pass the non iterative obj
  - call by reference
    - passing the iterative obj like names

- Collections 
  - list - ordered collection (also known as a sequence). Lists can contain duplicate elements
  - set - does not allow duplicate elements
  - queue - FIFO order
  - map - key-value pair
```java
import java.util.ArrayList;
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");
list.get(0)
```

    
