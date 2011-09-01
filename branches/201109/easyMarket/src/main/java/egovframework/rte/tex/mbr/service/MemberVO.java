package egovframework.rte.tex.mbr.service;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Class Name : MemberVO.java
 * @Description : MemberVO VO class
 * @author 신혜연
 * @since 2011.05.25
 * @version 1.0
*/
public class MemberVO implements Serializable{

	private static final long serialVersionUID = -4076942847418714109L;
	
	private String memberNo; //회원번호
	
	@NotNull
	@Size(min = 1, max = 50)
	private String name; //이름
	
	private String ihidnum; //주민등록번호
	
	@NotNull
	@Size(min = 1)
	private String id; //아이디
	
	@NotNull
	@Size(min = 1)
	private String password; //비밀번호
	
	@Pattern(regexp=".+@.+\\.[a-z]+")
//	@Pattern(".+@.+\\.[a-z]+") 
	private String email; //이메일
	
	private String telno; //전화번호
	
	private String mobile; //휴대폰 번호
	
	private String zip; //우편번호
	
	private String adres; //주소
	
	private String detailAdres; //상세주소
	
	private Date lastChangeDt; //최종변경일
	
	private String mngrSe; //권한 
	

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	/**
	 * 회원이름을 가져온다.
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 회원이름을 등록한다.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 회원 주민등록번호를 가져온다.
	 * @return char
	 */
	public String getIhidnum() {
		return ihidnum;
	}
	
	/**
	 * 회원 주민등록번호를 등록한다.
	 * @param ihidnum
	 */
	public void setIhidnum(String ihidnum) {
		this.ihidnum = ihidnum;
	}
	
	/** 회원 주민등록번호를 가져온다.
	 * @return String
	 */
	public String getId() {
		return id;
	}
	
	/** 회원 아이디를 등록한다.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 비밀번호를 가져온다.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/** 비밀번호를 등록한다.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 이메일주소를 가져온다.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/** 이메일주소를 등록한다.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** 전화번호를 가져온다.
	 * @return String
	 */
	public String getTelno() {
		return telno;
	}
	
	/** 전화번호를 등록한다.
	 * @param telno
	 */
	public void setTelno(String telno) {
		this.telno = telno;
	}
	
	/** 핸드폰 번호를 가져온다.
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/** 핸드폰 번호를 등록한다.
	 * @param moblphon
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/** 우편번호를 가져온다.
	 * @return String
	 */
	public String getZip() {
		return zip;
	}
	
	/** 우편번호를 등록한다.
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/** 주소를 가져온다.
	 * @return String
	 */
	public String getAdres() {
		return adres;
	}
	
	/** 주소를 등록한다.
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	/** 상세주소를 가져온다.
	 * @return String
	 */
	public String getDetailAdres() {
		return detailAdres;
	}
	
	/** 상세주소를 등록한다.
	 * @param detail_adres
	 */
	public void setDetailAdres(String detailAdres) {
		this.detailAdres = detailAdres;
	}
	
	/** 최종변경일을 가져온다.
	 * @return Date
	 */
	public Date getLastChangeDt() {
		return lastChangeDt;
	}
	
	/** 최종변경일을 등록한다.
	 * @param last_change_dt
	 */
	public void setLastChangeDt(Date lastChangeDt) {
		this.lastChangeDt = lastChangeDt;
	}

	public String getMngrSe() {
		return mngrSe;
	}

	public void setMngrSe(String mngrSe) {
		this.mngrSe = mngrSe;
	}
	
	
	
	
}
