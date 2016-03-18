package pages;

import java.util.List;

public class Page<T> {
	private int pageNumber;
	private int pageSize;
	private int totalRecord;
	//private int index;
	private int totalPage;
	private List<T> date;

	public int getPageNumber() {
		if(pageNumber<1){
			return 1;
			
		}
		
		if (pageNumber>getTotalPage()){
			return getTotalPage();
		}
		return pageNumber;
	}

 	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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
	}

	public int getIndex() {
		
		return (getPageNumber()-1)*getPageSize();		
	}

//	public void setIndex(int index) {
//		this.index = index;
//	}

	public int getTotalPage() {
		if(getTotalRecord()%getPageSize()==0){
			return getTotalRecord()/getPageSize();
		}else{
			return getTotalRecord()/getPageSize()+1;
		}
		
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDate() {
		return date;
	}

	public void setDate(List<T> date) {
		this.date = date;
	}

}
