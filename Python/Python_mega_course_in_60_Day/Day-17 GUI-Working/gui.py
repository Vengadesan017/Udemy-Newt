from FreeSimpleGUI import button_color_to_tuple

from functions import get_todos, write_todos
import FreeSimpleGUI as gui


lable = gui.Text("Enter the your To DOs..")
input_box = gui.InputText(tooltip="Enter todo")
add_button = gui.Button("Add")

list_box = gui.Listbox(values=get_todos(),key="edit_todo",enable_events=True,size=[45,10])
edit_button = gui.Button("Edit")


delete_button = gui.Button("Remove")
window = gui.Window("Vengat",layout=[[lable],[input_box,add_button],[list_box,edit_button],[delete_button]],font=("Helvetica",20))

while True:
    # try:
        events, values = window.read()
        print(events)
        print(values)
        #

        match events:
            case "View":
                all = get_todos()
                for i, j in enumerate(all):
                    print(i, j, sep=" : ")
                    print(f"{i} : {j}")

            case "Add":
                all = get_todos()
                # temp = option_with_data[4:]
                all.append(values[0] + "\n")
                write_todos(all)
                window["edit_todo"].update(values=all)

            case "Remove":
                all = get_todos()
                # temp = option_with_data[7:]
                all.remove(values["edit_todo"][0])
                write_todos(all)
                window["edit_todo"].update(values=all)
            case "Edit":
                all = get_todos()
                # print(all)
                id = all.index(values["edit_todo"][0])
                # temp = input("Enter the todo to edit:") + "\n"
                all[id] = values[0] +"\n"
                write_todos(all)
                window["edit_todo"].update(values=all)
            case "Exit" | gui.WINDOW_CLOSED:
                break

            case _:
                print(events)
    # except Exception:
    #     print("Invalid action and the error ids :: ", Exception.)


#
window.close()


