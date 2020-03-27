package cn.edu.scau.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class  PageDTO<T> {
    /**
     * 当前页
     */
    private int curPage;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总条数
     */
    private long total;
    /**
     * 结果
     */
    private T result;

    public PageDTO() {
        this.curPage = 1;
        this.pageSize = 10;
    }
}
