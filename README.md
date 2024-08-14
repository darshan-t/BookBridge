# BookBridge

BookBridge is a web application built using Spring Boot, MySQL, Thymeleaf, HTML, and CSS (Bootstrap). The application provides a platform for managing a library system, enabling CRUD (Create, Read, Update, Delete) operations for books, authors, publishers, and categories.

## Features

- **CRUD Operations**: Efficiently manage books, authors, publishers, and categories with RESTful APIs.
- **Dynamic Web Pages**: Thymeleaf is used to create dynamic, user-friendly web pages.
- **Database Management**: MySQL is utilized for storing and managing data securely and efficiently.
- **Responsive Design**: The front-end is styled using Bootstrap, ensuring a responsive and modern design.

## Technologies Used

- **Spring Boot**: For building the application with a focus on RESTful API design.
- **MySQL**: For database management and efficient data storage.
- **Thymeleaf**: For rendering dynamic web pages.
- **HTML/CSS (Bootstrap)**: For the front-end design, ensuring a responsive and user-friendly interface.

## Getting Started

### Prerequisites

- Java 11 or later
- MySQL 8.0 or later
- Maven 3.6 or later

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/BookBridge-W.git
    cd BookBridge-W
    ```

2. **Set up the MySQL database:**

    - Create a new database:

    ```sql
    CREATE DATABASE bookbridge;
    ```

    - Update the `application.properties` file with your MySQL credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/bookbridge
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Build and run the application:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Access the application:**

    Open your browser and go to `http://localhost:8080`.

## Usage

Once the application is running, you can perform the following actions:

- **Manage Books**: Add, update, view, and delete books.
- **Manage Authors**: Add, update, view, and delete authors.
- **Manage Publishers**: Add, update, view, and delete publishers.
- **Manage Categories**: Add, update, view, and delete categories.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring Boot, MySQL, Thymeleaf, and Bootstrap communities for their fantastic documentation and tools.
