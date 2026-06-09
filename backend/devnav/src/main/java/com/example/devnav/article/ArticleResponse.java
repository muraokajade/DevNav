package com.example.devnav.article;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 記事情報をAPIレスポンスとして返すためのDTO。
 */
@Getter
@AllArgsConstructor
public class ArticleResponse {

    /**
     * 記事ID。
     */
    private Long id;

    /**
     * 記事タイトル。
     */
    private String title;

    /**
     * URLなどで利用する記事識別子。
     */
    private String slug;

    /**
     * 記事カテゴリ。
     */
    private String category;

    /**
     * 記事概要。
     */
    private String summary;

    /**
     * 記事本文。
     */
    private String content;

    /**
     * 作成日時。
     */
    private LocalDateTime createdAt;

    /**
     * 更新日時。
     */
    private LocalDateTime updatedAt;
}