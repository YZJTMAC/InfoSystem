package framelib.utils.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 页面对象（保存着每一页的列表数据，分页数据）
 * 
 * @author GaoMingJie
 * @date 2013-07-16
 */
public class PageObject implements Serializable {
	private static final long serialVersionUID = 1L;

	private int count; // 记录总数

	private int currentPage; // 当前页数

	private List<?> objects; // 具体的记录集合

	private int pages; // 所有页数

	private int pagesize; // 每页记录数

	private int startIndex; // 当前页的开始记录数

	private int endIndex;// 当前页的结束记录数
	
	private List<Integer> pageNumbers;//分页列表（类似百度分页）

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public List<?> getObjects() {
		return objects;
	}

	public void setObjects(List<?> objects) {
		if (objects == null) {
			objects = new ArrayList<Object>();
		}
		this.objects = objects;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<Integer> getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(List<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	/**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("objects", this.objects)
                .append("startIndex", this.startIndex).append("pages",
                        this.pages).append("pageNumbers", this.pageNumbers)
                .append("currentPage", this.currentPage).append("pagesize",
                        this.pagesize).append("endIndex", this.endIndex)
                .append("count", this.count).toString();
    }
	
}
