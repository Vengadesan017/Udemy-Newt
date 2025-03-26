import streamlit as st
import plotly.express as px


st.title("Weather Forecasting..")
place = st.text_input("Place: ")
days = st.slider("Forecast Days", min_value=1, max_value=5,
                 help="Select the number of forecasted days")
option = st.selectbox("Select data to filter",
                      ("Temperature", "Sky"))
st.subheader(f"{option} for the next {days} days in {place}")
figure = px.line(x=[12,123,12,12], y=[890,890,890890,890], labels={"x": "Date", "y": "Temperature (C)"})
st.plotly_chart(figure)
