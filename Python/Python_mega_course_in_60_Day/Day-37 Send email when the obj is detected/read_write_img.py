import cv2
import numpy

array = cv2.imread("img.png")

# print(array)
# print(array.shape)

create_img = cv2.imwrite("car.jpg",array)