package itsource.utils;

public enum ResponseCode {

    SUCCESS("0", "请求成功"),
    FAIL("9999", "网络异常"),
    ERROR_1("9001", "手机号为空"),
    ERROR_2("9002", "密码为空"),
    ERROR_3("9003", "手机号已注册"),
    ERROR_4("9004", "账号密码不匹配"),
    ERROR_5("9005", "购物车已存在"),
    ERROR_6("9006", "非正常登录"),
    ERROR_7("9007", "该用户被冻结"),
    ERROR_8("9008", "用户权限不足");

    //状态码
    private String code;

    //状态值
    private String msg;

    ResponseCode() {

    }

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
