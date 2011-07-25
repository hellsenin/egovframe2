package egovframework.rte.tex.brd.service;

import java.io.Serializable; 
import java.util.Date;

import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : BoardVO.java
 * @Description : BoardVO VO class
 * @author 신혜연
 * @version 1.0
*/
public class BoardVO extends SearchVO implements Serializable{

	
	private String bbscttNo; //글번호
	private String title; //제목
	private String contents; //내용
	private Date rgsde; //등록일
	
	
	/**
	 * 글번호를 가져온다.
	 * @return bbsctt_no 글번호
	 */
	public String getbbscttNo() {
		return bbscttNo;
	}
	/**
	 * 글번호를 입력한다.
	 * @param bbsctt_no 글번호
	 */
	public void setbbscttNo(String bbscttNo) {
		this.bbscttNo = bbscttNo;
	}
	/**
	 * 제목을 가져온다.
	 * @return title 제목
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 제목을 입력한다.
	 * @param title 제목
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 내용을 가져온다.
	 * @return contents 내용
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * 내용을 입력한다.
	 * @param contents 내용
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * 등록일을 가져온다.
	 * @return rgsde
	 */
	public Date getRgsde() {
		return rgsde;
	}
	/**
	 * 등록일을 입력한다.
	 * @param rgsde 
	 */
	public void setRgsde(Date rgsde) {
		this.rgsde = rgsde;
	}
	
	
}
