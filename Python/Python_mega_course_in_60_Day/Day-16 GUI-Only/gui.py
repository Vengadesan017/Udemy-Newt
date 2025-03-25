from FreeSimpleGUI import button_color_to_tuple

import functions
import FreeSimpleGUI as gui


lable = gui.Text("Haiiii")
input_box = gui.InputText(tooltip="Enter todo")
button = gui.Button("Add")
window = gui.Window("Vengat",layout=[[lable,input_box],[button]])
window.read()
window.close()


