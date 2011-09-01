package egovframework.rte.tex.cgr.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.tex.cgr.service.CategoryVO;
import egovframework.rte.tex.cgr.service.EgovCategoryService;

/**
 *@Class Name :EgovCategoryController.java
 *@Description : EgovCategoryController class
 *@author 신혜연
 *@since 2011.05.26
 *@version 1.0
 */
@Controller
@SessionAttributes(types=CategoryVO.class)
public class EgovCategoryController {

	/**CategoryService */
	@Resource(name="categoryService")
	private EgovCategoryService categoryService; // 카테고리정보에 관한 인터페이스클래스
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
    /** Validator */
//    @Resource(name = "beanValidator")
//	protected DefaultBeanValidator beanValidator;
    
    
	/**
	 * 카테고리 목록을 출력한다.
	 * @return String 목록조회 화면
	 * @throws Exception
	 */
	@RequestMapping(value="/springrest/cgr", method=RequestMethod.GET)
	public String selectCategoryList(HttpServletRequest request, Model model)
			throws Exception {
		List categoryList = categoryService.selectCategoryList();
		model.addAttribute("categoryList", categoryList);

		if("popup".equals(request.getParameter("name"))) return "cgr/EgovCategoryPopup";
		else 
			return "cgr/egovCategoryList";
	}
	
	/**
	 * 카테고리 등록 화면으로 이동한다.
	 * @return String 카테고리 등록 화면
	 */
    @RequestMapping(value="/springrest/cgr/new", method=RequestMethod.GET)
    public String insertCategoryView(Model model) throws Exception {
    	model.addAttribute("categoryVO", new CategoryVO());
    	return "cgr/egovCategoryRegister";
    }
    
    
	@RequestMapping(value="/springrest/cgr", method = RequestMethod.POST, headers = "Content-type=application/x-www-form-urlencoded")
	public String create(@Valid CategoryVO categoryVO, BindingResult results,
			HttpSession session, Model model) throws Exception {
		if (results.hasErrors()) {
			return "cgr/egovCategoryRegister";
		}

		categoryService.insertCategory(categoryVO);

		return "redirect:/springrest/cgr.html";
	}
	
	
	
	/**
	 * 카테고리 수정 화면으로 이동한다.
	 * @param categoryId 카테고리ID
	 * @return String 카테고리 수정 화면
	 * @throws Exception
	 */
	@RequestMapping(value="/springrest/cgr/{ctgryId}", method = RequestMethod.GET)
	public String updtCategoryView(@PathVariable String ctgryId,	 Model model)
			throws Exception {
		CategoryVO vo = new CategoryVO();
		vo.setCtgryId(ctgryId);
		model.addAttribute(categoryService.getCategory(vo));
		return "cgr/egovCategoryRegister";
	}
	/**
	 * 카데고리 정보를 수정 후 목록조회 화면으로 이동한다.
	 * 
	 * @param updateCategory
	 * @param model
	 * @return return Page object, Response Status : 200 OK
	 * @throws Exception
	 */
	@RequestMapping(value = "/springrest/cgr/{ctgryId}", method = RequestMethod.PUT, headers = "Content-type=application/x-www-form-urlencoded")
	public String update(@Valid CategoryVO updateCategory, BindingResult results,
			Model model) throws Exception {
		if (results.hasErrors()) {
			return "cgr/egovCategoryRegister";
		}
		categoryService.updateCategory(updateCategory);
		
		return "redirect:/springrest/cgr.html";
	}
	
	
	/**
	 * 카테고리 정보 삭제 후 목록조회 화면으로 이동한다.
	 * @param categoryIdList 카테고리ID 리스트
	 * @return String 목록조회 화면
	 * @throws Exception
	 */
	@RequestMapping(value = "/springrest/cgr/{ctgryId}", method=RequestMethod.DELETE)
	public String deleteCategory(@PathVariable String ctgryId, SessionStatus status, Model model){
		CategoryVO vo = new CategoryVO();
		vo.setCtgryId(ctgryId);
		try {
			categoryService.deleteCategory(vo);
			status.setComplete();
			return "redirect:/springrest/cgr.html";
		} catch (Exception e) {
			return "cgr/EgovCategoryNotDeletable";
		}
		
	}
}
