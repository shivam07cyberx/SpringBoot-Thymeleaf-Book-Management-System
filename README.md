# 📚 Spring Boot Thymeleaf Book Management System

A full-stack Book Management System developed using **Spring Boot**, **Thymeleaf**, **Spring Security**, **Spring Data JPA**, and **MySQL**. The application provides role-based authentication and authorization with separate functionalities for Admin and User.

---

## 🚀 Features

### 👨‍💼 Admin
- Secure Login
- Add New Books
- Update Book Details
- Delete Books
- View All Books
- Search Books
- Manage Book Inventory

### 👤 User
- Register & Login
- View Available Books
- Search Books
- Access Profile
- Role-Based Access Control

---

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA (Hibernate)
- Thymeleaf
- MySQL
- Maven
- HTML5
- CSS3
- Bootstrap

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── security
│   │   └── config
│   └── resources
│       ├── templates
│       ├── static
│       └── application.properties
```

---

## 🔐 Authentication & Authorization

- Spring Security
- BCrypt Password Encryption
- Role-Based Authorization
    - ADMIN
    - USER
- Custom Login Page
- Secure URL Access

---

## 💾 Database

- MySQL
- Spring Data JPA
- Hibernate ORM

---

## 📸 Screenshots

Add screenshots here.

Example:

```
screenshots/
├── login.png
├── dashboard.png
├── add-book.png
└── books.png
```

---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/your-username/your-repository.git
```

### Open Project

Import the project into IntelliJ IDEA or Eclipse.

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

### Run Application

```bash
mvn spring-boot:run
```

Open

```
http://localhost:8080
```

---

## 📚 Future Improvements

- Book Image Upload
- Pagination
- Sorting
- Book Categories
- Borrow & Return Books
- Email Notifications
- REST API
- JWT Authentication

---

## 👨‍💻 Author

**Shivam Pal**

GitHub: https://github.com/shivam07cyberx

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ on GitHub.
