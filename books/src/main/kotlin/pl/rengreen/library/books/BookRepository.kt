package pl.rengreen.library.books

import org.springframework.data.jpa.repository.JpaRepository
interface BookRepository: JpaRepository<Book, Long>