package com.study.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResult<T> {

    private int code;
    private String message;
    private T     date;

    public CommentResult(int code,String message){
        this(code,message,null);
    }
}
