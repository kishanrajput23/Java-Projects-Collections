import sys

# Check number of strings passed
if len(sys.argv) != 4:
    print("Usage: python Calculator.py operand1 operator operand2")
    sys.exit()

# Determine the operator
if sys.argv[2][0] == '+':
    result = eval(sys.argv[1]) + eval(sys.argv[3])
elif sys.argv[2][0] == '-':
    result = eval(sys.argv[1]) - eval(sys.argv[3])
elif sys.argv[2][0] == '*':
    result = eval(sys.argv[1]) * eval(sys.argv[3])
elif sys.argv[2][0] == '/':
    result = eval(sys.argv[1]) / eval(sys.argv[3])

# Display result
print(sys.argv[1], sys.argv[2], sys.argv[3], "=", result)
