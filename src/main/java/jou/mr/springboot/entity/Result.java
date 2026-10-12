package jou.mr.springboot.entity;

public class Result {
    private Integer code;//状态码,比如成功:200,失败:500,...
    private String message;//响应的消息
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }


    public Result(String message) {
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
    }

    public static Result success(String message){
        return new Result(200,message);
    }

    public static Result fail(String message){
        return new Result(500,message);
    }

    public static Result success(Integer code,Object data){
        return new Result(code,data);
    }

    public static Result success(Object data){
        return new Result(200,"success",data);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
