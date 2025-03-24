serials = ["RH80810A", "AA899819A", "XYSA9099400", "OOP8988459", "EEO8904882", "KOC9889482"]
print(serials[2])

words = [10,20,30,40,50]
print(words[3])

language = "pytgon"
print(language.replace("g","h"))
print(language)
language = language.replace("g","h")
print(language)

usernames = ['the blueman', 'sorted hedgehog', 'infinite lagoon']
usernames2 = []

for x in usernames:
    x = x.replace(" ","_")
    usernames2.append(x)

for y in usernames2:
    print(y)

seconds = [1.23, 1.45, 1.02]
current = 1.11
seconds.append(current)

color_codes = ((10,20,30), ("Hai","Hello","welcome"), (1.2,2.3,3.4))



# TO DO list
to_do = []
while True:
    option = input("Type the option view add remove edit..")
    match option:
        case "view":
            for i in to_do:
                print(i)



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
