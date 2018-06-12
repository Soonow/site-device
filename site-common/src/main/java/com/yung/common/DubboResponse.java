package com.yung.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xiehd
 */
public final class DubboResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7026481811132990854L;

	public enum Status {

        SUCCESS("success"), ERROR("error"), WARNING("warning");

        private final String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    // Default value is success
    private Status status = Status.SUCCESS;

    // Result data
    private Map<String, Object> result;

    // Success message
    private String successMsg;

    /**
     * 
     * Error code
     * 
     * 1***为系统异常,
     * 2***为业务相关异常;
     * 
     * 0	默认值,正常
     * 1001	系统异常
     * 1002	拒绝服务
     * 1003	连接异常
     * ….	….
     * 2001	参数错误
     * ….	….
     * 
     */
    private String errorCode;

    // Error message
    private String errorMsg;

    // Warning message
    private String warningMsg;

    public DubboResponse() {
        super();
    }

    public DubboResponse(Map<String, Object> result) {
        super();
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.status=Status.ERROR;
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.status = Status.ERROR;
        this.errorMsg = errorMsg;
    }

    public String getWarningMsg() {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg) {
        this.status = Status.WARNING;
        this.warningMsg = warningMsg;
    }
}
