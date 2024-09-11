# Print user information
print('Michael Mastando')
print('mikemastando23@gmail.com')


# Start the exit function
exit_program = False

# Main loop starts, which will run until exit_program is set to True
while not exit_program:
    # Display options and instructions
    print('\nThis Python program displays Roman Numerals and Predicts Population.')
    print('Enter option 1 to display Roman Numerals. Enter option 2 to Predict Population. Enter 9 to Exit the program.')

    try:
        # Get the user's option
        option = int(input("Enter an option (1 for Roman Numerals, 2 for Population Prediction, 9 to Exit): "))

        # Check the user's option
        if option == 1:
            # Option 1: Display Roman Numerals
            n = int(input("Enter a number between 1 and 10: "))
            if 1 <= n <= 10:
                # Valid number for Roman numerals
                # Lists for Roman numerals and their corresponding values
                value = [10, 9, 5, 4, 1]
                symbol = ["X", "IX", "V", "IV", "I"]
                roman_num = ''
                # Loop through values to construct the Roman numeral
                for i in range(len(value)):
                    count = n // value[i]
                    roman_num += symbol[i] * count
                    n -= value[i] * count
                print("Roman numeral:", roman_num)
            else:
                # Notify the user of an invalid range
                print("Please enter a number within the specified range.")
        elif option == 2:
            # Option 2: Predict Population
            starting_population = int(input("Enter the starting number of organisms: "))
            if starting_population < 0:
                # Check if the population is non-negative
                print("Please enter a non-negative number.")
            else:
                average_daily_increase = float(input("Enter the average daily increase (as a percentage): "))
                if 1 <= average_daily_increase <= 100:
                    # Check if the daily increase is a valid percentage
                    num_days = int(input("Enter the number of days the organisms will be left to multiply (2-30): "))
                    if 2 <= num_days <= 30:
                        # Valid input, perform prediction
                        print("\nDay  Approximate Population")
                        print("----------------------------")
                        for day in range(1, num_days + 1):
                            print(f"{day:2}  {starting_population:.2f}")
                            starting_population += (average_daily_increase / 100) * starting_population
                    else:
                        # Notify the user of an invalid range for days
                        print("Please enter a number of days between 2 and 30.")
                else:
                    # Notify the user of an invalid percentage range
                    print("Please enter a percentage between 1 and 100.")
        elif option == 9:
            # Option 9: Exit the program
            print("Exiting the program.")
            exit_program = True
        else:
            # Notify the user of an invalid option
            print("Invalid option. Please enter 1, 2, or 9.")
    except ValueError:
        # Notify of invalid input
        print("Please enter a valid option.")
