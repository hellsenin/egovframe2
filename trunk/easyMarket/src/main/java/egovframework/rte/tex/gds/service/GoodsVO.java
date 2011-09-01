package egovframework.rte.tex.gds.service;

import javax.xml.bind.annotation.XmlRootElement;

import egovframework.rte.tex.cgr.service.CategoryVO;
import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : GoodsVO.java
 * @Description : GoodsVO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public class GoodsVO extends SearchVO{
	private static final long serialVersionUID = -9207840954650025298L;
	
	private String goodsId; //상품ID
	private String goodsNm; //상품명
	private int price; //가격
	private GoodsImageVO goodsImageVO; //상품이미지VO
	private CategoryVO categoryVO; //카테고리VO
	private GoodsImageVO detailImageVO; //상세정보 이미지VO
	private String makr; //제조사
	private String useAt; //삭제여부
	
	/**
	 * 상품정보 기본 생성자
	 */
	public GoodsVO()
	{
		
	}

	/**
	 * 상품정보 생성자
	 * @param goodsId
	 * @param goodsNm
	 * @param price
	 * @param categoryVO
	 * @param goodsImage
	 * @param detailImageVO
	 * @param makr
	 */
	public GoodsVO(String goodsId, String goodsNm, int price,
			GoodsImageVO goodsImageVO, CategoryVO categoryVO,
			GoodsImageVO detailImageVO, String makr) {
		super();
		this.goodsId = goodsId;
		this.goodsNm = goodsNm;
		this.price = price;
		this.goodsImageVO = goodsImageVO;
		this.categoryVO = categoryVO;
		this.detailImageVO = detailImageVO;
		this.makr = makr;
	}	

	/** 
	 * 상품ID 조회
	 * @return String 상품ID
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/** 
	 * 상품ID 등록
	 * @param goodsId 등록될 상품ID
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/** 
	 * 상품명 조회
	 * @return String 상품명
	 */
	public String getGoodsNm() {
		return goodsNm;
	}

	/** 
	 * 상품명 등록
	 * @param goodsNm 등록될 상품명
	 */
	public void setGoodsNm(String goodsNm) {
		this.goodsNm = goodsNm;
	}

	/** 
	 * 상품가격 조회
	 * @return String 상품가격
	 */
	public int getPrice() {
		return price;
	}

	/** 
	 * 상품가격 등록
	 * @param price 등록될 상품가격
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/** 
	 * 카테고리VO 조회
	 * @return String 카테고리명
	 */
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	/** 
	 * 카테고리VO 등록
	 * @param ctgryId 등록될 카테고리VO
	 */
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	/**
	 * 상품이미지 정보 조회
	 * @return String 상품 이미지경로
	 */
	public GoodsImageVO getGoodsImageVO() {
		return goodsImageVO;
	}

	/** 
	 * 상품이미지 정보 등록
	 * @param goodsImage 등록될 상품 이미지
	 */
	public void setGoodsImageVO(GoodsImageVO goodsImageVO) {
		this.goodsImageVO = goodsImageVO;
	}
	
	
	/** 
	 * 상세이미지 정보 조회
	 * @return String 상세정보 이미지 경로
	 */
	public GoodsImageVO getDetailImageVO() {
		return detailImageVO;
	}


	/** 
	 * 상세이미지 정보 등록
	 * @param detailImageVO 등록될 상세정보 이미지
	 */
	public void setDetailImageVO(GoodsImageVO detailImageVO) {
		this.detailImageVO = detailImageVO;
	}


	/** 
	 * 제조사 조회
	 * @return String 제조사명
	 */
	public String getMakr() {
		return makr;
	}

	/** 
	 * 제조사 등록
	 * @param makr 등록될 제조사
	 */
	public void setMakr(String makr) {
		this.makr = makr;
	}
	
	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	/** 
	 * 상품에 대한 정보를 문자열로 반환
	 * @return String 상품에 대한 정보
	 */
	@Override
	public String toString() {
		return "GoodsVO [goodsId=" + goodsId + ", goodsNm=" + goodsNm
				+ ", price=" + price + ", goodsImageVO=" + goodsImageVO
				+ ", categoryVO=" + categoryVO + ", detailImageVO="
				+ detailImageVO + ", makr=" + makr + "]";
	
	}
}
