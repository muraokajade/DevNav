package com.example.devnav.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleUpdateRequest {
    private String title;
    private String slug;

    private String category;

    private String summary;

    private String content;
}
