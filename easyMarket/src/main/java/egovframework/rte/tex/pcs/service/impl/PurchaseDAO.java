package egovframework.rte.tex.pcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : PurchaseDAO.java
 * @Description : PurchaseDAO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Repository("purchaseDAO")
public class PurchaseDAO extends EgovAbstractDAO{
	
	/** 
	 * 구매상품을 등록한다
	 * @param purchaseVO 구매VO
	 */
	public void insertPurchase(PurchaseVO purchaseVO)
	{
		insert("purchaseDAO.insertPurchase", purchaseVO);
	}
}
