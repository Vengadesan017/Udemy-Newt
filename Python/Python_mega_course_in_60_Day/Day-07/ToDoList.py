# List comprehension
names = ["john smith", "jay santi", "eva kuki"]
print([x.title() for x in names if True])

usernames = ["john 1990", "alberta1970", "magnola2000"]
print([len(x) for x in usernames])

user_entries = ['10', '19.1', '20']
print([float(x) for x in user_entries])

numbers = [10, 20, 30]
print([x*2 for x in numbers])

user_entries = ['10', '19.1', '20']
total_sum = sum(float(number) for number in user_entries)
print(total_sum)


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





