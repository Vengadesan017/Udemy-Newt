country = "Italy"
match country:
    case "USA":
        print("Hello")
    case "Italy":
        print("Ciao")
    case "Germany":
        print("Hallo")


members = ["john", "sarah", "dora"]

for i in members:
    print(i.capitalize())


country = "USA"
match country:
    case "USA" | "United States":
        print("Hello")
    case "Italy":
        print("Ciao")
    case "Germany":
        print("Hallo")

employees = ["john smith", "sarah bremen", "dora dawson"]
for e in employees:
    print(e.title())

scores = [11, 34, 98, 43, 45, 54, 54]
for i in scores:
    print(i)