package pl.wsb.fitnesstracker.user.internal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDate;
import java.util.List;

/**
 * UserController is responsible for handling HTTP requests related to user operations.
 */
@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserService userService;
    private final UserProvider userProvider;
    private final UserMapper userMapper;

    UserController(UserService userService, UserProvider userProvider, UserMapper userMapper) {
        this.userService = userService;
        this.userProvider = userProvider;
        this.userMapper = userMapper;
    }

    /**
     * Returns all users with full basic data.
     */
    @GetMapping
    public List<UserDto> getUsers() {
        return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    /**
     * Returns simplified list of users.
     */
    @GetMapping("/simple")
    public List<UserDto> getSimpleUsers() {
        return this.userProvider.findAllUsers().stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    /**
     * Returns user details by ID.
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = this.userProvider.getUser(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " does not exist"));

        return this.userMapper.toUserDto(user);
    }

    /**
     * Searches users by e-mail fragment.
     */
    @GetMapping("/email")
    public List<UserDto> getUsersByEmail(@RequestParam String email) {
        return this.userProvider.findUsersByEmailContainingIgnoreCase(email).stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    /**
     * Returns users born before provided date.
     */
    @GetMapping("/older/{time}")
    public List<UserDto> getUsersOlderThan(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate time
    ) {
        return this.userProvider.findUsersOlderThan(time).stream()
                .map(this.userMapper::toUserDto)
                .toList();
    }

    /**
     * Creates a new user.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = this.userMapper.toUser(userDto);
        User createdUser = this.userService.createUser(user);

        return this.userMapper.toUserDto(createdUser);
    }

    /**
     * Deletes user by ID.
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
    }

    /**
     * Updates user by ID.
     */
    @PutMapping("/{userId}")
    public UserDto updateUser(
            @PathVariable Long userId,
            @RequestBody UserDto userDto
    ) {
        User user = this.userMapper.toUser(userDto);
        User updatedUser = this.userService.updateUser(userId, user);

        return this.userMapper.toUserDto(updatedUser);
    }
}
