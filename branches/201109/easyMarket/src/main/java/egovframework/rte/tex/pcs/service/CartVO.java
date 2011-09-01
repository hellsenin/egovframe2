package egovframework.rte.tex.pcs.service;

import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.gds.service.GoodsVO;

/**
 * @Class Name : CartVO.java
 * @Description : CartVO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public class CartVO extends SearchVO{
	private String cartId; //장바구니 ID
	private GoodsVO goodsVO; //상품VO
	private String mberNo; //회원번호
	private int qy; //수량
	
	
	/**
	 * 장바구니정보 기본생성자
	 */
	public CartVO() {
		super();
	}

	/**
	 * 장바구니정보 생성자
	 * @param cartId
	 * @param goodsNo
	 * @param mberNo
	 * @param qy
	 */
	public CartVO(String cartId, GoodsVO goodsVO, String mberNo, int qy) {
		super();
		this.cartId = cartId;
		this.goodsVO = goodsVO;
		this.mberNo = mberNo;
		this.qy = qy;
	}

	/**
	 * 장바구니 ID 조회
	 * @return String 장바구니 ID
	 */
	public String getCartId() {
		return cartId;
	}

	/**
	 * 장바구니 ID 등록
	 * @param cartId 등록될 장바구니 ID
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	/**
	 * 상품VO 조회
	 * @return String 상품VO
	 */
	public GoodsVO getGoodsVO() {
		return goodsVO;
	}

	/**
	 * 상품VO 등록
	 * @param goodsNo 등록될 상품VO
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
	 * @return int 수량
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
	 * 장바구니에 대한 정보를 문자열로 반환
	 * @return String 장바구니에 대한 정보
	 */
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", goodsVO=" + goodsVO
				+ ", mberNo=" + mberNo + ", qy=" + qy + "]";
	}
	
}
