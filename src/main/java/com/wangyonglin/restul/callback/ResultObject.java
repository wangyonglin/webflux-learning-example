package com.wangyonglin.springframework.result;


import javakit.date.DateUtils;
import lombok.Data;
import java.util.Date;

@Data
public class ResultObject {
    private String reason;
    private Object result;
    private Integer errcode;
    private Date timestamp;

    public static ResultObject failure(Integer status, String message) {
 
        
        ResultObject resultObject = new ResultObject();
        resultObject.setErrcode(status);
        resultObject.setTimestamp(DateUtils.CurrentDate());
        resultObject.setReason(message);
        resultObject.setResult(new Object());
        return resultObject;
    }
    public static ResultObject success(Integer status,Object producer){
        ResultObject resultObject = new ResultObject();
        resultObject.setErrcode(status);
        resultObject.setReason("SUCCESS");
        resultObject.setResult(producer);
        resultObject.setTimestamp(DateUtils.CurrentDate());
        return resultObject;
    }
}
