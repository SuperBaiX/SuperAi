package com.superai.analysis.enums;

import com.superai.supercommon.core.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import com.superai.supercommon.core.*;

/**
 * @author : XiaoBaiBai
 * @description : 解析文件类型枚举
 * @created : 2025/6/19
 **/
@Getter
@AllArgsConstructor
public enum AnalysisFileTypeEnum {
    /**
     * 文本类型
     */
    TXT_TYPE(1, "txt", "txtAnalysisStrategyName"),

    /**
     * csv类型
     */
    CSV_TYPE(2, "csv", "xlsxAnalysisStrategyName"),

    /**
     * word
     */
    WORD_TYPE(3, "word", "wordAnalysisStrategyName"),

    /**
     * pdf
     */
    PDF_TYPE(4, "pdf", "pdfAnalysisStrategyName"),

    /**
     * PPT
     */
    PPT_TYPE(5, "ppt", "pptAnalysisStrategyName"),

    /**
     * PPTX
     */
    PPTX_TYPE(6, "pptx", "pptAnalysisStrategyName"),

    /**
     * XLS
     */
    XLS_TYPE(7, "xls", "xlsxAnalysisStrategyName"),

    /**
     * XLSX
     */
    XLSX_TYPE(8, "xlsx", "xlsxAnalysisStrategyName"),

    /**
     * PNG
     */
    PNG_TYPE(9, "png", "pngAnalysisStrategyName"),

    /**
     * JPG
     */
    JPG_TYPE(10, "jpg", "pngAnalysisStrategyName"),

    /**
     * JPEG
     */
    JPEG_TYPE(11, "jpeg", "pngAnalysisStrategyName"),

    /**
     * markdown
     */
    MARKDOWN_TYPE(12, "markdown", "markdownAnalysisStrategyName"),

    /**
     * json
     */
    JSON_TYPE(13, "json", "jsonAnalysisStrategyName"),

    ;

    private final Integer code;
    private final String fileType;
    private final String analysisStrategyName;


    public static AnalysisFileTypeEnum getEnumByFileType(String fileType) {
        for (AnalysisFileTypeEnum e : AnalysisFileTypeEnum.values()) {
            if (e.getFileType().equals(fileType)) {
                return e;
            }
        }
        throw new ServiceException("不支持的文件类型");
    }

}
