package com.lazycece.commons.restful;

/**
 * @author lazycece
 */
public class PageData<T> {
    /**
     * current page data
     */
    private T data;
    /**
     * total records
     */
    private Long count;
    /**
     * current page
     */
    private Integer page;


    public PageData() {
    }

    public PageData(T data, Long count) {
        this.data = data;
        this.count = count;
    }

    public PageData(T data, Long count, Integer page) {
        this.data = data;
        this.count = count;
        this.page = page;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
