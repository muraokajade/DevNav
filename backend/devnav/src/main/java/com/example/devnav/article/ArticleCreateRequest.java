package com.example.devnav.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 記事作成APIのリクエストDTO。
 */
@Getter
@NoArgsConstructor
public class ArticleCreateRequest {

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
}