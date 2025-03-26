import streamlit as st
import plotly.express as px
from get_data import get_data

st.title("Weather Forecasting..")
place = st.text_input("Place: ")
days = st.slider("Forecast Days", min_value=1, max_value=5,
                 help="Select the number of forecasted days")
option = st.selectbox("Select data to filter",
                      ("Temperature", "Sky"))
st.subheader(f"{option} for the next {days} days in {place}")
# figure = px.line(x=[12,123,12,12], y=[890,890,890890,890], labels={"x": "Date", "y": "Temperature (C)"})
# st.plotly_chart(figure)


if place:
    # Get the temperature/sky data
    try:
        filtered_data = get_data(place, days)

        if option == "Temperature":
            temperatures = [dict["main"]["temp"] / 10 for dict in filtered_data]
            dates = [dict["dt_txt"] for dict in filtered_data]
            # Create a temperature plot
            figure = px.line(x=dates, y=temperatures, labels={"x": "Date", "y": "Temperature (C)"})
            st.plotly_chart(figure)

        if option == "Sky":
            temperatures = [dict["weather"][0]["main"] / 10 for dict in filtered_data]
            dates = [dict["dt_txt"] for dict in filtered_data]
            # Create a temperature plot
            figure = px.line(x=dates, y=temperatures, labels={"x": "Date", "y": "Temperature (C)"})
            st.plotly_chart(figure)
    except KeyError:
        st.write("That place does not exist.")