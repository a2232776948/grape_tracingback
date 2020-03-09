package cn.edu.scau.entities.vo;

import lombok.Data;

@Data
public class Response {
    private Integer status;
    private String msg;
    private Object result;
    private Object error;
}

