# IF else
password = input("Enter a new password: ")
if len(password) > 7:
    print("Great password there!")
elif len(password) ==7:
    print("Password is OK, but not too strong")
else:
    print("Your password is weak.")
# TO DO list
# TO DO list
to_do = []
while True:
    option = input("Type the option view add remove edit.. with respective data..")
    option_with_data = option.strip()
    print(option_with_data)

    if option_with_data.startswith("view"):
        with open("to_dos.txt","r") as f:
            all = f.readlines()
        for i,j in enumerate(all):
            print(i,j,sep=" : ")
            print(f"{i} : {j}")

    elif option_with_data.startswith("add"):
        with open("to_dos.txt","r") as f:
            all = f.readlines()
        temp = option_with_data[4:]
        all.append(temp+ "\n")
        with open("to_dos.txt","w") as ff:
            ff.writelines(all)
    elif option_with_data.startswith("remove"):
        with open("to_dos.txt","r") as f:
            all = f.readlines()
        temp = option_with_data[7:]
        print(all)
        all.remove(temp+"\n")
        with open("to_dos.txt","w") as ff:
            ff.writelines(all)
    elif option_with_data.startswith("edit"):
        with open("to_dos.txt","r") as f:
            all = f.readlines()
        print(all)
        id = all.index(option_with_data[5:]+"\n")
        temp = input("Enter the todo to edit:") + "\n"
        all[id] = temp
        with open("to_dos.txt","w") as ff:
            ff.writelines(all)
    elif "exit" in option_with_data:
        break

    else :
        print(option)
