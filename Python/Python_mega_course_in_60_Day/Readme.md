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
- in Standard models , learn this 
  - csv
  - glob ( unix shell style pathname
  - webbrowser ( easy to use controller )
  - shutil  ( high level file operation

- git
  - user .gitignore file to add the env file and unwanted files to add in git
  - to revert from the commit
    - click the git then the commit msg then right click then git checkout or revort
- Annotation
  - funtion funtion_name
  - types TypesName
- GUI
  - pip install FreeSimpleGui or install in setting > Project interpreter
- streamlit
  - for simple web app in easy steps
  - streamlit run web.py
  - deploy
    - create as standalone
    - pip freeze > requirements.txt
    - pip freeze
    - create new repo in github
      - push the code
    - deploy this app option in web output
      - gir githup repo details
- Follow pep standard
  - 4 space for tap space
  - wrap the text in line if more the 72 that line (hard wrap)
  - use space before and after the =
  - use after space for commo
  - add documentation
  - Camel for class name
  - snake foe function
- Zen of python (PEP 20)
- debug in pycharm
  - make red check mark at left side
  - start debug
    - use console and thread and variable to see the value of var
    - use moments
      - step over
      - step into
      - step into my code
      - step out
- Pythonanywhere.com
  - to host run py in cloud
