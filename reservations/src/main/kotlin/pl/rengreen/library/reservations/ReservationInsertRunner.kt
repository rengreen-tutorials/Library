package pl.rengreen.library.reservations

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ReservationInsertRunner(
        private val reservationRepository: ReservationRepository,
        private val userRepository: UserRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val users = listOf(
                User(1, "Piotr Kozak"),
                User(2, "Malwina Nowak"),
                User(3, "Krzysztof Zabielski"),
                User(4, "Andrzej Majewski"),
                User(5, "Anna Kowalska"),
                User(6, "Karolina Szewczyk")
        )
        userRepository.saveAll(users)
        val now = LocalDateTime.now()
        reservationRepository.saveAll(listOf(
                Reservation(0, now, now.plusDays(10), 1, users[0]),
                Reservation(0, now, now.plusDays(15), 2, users[1]),
                Reservation(0, now, now.plusDays(25), 3, users[2]),
                Reservation(0, now, now.plusDays(15), 3, users[4])
        ))
    }
}