// src/App.tsx

import { useEffect, useState } from "react";
import { fetchArticles } from "./api/articles";
import type { Article } from "./types/articles";

/**
 * アプリのメインコンポーネント。
 */
function App() {
  const [articles, setArticles] = useState<Article[]>([]);
  const [loading, setLoading] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");

  /**
   * 初回表示時に記事一覧を取得する。
   */
  useEffect(() => {
    const loadArticles = async () => {
      try {
        const articles = await fetchArticles();
        setArticles(articles);
      } catch (error) {
        setErrorMessage("記事一覧の取得に失敗しました");
      } finally {
        setLoading(false);
      }
    };

    loadArticles();
  }, []);

  if (loading) {
    return <p>読み込み中...</p>;
  }

  if (errorMessage) {
    return <p>{errorMessage}</p>;
  }

  return (
    <main>
      <h1>DevNav Handbook</h1>

      <section>
        <h2>記事一覧</h2>

        {articles.map((article) => (
          <article key={article.id}>
            <p>{article.category}</p>
            <h3>{article.title}</h3>
            <p>{article.summary}</p>
            <p>slug: {article.slug}</p>
          </article>
        ))}
      </section>
    </main>
  );
}

export default App;
