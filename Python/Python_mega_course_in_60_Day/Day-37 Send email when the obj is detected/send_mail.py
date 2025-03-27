import imghdr
import smtplib
import ssl
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.message import EmailMessage

def send_mail(image_path):
    with open("./../../../../confidentials.txt", "r") as file:
        config = file.readlines()
    host = "smtp.gmail.com"
    port = 587
    username = config[3].strip()
    password = config[4].strip()
    email_message = EmailMessage()
    email_message["Subject"] = "New obj "+image_path
    email_message.set_content("From web cam")

    with open(image_path, "rb") as file:
        content = file.read()
    email_message.add_attachment(content, maintype="image", subtype=imghdr.what(None, content))

    gmail = smtplib.SMTP(host, port)
    gmail.ehlo()
    gmail.starttls()
    gmail.login(username, password)
    gmail.sendmail(username, "vengadesang2003@gmail.com", email_message.as_string())
    gmail.quit()
    print("send email ")
if __name__ == "__main__":
    send_mail(image_path="img.png")

def send_mail_msg(msg):
    # use this method or use os environment varibale like sva ein that and use it
    # like os.getenv("POSSWIRD")
    with open("./../../../../confidentials.txt", "r") as file:
        config = file.readlines()
    host = "smtp.gmail.com"
    port = 465
    username = config[3].strip()
    password = config[4].strip()

    email = "vengadesang2003@gmail.com"

    message = MIMEMultipart()
    message['From'] = username
    message['To'] = email
    message['Subject'] = "Daily News letter : Auto"

    msg_part = MIMEText(msg, 'plain', 'utf-8')  # Ensure UTF-8 encoding here
    message.attach(msg_part)

    context = ssl.create_default_context()
    with smtplib.SMTP_SSL(host, port, context=context) as server:
        server.login(username, password)
        server.sendmail(email, "vengadesang2003@gmail.com",message.as_string())






