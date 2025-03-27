class A:
    def __init__(self,name):
        self.name=name

    @property
    def get_name(self):
        return f"Haii {self.name}.."


a = A("Kumar")
print(a.get_name)
