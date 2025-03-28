from flask import Flask, render_template
import pandas as pd
app = Flask(__name__)

stations = pd.read_csv("sample_data/stations.txt", skiprows=17)
stations = stations[["STAID", "STANAME                                 "]]

@app.route("/")
def home():
    return render_template("index.html",data = stations.to_html())

@app.route("/about/")
def about():
    return render_template("index.html")

@app.route("/contact-us/")
def contact_us():
    return render_template("index.html")

@app.route("/api/v1/<station>/<date>")
def rest_data(station,date):
    filename = "sample_data/TG_STAID" + str(station).zfill(6) + ".txt"
    df = pd.read_csv(filename, skiprows=20, parse_dates=["    DATE"])
    temperature = df.loc[df['    DATE'] == date]['   TG'].squeeze() / 10
    return {"station": station,
            "date": date,
            "temperature": temperature}


if __name__ == "__main__":
    app.run(debug=True, port=5000)