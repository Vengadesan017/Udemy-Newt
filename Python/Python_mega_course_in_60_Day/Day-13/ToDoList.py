# Functions with default
# And documentation


#
def get_age(year_of_birth, current_year = 2025):
    return current_year - year_of_birth
#
def get_nr_items(user_input):
    temp = user_input.split(",")
    return len(temp)
#
def area(length):
    return length*length
#
def foo(x):
    if x <= 7:
        return "Cold"
    else:
        return "warm"


# TO DO list
def get_todos(filename="to_dos.txt"):
    """
    Read the file and return the list of to dos
    :param filename:
    :return: all to do's
    """
    with open(filename, "r") as f:
        all = f.readlines()
    return all

def write_todos(to_dos, filename="to_dos.txt"):
    with open(filename, "w") as ff:
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