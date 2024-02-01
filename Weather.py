def main():
    NUMBER_OF_DAYS = 10
    NUMBER_OF_HOURS = 24

    # Initialize data
    data = initialize_data(NUMBER_OF_DAYS, NUMBER_OF_HOURS)

    # Read input using input redirection from a file
    read_input(data, NUMBER_OF_DAYS, NUMBER_OF_HOURS)

    # Find and display the average daily temperature and humidity
    calculate_and_display_averages(data, NUMBER_OF_DAYS, NUMBER_OF_HOURS)


def initialize_data(num_days, num_hours):
    """Initialize a 3D list for storing temperature and humidity data."""
    return [[[0, 0] for _ in range(num_hours)] for _ in range(num_days)]


def read_input(data, num_days, num_hours):
    """Read input data and populate the data list."""
    for _ in range(num_days * num_hours):
        line = input().strip().split()
        day, hour, temperature, humidity = map(eval, line)
        data[day - 1][hour - 1] = [temperature, humidity]


def calculate_and_display_averages(data, num_days, num_hours):
    """Calculate and display the average daily temperature and humidity."""
    for i in range(num_days):
        daily_temperature_total = sum(data[i][j][0] for j in range(num_hours))
        daily_humidity_total = sum(data[i][j][1] for j in range(num_hours))

        # Display result
        print(f"Day {i + 1}'s average temperature is {daily_temperature_total / num_hours:.2f}")
        print(f"Day {i + 1}'s average humidity is {daily_humidity_total / num_hours:.2f}")


if __name__ == "__main__":
    main()  # Call the main function
