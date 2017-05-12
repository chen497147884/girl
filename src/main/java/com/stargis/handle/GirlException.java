package com.stargis.handle;

import com.stargis.enums.ResultEnum;

/**
 * Created by Chen.YH
 * 2017-04-18 11:58
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
