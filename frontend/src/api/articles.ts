// src/api/articles.ts

import type { Article } from "../types/articles";

/**
 * 記事一覧を取得する。
 *
 * @returns 記事一覧
 */
export const fetchArticles = async (): Promise<Article[]> => {
  const response = await fetch("http://localhost:8080/api/articles");

  if (!response.ok) {
    throw new Error("記事一覧の取得に失敗しました");
  }

  return response.json();
};
