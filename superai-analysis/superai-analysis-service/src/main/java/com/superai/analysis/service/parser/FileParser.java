package com.superai.analysis.service.parser;

import com.superai.supercommon.config.api.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public interface FileParser {
    /**
     * 获取支持的文件扩展后缀
     * @return
     */
    String getSupportedExtension();

    /**
     * 处理解析
     * @param file
     * @return
     * @throws IOException
     */
    R<?> parse(MultipartFile file) throws IOException;
}
