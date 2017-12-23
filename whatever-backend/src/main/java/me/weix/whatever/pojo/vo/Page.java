package me.weix.whatever.pojo.vo;

/**
 * @Author: Wells.Wei
 * @Date: 2017/4/25
 * @Description:
 */
import java.io.Serializable;


/**
 * 分页封装类
 * @Description
 * @param
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 485565308302269995L;

    private int pageNo = 1; // 页码，默认是第一页
    private int pageSize = 15; // 每页显示的记录数，默认是15
    private int totalRecord; // 总记录数
    private int totalPage; // 总页数


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        // 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [pageNo=").append(pageNo).append(", pageSize=").append(pageSize).append(", totalPage=").append(totalPage).append(", totalRecord=").append(totalRecord)
                .append("]");
        return builder.toString();
    }

}
