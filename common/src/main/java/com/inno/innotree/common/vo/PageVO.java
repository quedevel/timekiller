package com.inno.innotree.common.vo;

public class PageVO {

    private Integer page = 1;
    private Integer pageSize = 20;

    public Integer getSkip() {
        return (page-1)*pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if(page < 1){
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize < 1){
            this.pageSize = 20;
        } else {
            this.pageSize = pageSize;
        }
    }
}
