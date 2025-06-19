package com.superai.analysis.controller;

import com.superai.analysis.enums.AnalysisFileTypeEnum;
import com.superai.analysis.service.IFileAnalysisService;
import com.superai.supercommon.core.api.R;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
@RestController
@RequestMapping("/analysis")
public class FileAnalysisController {
    @Resource
    private IFileAnalysisService fileAnalysisService;


    /**
     * 本地文件解析
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFileAnalysis")
    public R<?> handleFileUpload( @RequestParam("file") MultipartFile file) {
        return fileAnalysisService.analyzeMultipartFile(AnalysisFileTypeEnum.getEnumByFileType(StringUtils.getFilenameExtension(file.getOriginalFilename())),file);
    }




}
