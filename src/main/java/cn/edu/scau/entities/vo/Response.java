package cn.edu.scau.entities.vo;

import lombok.Data;

@Data
public class Response<T> {
    private Integer status;
    private String msg;
    private T result;
    private Object error;
}

