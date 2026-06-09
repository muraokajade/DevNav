// src/types/article.ts

/**
 * Spring Bootから取得する記事情報の型。
 */
export type Article = {
  id: number;
  title: string;
  slug: string;
  category: string;
  summary: string;
  content: string;
  createdAt: string;
  updatedAt: string;
};
