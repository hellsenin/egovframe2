package egovframework.rte.tex.dlv.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : DeliveryDAO.java
 * @Description : DeliveryDAO Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Repository("deliveryDAO")
public class DeliveryDAO extends EgovAbstractDAO {

	/**
	 * 사용자의 구매내역 조회
	 * 
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectPurchaseList(PurchaseVO purchaseVO)
			throws Exception {
		return list("deliveryDAO.selectPurchaseList", purchaseVO);
	}

	/**
	 * 전체 구매내역 조회(관리자용)
	 * 
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectAllPurchaseList(PurchaseVO purchaseVO)
	throws Exception {
		return list("deliveryDAO.selectAllPurchaseList", purchaseVO);
	}
	
	/**
	 * 전체 구매내역 조회(xml, Excel용)
	 * 
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectAllPurchaseXml()
	throws Exception {
		return list("deliveryDAO.selectAllPurchaseXml", new PurchaseVO());
	}

	/**
	 * 배송상태를 변경한다
	 * 
	 * @param status
	 *            배송상태
	 */
	public void updateDeliveryStatus(PurchaseVO purchaseVO) {
		update("deliveryDAO.updateDeleveryInfo", purchaseVO);
	}

	/**
	 * 배송정보를 조회한다
	 * 
	 * @return List 배송정보 리스트
	 * @throws Exception
	 */
	public List selectDeliveryInfoList() throws Exception {
		return list("deliveryDAO.selectDeliveryInfoList", null);
	}

	/**
	 * 사용자의 구매목록의 건수를 조회한다
	 * 
	 * @param searchVO
	 *            검색정보
	 * @return int 구매 건수
	 */
	public int selectGoodsListTotCnt(PurchaseVO purchaseVO) throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"deliveryDAO.selectDeleveryInfoListTotCnt", purchaseVO);
	}
	
	/**
	 * 전체 구매목록의 건수를 조회한다(관리자용)
	 * 
	 * @param searchVO
	 *            검색정보
	 * @return int 구매 건수
	 */
	public int selectAllGoodsListTotCnt(PurchaseVO purchaseVO) throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"deliveryDAO.selectAllDeleveryInfoListTotCnt", purchaseVO);
	}
}
