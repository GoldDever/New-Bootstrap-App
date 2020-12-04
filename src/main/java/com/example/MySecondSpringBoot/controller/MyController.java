package com.example.MySecondSpringBoot.controller;

import com.example.MySecondSpringBoot.model.User;
import com.example.MySecondSpringBoot.service.RoleService;
import com.example.MySecondSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MyController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/")
    public String firstPage(Model model) {
        return "firstView";
    }

    @GetMapping(value = "/allUsers")
    public String showAllUsers(Model model) {
        model.addAttribute("usersAll", userService.findAll());
        return "allUsers";
    }

    @GetMapping(value = "/{id}")
    public String showOneUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("userByid", userService.findById(id));
        return "getUserById";
    }

    @GetMapping(value = "/addUser")
    public String giveNewUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.getAll());
        return "newuser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String editUser(Model model) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       User user = (User) auth.getPrincipal();
       model.addAttribute("userGotIn", user);
       model.addAttribute("users", userService.findAll());
       model.addAttribute("allRoles", roleService.getAll());
       return "bootstrapAdmin";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id ) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("page/user")
    public String showOverview(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("userGotIn", user);
        return "user";
    }
}

