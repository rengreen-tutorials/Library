package pl.rengreen.library.books
import org.springframework.web.bind.annotation.*
import pl.rengreen.library.books.BookService

@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {
    @GetMapping("/")
    fun getAvailableBooks() = bookService.getAvailableBooks()
}