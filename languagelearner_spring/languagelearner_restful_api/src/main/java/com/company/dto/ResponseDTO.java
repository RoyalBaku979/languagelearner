package com.company.dto;

public class ResponseDTO {
    private Object result;
    private String successMessage;
    private String errorMessage;
    private int errorCode;

    public ResponseDTO() {
    }

    public ResponseDTO(Object result, String successMessage, String errorMessage, int errorCode) {
        this.result = result;
        this.successMessage = successMessage;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static ResponseDTO of(Object result){
        return new ResponseDTO(result, null,null,0);
    }

    public static ResponseDTO of(String successMessage){
        return new ResponseDTO(null,successMessage, null,0);
    }

    public static ResponseDTO of(String successMessage, Object result){
        return new ResponseDTO(result,successMessage, null,0);
    }

    public static ResponseDTO of(String errorMessage, int errorCode){
        return new ResponseDTO(null,null, errorMessage,errorCode);
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
