# Python Basics
- use dir(a)
- use help(a.append)
- in list update
  - by list1[1] = 10
  - is consist of list1.__setitem__(1,10)
-  string are immutable but it is override using .replace(,,,)
-  use enumerate in for loop to get index
  ```py
            to_do = [10, 20, 30]
            for i,j in enumerate(to_do):   # this same like for i in [(0,10), (1,20), (2,30)]  # use zip(a,b) for custom index
                print(i,j,sep=" : ")

  ```
- storing the result to txt file
  - open connect to read the write  -- wriye data must be a string
  - use with open
