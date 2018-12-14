package pl.rengreen.library.books

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAvailableBooks() = bookRepository.findAll().filter {
        it.available
    }

    fun getBookInfo(bookId: Long): BookDTO =
            with(bookRepository.findById(bookId)) {
                when {
                    this.isPresent -> this.get().toDTO()
                    else -> throw NoSuchElementException("Book with id $bookId does not exist")
                }
            }

    fun isBookAvailable(bookId: Long) = with(bookRepository.findById(bookId)) {
        when {
            this.isPresent -> this.get().available
            else -> throw NoSuchElementException("Book with id $bookId does not exist")
        }
    }

    fun addBook(title: String, author: String, publicationYear: Int) =
            bookRepository.save(Book(0, title, author, publicationYear, true))
}