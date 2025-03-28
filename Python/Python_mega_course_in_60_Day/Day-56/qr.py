import qrcode

if __name__ == '__main__':
    image = qrcode.make("http://127.0.0.1:8000/")
    image.save("myqr.png")
