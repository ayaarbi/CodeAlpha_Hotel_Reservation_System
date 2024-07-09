# Hotel Reservation System

## Overview
For the CodeAlpha intership, The Hotel Reservation System is a comprehensive Java application designed to facilitate hotel room reservations. Users can search for available rooms, make reservations, view booking details, and manage their profile. .

## Features
- **User Authentication:** Secure login and sign-up functionality.
- **Room Search:** Search for available rooms based on various criteria.
- **Room Categorization:** Rooms are categorized by type, price, and amenities.
- **Booking Management:** Make new reservations and view booking history.
- **Profile Management:** Users can view and update their profile information.
- **Payment Processing:** Secure payment processing for room bookings.
- **Room Availability:** Real-time room availability status displayed.

## Technologies Used
- **Java:** Core language for the application.
- **JavaFX:** Used for building the user interface.
- **MySQL:** Database management for storing user, room, and booking information.
- **JDBC:** Java Database Connectivity for database operations.

## Setup Instructions
### Prerequisites
- JDK 8 or higher
- MySQL server (as WampServer for Windows)
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Steps to Setup
1. **Clone the Repository:**
    ```sh
    git clone https://github.com/yourusername/hotel-reservation-system.git
    ```
2. **Import the Project:**
    - Open your preferred IDE.
    - Import the project as a Maven project.

3. **Database Setup:**
    - Create a MySQL database named `reservation`.
    - Execute the SQL scripts in the `reservation.sql` located in the main folder to create the necessary tables.

4. **Update Database Configuration:**
    - Open the `src/main/java/DAO/DBConnector` file.
    - Update the database URL, username, and password as per your MySQL setup.

    ```properties
    db.url=jdbc:mysql://localhost:3306/reservation
    db.username=root
    db.password=yourpassword
    ```

5. **Run the Application:**
    - Locate the main class `App.java` in the `src/main/java/CodeAlpha/CodeAlpha_Hotel_Reservation_System` directory.
    - Run the main class to start the application.

## Usage
1. **User Registration:**
    - Open the application and navigate to the Sign-Up page.
    - Fill in the required details to create a new account.

2. **Login:**
    - Enter your credentials on the Login page to access the system.

3. **Room Search and Booking:**
    - Select an available room and proceed with the booking process.
    - Make a payment to confirm the reservation.

4. **View Bookings:**
    - Navigate to the Booking History page to view your past and current reservations.


Enjoy using the Hotel Reservation System! Your feedback and suggestions are highly appreciated.
