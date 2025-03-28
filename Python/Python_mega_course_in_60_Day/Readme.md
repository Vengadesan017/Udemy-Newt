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
- https://openweathermap.org/
  for wheather forecasting
- Jupitor lap for data mangement
  - pip install jupyter
  - open folder in terminal
    - jupyter-lab
    - python3 -m pip install pandas
    - python3 -m pip install matplotlib
    ```
    import os
    os.getcwd()
    import pandas as pd
    df = pd.read_csv("TG_STAID000001.txt", skiprows=20, parse_dates=["    DATE"])
    df[:20]
    df.columns
    df['   TG'].mean()  # container the non data -as -9999
    df.loc[df['   TG'] != -9999]['   TG'].mean() /10
    df.loc[df['   TG'] != -9999]['   TG'].max() /10
    df.loc[df['   TG'] != -9999]['   TG'].hist()

    -- for RE * 
    open a text file and read() as book
    book.count("Capter")
    import re
    pattern = re.compile("Chapter [1-9]+")   # + include 11
    re.findall(patter, book)
    
    --  for love txt
    pattern = re.compile("[a-zA-Z]* love [a-zA-Z]*")    * include More then one char
    pattern = re.compile("[a-zA-Z ,:,]* love [a-zA-Z]*")    
    pattern = re.compile("[^.]* love [a-zA-Z]*")    ^. all except .
    pattern = re.compile("[A-z]{1}[^.]* love [a-zA-Z]*")    must start with capital at once in startting
    re.findall(pattern, book)

    -- comman words
    pattern = re.compile("[a-zA-Z]+")  
    re.findall(pattern, book)
    d = {}
    for words in result:
      if word in d.key():
          d[worf] += 1\
      else:
          d[word] = 1

    -- NPL
    --- use import nltk for stopword
    --- use from nltk.sentiment import SentimentIntensityAnalyzer for positivie and negative chapter
    ```
    - select tag press a them m for markdown code
- Email web cam object
  - use cv2 to image as array from opencv-python pip
  - detecting obj
    - capture rgb image
    - convert to
      - gray
      - blue
    - compare
      - current frame to the first frame
    - covert to back and white image for rectangle box ( contouring) by Threshold
    - appending the rectangle array into the frame
  - send mail
    - after the obj detection compare the oject entry and exit in list
    - Create thread to send the mail to avoid the frame waiting
- web Scraping
  - automatic method to obtain large amounts of data from websites
  - from http://programmer100.pythonanywhere.com/tours/
    - request the html data with url and heder
    - then extract the data using yaml file
- sql lite
  - db browser for sqlite  - download
  - create db table
  - import sqlite
  - create conntection
  - create cursor with connection
  - execute query using cursor 

- OOPs
  - when to use
    - appication become bigger and had futher enhancement
  - class variable vs instance variable
  - methods
    - instance methos func(self)
    - class method  func(cls) and metion as @classmethod
      - use claa name or obj name to call
    - @property like getter in java used to get the processed data like cls_obj.pro_metho_name
    - @Staticmethod do not had any reference
    - magic method like a == b is a.__eq__(b)
   

- Desktop application using pyQT6
- Web automation tool with Selenium
  - download the chrome driver for windows https://googlechromelabs.github.io/chrome-for-testing/
  - pip install selenium
  - auto form submission for demoqa.com
- Flask
- Django
  - **Jinja** is a web template engine for the Python programming language
    - like {{ }} {% %}
    - and also for item_list not need to create the variable the django create is for Item model
      - but also need to mention the query set and super() of get content data in view class
        ```py
          -- view  this is django generic view concept not a jinja
          class MenuList(generic.ListView):
              queryset = {}
              # queryset = Item.objects.order_by("-date_created")
              template_name = "index.html"
          
              def get_context_data(self, **kwargs):
                  # context = {}
                  context = super().get_context_data(**kwargs)
                  context["meals"] = MEAL_TYPE
          
                  return context

            -- template
                        {% for row in item_list %}
        ```
- Recommendation system
   - type
     - popular things no user data neeeded
     - similar things based on your data
     - ..
   - use deep notes cloud based like google code lab
