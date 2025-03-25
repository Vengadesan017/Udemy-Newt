import streamlit as st

st.set_page_config(layout="wide")
col1, col2 = st.columns(2)

with col1:
    st.image("img.png")
    pass


with col2:
    st.title("Column 2")
    st.write("Hello from the column 2")

st.write("Outside from the columns............................................. ... .. . . ... .. .....")