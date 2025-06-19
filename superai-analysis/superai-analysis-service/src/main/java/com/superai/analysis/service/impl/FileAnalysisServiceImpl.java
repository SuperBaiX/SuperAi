package com.superai.analysis.service.impl;

import com.superai.analysis.enums.AnalysisFileTypeEnum;
import com.superai.analysis.service.IFileAnalysisService;
import com.superai.analysis.service.parser.FileParser;
import com.superai.supercommon.core.api.R;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Objects;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
@Service
public class FileAnalysisServiceImpl implements IFileAnalysisService {

    @Autowired
    private Map<String, FileParser> parserMap;


    /**
     * 本地文件解析
     * @param file
     * @return
     */
    @Override
    @SneakyThrows
    public R<?> analyzeMultipartFile(AnalysisFileTypeEnum typeEnum, MultipartFile file) {
        return  parserMap.get(typeEnum.getAnalysisStrategyName()).parse(file);
    }
}
