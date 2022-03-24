from cgitb import text
from logging import root
from tkinter import *
from tkinter import ttk
from tkinter import filedialog
from PIL import ImageTk,Image

# Variable and functions corner :)
def openFile():
    file_name = filedialog.askopenfilename(initialdir="./images", title="Select an image file")
    image_name = Label(display_frame,text=f"Image you selected: {file_name}").pack()
    my_image = ImageTk.PhotoImage(Image.open(file_name))
    image_label = Label(image_frame,image=my_image).pack(padx=5, pady=5)
    image_label.image = my_image
    image_label.bind('<Button-1>', getMousecoOrdinates)

def getMousecoOrdinates(event):
    print("Position = ({0},{1})".format(event.x, event.y))


# creating a root window
root = Tk()


# Giving a title 
root.title("6th semester project AC Sir")


# Setting the size of our window
root.geometry("500x500")


# Creating frames for buttons
btn_frame = Frame(root)
btn_frame.pack(side=TOP)


# Creating frames for displaying
display_frame = Frame(root)
display_frame.pack()

image_frame = Frame(root,highlightbackground="black", highlightthickness=2)
image_frame.bind('<Button-1>', getMousecoOrdinates)
image_frame.pack()


# Creating buttons
browse_btn = Button(btn_frame, text="Browse", command=openFile)
browse_btn.pack(side=LEFT, padx=5, pady=5)

about_btn = Button(btn_frame, text="About")
about_btn.pack(side=LEFT, padx=5, pady=5)


# Mainloop
root.mainloop()