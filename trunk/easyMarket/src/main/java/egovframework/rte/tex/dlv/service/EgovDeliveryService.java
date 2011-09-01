package egovframework.rte.tex.dlv.service;

import java.util.List;

import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : EgovDeliveryService.java
 * @Description : EgovDeliveryService Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public interface EgovDeliveryService {
	/** 
	 * 사용자의 구매목록을 조회한다
	 * @param purchaseVO 검색정보
	 * @return List<PurchaseVO>
	 */
	public List<PurchaseVO> selectPurchaseList(PurchaseVO purchaseVO) throws Exception;

	/** 
	 * 전체 구매목록을 조회한다(관리자용)
	 * @param purchaseVO 검색정보
	 * @return List<PurchaseVO>
	 */
	public List<PurchaseVO> selectAllPurchaseList(PurchaseVO purchaseVO) throws Exception;
	
	/**
	 * 배송정보를 조회한다
	 * @return List 배송정보 리스트
	 * @throws Exception
	 */
	public List selectDeliveryInfoList() throws Exception;

	/**
	 * 전체 구매목록을 조회한다(xml, Excel용)
	 * @return List 배송정보 리스트
	 * @throws Exception
	 */
	public List<PurchaseVO> selectAllPurchaseXml() throws Exception;
	
	/** 
	 * 배송상태를 변경한다
	 * @param status 배송상태
	 */
	public void updateDeliveryStatus(PurchaseVO purchaseVO) throws Exception;
	
	/** 
	 * 엑셀파일로 저장한다
	 * @param memberVO 회원정보
	 */
	public void exportExcel(MemberVO memberVO);
	
	/**
	 * 사용자의 구매목록의 건수를 조회한다
	 * @param purchaseVO 검색정보
	 * @return int 구매 건수
	 */
	public int selectPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception;
	
	/**
	 * 전체 구매목록의 건수를 조회한다 (관리자용)
	 * @param purchaseVO 검색정보
	 * @return int 구매 건수
	 */
	public int selectAllPurchaseListTotCnt(PurchaseVO purchaseVO) throws Exception;
}
