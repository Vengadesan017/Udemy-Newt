FileName = ""
def get_todos(filename="to_dos.txt"):
    """
    Read the file and return the list of to dos
    :param filename:
    :return: all to do's
    """
    with open(filename, "r") as f:
        all = f.readlines()
    return all

def write_todos(to_dos, filename="to_dos.txt"):
    with open(filename, "w") as ff:
        ff.writelines(to_dos)


if __name__ == "__main__":
    print(" package is running..! as ",__name__)
else:
    print(f"{__name__} is running")