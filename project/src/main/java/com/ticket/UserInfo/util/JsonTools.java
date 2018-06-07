package com.ticket.UserInfo.util;

/**
 * Created by Shinelon on 2018/5/15.
 */
public class JsonTools {
    /**
     * 利用工厂方法完成返回结果的格式化
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult formJsonResult(int code, String msg){
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
