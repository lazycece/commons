package com.lazycece.commons.restful;

/**
 * @author lazycece
 */
public enum RespStatus implements Status {
    AUTH_TOKEN_FAIL(-100, "auth token fail"),
    AUTH_SIGN_FAIL(-101, "auth sign fail"),
    AUTH_PARAM_FAIL(-102, "auth param fail"),
    SUCCESS(200, "success"),
    ACCESS_DENIED(403, "access denied"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    FAIL(800, "fail"),
    PARAM_ERROR(801, "param error");
    private int code;
    private String message;
    private Family family;

    RespStatus(int code, String message) {
        this.code = code;
        this.message = message;
        switch (code / 100) {
            case -1:
                this.family = Family.AUTH;
                break;
            case 2:
                this.family = Family.SUCCESS;
                break;
            case 4:
                this.family = Family.CLIENT_ERROR;
                break;
            case 5:
                this.family = Family.SERVER_ERROR;
                break;
            case 8:
                this.family = Family.FAIL;
                break;
            default:
        }
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public Family getFamily() {
        return family;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public enum Family {
        AUTH,
        SUCCESS,
        CLIENT_ERROR,
        SERVER_ERROR,
        FAIL
    }
}
