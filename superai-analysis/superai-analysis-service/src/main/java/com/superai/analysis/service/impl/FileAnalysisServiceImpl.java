package com.superai.analysis.service.impl;

import com.superai.analysis.service.IFileAnalysisService;
import com.superai.analysis.service.parser.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
@Service
public class FileAnalysisServiceImpl implements IFileAnalysisService {

    @Autowired
    private Map<String, FileParser> parserMap;
}
