# Student Record Manager

A Java console application for managing student records and academic information.

This project is being built as part of my Java learning and portfolio journey, with a focus on strengthening Object-Oriented Programming (OOP), Java Collections, input validation, and software design principles.

---

## Features

### ✅ Completed

- [x] Add Student
- [x] View Students
- [x] Search Student
- [x] Update Student
- [x] Delete Student
- [x] Input Validation
- [x] Student ID Validation
- [x] Student Name Validation
- [x] Student Age Validation
- [x] Student Class Validation
- [x] Duplicate Student ID Prevention
- [x] Age/Class Compatibility Checks
- [x] Age/Class Exception Handling
- [x] Protected Student State Through Constructor & Setter Validation
- [x] LinkedHashMap-Based Student Storage
- [x] Separated Input, Business Rules, Data Management, and Display Responsibilities

### 🚀 Planned

- [ ] User-defined Subjects
- [ ] Add/Edit Marks
- [ ] Calculate Average Marks
- [ ] Grade Calculation
- [ ] Sort Students
- [ ] Save Data to File
- [ ] Load Data from File
- [ ] Student Statistics
- [ ] Export Student Records
- [ ] Unit Testing

---

## Technologies Used

- Java
- IntelliJ IDEA
- Git
- GitHub

---

## Project Structure

```text
src
├── Main.java
├── Student.java
├── StudentManager.java
├── StudentRules.java
├── StudentInputHelper.java
├── StudentView.java
└── InputValidator.java
```

### Class Responsibilities

#### `Main.java`

Controls the main application flow and menu system.

Responsible for:
- Displaying the main menu
- Handling user choices
- Coordinating student operations

#### `Student.java`

Represents an individual student.

Responsible for:
- Storing student information
- Providing getters and setters
- Protecting the object's basic state through validation

#### `StudentManager.java`

Manages the collection of students.

Responsible for:
- Adding students
- Finding students
- Removing students
- Checking for duplicate IDs
- Providing student records for viewing

Student records are currently stored using a `LinkedHashMap<Integer, Student>`.

#### `StudentRules.java`

Contains the application's student validation and business rules.

Responsible for:
- Student ID validation
- Name validation
- Age validation
- Class validation
- Age/Class compatibility rules

#### `StudentInputHelper.java`

Handles more complex input workflows.

Currently responsible for:
- Checking Age/Class compatibility
- Handling user-approved Age/Class exceptions

#### `StudentView.java`

Handles displaying information to the user.

Responsible for:
- Displaying individual student information
- Displaying multiple students
- Displaying update menus

#### `InputValidator.java`

Handles user input validation.

Responsible for:
- Reading and validating Student IDs
- Reading and validating names
- Reading and validating ages
- Reading and validating classes
- Validating menu choices
- Validating Y/N input
- Preventing invalid numeric input from crashing the program

---

## Learning Objectives

This project focuses on learning and applying:

- Object-Oriented Programming (OOP)
- Classes & Objects
- Constructors
- Encapsulation
- Getters & Setters
- Data Validation
- Business Rules
- Separation of Responsibilities
- Java Collections
- `Map`
- `LinkedHashMap`
- Searching
- Exception Handling
- Clean Code Practices
- Git & GitHub Workflow

---

## Validation

The application currently validates:

### Student ID

- Must contain 4 digits
- Valid range: `1000–9999`
- Duplicate IDs are not allowed

### Student Name

- Must not be empty
- Must contain valid alphabetic characters and spaces

### Student Age

- Valid range: `5–20`

### Student Class

- Valid range: `1–12`

### Age/Class Compatibility

The application calculates an expected age based on the student's class.

```text
Expected Age = Class + 5
```

An age within ±1 year of the expected age is considered normally valid.

If the combination falls outside that range, the user is given the option to explicitly treat it as an exception.

---

## Data Structure

Student records are currently stored using:

```text
LinkedHashMap<Integer, Student>
```

The student's ID is used as the key.

This allows:

- Fast student lookup by ID
- Fast duplicate ID checking
- Fast removal by ID
- Preservation of insertion order when displaying students

---

## Future Improvements

The project will gradually be expanded with features such as:

- Persistent data storage
- User-defined subjects
- Marks management
- Automatic average calculation
- Grade calculation
- Student sorting
- Student statistics
- Exporting student records
- Unit testing
- Improved application interface

The goal is to gradually increase the project's complexity while applying the Java concepts learned along the way.

---

## Author

Built by **Notorious** as part of a Java learning and portfolio journey.