import pandas

df = pandas.read_csv("hotels.csv", dtype={"id": str})

class Hotel:
    def __init__(self,id):
        self.hotel_id = id
        self.name = df.loc[df["id"] == self.hotel_id, "name"].squeeze()
        print(self.hotel_id,self.name)

    def book(self):
        df.loc[df["id"] == self.hotel_id, "available"] = "no"
        df.to_csv("hotels.csv", index=False)
    def available(self):
        availability = df.loc[df["id"] == self.hotel_id, "available"].squeeze()
        print(availability)
        if availability == "yes":
            return True
        else:
            return False

class ReservationTicket:
    def __init__(self, name, hotel):
        self.customer_name = name
        self.hotel = hotel

    def generate(self):
        content = f"""
        Thank you....
        Here are you booking data:
        Name: {self.customer_name}
        Hotel name: {self.hotel.name}
        """
        return content




print(df)
id = input("enter the ID : ")
hotel = Hotel(id)
if hotel.available():
    hotel.book()
    name = input("Enter your name : ")
    reservation_ticket = ReservationTicket(name, hotel)
    print(reservation_ticket.generate())
else :
    print("Hotel is booked")



