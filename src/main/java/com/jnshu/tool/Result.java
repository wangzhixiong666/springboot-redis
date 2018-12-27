package com.jnshu.tool;

/**
 * @author Mr_Wang
 */
public class Result<T> {
    private String msg;
    private int code;
    private T data;

    private Result(T data) {
        //默认000000是成功
        this.code=200;
        this.msg="SUCCESS";
        this.data = data;
    }

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     *  成功时候的调用
     * */
    public static  <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static  <T> Result<T> success(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    /**
     * 失败时调用
     */

    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
}