package com.example.devnav.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final AppUserRepository appUserRepository;

    @GetMapping("/users")
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @GetMapping ("/users/admin")
    public AppUser findAdmin() {
        return appUserRepository.findByRole("ADMIN")
                .orElseThrow(() -> new RuntimeException("管理者ユーザーが見つかりません。"));
    }
}
