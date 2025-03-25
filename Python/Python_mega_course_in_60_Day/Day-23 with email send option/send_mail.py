import smtplib
import ssl






def send_mail(email, msg):
    # use this method or use os environment varibale like sva ein that and use it
    # like os.getenv("POSSWIRD")
    with open("./../../../../confidentials.txt", "r") as file:
        config = file.readlines()
    host = "smtp.gmail.com"
    port = 465
    username = config[3].strip()
    password = config[4].strip()
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
        server.sendmail(email, "vengadesang2003@gmail.com", f"{msg} \n\nsended by \n{email} ")






