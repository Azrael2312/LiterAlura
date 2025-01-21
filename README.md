# LiterAlura

The **Book Catalog Application** is a Java-based Spring Boot project that allows users to manage a catalog of books. The application includes features to search for books online using the Gutendex API, view saved books, and add new books to the catalog.

## Features

1. **Search Books Online**:
    - Query books from the Gutendex API based on a search term.
    - Display results including the title, author, and language.

2. **View Saved Books**:
    - Retrieve and display all books saved in the local catalog.

3. **Add a New Book**:
    - Save a new book to the catalog by providing title, author, language, and published date.

4. **Exit the Application**:
    - Gracefully terminate the program.

---

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for application development.
    - Spring Data JPA for database interaction.
    - RestTemplate for making HTTP requests.
- **PostgreSQL**: Database for storing saved books.
- **Lombok**: Reduces boilerplate code by generating getters, setters, and other methods.
- **Maven**: Build and dependency management.

---

## Installation and Setup

### Prerequisites

1. **Java Development Kit (JDK)**
    - Ensure JDK 17 or above is installed.

2. **PostgreSQL Database**
    - Set up a PostgreSQL database and create a database named `book_catalog`.
    - Provide environment variables for database connection:
      ```bash
      DB_USERNAME=<your_username>
      DB_PASSWORD=<your_password>
      ```

3. **Maven**
    - Ensure Maven is installed for building the project.

---

### Steps to Run the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd book-catalog
   ```

2. Configure the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/book_catalog
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Interact with the application in the terminal.

---

## Usage Instructions

1. Launch the application and choose an option from the menu.

    - **Option 1**: Search for books online by entering a search query.
    - **Option 2**: View a list of all saved books.
    - **Option 3**: Add a new book to the catalog by entering the book's details.
    - **Option 0**: Exit the program.

2. Follow the prompts to perform your desired actions.

---

## Example Menu

```
Book Catalog Options:
1 - Buscar libro por título
2 - Listar libros registrados
3 - Guardar un nuevo libro
0 - Salir

Ingrese su opción:
```

---

## Future Enhancements

- Add support for multiple authors per book.
- Improve error handling and user feedback.
- Add integration tests.

---

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

