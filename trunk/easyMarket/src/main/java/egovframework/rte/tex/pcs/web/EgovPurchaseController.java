package egovframework.rte.tex.pcs.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.tex.cgr.service.CategoryVO;
import egovframework.rte.tex.com.service.EgovUserUtil;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.gds.service.GoodsVO;
import egovframework.rte.tex.mbr.service.MemberVO;
import egovframework.rte.tex.pcs.service.CartVO;
import egovframework.rte.tex.pcs.service.EgovCartService;
import egovframework.rte.tex.pcs.service.EgovPurchaseService;
import egovframework.rte.tex.pcs.service.PurchaseVO;

/**
 * @Class Name : EgovPurchaseController.java
 * @Description : EgovPurchaseController Class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Controller
public class EgovPurchaseController {
	
	@Resource(name="purchaseService")
	EgovPurchaseService egovPurchaseService; //EgovPurchaseService
	
	@Resource(name="cartService")
	EgovCartService egovCartService; //EgovCartService
	
    @Resource(name = "propertiesService") 
    protected EgovPropertyService propertiesService; //EgovPropertyService
    
	/**
	 * 장바구니정보를 조회한다
	 * @param searchVO 검색정보
	 * @return String 장바구니정보조회 화면
	 */
	@RequestMapping("/pcs/selectListCart.do")
	public String selectCartList(@ModelAttribute("searchVO") SearchVO searchVO, ModelMap model) throws Exception
	{
		CartVO cartVO = new CartVO();
		cartVO.setSearchVO(searchVO);
		cartVO.setMberNo(EgovUserUtil.getMemberInfo().getMemberNo());
		
		List cartList = egovCartService.selectCartList(cartVO);
        model.addAttribute("resultList", cartList);
	
		return "pcs/EgovCartList";
	}

	/**
	 * 장바구니정보를 등록한다
	 * @param cartVO 장바구니정보
	 * @return String 장바구니정보등록 화면
	 */
	@RequestMapping("/pcs/insertCart.do")
	public String insertCart(
    		@RequestParam("selectedId") String goodsId,
    		@RequestParam("qy") int qy,
			@ModelAttribute("searchVO") SearchVO searchVO,Model model) throws Exception
	{
		

		CartVO cartVO = new CartVO();
		GoodsVO goodsVO = new GoodsVO();
		
		goodsVO.setGoodsId(goodsId);
		cartVO.setGoodsVO(goodsVO);
		
		MemberVO memberVO=EgovUserUtil.getMemberInfo();
		cartVO.setMberNo(memberVO.getMemberNo());
		cartVO.setQy(qy); 
		
		egovCartService.insertCart(cartVO);
		return "redirect:/pcs/selectListCart.do";
	}
	
	/**
	 * 선택된 장바구니정보를 삭제한다
	 * @param ckd 체크리스트
	 * @return String 장바구니정보조회 화면
	 */
	@RequestMapping("/pcs/deleteCart.do")
	public String deleteCart(
			@RequestParam("cart_col_check[]") String[] ckd) throws Exception
	{
		
		egovCartService.deleteCart(ckd);
		return "redirect:/pcs/selectListCart.do";
	}
	
	/** 
	 * 장바구니에서 선택된 상품을 구매한다
	 * @param ckd 체크리스트
	 * @return String 상품구매목록 화면
	 */
	@RequestMapping("/pcs/purchaseFromCart.do")
	public String insertPurchaseFromCart(
			@RequestParam("cart_col_check[]") String[] ckd) throws Exception
	{
		//transactional??????	추가
		egovPurchaseService.insertPurchaseFromCart(ckd);
		//주석 풀것
		return "redirect:/dlv/selectListPurchase.do";
	}
	
	/** 
	 * 상품을 구매한다
	 * @param ckd 체크리스트
	 * @return String 상품구매목록 화면
	 */
	@RequestMapping("/pcs/Purchase.do")
	public String insertPurchase(
    		@RequestParam("selectedId") String goodsId,
    		@RequestParam("qy") int qy,
			@ModelAttribute("searchVO") SearchVO searchVO,Model model) throws Exception
	{
		PurchaseVO purchaseVO = new PurchaseVO();
		//purchaseVO에 값 입력
		GoodsVO goodsVO = new GoodsVO();
		goodsVO.setGoodsId(goodsId);
		
		purchaseVO.setGoodsVO(goodsVO);
		
		MemberVO memberVO=EgovUserUtil.getMemberInfo();
		purchaseVO.setMberNo(memberVO.getMemberNo());
		purchaseVO.setQy(qy);
		egovPurchaseService.insertPurchase(purchaseVO);

		return "redirect:/dlv/selectListPurchase.do";
	}
	
}
