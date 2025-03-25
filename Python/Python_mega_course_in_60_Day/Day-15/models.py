import glob

myfile = glob.glob("*.txt")
print(myfile)
print(glob.glob("*.py"))   # list of files
print(glob.glob("./../Day-14/*.py"))

import csv

with open("myfile.csv","r") as file :
    print(list(csv.reader(file)))


import shutil
#  to make a zip file

shutil.make_archive("Create_zip_file","zip","vv")

import webbrowser

webbrowser.open("google.com")
webbrowser.open("google.com/search?q=",myfile)


#  Json List of dictionary's
import json

with open("hello.json","r") as f:
    data = f.read()

print(json.loads(data))
print(type(json.loads(data)))
