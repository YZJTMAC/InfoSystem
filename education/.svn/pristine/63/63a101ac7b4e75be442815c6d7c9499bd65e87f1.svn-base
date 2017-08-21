package framelib.utils.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framelib.common.Common;

/**
 * 分析页面传递的分页参数，得到正确的分页值并返回给后台分页程序使用
 * 主要用于DAO操作中，对表现层传递过来的页相关数据进行纠错处理并改正，以确保后台应用程序能获取准确的数据
 * 
 * @author GaoMingJie
 * @date 2013-07-16
 */
public class PageParser {
	private static int pageNumberLen = 8;// 显示多少个页数

	public static Map<String, Integer> getPageInfo(int startIndex,
			int pageSize, int count) {
		if (startIndex < 0)
			startIndex = 0;
		if (pageSize <= 0)
			pageSize = Common.PNN_USER_PAGE_LIMIT;

		int endIndex = 0;
		if (startIndex >= count) {
			if (pageSize > count) {
				startIndex = 0;
				endIndex = count;
			} else {
				if (count % pageSize == 0) {
					startIndex = count - pageSize;
				} else {
					startIndex = count - count % pageSize;
				}
				endIndex = count;
			}
		} else {
			endIndex = startIndex + pageSize;
			if (endIndex > count) {
				endIndex = count;
			}
		}

		int pages = 0;
		if (count % pageSize == 0) {
			pages = count / pageSize;
		} else {
			pages = count / pageSize + 1;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		map.put("endIndex", endIndex);
		map.put("count", count);
		map.put("pages", pages);
		return map;
	}

	public static void getPageObject(Map<String, Integer> map, PageObject po) {
		// 必须要先进行过滤，这样才能获取到正确的数据
		int startIndex = map.get("startIndex");
		int endIndex = map.get("endIndex");
		int pageSize = map.get("pageSize");
		int count = map.get("count");
		int pages = map.get("pages");

		po.setStartIndex(startIndex);
		po.setEndIndex(endIndex);
		po.setPagesize(pageSize);
		po.setCount(count);
		po.setPages(pages);
		po.setCurrentPage(startIndex / pageSize + 1);
		po.setPageNumbers(getPageNumbers(po.getCurrentPage(), po.getPages()));
	}

	private static List<Integer> getPageNumbers(int currentPage, int totalPage) {
		List<Integer> pageNumber = new ArrayList<Integer>();
		if (totalPage > pageNumberLen) {
			if (currentPage > pageNumberLen / 2) {
				if (currentPage + pageNumberLen / 2 > totalPage) {
					for (int i = totalPage - pageNumberLen - 1; i <= totalPage; i++) {
						pageNumber.add(i);
					}
				} else {
					for (int i = currentPage - pageNumberLen / 2; i < currentPage
							+ pageNumberLen / 2; i++) {
						pageNumber.add(i);
					}
				}
			} else {
				for (int i = 1; i <= pageNumberLen; i++) {
					pageNumber.add(i);
				}
			}
		} else {
			for (int i = 1; i <= totalPage; i++) {
				pageNumber.add(i);
			}
		}
		return pageNumber;
	}
}
