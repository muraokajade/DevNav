import type { AppUser } from "../types/user";

/**
 * 管理者ユーザーを取得する。
 *
 * @returns 管理者ユーザー情報
 */
export const fetchAdminUser = async (): Promise<AppUser> => {
  const response = await fetch("http://localhost:8080/api/users/admin");

  if (!response.ok) {
    throw new Error("管理者ユーザーの取得に失敗しました");
  }

  return response.json();
};
