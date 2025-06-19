package com.superai.analysis.service;

import com.superai.analysis.enums.AnalysisFileTypeEnum;
import com.superai.supercommon.core.api.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public interface IFileAnalysisService {

    R<?> analyzeMultipartFile(AnalysisFileTypeEnum typeEnum, MultipartFile file);
}
