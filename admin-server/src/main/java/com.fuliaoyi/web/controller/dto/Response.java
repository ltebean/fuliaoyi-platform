package com.fuliaoyi.web.controller.dto;

/**
 * Created by leo on 16/6/6.
 */
public class Response {

    public int code = 200;

    public String msg = "";

    public Object data;

    public Response(Object data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(int status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    public static Response error(String msg) {
        Response response = new Response();
        response.code = 500;
        response.msg = msg;
        return response;
    }

    public static Response success() {
        Response response = new Response();
        response.code = 200;
        return response;
    }

    public static Response badRequest() {
        Response response = new Response();
        response.code = 400;
        return response;
    }
}
