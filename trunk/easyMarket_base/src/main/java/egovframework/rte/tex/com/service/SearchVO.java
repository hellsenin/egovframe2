package egovframework.rte.tex.com.service;

import java.io.Serializable;

/**
 * @Class Name : SearchVO.java
 * @Description : SearchVO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public class SearchVO implements Serializable{
	
	
	private int pageIndex = 1; //현재 페이지
	private String searchCondition = ""; //검색조건
	private String searchKeyword = ""; //검색키워드
    private String searchUseYn = ""; //검색사용여부
    private int pageUnit = 10; //페이지갯수
    private int pageSize = 10; //페이지사이즈
    private int firstIndex = 1; //시작인덱스
    private int lastIndex = 1; //끝인덱스
    private int recordCountPerPage = 10; //페이지 별 레코드 갯수 
    
	/**
	 * 끝인덱스 조회
	 * @return 끝인덱스 
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * 끝인덱스 등록
	 * @param lastIndex 등록될 끝인덱스 
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	/**
	 * recordCountPerPage 조회
	 * @return recordCountPerPage
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	/**
	 * recordCountPerPage 등록
	 * @param recordCountPerPage 등록될 recordCountPerPage
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	/**
	 * first Index 조회
	 * @return first Index
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * first Index 등록
	 * @param firstIndex 등록될 first Index
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	/**
	 * 현재 페이지 조회
	 * @return int 현재 페이지
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 현재 페이지 등록
	 * @param pageIndex 등록될 현재 페이지
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	
	/**
	 * 검색조건 조회
	 * @return String 검색조건
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * 검색조건 등록
	 * @param searchCondition 검색조건
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * 검색키워드 조회
	 * @return String 검색키워드
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * 검색키워드 등록
	 * @param searchKeyword 등록될 검색키워드
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * 검색사용여부 조회
	 * @return String 검색사용여부
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * 검색사용여부 등록
	 * @param searchUseYn 검색사용여부
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * 페이지 수 조회
	 * @return int 페이지 수 
	 */
	public int getPageUnit() {
		return pageUnit;
	}

	/**
	 * 페이지 수 등록
	 * @param pageUnit 페이지 수
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	/**
	 * 페이지 사이즈 조회
	 * @return int 페이지 사이즈
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 페이지 사이즈 등록
	 * @param pageSize 페이지 사이즈
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 
	 * 검색에 대한 정보를 문자열로 반환
	 * @return String 검색에 대한 정보
	 */
	@Override
	public String toString() {
		return "SearchVO [pageIndex=" + pageIndex + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword
				+ ", searchUseYn=" + searchUseYn + ", pageUnit=" + pageUnit
				+ ", pageSize=" + pageSize + "]";
	}
    
}
 