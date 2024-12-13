from tkinter import * # Import tkinter
from StillClock import StillClock
   
def setNewTime():
    clock.setHour(hour.get())
    clock.setMinute(minute.get())
    clock.setSecond(second.get())
    
window = Tk() # Create a window
window.title("Change Clock Time") # Set title

clock = StillClock(window) # Create a clock
clock.pack()

frame = Frame(window)
frame.pack()
Label(frame, text = "Hour: ").pack(side = LEFT)
hour = IntVar()
hour.set(clock.getHour())
Entry(frame, textvariable = hour, width = 2).pack(side = LEFT) 
Label(frame, text = "Minute: ").pack(side = LEFT)
minute = IntVar()
minute.set(clock.getMinute())
Entry(frame, textvariable = minute, width = 2).pack(side = LEFT) 
Label(frame, text = "Second: ").pack(side = LEFT)
second = IntVar()
second.set(clock.getMinute())
Entry(frame, textvariable = second, width = 2).pack(side = LEFT) 
Button(frame, text = "Set New Time", 
       command = setNewTime).pack(side = LEFT) 

window.mainloop() # Create an event loop