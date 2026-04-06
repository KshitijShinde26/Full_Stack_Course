package com.basic_spring.demo.controller;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.services.AccountService;
import com.basic_spring.demo.services.EmailService;
import com.basic_spring.demo.util.EmailDetails;

@Controller
public class AuthController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmailService emailService;

    // Forgot page
    @GetMapping("/forgot")
    public String forgotPage() {
        return "forgot";
    }

    // Send email
    @PostMapping("/forgot")
    public String sendResetLink(@RequestParam String email, Model model) {

        Optional<Account> optional = accountService.findByEmail(email);

        if(optional.isEmpty()) {
            model.addAttribute("error", "Email not found");
            return "forgot";
        }

        Account account = optional.get();

        String token = UUID.randomUUID().toString();

        account.setPasswordResetToken(token);
        account.setPasswordResetExpiry(LocalDateTime.now().plusMinutes(10));

        accountService.save(account);

        String link = "http://localhost:8080/change-password?token=" + token;

        EmailDetails emailDetails = new EmailDetails(
                account.getEmail(),
                "Reset Password",
                "Click here: " + link
        );

        emailService.sendEmail(emailDetails);

        model.addAttribute("message", "Email sent!");
        return "forgot";
    }

    // Validate token
    @GetMapping("/change-password")
    public String changePasswordPage(@RequestParam String token, Model model) {

        Optional<Account> optional = accountService.findByPasswordResetToken(token);

        if(optional.isEmpty()) return "error";

        Account acc = optional.get();

        if(LocalDateTime.now().isAfter(acc.getPasswordResetExpiry())) {
            return "error";
        }

        model.addAttribute("account", acc);
        return "change_password";
    }

    // Update password
    @PostMapping("/change-password")
    public String updatePassword(@ModelAttribute Account account, Model model) {

        Account acc = accountService.findById(account.getId()).get();

        acc.setPassword(account.getPassword());
        acc.setPasswordResetToken(null);

        accountService.save(acc);

        model.addAttribute("message", "Password updated");
        return "login";
    }
}