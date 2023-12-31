package com.semi.main.util;


public class Pager {
	//최신순,인기순,저가순,고가순 정
	private String condition;
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}


	//검색 관련
	private String kind;
	private String search;
	
	private Long startRow;
	private Long lastRow;
	
	//파라미터로 받기 위해 선언
	private Long page;
	
	
	//한페이지에 보여질 (row)데이터의 갯수
	private Long perPage;
	
	private Long perBlock;
	


	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}


	//총페이지의 갯수 (필요는없음)
	private Long totalPage;
	
	//시작번호 JSP에서 사용하기 위해 꼭 필요
	private Long startNum;
	//끝번호 JSP에서 사용하기 위해 꼭 필요
	private Long lastNum;
	
	//이전블럭 활성화를 담는 블럭
	//false면 1번블럭 true면(1번블럭이아님)
	private boolean pre; 
	
	
	
	private Long catNo;
	
	
	public Long getCatNo() {
		return catNo;
	}

	public void setCatNo(Long catNo) {
		this.catNo = catNo;
	}

	


	//다음블럭 활성화를 담는 블럭
	//false면 마지막블럭 true면(마지막블럭이아님)
	private boolean next;//
		
	
	public void makePageNum(Long total) {
		//130     -> 13
		//131-139 -> 14
		//90      -> 9
		//91-99   -> 10
		
		//1. 전체 갯수로 전체 페이지 수 구하기
		this.totalPage= total/ this.getPerPage();//13
		if(total%this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		//2. 전체 페이지수로 전체 block 수 구하기
		//한페이지에 출력할 번호의 갯수
		long perBlock=5;
		
		long totalBlock = this.totalPage/perBlock;
		if(this.totalPage%perBlock !=0 ) {
			totalBlock++;
		}
		
		//3. 현재 page번호로 블럭번호 구하기
		//현재 블럭 번호
		long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호의 시작번호와 끝번호 구하기
		// curBlock		startNum	lastNum
		// 1			1			10
		// 2			11			20
		// 3			21			30
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;		
		
		//이전 블럭 활성화 여부
		if(curBlock>1) {
			this.pre=true;
		}
		
		//다음 블럭 활성화 여부
		if(curBlock<totalBlock) {
			this.next=true;
		}
		
		//현재 블럭이 마지막 블럭일때 lastNum을 totalPage숫자로 대입
//		if(curBlock==totalBlock) {
		if(!this.next) {
			this.lastNum=totalPage;
		}
		
		
		
	}
	
	
	public void makeRowNum() {
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=this.page*this.getPerPage();
	}


	public Long getStartNum() {
		return startNum;
	}


	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}


	public Long getLastNum() {
		return lastNum;
	}


	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}


	public Long getTotalPage() {
		return totalPage;
	}




	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}




	public Long getStartRow() {
		return startRow;
	}



	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}



	public Long getLastRow() {
		return lastRow;
	}



	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}



	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}



	public void setPage(Long page) {
		this.page = page;
	}



	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=8L;
		}
		return perPage;
	}



	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}


	public boolean isPre() {
		return pre;
	}


	public void setPre(boolean pre) {
		this.pre = pre;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}

}