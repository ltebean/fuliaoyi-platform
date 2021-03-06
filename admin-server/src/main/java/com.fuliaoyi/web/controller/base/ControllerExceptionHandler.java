package com.fuliaoyi.web.controller.base;

import com.fuliaoyi.web.controller.dto.Response;
import com.fuliaoyi.web.controller.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by leo on 16/6/7.
 */
@ControllerAdvice(basePackages = "com.fuliaoyi.web.controller")
public class ControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Response handleUnAuthorzied() {
        Response response = new Response();
        response.code = HttpStatus.UNAUTHORIZED.value();
        response.msg = "unauthorized";
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response badRequest() {
        return Response.badRequest();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleError(Exception exception) {
        logger.error("api error", exception);
        return Response.error("server error");
    }
}
