# Exceptions

try:
    total_value = float(input("Enter total value: "))
    value = float(input("Enter value: "))

    percentage = value / total_value * 100
    print(f"That is {percentage}%")
except ZeroDivisionError:
    print("Your total value cannot be zero.")
except:
    print("You need to enter a number. Run the program again.")
#
colors = [11, 34, 98, 43, 45, 54, 54]
for i in colors:
    if i > 50 :
        print(i)
#
filenames = ["report.txt", "downloads.txt", "success.txt", "folders.txt"]
for i in filenames:
    print(i[:-4].capitalize())

# TO DO list
to_do = []
while True:
    try:
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
    except Exception:
        print("Invalid action and the error ids :: ", Exception)