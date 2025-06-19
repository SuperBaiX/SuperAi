package com.superai.analysis.service.parser;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public interface FileParser {

    String getSupportedExtension();
    ParseResult parse(MultipartFile file) throws IOException;
}
