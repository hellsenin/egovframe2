package egovframework.rte.tex.pcs.service;

import java.util.List;

import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.mbr.service.MemberVO;

/**
 * @Class Name : EgovCartService.java
 * @Description : EgovCartService class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public interface EgovCartService {

	/**
	 * 장바구니 목록을 조회한다
	 * @param searchVO 검색정보
	 * @return List<CartVO> 장바구니정보
	 */
	public List<CartVO> selectCartList(CartVO cartVO) throws Exception;

	/**
	 * 장바구니 정보를 조회한다
	 * @param searchVO 검색정보
	 * @return CartVO 장바구니정보
	 */
	public CartVO selectCart(String cartId) throws Exception;

	/**
	 * 장바구니정보를 등록한다
	 * @param cartVO 장바구니정보
	 */
	public String insertCart(CartVO cartVO) throws Exception;

	/** 
	 * 선택된 장바구니정보를 삭제한다
	 * @param ckd 체크 리스트
	 */
	public void deleteCart(String[] ckd) throws Exception;
	
//	
//    /**
//	 * 장바구니 리스트내의 상품 수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 리스트의 갯수
//	 */
//    public int selectCartListTotCnt(SearchVO searchVO);
}
