package com.example.devnav.user;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
     /**
     * メールアドレスでユーザーを検索する。
     *
     * @param email メールアドレス
     * @return 該当するユーザー
     */
    Optional<AppUser> findByEmail(String email);


    Optional<AppUser> findByFirebaseUid(String firebaseUid);

    Optional<AppUser> findByRole(String role);




}
