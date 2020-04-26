package com.lazycece.commons.utils.xmlc;

/**
 * @author lazycece
 * @date 2018/4/6
 */
public class NameSpace {
    private String name;
    private String value;

    public NameSpace(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
