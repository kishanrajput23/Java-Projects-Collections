import turtle

def main():
    drawChessboard(-260, -20, -120, 120) # Draw first chess board
    drawChessboard(20, 260, -120, 120) # Draw second chess board

    turtle.hideturtle()
    turtle.done() 

# Draw one chess board
def drawChessboard(startx, endx, starty, endy):
    # Draw chess board borders
    turtle.pensize(3) # Set pen thickness to 3 pixels
    turtle.penup() # Pull the pen up
    turtle.goto(startx, starty)
    turtle.pendown() # Pull the pen down
    turtle.color("red")

    for i in range(4):
        turtle.forward(240) # Draw a line
        turtle.left(90) # Turn left 90 degrees

    # Draw chess board inside
    drawMultipleRectangle(startx, endx, starty, endy)
    drawMultipleRectangle(startx + 30, endx, starty + 30, endy)

# Draw multiple rectangles
def drawMultipleRectangle(startx, endx, starty, endy):
    turtle.color("black")
    for j in range(starty, endy, 60): 
        for i in range(startx, endx, 60):
            fillRectangle(i, j)

# Draw a small rectangle  
def fillRectangle(i, j):      
    turtle.penup()
    turtle.goto(i, j)
    turtle.pendown()
    turtle.begin_fill()
    for k in range(4):
        turtle.forward(30) # Draw a line
        turtle.left(90) # Turn left 90 degrees
    turtle.end_fill()

main()
