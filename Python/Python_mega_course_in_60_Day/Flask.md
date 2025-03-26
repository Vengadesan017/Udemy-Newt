# Flask
- home.html file in templates folder
- img.png in static folder
- main.py in root folder
```py
from flask import Flask, render_template

app = Flask("website")

@app.route("/")
def home():
    return render_template("home.html")

@app.route("/about/")
def about():
    return render_template("home.html")

@app.route("/contact-us/")
def contact_us():
    return render_template("home.html")

@app.route("/api/v1/<station>/<date>")
def rest_data(station,date):
    temperature = 23
    return {"station":station,
            "date" : date,
            "temperatue" : temperature
            }


if __name__ == "__main__":
    app.run(debug=True, port=5001)
```
