package com.example.devnav.article;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * articlesテーブルを操作するRepository。
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    /**
     * slugで記事を検索する。
     *
     * @param slug URLなどで利用する記事識別子
     * @return 該当する記事
     */
    Optional<Article> findBySlug(String slug);

    /**
     * カテゴリで記事一覧を検索する。
     *
     * @param category 記事カテゴリ
     * @return 該当する記事一覧
     */
    @Query("SELECT a FROM Article a WHERE a.category = :category")
    List<Article> findByCategory(@Param("category") String category);

    /**
     * タイトルにキーワードを含む記事一覧を検索する。
     *
     * @param keyword 検索キーワード
     * @return 該当する記事一覧
     */
    @Query("SELECT a FROM Article a WHERE a.title LIKE %:keyword%")
    List<Article> findByKeyword(@Param("keyword") String keyword);

}