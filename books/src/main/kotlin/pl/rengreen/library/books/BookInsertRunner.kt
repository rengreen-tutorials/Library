package pl.rengreen.library.books

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
@Service
class BookInsertRunner(private val bookRepository: BookRepository):
        CommandLineRunner {

    override fun run(vararg args: String?) {
        bookRepository.saveAll(listOf(
                Book(1, "Clean Code", "Robert C. Martin", 2008, true),
                Book(2, "The Software Craftsman", "Sandro Mancuso", 2014, true),
                Book(3, "Grokking Algorithms", "Aditya Y. Bhargava", 2015, true),
                Book(4, "Java: A Beginner's Guide", "Herbert Schildt", 2017, true),
                Book(5, "Java: The Complete Reference", "Herbert Schildt", 2018, true),
                Book(6, "Effective Java", "Joshua Bloch", 2017, true),
                Book(7, "Implementing Domain-Driven Design", "Vaughn Vernon", 2013, true),
                Book(8, "Data Structures and Algorithms in Java", "Robert Lafore", 2017, false),
                Book(9, "Think Like a Programmer", "V. Anton Spraul", 2012, false),
                Book(10, "Data Structures and Algorithms Made Easy", "Narasimha Karumanchi", 2017, true)
        ))
        println("Books in database ${bookRepository.count()}")
    }
}

