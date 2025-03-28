from PyQt6.QtWidgets import QApplication, QLabel, QWidget, QGridLayout, \
    QLineEdit, QPushButton, QTableWidget, QTableWidgetItem

import sys
from datetime import datetime
import sqlite3
import mysql.connector


class DatabaseConnection:
    def __init__(self, host="localhost", user="root", password="123456", database="PyQt6"):
        self.host = host
        self.user = user
        self.password = password
        self.database = database

    def connect(self):
        try:
            connection = mysql.connector.connect(host= self.host,user=self.user,password=self.password,database=self.database)
            if connection.is_connected():
                print("Connection successful!")
                # connection.close()
            else:
                print("Failed to connect.")

        except mysql.connector.Error as err:
            print(f"Error: {err}")
        cursor = connection.cursor()
        cursor.execute("SELECT name FROM user_age")
        tables = cursor.fetchall()
        print(cursor)
        print(tables)
        return connection


print(DatabaseConnection().connect())

class AgeCalculator(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Age Calculator")
        grid = QGridLayout()

        # Create widgets
        name_label = QLabel("Name:")
        self.name_line_edit = QLineEdit()

        date_birth_label = QLabel("Date of Birth MM/DD/YYYY:")
        self.date_birth_line_edit = QLineEdit()

        calculate_button = QPushButton("Calculate Age")
        calculate_button.clicked.connect(self.calculate_age)
        self.output_label = QLabel("")

        # list data
        user_data_header = QLabel("All users data:")

        self.table_widget = QTableWidget()
        self.table_widget.setColumnCount(2)
        self.table_widget.setHorizontalHeaderLabels(["Name", "Date of Birth"])

        # Add widgets to grid
        grid.addWidget(name_label, 0, 0)
        grid.addWidget(self.name_line_edit, 0, 1)
        grid.addWidget(date_birth_label, 1, 0)
        grid.addWidget(self.date_birth_line_edit, 1, 1)
        grid.addWidget(calculate_button, 2, 0, 1, 2)
        grid.addWidget(self.output_label, 3, 0, 1, 2)
        grid.addWidget(user_data_header, 4, 0, 1, 2)
        grid.addWidget(self.table_widget, 5, 0, 1, 2)

        self.setLayout(grid)
        # self.load_data()

    def calculate_age(self):
        current_year = datetime.now().year
        date_of_birth = self.date_birth_line_edit.text()
        year_of_birth = datetime.strptime(date_of_birth, "%m/%d/%Y").date().year
        age = current_year - year_of_birth
        print(age)
        self.output_label.setText(f"{self.name_line_edit.text()} is {age} years old.")
        # self.insert_data(self.name_line_edit.text(),age)

    def load_data(self):
        connection = DatabaseConnection().connect()
        cursor = connection.cursor()
        result = cursor.execute("SELECT * FROM User_age").fetchall()
        connection.close()
        print(result)
        self.table_widget.setRowCount(len(result))
        for row, user in enumerate(result):
            self.table_widget.setItem(row, 0, QTableWidgetItem(user[0]))
            self.table_widget.setItem(row, 1, QTableWidgetItem(user[1]))

    def insert_data(self,name,age):
        print(name,age)
        connection = DatabaseConnection().connect()
        cursor = connection.cursor()
        cursor.execute("INSERT INTO User_age (Name, age) VALUES (?, ?)", (name, age))
        connection.commit()
        connection.close()
        print(f"Inserted: {name}, {age}")
        # self.load_data()
app = QApplication(sys.argv)
age_calculator = AgeCalculator()
age_calculator.show()
sys.exit(app.exec())

