from FreeSimpleGUI import button_color_to_tuple

import FreeSimpleGUI as gui
import zipfile
import pathlib

def make_zip(files, folder):
    dest_path = pathlib.Path(folder,"Compressed.zip")
    with zipfile.ZipFile(dest_path, "w") as archive:
        for file in files:
            archive.write(file)

lable1 = gui.Text("Select the files to compress : ")
input_box1 = gui.Input()
choose_button1 = gui.FilesBrowse("Choose", key="Files")

lable2 = gui.Text("Select the destination folder : ")
input_box2 = gui.Input()
choose_button2 = gui.FolderBrowse("Choose", key="Folders")


button = gui.Button("Compress")

window = gui.Window("Vengat file compressor",layout=[[lable1,input_box1,choose_button1],[lable2,input_box2,choose_button2],[button]])
while True:
    events, values = window.read()
    print(events)
    print(values)
    match events:
        case "Compress":
            files = values["Files"].split(";")
            folder = values["Folders"]
            print(files)
            print(folder)
            make_zip(files, folder)


        case "Exit" | gui.WINDOW_CLOSED:
            break

        case _:
            print(events)
window.close()


