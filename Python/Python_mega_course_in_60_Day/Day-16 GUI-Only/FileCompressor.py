from FreeSimpleGUI import button_color_to_tuple

import FreeSimpleGUI as gui


lable1 = gui.Text("Select the files to compress : ")
input_box1 = gui.Input()
choose_button1 = gui.FilesBrowse("Choose")

lable2 = gui.Text("Select the destination folder : ")
input_box2 = gui.Input()
choose_button2 = gui.FolderBrowse("Choose")


button = gui.Button("Compress")

window = gui.Window("Vengat file compressor",layout=[[lable1,input_box1,choose_button1],[lable2,input_box2,choose_button2],[button]])
window.read()
window.close()


