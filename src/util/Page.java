package util;

public class Page {
	private int totalRow;
	private int pageSize = 10;
	private int currentPage = 0;
	private int totalPage = 0;
	private int firstRow = 0;
	

	public Page(int totalRow,int currentPage,int pageSize){
		this.currentPage=currentPage;
		this.totalRow = totalRow;
		this.pageSize = pageSize;
		calculate();
		
	}
/*
 * 计算当前页、总页数等信息
 */
	public void calculate(){
	
		totalPage = totalRow/pageSize+((totalRow%pageSize)>0?1:0);
		if(currentPage>totalPage)
			{currentPage=totalPage;}
		else if(currentPage<1){currentPage=1;}
		
		firstRow = (currentPage-1)*pageSize;
		
	}
	
	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

}
