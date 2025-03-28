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
        cursor.execute("SELECT * FROM user_age")
        tables = cursor.fetchall()
        print(cursor)
        print(tables)
        return connection


print(DatabaseConnection().connect())
print("hii")
print(DatabaseConnection().connect())


