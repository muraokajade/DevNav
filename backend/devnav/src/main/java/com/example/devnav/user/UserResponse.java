package com.example.devnav.user;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー情報をAPIレスポンスとして返すためのDTO。
 */
@Getter
@AllArgsConstructor
public class UserResponse {

    /**
     * ユーザーID。
     */
    private Long id;

    /**
     * Firebase AuthenticationのUID。
     */
    private String firebaseUid;

    /**
     * メールアドレス。
     */
    private String email;

    /**
     * 表示名。
     */
    private String displayName;

    /**
     * アプリ側の権限。
     */
    private String role;

    /**
     * 作成日時。
     */
    private LocalDateTime createdAt;
}