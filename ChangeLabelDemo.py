from tkinter import * # Import tkinter
    
class ChangeLabelDemo:
    def __init__(self):
        window = Tk() # Create a window 
        window.title("Change Label Demo") # Set a title
        
        # Add a label to frame1
        frame1 = Frame(window) # Create and add a frame to window 
        frame1.pack()        
        self.lbl = Label(frame1, text = "Programming is fun")
        self.lbl.pack()
        
        # Add a label, an entry, a button, and two radio buttons to frame2
        frame2 = Frame(window) # Create and add a frame to window 
        frame2.pack()
        label = Label(frame2, text = "Enter text: ")
        self.msg = StringVar()
        entry = Entry(frame2, textvariable = self.msg) 
        btChangeText = Button(frame2, text = "Change Text", 
            command = self.processButton)
        self.v1 = StringVar()
        rbRed = Radiobutton(frame2, text = "Red", bg = "red",
            variable = self.v1, value = 'R', 
            command = self.processRadiobutton) 
        rbYellow = Radiobutton(frame2, text = "Yellow", 
            bg = "yellow", variable = self.v1, value = 'Y', 
            command = self.processRadiobutton) 
        
        label.grid(row = 1, column = 1)
        entry.grid(row = 1, column = 2)
        btChangeText.grid(row = 1, column = 3)
        rbRed.grid(row = 1, column = 4)
        rbYellow.grid(row = 1, column = 5)
        
        window.mainloop() # Create an event loop

    def processRadiobutton(self):
        if self.v1.get() == 'R':
            self.lbl["fg"] = "red"
        elif self.v1.get() == 'Y':
            self.lbl["fg"] = "yellow" 
    
    def processButton(self):
        self.lbl["text"] = self.msg.get() # New text for the label
        
ChangeLabelDemo() # Create GUI 
