package com.example.devnav.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firebase_uid", nullable = false, unique = true)
    private String firebaseUid;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "display_name")
    private String displayName;

    @Column(nullable = false)
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * Firebase認証済みユーザーからAppUserを生成する。
     *
     * @param firebaseUid Firebase AuthenticationのUID
     * @param email メールアドレス
     * @param displayName 表示名
     * @param role アプリ側の権限
     */
    public AppUser(String firebaseUid, String email, String displayName, String role) {
        this.firebaseUid = firebaseUid;
        this.email = email;
        this.displayName = displayName;
        this.role = role;
    }
}
