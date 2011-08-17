package egovframework.rte.tex.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.tex.pcs.service.CartVO;
import egovframework.rte.tex.pcs.service.EgovCartService;
import egovframework.rte.tex.pcs.service.EgovPurchaseService;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : EgovPurchaseServiceImpl.java
 * @Description : EgovPurchaseServiceImpl class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Service("purchaseService")
public class EgovPurchaseServiceImpl extends AbstractServiceImpl implements EgovPurchaseService{
	
	@Resource(name="cartService")
	EgovCartService egovCartService; //EgovCartService
	
	@Resource(name="purchaseDAO")
	PurchaseDAO purchaseDAO; //PurchaseDAO
	
	@Resource(name="egovIdGnrServicePurchs")
	EgovIdGnrService egovIdGnrServicePurchs; //purchaseId Generation
	
	/** 
	 * 장바구니에서 선택된 상품을 구매
	 * @param ckd 체크리스트
	 */
	public void insertPurchaseFromCart(String[] ckd) throws Exception
	{
		PurchaseVO purchaseVO = new PurchaseVO();
		CartVO cartVO;
		for(int i = 0;i<ckd.length;i++)
		{
			//선택된 장바구니 조회
			cartVO = egovCartService.selectCart(ckd[i]);
			log.debug(cartVO.toString());
				
			//purchaseVO에 값 입력
			purchaseVO.setPurchsId(egovIdGnrServicePurchs.getNextStringId());
			purchaseVO.setGoodsVO(cartVO.getGoodsVO());
			purchaseVO.setMberNo(cartVO.getMberNo());
			purchaseVO.setQy(cartVO.getQy());
			
			//구매리스트에 insert
			purchaseDAO.insertPurchase(purchaseVO);
		}
		//선택된 장바구니 삭제
		egovCartService.deleteCart(ckd);
	}
	
	/** 
	 * 상품을 구매
	 * @param purchaseVO 구매VO
	 */
	public void insertPurchase(PurchaseVO purchaseVO) throws Exception
	{
		purchaseVO.setPurchsId(egovIdGnrServicePurchs.getNextStringId());

		//구매리스트에 insert
		purchaseDAO.insertPurchase(purchaseVO);
	}
	
}
