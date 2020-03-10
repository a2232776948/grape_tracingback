package cn.edu.scau.util;

import cn.edu.scau.entities.vo.Response;

public class ResponseUtil {

    /**
     * http 响应成功
     */
    public static Response success(Object result) {


        Response response = getResponse("success");
        response.setStatus(200);
        response.setResult(result);
        return response;
    }

    /**
     * http 响应成功
     */
    public static Response success(String msg, Object result) {
        Response response = getResponse(msg);
        response.setStatus(200);
        response.setResult(result);
        return response;
    }

    /**
     * http 响应成功
     */
    public static Response success(String msg) {
        Response response = getResponse(msg);
        response.setStatus(200);
        return response;
    }

    /**
     * http 响应失败
     */
    public static Response error(Integer status, String msg, Object error) {
        Response response = getResponse(msg);
        response.setStatus(status);
        response.setError(error);
        return response;
    }

    /**
     * http 响应失败
     */
    public static Response error(Integer status, String msg) {
        Response response = getResponse(msg);
        response.setStatus(status);
        return response;
    }

    /**
     * http 响应失败
     */
    public static Response error(String msg) {
        Response response = getResponse(msg);
        return response;
    }

    /**
     * 获取Response
     */
    private static Response getResponse(String msg) {
        Response response = new Response();
        response.setMsg(msg);
        return response;
    }
}
