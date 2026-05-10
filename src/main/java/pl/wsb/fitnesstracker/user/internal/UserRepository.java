package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Query searching users by email address. It matches by exact match.
     *
     * @param email email of the user to search
     * @return Optional containing found user or Optional.empty if none matched
     */
    default Optional<User> findByEmail(String email) {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }

    /**
     * Searches users by e-mail fragment, ignoring letter case.
     *
     * @param email e-mail fragment
     * @return matching users
     */
    default List<User> findByEmailContainingIgnoreCase(String email) {
        String searchedText = email == null ? "" : email.toLowerCase(Locale.ROOT);

        return findAll().stream()
                .filter(user -> user.getEmail() != null)
                .filter(user -> user.getEmail().toLowerCase(Locale.ROOT).contains(searchedText))
                .toList();
    }

    /**
     * Finds users born before provided date.
     *
     * @param date boundary date
     * @return users older than provided date
     */
    default List<User> findUsersOlderThan(LocalDate date) {
        return findAll().stream()
                .filter(user -> user.getBirthdate() != null)
                .filter(user -> user.getBirthdate().isBefore(date))
                .toList();
    }
}
