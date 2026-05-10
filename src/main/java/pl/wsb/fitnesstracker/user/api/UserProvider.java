package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserProvider {

    /**
     * Retrieves a user based on their ID.
     *
     * @param userId id of the user to be searched
     * @return An Optional containing the located user, or Optional.empty if not found
     */
    Optional<User> getUser(Long userId);

    /**
     * Retrieves a user based on their email.
     *
     * @param email The email of the user to be searched
     * @return An Optional containing the located user, or Optional.empty if not found
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Retrieves all users.
     *
     * @return all users
     */
    List<User> findAllUsers();

    /**
     * Searches users by e-mail fragment, ignoring letter case.
     *
     * @param email e-mail fragment
     * @return matching users
     */
    List<User> findUsersByEmailContainingIgnoreCase(String email);

    /**
     * Finds users older than the provided date.
     *
     * @param date boundary date
     * @return users born before the provided date
     */
    List<User> findUsersOlderThan(LocalDate date);
}
