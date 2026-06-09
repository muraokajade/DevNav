package com.example.devnav.article;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 記事情報を表すEntity。
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "articles")
public class Article {

    /**
     * 記事ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 記事タイトル。
     */
    @Column(nullable = false)
    private String title;

    /**
     * URLなどで利用する記事識別子。
     */
    @Column(nullable = false, unique = true)
    private String slug;

    /**
     * 記事カテゴリ。
     */
    @Column(nullable = false)
    private String category;

    /**
     * 記事概要。
     */
    @Column(columnDefinition = "TEXT")
    private String summary;

    /**
     * 記事本文。
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 作成日時。
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * 更新日時。
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * アプリ側で新しいArticleを作成するためのコンストラクタ。
     *
     * @param title 記事タイトル
     * @param slug URLなどで利用する記事識別子
     * @param category 記事カテゴリ
     * @param summary 記事概要
     * @param content 記事本文
     */
    public Article(String title, String slug, String category, String summary, String content) {
        this.title = title;
        this.slug = slug;
        this.category = category;
        this.summary = summary;
        this.content = content;
    }
}