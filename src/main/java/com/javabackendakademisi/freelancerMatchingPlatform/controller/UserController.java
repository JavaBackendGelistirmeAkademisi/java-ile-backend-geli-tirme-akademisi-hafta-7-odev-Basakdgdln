package com.javabackendakademisi.freelancerMatchingPlatform.controller;

import com.javabackendakademisi.freelancerMatchingPlatform.model.User;
import com.javabackendakademisi.freelancerMatchingPlatform.model.request.UserRequestDTO;
import com.javabackendakademisi.freelancerMatchingPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Kullanıcı işlemleri için kontrolcü sınıfı
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Yeni kullanıcı ekleme işlemi
    @PostMapping("/add")
    public User addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        // DTO'dan User modeline dönüştürme
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        return userService.addUser(user);
    }

    // Tüm kullanıcıları listeleme işlemi
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Belirli bir kullanıcıyı ID ile getirme işlemi
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
