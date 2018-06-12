package com.yung.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class DubboRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8543609064502490688L;

	private Long requestId;

    private Date requestTime;

    private Map<String, Object> requestBody;
    
    

	public DubboRequest() {
		super();
	}
	
	public DubboRequest(Map<String, Object> requestBody) {
		this.requestTime = new Date();
		this.requestBody = requestBody;
	}

	public DubboRequest(Long requestId, Date requestTime, Map<String, Object> requestBody) {
		super();
		this.requestId = requestId;
		this.requestTime = requestTime;
		this.requestBody = requestBody;
	}

	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Map<String, Object> getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Map<String, Object> requestBody) {
		this.requestBody = requestBody;
	}
    
}
