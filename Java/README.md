# Java Basics
1. download jdk from oralce
2. install
3. adda env path
4. check java -version
5. and javac -version
6. JDK > JRE > JVM
7. JVM
   - Stack memory
      - stack memory for each method
      - for main

         | obj | 101 |
         |  b  |  20 |
         |  a  | 10  |

      - for add
      
         |     |     |
         |  y  |  20 |
         |  x  | 10  |
     
   - Heap memory
     - store the instance memory ( class varianble)
     - store also the object
     -  101 is address this heap which is stored in main stack
     -  num is class variable\
       
| num = 5 | 
|----------|
| add() |

8. import java.lang.*  // default and system from the paackage
9. package com.google.package  -- is reverse of domain google.com to make the package globally unique avoid collision
10. in com.google the com is parent dir and google is sub parent dir
11. access modifier
    - public - use from any where in package it outside the package need to import the package
    - private - use within the class
    - default - private&productor - use inse the package
    - protected - use inside the package and can not use out side the package but need to extends
12. Dynamic method dispatch
    - parent_class obj = new child_class() - create object for child in parent type    
    - obj = new child_class2() -- update the object with new cls
13. final
    - variable - value is not be change
    - class - not be inherit
    - method - not be override
14. object class = tostring(hashcode())
  - sout(obj) return classname@43112212 --- 4311123 is hashcode of object
  - by default sout(obj) is conceder as sout(obt,toString())  -- we can able to create own toString function
  - from source action create toString, hashcode,equals()
15. Type casting
    - par_cls obj1 = (child_cls) new child_cls();      -- upcasting
    - child_cls onj2 = (child_cls) obj1;      -- low casting

16. Wrapper class
    - int num1 = 5
    - Integer num2 = new Integer(num) -- boxing  -- storing int(primitive type) in integer object
    - Integer num2 = 5 -- auto boxing  -- no warning
    - int num3 = num1.intValue();     -- unboxing
    - String str = "12";
    - int num4 = integer.parseInt(str);
    - sout(num4*4);

# Advance Java
0. Abstract
   - declare function but define later when need
   - obj is not createble for abstract class need to inherit
2. inner class
   - nested class A > B
   - create obj like A.B obj = new B();
3. Anonymous inner class
   - no declaration only define
     ```
     A obj = new A(){
      public void show(){
         sout("in show");
      }
     }
     obj.show();   -- obj is obj of anonymous cls
4. interface
   - all methods are public abstract method by default
   - use implements instead of extends  ( implement only the methods)
   - interface variable are final and static
   - usage
     - class - class -> extends
     - class - interface -> Implements
     - interface - interface -> extends
   - needs
     - when same method with differnt logic for different class is need then create interface wit abstract method and override in your classes
     - like code abs method in computer interface then override the code method in laptop desktop mobile class.
   - Types
     - normal - contain two or more method
     - functional ( sam - single abstract method) single method
     - marker - no methods - used as serializer
       - serialization - save the data(a=123,b=1212) from heap to disk when the game closed gp to km
       - deserialization - load the data(a=123,b=1212) from dist to heap when the game reopen kb to gp
     - Functional interface - only one method
       ```
       @FunctionalInterface
       interface A{
          void show();
       }
       class B implements A{    --instead of creating obj to B and implements A create Anonymous class 
         p v show(){...}
       }
       main{
        A obj = new A()
       {
            public void show(){
               sout();
            }
       };obj.show()
       ```
5. Enums
   ```
      enum Nums{   --- act like class nit able to extends   
   	one, Two, Three;     --- act like object but is is also a named constand
      }

   	Nums s= Nums.Two;
   	System.out.println(s);    // constand variable value
   	System.out.println(s.ordinal());   // index value
    	
    	Nums[] ss=Nums.values();
    	System.out.println(ss);
    	
    	for(Nums e:ss)
    	{
    		System.out.println(e+" : "+e.ordinal());
    	}
   ```
6. Annotation
   - meta data about the programm like @ override
7. Functional interface - only one method
 ```
 @FunctionalInterface
 interface A{
    void show();
 }
 class B implements A{    --instead of creating obj to B and implements A create Anonymous class 
   p v show(){...}
 }
 main{
  A obj = new A()
 {
      public void show(){
         sout();
      }
 };obj.show();
 ```
8. Lamda Expression
   - in Functional interface in anonymous class implement shorthands
```
 main{
  A obj = () -> {
         sout();
 };obj.show();

 main{
  A obj = () -> sout();
  obj.show();
-- parameter
 main{
  A obj = (int i) -> sout(i);
  obj.show(5);
-- return
 main{
  A obj = (int i) -> i*10;
  obj.show();
```
9. Exceptions
    - Compile time error (checked)
    - runtime error (unchecked)
    - logical error
    - states
      - normal state i = 10;
      - critical state j = 50/i;
    - hierarchy
      - Object
        - Throwable ( interface) most of interface end with ..able
          - error
            - I.O error
            - thread death
            - out of memory
            - virtual machine
          - Exception
            - runtimeexception ( unchecked)
               - arithematic
               - nullpointer            
            - SQL Exception (Checked)  must to handly - it your job to handle the exception
               - IO exception 
    - keywords
      - try - throw the error
      - catch - catch the error which is throwen by try bloc
      - throw - manually throw the error/exception 
      - throw - manually throw the error/exception your own exception too
      - throws 
        - not like in try block you just mention the exception in function whos call the code whhich contain the checked error.
        - instean of running code inside the try you forward the responsibelity to upper function
        - public void show() throws ClassNotFoundException
      - Finally  it is default block , which run always if error occured or not. mostly used to close the obj od io files resouce

10. input and Bufferedreader and scanner
   - system.in.read() - used to read the int but one char and return as ascii code and also handle checked error
   - BufferReader but it need InputStreamReader obj but it need System.in obj, can also use without catch block to close the resource
     ```
    	InputStreamReader in=new InputStreamReader(System.in);
    	BufferedReader bf=new BufferedReader(in);
    	
    	int num=Integer.parseInt(bf.readLine());
    	System.out.println(num);
      bf.close();   best pratice to close
     ```
   - Scanner nee System.in object
     ```
    	Scanner sc=new Scanner(System.in);
    	int num=sc.nextInt();
    	System.out.println(num);
     ```

11. try with resources
   ```
      -- manual close
      BufferedReader bf = null
      try{
    	BufferedReader bf=new BufferedReader(InputStreamReader(System.in));
    	
    	int num=Integer.parseInt(bf.readLine());
    	System.out.println(num);
         }
         finally{
            bf.close();
         }
      -- Auto close
      try(BufferedReader bf=new BufferedReader(InputStreamReader(System.in));){
    	BufferedReader bf=new BufferedReader(InputStreamReader(System.in));
    	
    	int num=Integer.parseInt(bf.readLine());
    	System.out.println(num);
         }
   ```
12. threads
    - each process had multiple thread
    - each process had multiple thread
    - extend thread class or implement runnable interface
    ```
      class A extend Thread{
          public void run(){for}}
      class B extend Thread{
          public void run(){for}}
      class C{
          A obj.start()
          B obj.start()   Randomly run the both function   
      
    ```
13. Thread priority sleep
```
      class A extends Thread
      {
      	public void run()
      	{
      		for(int i=1;i<=100;i++)
      		{
      			System.out.println("Hi");
      			try {
      				Thread.sleep(10);
      			}catch(InterruptedException e) {
      				e.printStackTrace();
      			}
      		}
      	}
      }


      class B extends Thread
      {
      	public void run()
      	{
      		for(int i=1;i<=100;i++)
      		{
      			System.out.println("Hello");
      			try {
      				Thread.sleep(10);
      			}catch(InterruptedException e) {
      				e.printStackTrace();
      			}
      		}
      	}
      }

public class Demo {
    public static void main(String[] args) throws NumberFormatException {   
    	
    	A obj1=new A();
    	B obj2=new B();
    	
    	obj2.setPriority(Thread.MAX_PRIORITY);   // min max normal
    	System.out.println(obj1.getPriority());
    	
    	obj1.start();
    	try {
			Thread.sleep(2);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
    	obj2.start();
    }
    
}
```
14. Runnable 
```
      class A implements Runnable{
          public void run(){for}}
      class B implements Runnable{
          public void run(){for}}
      class C{
    	Runnable obj1=new A();
    	Runnable obj2=new B();

    	Thread t1=new Thread(obj1);
    	Thread t2=new Thread(obj2);
 ```
15. Lambda Expression
```
 	-- anonymous
	//      class A implements Runnable{
	//          public void run(){for}}
      class B implements Runnable{
          public void run(){for}}
      class C{
    	Runnable obj1=new A();
    	Runnable obj2=new B();

    	Thread t1=new Runnable(){
    		 public void run(){for}
       };	
    	Thread t2=new Thread(obj2);

     
	//      class A implements Runnable{
	//          public void run(){for}}
	//      class B implements Runnable{
	//          public void run(){for}}
      class C{
    	Runnable obj1=new A();
    	Runnable obj2=new B();

    	Thread t1=() -> {
    		 public void run(){for}
       };	
    	Thread t2=() -> {
    		 public void run(){for}
       };
  ```
16. Race condition
    - 2 threads use same resouce for read and write
    - so use obj.join() to wait for execute the both thread and then execute the main
    - then use synchronized in resource to avoid the race condition

17. Tread states
    - new  
    - runnable  - when start() is call (new to runnable)
    - running   - run()
    - waiting   - sleep(),wait() ( running to waiting) , notify() ( waiting to runnable )
    - dead       - stop()   (running,runnable to dead)
    
          
18. Collection *
    - to store multiple value in dissimilar datatype
    - object type and generic type
    - collection(interface)
      - List
         - Arraylist *
         - LinkedList
      - Queue
         - Dequeue        
      - Set ( no duilicates )
         - Hashset *
         - Linked Hashset
    - Sorting
      - buildin
        ```
		Collections.sort(nums);
		System.out.println(nums);
        ```
      - Comparator
        ```
    	Comparator<Integer> com=new Comparator<Integer>()   // our logic for sorting
    	{
    		public int compare(Integer i,Integer j)
    		{
    			if(i%10 >j%10)
    				return 1;
    			else
    				return -1;
    		}
    	};
		Collections.sort(nums,com);   it sent 2 2 vaules 
		System.out.println(nums);        
        ```
      - Comparable - implement comparable interface for our class objects to sort in custom logic      
19. iterating
```

    	List<Integer> nums= Arrays.asList(4,5,7,3,2,6);
	nums.forEach(n -> System.out.println(n));
	-- or
    	for(int i=0;i<nums.size();i++)
    	{
    		System.out.println(nums.get(i));
    	}
	 -- or 
    	for(int n: nums)
    	{
    		System.out.println(n);
    	}
    	System.out.println(nums);
	-- or
    	nums.forEach(n -> System.out.println(n));
    	
    	
    	int sum=0;
    	for(int n:nums)
    	{
    		if(n%2==0)
    		{
    			n=n*2;
    			sum=sum+n;
    		}
    	}
    	
    	System.out.println(sum);
  
```
20. Stream API
    - iterate only once

           
           
