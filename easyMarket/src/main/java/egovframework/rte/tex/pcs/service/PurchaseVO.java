package egovframework.rte.tex.pcs.service;

import java.util.Date;

import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.gds.service.GoodsVO;

/**
 * @Class Name : PurchaseVO.java
 * @Description : PurchaseVO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public class PurchaseVO extends SearchVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2781867666906905705L;
	
	
	private String purchsId; //구매목록번호
	private GoodsVO goodsVO; //상품번호
	private String mberNo; //회원번호
	private int qy; //수량
	private Date purchsDe; //구입일자
	private String dlvySe; //배송구분
	
	
	/**
	 * 구매정보 기본 생성자
	 */
	public PurchaseVO() {
		super();
	}

	/**
	 * 구매정보 생성자
	 * @param purchsId
	 * @param goodsNo
	 * @param mberNo
	 * @param qy
	 * @param purchsDe
	 * @param dlvySe
	 */
	public PurchaseVO(String purchsId, GoodsVO goodsVO, String mberNo,
			int qy, Date purchsDe, String dlvySe) {
		super();
		this.purchsId = purchsId;
		this.goodsVO = goodsVO;
		this.mberNo = mberNo;
		this.qy = qy;
		this.purchsDe = purchsDe;
		this.dlvySe = dlvySe;
	}

	/**
	 * 구매목록번호 조회
	 * @return String 구매목록번호
	 */
	public String getPurchsId() {
		return purchsId;
	}


	/**
	 * 구매목록번호 등록
	 * @param purchsId 등록될 구매목록번호
	 */
	public void setPurchsId(String purchsId) {
		this.purchsId = purchsId;
	}

	/**
	 * 상품정보 조회
	 * @return GoodsVO 상품정보
	 */
	public GoodsVO getGoodsVO() {
		return goodsVO;
	}

	/**
	 * 상품정보 등록
	 * @param goodsVO 등록될 상품정보
	 */
	public void setGoodsVO(GoodsVO goodsVO) {
		this.goodsVO = goodsVO;
	}

	/**
	 * 회원번호 조회
	 * @return String 회원번호
	 */
	public String getMberNo() {
		return mberNo;
	}

	/**
	 * 회원번호 등록
	 * @param mberNo 등록될 회원번호
	 */
	public void setMberNo(String mberNo) {
		this.mberNo = mberNo;
	}

	/**
	 * 수량 조회
	 * @return String 수량
	 */
	public int getQy() {
		return qy;
	}

	/**
	 * 수량 등록
	 * @param qy 등록될 수량
	 */
	public void setQy(int qy) {
		this.qy = qy;
	}

	/**
	 * 구입일자 조회
	 * @return String 구입일자
	 */
	public Date getPurchsDe() {
		return purchsDe;
	}

	/**
	 * 구입일자 등록
	 * @param purchsDe 등록될 구입일자
	 */
	public void setPurchsDe(Date purchsDe) {
		this.purchsDe = purchsDe;
	}

	/**
	 * 배송구분 조회
	 * @return String 배송구분
	 */
	public String getDlvySe() {
		return dlvySe;
	}

	/**
	 * 배송구분 등록
	 * @param dlvySe 등록될 배송구분
	 */
	public void setDlvySe(String dlvySe) {
		this.dlvySe = dlvySe;
	}
	
	/** 
	 * 구매에 대한 정보를 문자열로 반환
	 * @return String 구매에 대한 정보
	 */
	@Override
	public String toString() {
		return "PurchaseVO [purchsId=" + purchsId + ", goodsVO="
				+ goodsVO + ", mberNo=" + mberNo + ", qy=" + qy + ", purchsDe="
				+ purchsDe + ", dlvySe=" + dlvySe + "]";
	}
} 