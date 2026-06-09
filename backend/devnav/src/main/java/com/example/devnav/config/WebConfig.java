package com.example.devnav.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * React開発サーバーからSpring Boot APIへアクセスするためのCORS設定。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Viteの開発サーバーから /api 配下へのアクセスを許可する。
     *
     * @param registry CORS設定を登録するためのオブジェクト
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*");
    }
}