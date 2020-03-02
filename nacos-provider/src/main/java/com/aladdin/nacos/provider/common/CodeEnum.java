package com.aladdin.nacos.provider.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
@Getter
@ToString
public enum  CodeEnum {

    // 公共错误码
    OK(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()),
    NO_LOGIN(-101, "账号未登录"),
    INVALID_OPERATION(-102, "无效操作"),
    REQUEST_ERR(-400, "请求错误"),
    UNAUTHORIZED(-401, "未认证"),
    ACCESS_DENIED(-403, "访问权限不足"),
    NOT_FOUND(-404, "404"),
    METHOD_NOT_ALLOWED(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase()),
    SERVER_ERR(-500, "服务器错误"),
    SERVICE_UNAVAILABLE(-503, "过载保护，服务暂时不可用"),
    DEADLINE(-504, "服务调用超时"),
    LIMIT_EXCEED(-509, "超出限制");

    // [1000~2000) 业务 A 错误码

    // [2000~3000) 业务 B 错误码

    // 31000~4000) 业务 C 错误码

    private Integer code;
    private String message;


    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private static Map<Integer, CodeEnum> map;

    private static void initMap() {
        map = new HashMap<>();
        for (CodeEnum e : CodeEnum.values()) {
            map.put(e.code, e);
        }
    }

    public static CodeEnum get(int code) {
        if (map == null) {
            initMap();
        }
        return map.get(code);
    }

}
