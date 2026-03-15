package com.gyqstd.visualassets.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康检查接口
 * @author GuYuqi
 * @version 1.0
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * 基础健康检查
     * @return 健康状态
     */
    @GetMapping
    public Map<String, Object> health() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "UP");
        result.put("timestamp", LocalDateTime.now());
        return result;
    }

    /**
     * 详细健康检查
     * @return 详细健康信息
     */
    @GetMapping("/detail")
    public Map<String, Object> healthDetail() {
        Map<String, Object> result = new HashMap<>(16);
        result.put("status", "UP");
        result.put("application", "VisualAssets");
        result.put("version", "0.0.1-SNAPSHOT");
        result.put("timestamp", LocalDateTime.now());

        // 系统信息
        Map<String, Object> system = new HashMap<>(4);
        system.put("javaVersion", System.getProperty("java.version"));
        system.put("osName", System.getProperty("os.name"));
        system.put("osVersion", System.getProperty("os.version"));
        system.put("processors", Runtime.getRuntime().availableProcessors());
        result.put("system", system);

        // JVM内存信息
        Runtime runtime = Runtime.getRuntime();
        Map<String, Object> jvm = new HashMap<>(4);
        jvm.put("totalMemory", runtime.totalMemory() / 1024 / 1024 + " MB");
        jvm.put("freeMemory", runtime.freeMemory() / 1024 / 1024 + " MB");
        jvm.put("maxMemory", runtime.maxMemory() / 1024 / 1024 + " MB");
        jvm.put("usedMemory", (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024 + " MB");
        result.put("jvm", jvm);

        return result;
    }

    /**
     * 简单的存活检查
     * @return 简单文本
     */
    @GetMapping("/liveness")
    public String liveness() {
        return "OK";
    }

    /**
     * 就绪检查
     * @return 就绪状态
     */
    @GetMapping("/readiness")
    public Map<String, Object> readiness() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "READY");
        result.put("timestamp", LocalDateTime.now());
        return result;
    }
}
