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

# Advance java
1. Abstract method
   - declare the method but not the logic, later done the logic
2. inner class
   - nested class
   - create obj like A.B obj = new B();
3. Anonymous inner cls
   ```
      A obj = new A(){
         public void show(){
            sout(" In new show ");
         }
      }
      obj.show();
      
   ```
4. Annotation
   - @override to override and indicate in dup method
   - 
