package pl.wsb.fitnesstracker.user.api;

/**
 * Interface for modifying operations on User entities.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user The user to be created
     * @return The created user
     */
    User createUser(User user);

    /**
     * Updates an existing user.
     *
     * @param userId ID of the user to update
     * @param user New user data
     * @return Updated user
     */
    User updateUser(Long userId, User user);

    /**
     * Deletes an existing user.
     *
     * @param userId ID of the user to delete
     */
    void deleteUser(Long userId);
}
