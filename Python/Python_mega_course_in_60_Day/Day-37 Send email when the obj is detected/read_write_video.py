import time

import cv2
import numpy

video = cv2.VideoCapture(0)
time.sleep(1)

while True:
    check,  frame = video.read()
    cv2.imshow("Your video", frame)

    key = cv2.waitKey(1)
    print(key)
    if key != -1:
        print("break")
        break
video.release()
print(check)
print(frame)

