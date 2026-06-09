package com.example.devnav.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;


    /**
     * 記事一覧を取得する。
     *
     * @return 記事一覧レスポンス
     */
    public List<ArticleResponse> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
//                .map(article -> new ArticleResponse(
//                        article.getId(),
//                        article.getTitle(),
//                        article.getSlug(),
//                        article.getCategory(),
//                        article.getSummary(),
//                        article.getContent(),
//                        article.getCreatedAt(),
//                        article.getUpdatedAt()
//                )).toList();
    }

    /**
     * slugで記事を1件取得する。
     *
     * @param slug URLなどで利用する記事識別子
     * @return 記事詳細レスポンス
     */
    public ArticleResponse findBySlug(String slug) {
        Article article = articleRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("記事が見つかりませんでした。"));

//        return new ArticleResponse(
//                article.getId(),
//                article.getTitle(),
//                article.getSlug(),
//                article.getCategory(),
//                article.getSummary(),
//                article.getContent(),
//                article.getCreatedAt(),
//                article.getUpdatedAt()
//        );
        return toResponse(article);
    }

    /**
     * 記事を新規作成する。
     *
     * @param request 記事作成リクエスト
     * @return 作成した記事レスポンス
     */

    public ArticleResponse create(ArticleCreateRequest request) {
        Article article = new Article(
                request.getTitle(),
                request.getSlug(),
                request.getCategory(),
                request.getSummary(),
                request.getContent()
        );

        Article savedArticle = articleRepository.save(article);

//        return new ArticleResponse(
//                savedArticle.getId(),
//                savedArticle.getTitle(),
//                savedArticle.getSlug(),
//                savedArticle.getCategory(),
//                savedArticle.getSummary(),
//                savedArticle.getContent(),
//                savedArticle.getCreatedAt(),
//                savedArticle.getUpdatedAt()
//        );

        return toResponse(savedArticle);
    }

    /**
     * カテゴリで記事一覧を検索する。
     *
     * @param category 記事カテゴリ
     * @return 記事一覧レスポンス
     */
    public List<ArticleResponse> findByCategory(String category) {
        return articleRepository.findByCategory(category)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * タイトルにキーワードを含む記事一覧を検索する。
     *
     * @param keyword 検索キーワード
     * @return 記事一覧レスポンス
     */

    public List<ArticleResponse> findByKeyword(String keyword) {
        return articleRepository.findByKeyword(keyword)
                .stream()
                .map(this::toResponse)
                .toList();
    }




    /**
     * Article EntityをArticleResponse DTOへ変換する。
     *
     * @param article 記事Entity
     * @return 記事レスポンス
     */
    private ArticleResponse toResponse(Article article){
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getSlug(),
                article.getCategory(),
                article.getSummary(),
                article.getContent(),
                article.getCreatedAt(),
                article.getUpdatedAt()
        );
    }



}
