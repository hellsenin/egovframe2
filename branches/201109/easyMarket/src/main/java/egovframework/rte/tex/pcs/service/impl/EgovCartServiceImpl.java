package egovframework.rte.tex.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.CartVO;
import egovframework.rte.tex.pcs.service.EgovCartService;

/**
 * @Class Name : EgovCartServiceImpl.java
 * @Description : EgovCartServiceImpl class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Service("cartService")
public class EgovCartServiceImpl extends AbstractServiceImpl implements EgovCartService{
	
	@Resource(name="cartDAO")
	private CartDAO cartDAO; // CartDAO
	
	@Resource(name="egovIdGnrServiceCart")
	private EgovIdGnrService egovIdGnrServiceCart; //CartID Generation
	
	
	/**
	 * 장바구니 목록을 조회한다
	 * @param searchVO 검색정보
	 * @return List<CartVO> 장바구니정보
	 */
	public List<CartVO> selectCartList(CartVO cartVO) throws Exception
	{
		return cartDAO.selectCartList(cartVO);
	}
	
	/**
	 * 장바구니 정보를 조회한다
	 * @param searchVO 검색정보
	 * @return CartVO 장바구니정보
	 */
	public CartVO selectCart(String cartId) throws Exception
	{
		return cartDAO.selectCart(cartId);
	}
	/**
	 * 장바구니정보를 등록한다
	 * @param cartVO 장바구니정보
	 */
	public String insertCart(CartVO cartVO) throws Exception
	{
		log.debug(cartVO.toString());
		
		String id = egovIdGnrServiceCart.getNextStringId();
		cartVO.setCartId(id);
		log.debug(cartVO.toString());
		
		cartDAO.insertCart(cartVO);
		
		return id;
	}
	
	
	/**
	 * 선택된 장바구니정보를 삭제한다
	 * @param ckd 체크 리스트
	 */
	public void deleteCart(String[] ckd) throws Exception
	{
		for(int i=0;i<ckd.length;i++){
		    cartDAO.deleteCart(ckd[i]);		  
		}
	}
	
//	
//    /**
//	 * 장바구니 리스트내의 상품 수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return 리스트의 갯수
//	 * @exception
//	 */
//    public int selectCartListTotCnt(SearchVO searchVO) {
//		return cartDAO.selectCartListTotCnt(searchVO);
//	}
    	
}
