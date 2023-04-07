package org.sample.ytech.common;

public class SuccessResponse {

    private String code;
    private String description;

    public SuccessResponse() {
    }

    public SuccessResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
