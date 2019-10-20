package org.wu.toolbox.web;

/**
 * 分页查询参数
 * @author wusq
 * @date 2019/8/31
 */
public class PageQuery {

    /**
     * 起始位置，数据库分页查询使用
     */
    protected Integer offset;

    /**
     * 限制数量，数据库分页查询使用
     */
    protected Integer limit;

    /**
     * 页数，接收客户端参数使用
     */
    protected Integer pageNumber;

    /**
     * 每页数量，接收客户端参数使用
     */
    protected Integer pageSize;

    public void init(){
        // 默认查询第1页
        if(pageNumber == null || pageNumber < 1){
            pageNumber = 1;
        }

        limit = pageSize;
        // 默认每页显示10条数据
        if(pageSize == null || pageSize < 1){
            limit = 10;
        }
        // 设置最大限制，防止恶意查询大数据量
        if(limit > 1000){
            limit = 1000;
        }

        offset = (pageNumber - 1) * limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
