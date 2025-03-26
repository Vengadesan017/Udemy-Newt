import smtplib
import ssl
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText


def send_mail(msg):
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
    # msg = """
    # Subject: Test Email
    #
    # Hii!
    # Hello
    # Bye!
    # """
    context = ssl.create_default_context()
    with smtplib.SMTP_SSL(host, port, context=context) as server:
        server.login(username, password)
        server.sendmail(email, "vengadesang2003@gmail.com",message.as_string())






