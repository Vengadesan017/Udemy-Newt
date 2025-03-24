# handling the files
file = open("bear.txt",'r')
print(file.readlines())
print("==============")
file = open("essay.txt",'r')
content = file.read()
for i in content.split(" "):
    print(i.capitalize(), end=" ")
print()
print("The file contains ",len(content)," characters.")
file.close()

# wrirte
with open('file.txt', 'w') as file:
    file.write('snail')

# zip
countries = ["Albania", "Belgium", "Canada", "Denmark", "Ethiopia", "France"]
filenames = ['a.txt', 'b.txt', 'c.txt', 'd.txt', 'e.txt', 'f.txt']

for f_name, f_data in zip(filenames,countries):
    print(f_name,f_data)
    with open(f_name,"w") as file:
        file.write(f_data)
for i in countries:
    with open(f"{i}.txt","w") as f:
        print(i,f)
        f.write(i)
# use strip('\n\) to remove the \n
# TO DO list
to_do = []
while True:
    option = input("Type the option view add remove edit..")
    match option:
        case "view":
            for i,j in enumerate(to_do):
                print(i,j,sep=" : ")
                print(f"{i} : {j}")

        case "add":
            temp = input("Enter the new todo :")
            to_do.append(temp)
        case "remove" :
            temp = input("Enter the todo to remove:")
            to_do.remove(temp)
        case "edit":
            id = int(input("Enter to dos id to edit"))
            temp = input("Enter the todo to edit:")
            to_do[id] = temp
        case "exit":
            break

        case _:
            print(option)





