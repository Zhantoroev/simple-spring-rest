package simple.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newEmp) {
        return repository.save(newEmp);
    }

    @PutMapping("/users/{id}")
    User put(@RequestBody User replaceUser, @PathVariable Long id) {
        return repository.findById(id).map(employee -> {
            employee = replaceUser;
            employee.setId(id);
            return repository.save(employee);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    void del(@PathVariable Long id) {
        repository.deleteById(id);
    }
}