package com.example.devnav.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public List<ArticleResponse> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/articles/{slug}")
    public ArticleResponse findBySlug(@PathVariable String slug){
        return articleService.findBySlug(slug);
    }

    /**
     * 記事を新規作成する。
     *
     * @param request 記事作成リクエスト
     * @return 作成した記事レスポンス
     */
    @PostMapping("/articles")
    public ArticleResponse create(@RequestBody ArticleCreateRequest request) {
        return articleService.create(request);
    }
    /**
     * カテゴリで記事一覧を検索する。
     *
     * @param category 記事カテゴリ
     * @return 記事一覧レスポンス
     */
    @GetMapping("/articles/category/{category}")
    public List<ArticleResponse> findByCategory(@PathVariable String category) {
        return articleService.findByCategory(category);
    }

    /**
     * タイトルにキーワードを含む記事一覧を検索する。
     *
     * @param keyword 検索キーワード
     * @return 記事一覧レスポンス
     */
    @GetMapping("/articles/search")
    public List<ArticleResponse> searchByTitle(@RequestParam String keyword) {
        return articleService.findByKeyword(keyword);
    }
    /**
     * 記事を更新する。
     *
     * @param id 記事ID
     * @param request 記事更新リクエスト
     * @return 更新後の記事レスポンス
     */

    @PutMapping("/articles/{id}")
    public ArticleResponse update(@PathVariable Long id,
                                  @RequestBody ArticleUpdateRequest request) {
        return articleService.update(id,request);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
