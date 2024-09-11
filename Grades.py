import random
# import random module to use in code later

# first I create a class named Course
class Course:

    def __init__(self, name, credit_hours, letter_grade):
        # initial attributes for course
        self.name = name
        self.credit_hours = credit_hours
        self.letter_grade = letter_grade

    def __str__(self):
        # Return string that represents the formatted course
        return f"{self.name}, {self.credit_hours} credits, Grade: {self.letter_grade}"

# then create class named student
class Student:
    def __init__(self, full_name, email, major, project_info):
        # initial attributes for student
        self.full_name = full_name
        self.email = email
        self.major = major
        self.project_info = project_info
        self.courses = []  # List to store Course objects
        # created dictionary for letter to gpa conversion
        self.letter_grade_to_gpa_dictionary = {'A+': 4.0, 'A': 4.0, 'A-': 3.7, 'B+': 3.3, 'B': 3.0, 'B-': 2.7,
                                               'C+': 2.3, 'C': 2.0, 'C-': 1.7, 'D+': 1.3, 'D': 1.0, 'D-': 0.7, 'F': 0.0}

    def add_course(self, course):
        # Add a Course object
        self.courses.append(course)

    def letter_grade_to_gpa(self, letter_grade):
        # add letter grades to GPA object using the dictionary
        return self.letter_grade_to_gpa_dictionary.get(letter_grade, 0.0)

    def calculate_gpa(self):
        # Calculate the GPA for the student
        quality_points = 0.0
        total_credit_hours = 0.0

        for each_course in self.courses:
            letter_grade = each_course.letter_grade
            quality_points += self.letter_grade_to_gpa(letter_grade) * each_course.credit_hours
            total_credit_hours += each_course.credit_hours

        # Get quality points and credit hours, calculate the overall gpa

        overall_gpa = quality_points / total_credit_hours
        return overall_gpa

    def print_student_gpa(self):
        # Print the student's information like name email major and project
        print()
        print(f"{self.full_name}, {self.email}, {self.major}, {self.project_info}")
        print()
        print("COURSES:")
        for every_course in self.courses:
            print(every_course)

        FINAL_GPA = self.calculate_gpa()
        print(f'FINAL GPA: {FINAL_GPA:.2f}')

# Function to input student information
def calculate_student_gpa():
    given_student_information = input("Enter full name, email, major, & project information (separated by a comma): ")
    student_information_list = given_student_information.split(',')

    # Create instance with the info
    the_student = Student(student_information_list[0].strip(), student_information_list[1].strip(),
                            student_information_list[2].strip(), student_information_list[3].strip())

    amount_of_courses_list = ['2', '3', '4', '5', '6']
    amount_of_courses_input = input("How many courses do you want to add (2-6): ")

    # Validate the input
    while amount_of_courses_input not in amount_of_courses_list:
        amount_of_courses_input = input("Invalid number of courses. "
                                        "Please re-enter the number of courses you want to add (2-6):")

    amount_of_courses_input = int(amount_of_courses_input)

    # Input info for each course and add it to the student's courses
    for i in range(amount_of_courses_input):
        course_details = input("Enter course name, credit hours, and letter grade (separated by a comma): ")
        course_details_list = course_details.split(",")
        course_credit = course_details_list[1].strip()

        the_course = Course(course_details_list[0].strip(), int(course_credit), course_details_list[2].strip())
        the_student.add_course(the_course)

    the_student.print_student_gpa()


def lottery_number_generator():
    # create empty list to store lotto numbers
    powerball_numbers_list = []

    # randomize five numbers from 1 to 69
    while len(powerball_numbers_list) < 5:
        add_number = random.randint(1, 69)
        if add_number not in powerball_numbers_list:
            powerball_numbers_list.append(add_number)

    # Sort the list
    powerball_numbers_list.sort()

    # Generate a random number from 1 to 26 as the last number
    last_number = random.randint(1, 26)

    # Add the sixth number to the list
    powerball_numbers_list.append(last_number)

    # Print the lotto numbers
    print(*powerball_numbers_list)


def pig_latin():
    # Ask the user to input a sentence
    phrase = input("Enter a sentence, it will be translated into Pig Latin: ").upper()

    # Split the sentence into a list of words
    words_split = phrase.split()

    # Iterate through each word in the list
    for words in words_split:
        # Print each word in Pig Latin
        print(words[1:] + words[0] + 'AY', end=' ')



def rock_paper_scissors_game():
# Give options Rock, Paper, Scissors
    game_options = ['rock', 'paper', 'scissors']

# Computer chooses one of the options
    computer_game_input = random.choice(game_options)

# User inputs their choice
    user_game_input = input('Enter your choice, rock, paper, or scissors:')

# Display the computer's choice
    print(f'Computers choice: {computer_game_input}')

# Validate user input
    while user_game_input not in game_options:
        user_game_input = input('Invalid input. Please re-enter choices:')

    while computer_game_input == user_game_input:
    # tie = re-generate computer's choice
        computer_game_input = random.choice(game_options)

        user_game_input = input('Tie! Please re-enter choices.')

    # Display new choice
        print(f'Computers choice: {computer_game_input}')

# Determine the winner
    if user_game_input == 'rock' and computer_game_input == 'scissors':
        print('Winner, You won!')
    elif user_game_input == 'paper' and computer_game_input == 'rock':
        print('Winner, You won!')
    elif user_game_input == 'scissors' and computer_game_input == 'paper':
        print('Winner, You won!')
    else:
        print('Loser, Computer Wins!')


def main():
    # this displays all the menu options
    menu = ('Welcome to the CSC115 Final Project.\n'
            'Enter 1 to Calculate Student GPA\n'
            'Enter 2 for Lottery Number Generator\n'
            'Enter 3 for Pig Latin\n'
            'Enter 4 for Rock, Paper, Scissors Game\n')

    print(menu)

    # this prompts the user to input their choice
    user_menu_input = input('Enter an option: 1, 2, 3, 4, or enter 9 to exit.')

    # this is a list of valid choices
    valid_menu_options = ['1', '2', '3', '4', '9']

    # here we validate the users input
    while user_menu_input not in valid_menu_options:  # Input validation loop
        user_menu_input = input('Input Invalid. Re-enter a valid input: 1, 2, 3, 4, 9')

    print('Valid Input.')
    print('')

    # perform actions based on input until they choose exit
    while user_menu_input != '9':

        if user_menu_input == '1':
            print('Calculate Student GPA')
            calculate_student_gpa()
            print()

        elif user_menu_input == '2':
            print('Lottery Number Generator')
            print('Your Lottery Numbers:')
            lottery_number_generator()
            print()

        elif user_menu_input == '3':
            print('Translate to Pig Latin')
            pig_latin()
            print()
            print()

        else:
            print('Rock, Paper, Scissors Game')
            rock_paper_scissors_game()
            print()


        print(menu)

        # Prompt the user to input their choice again
        user_menu_input = input('Enter an option: 1, 2, 3, 4, or enter 9 to exit.')

        # Validate user input again
        valid_menu_options = ['1', '2', '3', '4', '9']

        while user_menu_input not in valid_menu_options:  # Input validation loop
            user_menu_input = input('Input Invalid. Re-enter a valid input: 1, 2, 3, 4, 9')

    print('Exiting')


# Execute the main function
if __name__ == "__main__":
    main()




