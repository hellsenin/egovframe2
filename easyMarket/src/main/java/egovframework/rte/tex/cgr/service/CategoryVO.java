package egovframework.rte.tex.cgr.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @Class Name :CategoryVO.java
 * @Description : CategoryVO VO class
 * @author 신혜연
 * @since 2011.05.26
 * @version 1.0
*/
@Entity
@Table(name = "rtetnctgry")
@XmlRootElement
public class CategoryVO implements Serializable{
	
	
	private static final long serialVersionUID = -2132379045115001026L;
	
	@Id
	@Column(name="ctgry_id")
	private String ctgryId; //카테고리ID
	
	@Column(name="ctgry_nm")
	@NotEmpty(message="카테고리명을 입력하세요.")
	private String ctgryNm; //카테고리명
	
	@Column(name="dc")
	private String dc; //카테고리 설명
	

	/** 카테고리 아이디를 가져온다.
	 * @return ctgry_Id 카테고리ID
	 */
	public String getCtgryId() {
		return ctgryId;
	}

	/**
	 * 카테고리 아이디를 입력한다.
	 * @param ctgry_Id 카테고리ID
	 */
	public void setCtgryId(String ctgryId) {
		this.ctgryId = ctgryId;
	}

	/**
	 * 카테고리명을 가져온다.
	 * @return ctgry_nm 카테고리명
	 */
	public String getCtgryNm() {
		return ctgryNm;
	}

	/**
	 * 카테고리명을 입력한다.
	 * @param ctgry_nm 카테고리명
	 */
	public void setCtgryNm(String ctgryNm) {
		this.ctgryNm = ctgryNm;
	}

	/** 카테고리 설명을 가져온다.
	 * @return dc 카테고리 설명
	 */
	public String getDc() {
		return dc;
	}

	/** 카테고리 설명을 입력한다.
	 * @param dc 카테고리 설명
	 */
	public void setDc(String dc) {
		this.dc = dc;
	}
	
	
}
