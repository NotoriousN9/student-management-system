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
- [x] Subject Class
- [x] Subject Catalogue Management
- [x] Subject Code Lookup
- [x] Subject Addition and Removal

### 🚀 Planned

- [ ] Class-Based Subject Assignment
- [ ] Stream-Based Subject Assignment
- [ ] Compulsory and Optional Subjects
- [ ] Admin Subject Management
- [ ] Add/Edit Marks
- [ ] Calculate Average Marks
- [ ] Grade Calculation
- [ ] Sort Students
- [ ] Save Data to File
- [ ] Load Data from File
- [ ] Student Statistics
- [ ] Export Student Records
- [ ] Unit Testing
- [ ] Auto ID Assigner

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
├── StudentOperations.java
├── InputValidator.java
├── Subject.java
└── SubjectManager.java
```

---

## Class Responsibilities

### `Main.java`

Controls the main application flow and menu system.

Responsible for:

- Displaying the main menu
- Handling user choices
- Coordinating student operations

### `Student.java`

Represents an individual student.

Responsible for:

- Storing student information
- Providing getters and setters
- Protecting the object's basic state through validation

### `StudentManager.java`

Manages the collection of students.

Responsible for:

- Adding students
- Finding students
- Removing students
- Checking for duplicate IDs
- Providing student records for viewing

Student records are currently stored using a `LinkedHashMap<Integer, Student>`.

### `StudentRules.java`

Contains the application's student validation and business rules.

Responsible for:

- Student ID validation
- Name validation
- Age validation
- Class validation
- Age/Class compatibility rules

### `StudentInputHelper.java`

Handles more complex input workflows.

Currently responsible for:

- Checking Age/Class compatibility
- Handling user-approved Age/Class exceptions

### `StudentView.java`

Handles displaying information to the user.

Responsible for:

- Displaying individual student information
- Displaying multiple students
- Displaying update menus

### `StudentOperations.java`

Handles the main student-related workflows of the application.

Responsible for:

- Adding students
- Searching for students
- Updating student information
- Removing students
- Coordinating input validation and student operations
- Handling update-specific workflows such as changing name, age, and class
- Connecting `InputValidator`, `StudentManager`, `StudentInputHelper`, and `StudentView` where needed

### `InputValidator.java`

Handles user input validation.

Responsible for:

- Reading and validating Student IDs
- Reading and validating names
- Reading and validating ages
- Reading and validating classes
- Validating menu choices
- Validating Y/N input
- Preventing invalid numeric input from crashing the program

### `Subject.java`

Represents an individual subject.

Responsible for:

- Storing subject information
- Providing the subject code and name
- Keeping the subject code immutable
- Allowing the subject name to be updated

### `SubjectManager.java`

Manages the school's subject catalogue.

Responsible for:

- Adding subjects
- Finding subjects by subject code
- Checking for duplicate subject codes
- Removing subjects
- Providing the complete subject catalogue

Subject records are currently stored using a `LinkedHashMap<Integer, Subject>`.

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

### Student Records

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

### Subject Catalogue

Subjects are currently stored using:

```text
LinkedHashMap<Integer, Subject>
```

The subject code is used as the key.

This allows:

- Fast subject lookup by code
- Duplicate subject code prevention
- Fast subject removal
- Preservation of insertion order when displaying subjects

---

## Future Improvements

The project will gradually be expanded with features such as:

- Class-based subject assignment
- Stream-based subject assignment
- Compulsory and optional subjects
- Admin-controlled subject management
- Persistent data storage
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

## Development Progress

The project is being developed incrementally, with each feature introducing new programming concepts and design challenges.

### Current Progress

```text
Student Management
    ├── Student CRUD                 ✅
    ├── Input Validation             ✅
    ├── Business Rules               ✅
    ├── Exception Handling           ✅
    └── Code Refactoring             ✅

Subject Management
    ├── Subject Class                ✅
    ├── Subject Catalogue            ✅
    ├── Subject Lookup               ✅
    └── Subject Removal              ✅

Academic Structure
    ├── Class-Based Subjects         🚧
    ├── Stream-Based Subjects        🚧
    ├── Compulsory Subjects          🚧
    └── Optional / Extra Subjects    🚧

Administration
    └── Admin Subject Management     🚧

Academic Records
    ├── Marks Management             ⏳
    ├── Average Calculation          ⏳
    └── Grade Calculation            ⏳
```

Legend:

- ✅ Completed
- 🚧 In Development
- ⏳ Planned

---

## Future Architecture

The subject system is designed to eventually follow this structure:

```text
School
│
├── Subject Catalogue
│   ├── Mathematics
│   ├── English
│   ├── Physics
│   ├── Chemistry
│   └── ...
│
├── Classes
│   ├── Class 1–10
│   │   └── Assigned Subjects
│   │
│   └── Class 11–12
│       ├── Science
│       ├── Commerce
│       ├── Arts
│       └── Other Streams
│
└── Students
    └── Automatically Assigned Subjects
```

The goal is for students to receive subjects based on their class and, for Classes 11–12, their selected stream rather than allowing completely arbitrary subject selection.

School administrators will eventually be able to manage the subject catalogue and assign subjects to the appropriate classes and streams.

---

## Project Goals

The goal of this project is not only to create a functional Student Management System, but also to progressively apply Java concepts to a real-world style application.

The project will evolve from a basic console-based CRUD application into a more complete academic management system while maintaining clean structure, separation of responsibilities, and maintainable code.

---

## Author

Built by `Notorious` as part of a Java learning and portfolio journey.