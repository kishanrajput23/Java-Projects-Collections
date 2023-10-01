import turtle
from UsefulTurtleFunctions import *

# Draw a line from (-50, -50) to (50, 50)
drawLine(-50, -50, 50, 50)

# Write a text at (-50, -60)
writeText("Testing useful Turtle functions", -50, -60)

# Draw a point at (0, 0)
drawPoint(0, 0)

# Draw a circle at (0, 0) with radius 80
drawCircle(0, 0, 80)
    
# Draw a rectangle at (0, 0) with width 60 and height 40
drawRectangle(0, 0, 60, 40)

turtle.hideturtle()
turtle.done() 