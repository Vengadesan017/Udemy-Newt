import pandas
import streamlit as st
import pandas

st.set_page_config(layout="wide")
col1, col2 = st.columns(2)

with col1:
    st.image("img.png")


with col2:
    st.title("Column 2")
    st.write("Hello from the column 2")

st.write("Outside from the columns............................................. ... .. . . ... .. .....")

col3, col4 = st.columns(2)

df = pandas.read_csv("data.csv", sep=";")
with col4:
    for i in range(len(df)):
        st.image("img.png")

with col3:

    for i , row in df.iterrows():
        st.header(row["title"])
        st.write(row["description"])
        st.write(row["url"])
        st.write(row["url"])


st.write(".. . . . . ...................Outside from the columns............................................. ... .. . . ... .. .....")
