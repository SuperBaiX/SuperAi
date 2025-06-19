package com.superai.supercommon.core.exception;

import com.superai.supercommon.core.api.IResultCode;
import com.superai.supercommon.core.api.ResultCode;

/**
 * @author : XiaoBaiBai
 * @description : T
 * @created : 2025/6/19
 **/
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;
    private final IResultCode resultCode;

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public ServiceException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ServiceException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

    public IResultCode getResultCode() {
        return this.resultCode;
    }
}