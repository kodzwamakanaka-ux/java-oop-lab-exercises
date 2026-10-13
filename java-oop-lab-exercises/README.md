# Object-Oriented Programming in Java: Lab Solutions

Solutions to every lab program and exercise in the *Object-Oriented Programming in Java: University Lab Manual*.
Assignment N below corresponds to Lab N of the manual.

Each folder has two parts:
- `lab-programs/`: the programs given in the manual (Program N.1, N.2, ...)
- `exercises/`: my solutions to the Basic, Intermediate and Challenge exercises (Lab 11: the Library Management mini-project)

| Assignment | Topic | Folder |
| --- | --- | --- |
| 1 | Classes and objects | [lab-01-classes-and-objects](lab-01-classes-and-objects) |
| 2 | Constructors, `this`, `static` | [lab-02-constructors-this-static](lab-02-constructors-this-static) |
| 3 | Encapsulation | [lab-03-encapsulation](lab-03-encapsulation) |
| 4 | Inheritance | [lab-04-inheritance](lab-04-inheritance) |
| 5 | Polymorphism | [lab-05-polymorphism](lab-05-polymorphism) |
| 6 | Abstraction | [lab-06-abstraction](lab-06-abstraction) |
| 7 | Exception handling | [lab-07-exception-handling](lab-07-exception-handling) |
| 8 | Generics and collections | [lab-08-generics-collections](lab-08-generics-collections) |
| 9 | Nested types, enums, records | [lab-09-nested-enums-records](lab-09-nested-enums-records) |
| 10 | File I/O, lambdas, streams | [lab-10-fileio-lambdas-streams](lab-10-fileio-lambdas-streams) |
| 11 | Design patterns and mini-project | [lab-11-mini-project-library](lab-11-mini-project-library) |

## Which file solves which exercise
Every `.java` file starts with a comment such as `// Assignment 3 (Lab 3) - Exercise 4 (Intermediate)`.

## How to run (JDK 17 or later)
Open a terminal inside the folder you want (for example `lab-01-classes-and-objects/exercises`):

```
javac *.java
java CarDemo
```

Replace `CarDemo` with the class that has the `main` method (the demo class, or the class named in the header comment).
Assignment 10 reads files such as `learners.csv`, so run it from inside its `exercises` folder.
The Assignment 11 app starts with `java LibraryApp` and saves its CSV files to a `data/` folder.

## Note
In Lab 6, the manual names Program 6.1 `Vehicle.java`, but the file contains `public class VehicleDemo`, so it is saved here as `VehicleDemo.java`.
