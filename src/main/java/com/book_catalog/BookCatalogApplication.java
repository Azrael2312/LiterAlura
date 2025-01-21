package com.book_catalog;

import com.book_catalog.model.Book;
import com.book_catalog.model.GutendexBook;
import com.book_catalog.service.BookService;
import com.book_catalog.service.GutendexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookCatalogApplication implements CommandLineRunner {

	private final GutendexService gutendexService;
	private final BookService bookService;

	public BookCatalogApplication(GutendexService gutendexService, BookService bookService) {
		this.gutendexService = gutendexService;
		this.bookService = bookService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogApplication.class, args);
	}

	private void displayMenu() {
		System.out.println("-----------");
		System.out.println("Elija la opción a través de su número:");
		System.out.println("1 - Buscar libro por título");
		System.out.println("2 - Listar libros registrados");
		System.out.println("3 - Guardar un nuevo libro");
		System.out.println("0 - Salir");
		System.out.println("-----------");
		System.out.print("Ingrese su opción: ");
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
				case 1 -> {
					System.out.print("Ingrese el título a buscar: ");
					String query = scanner.nextLine();
					List<GutendexBook> results = gutendexService.searchBooks(query);

					if (results == null || results.isEmpty()) {
						System.out.println("No se encontraron libros para la consulta: " + query);
					} else {
						System.out.println("Resultados de la búsqueda:");
						results.forEach(book -> System.out.println("Título: " + book.getTitle() + ", Autor: " + book.getAuthor()));
					}
				}

				case 2 -> {
					List<Book> savedBooks = bookService.getAllBooks();

					if (savedBooks.isEmpty()) {
						System.out.println("No hay libros guardados.");
					} else {
						System.out.println("Libros registrados:");
						savedBooks.forEach(book -> System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Autor: " + book.getAuthor()));
					}
				}

				case 3 -> {
					System.out.print("Ingrese el título del libro: ");
					String title = scanner.nextLine();
					System.out.print("Ingrese el autor del libro: ");
					String author = scanner.nextLine();
					System.out.print("Ingrese el idioma del libro: ");
					String language = scanner.nextLine();
					System.out.print("Ingrese la fecha de publicación: ");
					String publishedDate = scanner.nextLine();

					Book newBook = new Book();
					newBook.setTitle(title);
					newBook.setAuthor(author);
					newBook.setLanguage(language);
					newBook.setPublishedDate(publishedDate);

					Book savedBook = bookService.saveBook(newBook);
					System.out.println("Libro guardado con éxito con ID: " + savedBook.getId());
				}

				case 0 -> {
					System.out.println("¡Adiós!");
					System.exit(0);
				}

				default -> System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
	}
}
