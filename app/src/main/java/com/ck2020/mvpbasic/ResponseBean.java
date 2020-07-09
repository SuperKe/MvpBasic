package com.ck2020.mvpbasic;

/**
 * @author chenke
 * @create 2020/7/8
 * @Describe
 */
public class ResponseBean<T> {
    private T data;
    private int status;
    private String desc;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
