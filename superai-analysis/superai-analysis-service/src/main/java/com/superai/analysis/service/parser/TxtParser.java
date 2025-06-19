package com.superai.analysis.service.parser;

import com.superai.supercommon.config.api.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public class TxtParser implements FileParser{
    @Override
    public String getSupportedExtension() {
        return "txt";
    }

    @Override
    public R<?> parse(MultipartFile file) throws IOException {
        //文件解析逻辑

        return null;
    }
}
