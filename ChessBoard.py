import turtle

# Draw chess board borders
turtle.pensize(3) # Set pen thickness to 3 pixels
turtle.penup() # Pull the pen up
turtle.goto(-120, -120)
turtle.pendown() # Pull the pen down
turtle.color("red")

for i in range(4):
    turtle.forward(240) # Draw a line
    turtle.left(90) # Turn left 90 degrees

# Draw chess board inside
turtle.color("black")
for j in range(-120, 90, 60): 
    for i in range(-120, 120, 60):
        turtle.penup()
        turtle.goto(i, j)
        turtle.pendown()

       # Draw a small rectangle        
        turtle.begin_fill()
        for k in range(4):
            turtle.forward(30) # Draw a line
            turtle.left(90) # Turn left 90 degrees
        turtle.end_fill()

for j in range(-90, 120, 60): 
    for i in range(-90, 120, 60):
        turtle.penup()
        turtle.goto(i, j)
        turtle.pendown()

       # Draw a small rectangle        
        turtle.begin_fill()
        for k in range(4):
            turtle.forward(30) # Draw a line
            turtle.left(90) # Turn left 90 degrees
        turtle.end_fill()

turtle.hideturtle()

turtle.done() 
