# Functions with arguments
print("wDere".isdigit())

#
def strength(password):
    if len(password) >= 8:
        for i in password:
            if i.isupper():
                for j in password:
                    if j.isdigit():
                        return "Strong Password"

    return "Weak Password"
#
def foo(person):
    return f"Hi {person}"
#
def get_max():
    grades = [9.6, 9.2, 9.7]
    # return max(grades)
    return f"Max: {max(grades)}, Min: {min(grades)}"
print(get_max())
#
def format_filename():
    filename = "report.txt"
    temp = filename[:-4]
    return temp.capitalize()
print(format_filename())


# TO DO list
def get_todos():
    with open("to_dos.txt", "r") as f:
        all = f.readlines()
    return all

def write_todos(to_dos):
    with open("to_dos.txt", "w") as ff:
        ff.writelines(to_dos)
to_do = []
while True:
    try:
        option = input("Type the option view add remove edit.. with respective data..")
        option_with_data = option.strip()
        print(option_with_data)

        if option_with_data.startswith("view"):
            all=get_todos()
            for i,j in enumerate(all):
                print(i,j,sep=" : ")
                print(f"{i} : {j}")

        elif option_with_data.startswith("add"):
            all=get_todos()
            temp = option_with_data[4:]
            all.append(temp+ "\n")
            write_todos(all)
        elif option_with_data.startswith("remove"):
            all=get_todos()
            temp = option_with_data[7:]
            print(all)
            all.remove(temp+"\n")
            write_todos(all)
        elif option_with_data.startswith("edit"):
            all=get_todos()
            print(all)
            id = all.index(option_with_data[5:]+"\n")
            temp = input("Enter the todo to edit:") + "\n"
            all[id] = temp
            write_todos(all)
        elif "exit" in option_with_data:
            break

        else :
            print(option)
    except Exception:
        print("Invalid action and the error ids :: ", Exception)