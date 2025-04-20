# Train Booking System

A Java-based command-line application for managing train bookings using custom singly linked lists. This project is part of a university Data Structures and Algorithms (DSA) assignment.

## Features

### Train Management
- Load train data from a file (`trains.txt`)
- Add train to the beginning, end, or a specific position in the list
- Display all trains
- Save train data to file
- Search trains by `tcode` or name
- Delete trains by `tcode` or position
- Sort trains by `tcode`
- View all passengers who booked a specific train

### Passenger Management
- Load passenger data from a file (`passengers.txt`)
- Add new passenger
- Display all passengers
- Save passenger data to file
- Search by `pcode` or name
- Delete passengers by `pcode`
- View all trains booked by a passenger

### Booking Management
- Load booking data from file (`bookings.txt`)
- Create new booking with validation
- Display all bookings
- Save booking data to file
- Sort bookings by `tcode` and `pcode`
- Mark a booking as paid

## Technologies Used
- Java (Standard Edition)
- File I/O with `BufferedReader` and `FileWriter`
- Custom implementation of singly linked lists
- Date formatting using `SimpleDateFormat`

## Project Structure
```
├── TrainBookingSystem.java     # Main class with menu system
├── trains.txt                  # Train data file
├── passengers.txt              # Passenger data file
├── bookings.txt                # Booking data file
└── README.md                   # Project documentation
```

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/train-booking-system.git
   cd train-booking-system
   ```
2. Compile and run the project:
   ```bash
   javac TrainBookingSystem.java
   java TrainBookingSystem
   ```
3. Follow the menu instructions to interact with the system.

## Sample Data Format

### trains.txt
```
T01,Express,A,B,9.00,12.00,100,20
T02,Local,B,C,13.00,16.00,80,10
```

### passengers.txt
```
P01,Alice,1234567890
P02,Bob,0987654321
```

### bookings.txt
```
T01,P01,2025-04-20,0,2
T02,P02,2025-04-20,1,1
```
