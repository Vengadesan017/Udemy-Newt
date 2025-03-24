temperatures = [12.34, 45, "67"]
rainfall = [12.34, 45, "67", temperatures]

products = ['table', 'chair', 'door']

for i, j in enumerate(products):
    print(i,":",j)

filenames = ['document', 'report', 'presentation']
for i , j in enumerate(filenames):
    print(f"{i}-{j.capitalize()}.txt")
print(f"Last file {i}-{j.capitalize()}.txt")

seconds = [1.23, 1.45, 1.02, 1.11]
seconds.remove(1.45)
print(seconds)
print(len(seconds))

measurements = [177.8, 175.8, 166.9, 182.5]
measurements.sort()
for i in measurements:
    print(i)




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





