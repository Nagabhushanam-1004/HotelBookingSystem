# 🏨 Online Room Booking System

A web-based hotel room booking application developed using **Java, JDBC, Servlets, JSP, HTML, CSS, and MySQL**.

This project allows users to book hotel rooms through a simple web interface. Booking details are stored in a MySQL database.

## 🚀 Features

- User-friendly hotel booking form.
- Guest name and email collection.
- Check-in date selection.
- Room selection with room prices.
- JDBC connectivity with MySQL.
- Automatic booking data insertion into the database.
- Room availability status update.
- Booking confirmation page.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| JDBC | Database connectivity |
| Jakarta Servlets | Request handling |
| JSP | Dynamic web pages |
| HTML | Web page structure |
| CSS | Styling |
| MySQL | Database |
| Apache Tomcat 10.1 | Web server |
| Eclipse IDE | Development environment |

## 📂 Project Structure

```text
HotelBookingSystem/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hotel/
│   │   │       ├── connection/
│   │   │       │   ├── DBConnection.java
│   │   │       │   └── DBTest.java
│   │   │       └── controller/
│   │   │           └── BookingServlet.java
│   │   │
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   ├── lib/
│   │       │   └── web.xml
│   │       ├── css/
│   │       │   └── style2.css
│   │       ├── index.html
│   │       ├── confirmation.jsp
│   │       └── style.css
│
├── .classpath
├── .project
└── .gitignore
```

## ⚙️ Requirements

Install the following software:

1. JDK
2. Eclipse IDE for Enterprise Java and Web Developers
3. Apache Tomcat 10.1
4. MySQL Server
5. MySQL Workbench
6. MySQL Connector/J

## 🗄️ Database Setup

Create a database in MySQL:

```sql
CREATE DATABASE hotel_db;

USE hotel_db;
```

Create the rooms table:

```sql
CREATE TABLE rooms (
    room_id INT PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL,
    room_type VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Available'
);
```

Create the bookings table:

```sql
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100) NOT NULL,
    guest_email VARCHAR(100) NOT NULL,
    room_id INT NOT NULL,
    check_in DATE NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);
```

Insert sample rooms:

```sql
INSERT INTO rooms
(room_id, room_number, room_type, price, status)
VALUES
(1, '101', 'Deluxe Single', 1500.00, 'Available'),
(2, '102', 'Executive Suite', 3500.00, 'Available'),
(3, '201', 'Luxury King', 5000.00, 'Available');
```

## 🔌 Database Configuration

Open:

`src/main/java/com/hotel/connection/DBConnection.java`

Configure your own local MySQL credentials.

```java
private static final String URL =
    "jdbc:mysql://localhost:3306/hotel_db";

private static final String USERNAME = "root";

private static final String PASSWORD =
    "YOUR_MYSQL_PASSWORD";
```

Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

**Security:** Never upload your actual database password to GitHub.

## ▶️ How to Run the Project

1. Clone or download this repository.
2. Import the project into Eclipse.
3. Configure Apache Tomcat 10.1.
4. Configure MySQL and create the `hotel_db` database.
5. Add MySQL Connector/J to the project if it is not already included.
6. Update the database credentials in `DBConnection.java`.
7. Run the project on the Tomcat server.
8. Open the application in your browser:

```text
http://localhost:8080/HotelBookingSystem/index.html
```

## 🧪 Testing Database Records

After making a booking, execute:

```sql
USE hotel_db;

SELECT * FROM bookings;
```

To check room availability:

```sql
SELECT * FROM rooms;
```

## 📸 Application Workflow

1. Open the hotel booking website.
2. Enter guest details.
3. Select a check-in date.
4. Choose a room.
5. Click Confirm Reservation.
6. View the booking confirmation.
7. Verify booking details in MySQL.

## 👨‍💻 Developer

**Yalagala Nagabhushanam**

B.Tech – Computer Science and Engineering

## 📌 Project Status

Developed as a Java Full Stack learning project.

---

⭐ If you find this project useful, consider giving this repository a star!
