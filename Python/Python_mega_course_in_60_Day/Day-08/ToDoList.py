# with content manager
with open("bear.txt", "r") as file:
    content = file.read()

print(content)
print(len(content))
#
with open('file.txt', 'w') as file:
    file.write('snail')
#
languages = ['English', 'German', 'Spanish']

for x in languages:
    with open(f"{x}.txt", 'w') as file:
        file.write(x)

#
with open("story.txt", "r") as f1:
    data = f1.read()

with open("story_copy.txt", "w") as f2:
    f2.write(data)

#
# TO DO list
# TO DO list
to_do = []
while True:
    option = input("Type the option view add remove edit..")
    match option:
        case "view":
            with open("to_dos.txt","r") as f:
                all = f.readlines()
            for i,j in enumerate(all):
                print(i,j,sep=" : ")
                print(f"{i} : {j}")

        case "add":
            with open("to_dos.txt","r") as f:
                all = f.readlines()
            temp = input("Enter the new todo :")
            all.append(temp+ "\n")
            with open("to_dos.txt","w") as ff:
                ff.writelines(all)
        case "remove" :
            with open("to_dos.txt","r") as f:
                all = f.readlines()
            temp = input("Enter the todo to remove:")
            print(all)
            all.remove(temp+"\n")
            with open("to_dos.txt","w") as ff:
                ff.writelines(all)
        case "edit":
            with open("to_dos.txt","r") as f:
                all = f.readlines()
            id = int(input("Enter to dos id to edit"))
            temp = input("Enter the todo to edit:") + "\n"
            all[id] = temp
            with open("to_dos.txt","w") as ff:
                ff.writelines(all)
        case "exit":
            break

        case _:
            print(option)
