package pl.rengreen.library.books

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAvailableBooks() = bookRepository.findAll().filter {
        it.available }

    fun getBookInfo(bookId: Long): BookDTO =
            with(bookRepository.findById(bookId)) {
                when {
                    this.isPresent -> this.get().toDTO()
                    else -> throw NoSuchElementException("Book with id $bookId does not exist")
                }
            }
}