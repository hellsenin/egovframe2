package egovframework.rte.tex.pcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.CartVO;

/**
 * @Class Name : CartDAO.java
 * @Description : CartDAO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Repository("cartDAO")
public class CartDAO extends EgovAbstractDAO{
	
	/**
	 * 장바구니 목록을 조회한다
	 * @param searchVO 검색정보
	 * @return List<CartVO> 장바구니정보
	 */
	public List<CartVO> selectCartList(CartVO cartVO)
	{
		return list("cartDAO.selectCartList", cartVO);
	}
	
	/**
	 * 장바구니정보를 조회한다
	 * @param cartId 조회할 CartId
	 * @return CartVO 조회된 장바구니정보
	 */
	public CartVO selectCart(String cartId)
	{
		return (CartVO)selectByPk("cartDAO.selectCart", cartId);
	}

	/**
	 * 장바구니정보를 등록한다
	 * @param cartVO 장바구니정보
	 */
	public void insertCart(CartVO cartVO)
	{
		insert("cartDAO.insertCart", cartVO);
	}
	
	/**
	 * 선택된 장바구니정보를 삭제한다
	 * @param ckd 체크 리스트
	 */
	public void deleteCart(String ckd)
	{
		delete("cartDAO.deleteCart", ckd);
	}
	
//	/**
//	 * 상품목록의 갯수를 조회한다
//	 * @param searchVO 검색정보
//	 * @return int 리스트 갯수
//	 */
//	public int selectCartListTotCnt(CartVO cartVO) {
//	        return (Integer)getSqlMapClientTemplate().queryForObject("cartDAO.selectCartListTotCnt", cartVO);
//	    }
	
}
