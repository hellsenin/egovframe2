package egovframework.rte.tex.pcs.service;

/**
 * @Class Name : EgovPurchaseService.java
 * @Description : EgovPurchaseService Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public interface EgovPurchaseService {

	/** 
	 * 장바구니에서 선택된 상품을 구매
	 * @param ckd 체크리스트
	 */
	public void insertPurchaseFromCart(String[] ckd) throws Exception;
	
	/** 
	 * 상품을 구매
	 * @param ckd 체크리스트
	 */
	public void insertPurchase(PurchaseVO purchaseVO) throws Exception;
	
}
