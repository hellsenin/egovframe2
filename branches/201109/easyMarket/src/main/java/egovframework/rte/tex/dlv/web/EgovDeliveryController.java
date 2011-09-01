package egovframework.rte.tex.dlv.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.rte.tex.com.service.EgovUserUtil;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.dlv.service.EgovDeliveryService;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : EgovDeliveryController.java
 * @Description : EgovDeliveryController Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Controller
public class EgovDeliveryController {
	
	@Resource(name = "egovDeliveryService")
	EgovDeliveryService egovDeliveryService; //EgovDeliveryService 서비스
	
    @Resource(name = "propertiesService") 
    protected EgovPropertyService propertiesService; //EgovPropertyService
    
	/**
	 * 사용자 구매목록을 조회한다
	 * @param searchVO
	 * @param model
	 * @return String 구매목록 화면
	 * @throws Exception
	 */
	@RequestMapping("/dlv/selectListPurchase.do")
	public String selectPurchaseList(@ModelAttribute("searchVO") SearchVO searchVO, 
			ModelMap model) throws Exception
	{
		/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		MemberVO loginVO = EgovUserUtil.getMemberInfo();
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setSearchVO(searchVO);
		purchaseVO.setMberNo(loginVO.getMemberNo());
		
		List<PurchaseVO> purchsList = egovDeliveryService.selectPurchaseList(purchaseVO);
		model.addAttribute("resultList", purchsList);
		
		int totCnt = egovDeliveryService.selectPurchaseListTotCnt(purchaseVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		
	      
		return "dlv/EgovDeliveryList";
	}
	/**
	 * 전체 구매목록을 조회한다
	 * @param searchVO
	 * @param model
	 * @return String 구매목록 화면
	 * @throws Exception
	 */
	@RequestMapping("/dlv/selectAllListPurchase.do")
	public String selectAllPurchaseList(@ModelAttribute("searchVO") SearchVO searchVO, 
			ModelMap model) throws Exception
			{
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setSearchVO(searchVO);
		
		List<PurchaseVO> purchsList = egovDeliveryService.selectAllPurchaseList(purchaseVO);
		model.addAttribute("resultList", purchsList);
		
		int totCnt = egovDeliveryService.selectAllPurchaseListTotCnt(purchaseVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		List dlvyInfo = egovDeliveryService.selectDeliveryInfoList();
		model.addAttribute("dlvyList", dlvyInfo);
		
		return "dlv/EgovDeliveryAllList";
			}
	
	/** 
	 * 배송상태를 변경한다
	 * @param status 배송상태
	 */
	@RequestMapping("/dlv/updateDlvySttus.do")
	public String updateDeliveryStatus(@RequestParam("dlvySe") String dlvySe,
			@RequestParam("purchaseId") String purchsId) throws Exception
	{
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setPurchsId(purchsId);
		purchaseVO.setDlvySe(dlvySe);
		
		egovDeliveryService.updateDeliveryStatus(purchaseVO);
		return "redirect:/dlv/selectAllListPurchase.do";
	}
	
	
	/**
	 * 전체 구매 목록을 xml로 변환한
	 */
	@Resource MarshallingView purMarshallingView;
	@RequestMapping("/dlv/viewXML.do")
	public ModelAndView viewXML(@ModelAttribute("searchVO") SearchVO searchVO) throws Exception{
		
		List<PurchaseVO> purchsList = egovDeliveryService.selectAllPurchaseXml();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("purchsList", purchsList);
		
		return new ModelAndView(purMarshallingView, model);
	}
	
	
}
