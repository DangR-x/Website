package xiongjunmiao.top.Website.query;

/**
 * @Description 基础的query
 * @Author DangR-X
 * @Date 2020/4/15 16:19
 * @Version v1.0
 */
public class BaseQuery {


    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String keyword;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
