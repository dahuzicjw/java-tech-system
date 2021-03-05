package com.style.guide.framework.dto;

/**
 * Http内部接口交互状态码
 *
 * @author chenjw
 * @date 2020/7/6
 */
public enum ResultStatus {

    //业务处理成功，付款与退款结果表示处理完成
    Success(200, "业务处理成功"),
    Accepted(202, "业务处理成功"),
    // 提示message消息内容
    Failure(400, "业务处理失败"),
    // 用户身份验证不通过，拉起登录窗口
    Unauthorized(401, "会话过期请重新登录"),
    Forbidden(403, "无权限访问"),
    Not_Found(404, "无效指令，或接口不存在"),
    Method_Not_Allowed(405, "请求方法不支持"),
    Payload_Too_Large(413, "请求方法不支持"),
    // 显示系统异常占位图
    Internal_Server_Error(500, "服务器内部异常"),
    /**
     * 由于临时的服务器维护或者过载，服务器当前无法处理请求。这个状况是暂时的，并且将在一段时间以后恢复。
     */
    Service_Unavailable(503, "服务器繁忙，已通知管理员，请5秒后重试"),

    ;

    public final int code;
    public final String name;

    ResultStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public short shortCode() {
        return (short)code;
    }

}
