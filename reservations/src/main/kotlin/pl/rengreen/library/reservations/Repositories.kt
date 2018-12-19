package pl.rengreen.library.reservations

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
interface ReservationRepository: JpaRepository<Reservation, Long>