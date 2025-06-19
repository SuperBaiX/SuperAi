package com.superai.analysis.config;

import com.superai.analysis.service.parser.FileParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : XiaoBaiBai
 * @description : 文件解析组件映射器
 * @created : 2025/6/19
 **/
@Configuration
public class FileParserConfig {

    @Bean
    public Map<String, FileParser> parserMap(List<FileParser> parsers) {
        return parsers.stream().collect(Collectors.toMap(
                FileParser::getSupportedExtension,
                Function.identity()
        ));
    }
}
