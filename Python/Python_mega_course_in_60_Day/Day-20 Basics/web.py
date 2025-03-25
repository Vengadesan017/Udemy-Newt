import streamlit as st
import functions

todos = functions.get_todos()

def add_todo():
    todo = st.session_state["new_todo"] + "\n"
    todos.append(todo)
    functions.write_todos(todos)


st.title("TO DO List using streamlit lib")
st.subheader("Can you see the todo's")
st.write("Also add delete")


for index, todo in enumerate(todos):
    checkbox = st.checkbox(todo, key=todo)
    if checkbox:
        todos.pop(index)
        functions.write_todos(todos)
        del st.session_state[todo]
        
st.text_input(label="", placeholder="Add new todos..",
              on_change=add_todo, key='new_todo')
st.session_state
