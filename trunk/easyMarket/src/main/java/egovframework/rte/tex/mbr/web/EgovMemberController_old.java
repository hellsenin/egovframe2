package egovframework.rte.tex.mbr.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.tex.com.service.EgovUserUtil;
import egovframework.rte.tex.mbr.service.EgovMemberService;
import egovframework.rte.tex.mbr.service.MemberVO;
/**
 *@Class Name : EgovMemberInfoController.java
 *@Description : EgovMemberInfoController class
 *@author 신혜연
 *@since 2011.05.25
 *@version 1.0
 */
public class EgovMemberController_old {
/*
 * 
 * 
 * 
 * 
	*//**MemberService *//*
	@Resource(name="memberService")
	private EgovMemberService memberService; //회원 정보에 관한 인터페이스 클래스
	
	*//** EgovPropertyService *//*
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
    *//** Validator *//*
    @Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
    
	*//**
	 * 비밀번호 찾기 화면으로 이동한다.
	 * @return String 비밀번호 찾기 화면
	 * @throws Exception
	 *//*
    @RequestMapping("/mbr/searchPasswordView.do")
	public String searchPassword() throws Exception{
		return "mbr/egovSearchPassword";
	}
    
	*//**
	 * 비밀번호를 메일로 전송한 후 메인화면으로 이동한다.
	 * @param id ID
	 * @param email 이메일
	 * @return String 메인화면 
	 * @throws Exception
	 *//*
    @RequestMapping("/mbr/sendEmail.do")
	public String sendEmail(String id, String email, Model model) throws Exception{
    	MemberVO memberVO=new MemberVO();
    	memberVO.setId(id);
    	memberVO.setEmail(email);
    	boolean result= memberService.searchPassword(memberVO);
    	 if (result) {
             model.addAttribute("resultMsg", "sendEmailSuccess");
 			return "mbr/egovResult";
 			
         } else {
             model.addAttribute("resultMsg", "sendEmailFail");
 			return "mbr/egovResult";
         }
	}
	
    
    *//**
     * 로그인 화면으로 이동한다.
     * @return String 로그인 화면
     * @throws Exception
     *//*
    @RequestMapping("/mbr/loginView.do")
    public String loginView(HttpServletRequest request, Model model) throws Exception{
    	MemberVO vo = EgovUserUtil.getMemberInfo();
    	if(vo != null){
    		return "main/EgovMain";
    	}else{
    		model.addAttribute("login_error", request.getParameter("login_error"));
    		return "mbr/egovLogin";
    	}
    }
    *//**
     * 로그인 후 메인 화면 이동
     * @param
     * @return 
     * @exception Exception
     *//*
    @RequestMapping(value = "/mbr/actionMain.do")
    public String actionMain(HttpServletRequest request, Model model)
            throws Exception {
        // Spring Security
        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
        MemberVO memberVO=EgovUserUtil.getMemberInfo();
        if (!isAuthenticated) {
            return "mbr/egovLogin";
        }else{
        	model.addAttribute("loginVO", memberVO);
        	return "main/EgovMain";
        }
    }
    
	
	*//**
	 * 회원가입 화면으로 이동한다.
	 * @return String 회원가입 화면
	 * @throws Exception
	 *//*
	@RequestMapping("/mbr/insertMemberView.do")
	public String sbscrhMember(Model model) throws Exception{
		model.addAttribute("memberVO", new MemberVO());
		return "mbr/egovMemberRegister";
	}
    
	*//**
	 * 회원정보를 등록한 후 메인화면으로 이동한다.
	 * @param memberVO 회원정보
	 * @return String 메인화면
	 * @throws Exception
	 *//*
	@RequestMapping("/mbr/insertMember.do")
	public String insertMember(@ModelAttribute("memberVO") MemberVO memberVO,  
			BindingResult bindingResult, Model model,
			SessionStatus status) throws Exception{
		
			beanValidator.validate(memberVO, bindingResult);

			if (bindingResult.hasErrors()) {
				model.addAttribute("memberVO", memberVO);
				return "mbr/egovMemberRegister";
			}

			int count = memberService.checkIdDplct(memberVO.getId());
        	
        	if(count == 1){
				model.addAttribute("resultMsg", "idDpl");
				return "mbr/egovMemberRegister";
        	}else{
        		memberService.insertMember(memberVO);
    			status.setComplete();
    			model.addAttribute("resultMsg", "insertSuccess");
    			return "mbr/egovResult";
        	}
	}
	
	*//**
	 * 회원정보 수정으로 이동한다.
	 * @return String 회원가입 화면
	 * @throws Exception
	 *//*
	@RequestMapping("/mbr/updateMemberView.do")
	public String updateMemberView(Model model) throws Exception{
		MemberVO memberVO = EgovUserUtil.getMemberInfo();
		model.addAttribute("memberVO", memberVO);
		return "mbr/egovMemberRegister";
	}
	
	*//**
	 * 회원정보 수정 후 메인화면으로 이동한다.
	 * @param memberVO 회원정보
	 * @return String 메인화면
	 * @throws Exception
	 *//*
	@RequestMapping("/mbr/updateMember.do")
	public String updateMember(@ModelAttribute("memberVO") MemberVO memberVO, BindingResult bindingResult, Model model,
			SessionStatus status) throws Exception{
		
		  Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
	        if (!isAuthenticated) {
	            return "mbr/egovMemberRegister"; 
	        }
	        
		beanValidator.validate(memberVO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "mbr/egovMemberRegister";
		}

		memberService.updateMember(memberVO);
		status.setComplete();
		model.addAttribute("loginVO", memberVO);
		model.addAttribute("resultMsg", "updateSuccess");
//		return "mbr/egovResult";
		return "redirect:/mbr/actionMain.do";
	
	}
	
	*//**
	 * 회원삭제 후 메인화면으로 이동한다.
	 * @param memberVO 회원정보
	 * @return String 메인화면
	 * @throws Exception
	 *//*
	@RequestMapping("/mbr/deleteMember.do")
	public String deleteMember(MemberVO memberVO, SessionStatus status) throws Exception{
		memberService.deleteMember(memberVO);
		status.setComplete();
		 return "redirect:/j_spring_security_logout";
	}
	
	*
	*
	*/
	
}
