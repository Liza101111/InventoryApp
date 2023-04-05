package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Role;
import com.springboot.inventoryapp.entity.User;
import com.springboot.inventoryapp.repository.RoleRepository;
import com.springboot.inventoryapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String listUsers(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("users", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("listRoles", roleList);
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable("id") Integer id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        List<Role> roleList = roleRepository.findAll();
        model.addAttribute("listRoles", roleList);
        return "create_user";
    }
}
