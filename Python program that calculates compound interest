# Function to calculate compound interest
def calculate_compound_interest(principal, rate, time, n):
    # Calculate the compound interest
    amount = principal * (1 + (rate / n))**(n * time)
    
    # Calculate the interest earned
    interest = amount - principal
    
    return amount, interest

# Input from the user
principal = float(input("Enter the principal amount: "))
rate = float(input("Enter the annual interest rate (as a decimal): "))
time = float(input("Enter the number of years: "))
n = int(input("Enter the number of times interest is compounded per year: "))

# Calculate compound interest and interest earned
total_amount, interest_earned = calculate_compound_interest(principal, rate, time, n)

# Display the result
print(f"Principal Amount: ${principal}")
print(f"Annual Interest Rate: {rate * 100}%")
print(f"Number of Years: {time}")
print(f"Number of times interest is compounded per year: {n}")
print(f"Total Amount: ${total_amount:.2f}")
print(f"Interest Earned: ${interest_earned:.2f}")
