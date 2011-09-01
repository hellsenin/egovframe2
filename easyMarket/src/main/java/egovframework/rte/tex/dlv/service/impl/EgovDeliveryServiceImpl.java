package egovframework.rte.tex.dlv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.dlv.service.EgovDeliveryService;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : EgovDeliveryServiceImpl.java
 * @Description : EgovDeliveryServiceImpl Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Service("egovDeliveryService")
public class EgovDeliveryServiceImpl extends AbstractServiceImpl implements EgovDeliveryService{
	
	@Resource(name = "deliveryDAO")
	DeliveryDAO deliveryDAO; //DeliveryDAO
	
	/**
	 * 사용자의 구매목록 조회
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectPurchaseList(PurchaseVO purchaseVO) throws Exception
	{
		return deliveryDAO.selectPurchaseList(purchaseVO);
	}

	/**
	 * 전체 구매목록 조회(관리자용)
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectAllPurchaseList(PurchaseVO purchaseVO) throws Exception
	{
		return deliveryDAO.selectAllPurchaseList(purchaseVO);
	}
	
	/**
	 * 전체 구매목록 조회(xml, Excel용)
	 * @return List<PurchaseVO> 구매내역 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectAllPurchaseXml() throws Exception
	{
		return deliveryDAO.selectAllPurchaseXml();
	}
	
	/**
	 * 배송정보를 조회한다
	 * @return List 배송정보 리스트
	 * @throws Exception
	 */
	public List selectDeliveryInfoList() throws Exception
	{
		return deliveryDAO.selectDeliveryInfoList();
	}
	
	/** 
	 * 배송상태를 변경한다
	 * @param status 배송상태
	 */
	public void updateDeliveryStatus(PurchaseVO purchaseVO)  throws Exception
	{
		log.debug(purchaseVO.toString());
		deliveryDAO.updateDeliveryStatus(purchaseVO);
	}
	
	/** 
	 * 엑셀파일로 저장한다
	 * @param memberVO 회원정보
	 */
	public void exportExcel(MemberVO memberVO)
	{
		//TODO
	}
	
	/**
	 * 사용자의 구매목록의 건수를 조회한다
	 * @param searchVO 검색정보
	 * @return int 구매 건수
	 */
	public int selectPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception {

		return deliveryDAO.selectGoodsListTotCnt(purchaseVO);
	}
	
	/**
	 *  전체 구매목록의 건수를 조회한다(관리자)
	 * @param searchVO 검색정보
	 * @return int 구매 건수
	 */
	public int selectAllPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception {
		
		return deliveryDAO.selectAllGoodsListTotCnt(purchaseVO);
	}
}
