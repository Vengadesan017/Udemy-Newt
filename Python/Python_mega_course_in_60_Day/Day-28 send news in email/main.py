import requests
from send_mail import send_mail
key = "ee8eb20a17da477a9a8356d2b9007a26"
# Change the date
url = "https://newsapi.org/v2/everything?q=tesla&from=2025-02-26&sortBy=publishedAt&apiKey=" + key + "&language=en"

request = requests.get(url)
print(request)
content = request.json()


body = ""
for i in content["articles"]:
    if i["title"] is not None and i["description"] is not None:
        body = body+ "\n \n" + i["title"] + "\n" + i["description"] + "\n" + i["url"]

# body.encode("utf-8")
send_mail(msg=body)