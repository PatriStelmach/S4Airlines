# S4Airlines

## Overview
S4Airlines is a pure Java 21 console application for managing airline routes and seat availability over time with the criteria of working as fast as possible. 
It reads the number of planes (N) and commands (Q), supports dynamic updates to passenger counts, route capacities, and deactivations, and answers range queries for available seats on a given day.
The input command input must be in chronological order.
All logic is implemented with vanilla Java—no frameworks—and high‐performance I/O is handled via a custom `FastReader` utility.

## Features
- **Dynamic seat management**  
  - **P** _i_ _p_ _t_ – increase passengers on plane _i_ by _p_ at day _t_  
  - **A** _i_ _p_ _t_ – add new rout of plane _i_ e with capacity of _p_ at day _t_  
  - **C** _i_ _t_ – deactivate plane _i_ from day _t_ onward  
- **Range queries**  
  - **Q** _i_ _j_ _t_ – sum of available seats from planes _i_ to _j_ to day _t_  
- **Efficient I/O** via `FastReader` (buffered parsing from `System.in`)  
- dependencie*: only JDK 21 and JUnit 5 and mockito for testing 
## Repository Structure

S4Airlines/
├── pom.xml # Maven config (Java 21)
└── src/
├── main/java/org/example/
│ ├── App.java # Entry point; orchestrates I/O & commands
│ ├── FastReader.java # High‐speed console reader
│ └── Models/
│ ├── Plane.java # Manages per‐plane state & operations
│ └── Flight.java # Tracks passenger periods internally
└── test/java/org/example/
├── FlightTests.java
├── PlaneTests.java
├── IntegrationTests.java
└── SystemTests.java #System test via mocking standard input and output


## Requirements
- **Java 21 JDK** (must be on your `PATH`)
- **Maven 3.6+** (for build & dependency management)
  
## Installation & Build
1. **Clone the repo**  
   ```bash
   git clone https://github.com/PatriStelmach/S4Airlines.git
   cd S4Airlines

2. Build
   mvn clean build -> builds a runnable JAR file

   
License

No license is specified. This project is free for anyone to use, modify, and distribute without restriction.
