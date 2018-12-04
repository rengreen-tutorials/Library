package pl.rengreen.library.books

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun getAvailableBooks() = bookRepository.findAll().filter { it.available }
}