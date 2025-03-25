import streamlit as st
from send_mail import send_mail
st.write("Contact Vengat..!")

with st.form(key="email_form"):
    email = st.text_input("Enter your address..")
    message = st.text_area("Your message")
    button = st.form_submit_button()

    if button:
        send_mail(email,message)

# with open("./../../../../../confidentials.txt","r") as file:
#     config = file.readlines()
# username = config[2][:-1]
# password = config[3][:-1]
# print(username,password)