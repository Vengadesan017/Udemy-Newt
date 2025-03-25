import requests

key = "ee8eb20a17da477a9a8356d2b9007a26"
url = "https://newsapi.org/v2/everything?q=tesla&from=2025-02-25&sortBy=publishedAt&apiKey="+key

request = requests.get(url)
print(request)
content = request.text
print(content)

