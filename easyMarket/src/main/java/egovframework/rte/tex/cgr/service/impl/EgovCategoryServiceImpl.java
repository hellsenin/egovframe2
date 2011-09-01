package egovframework.rte.tex.cgr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.tex.cgr.service.CategoryVO;
import egovframework.rte.tex.cgr.service.EgovCategoryService;

/**
 * @Class Name : EgovCategoryServiceImpl.java
 * @Description : 카테고리에 관한 비지니스클래스를 정의한다.
 * @author 신혜연
 * @since 2011.05.26
 * @version 1.0
*/
@Service("categoryService")
@Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
public class EgovCategoryServiceImpl extends AbstractServiceImpl implements EgovCategoryService {

	/** CategoryDAO */
    @Resource(name="categoryDAO")
	private CategoryDAO categoryDAO; //데이터베이스 접근 클래스

    /** ID Generation */
    @Resource(name="egovIdGnrServiceCgr")    
    private EgovIdGnrService egovIdGnrService; // ID Generation
    

	/**
	 * 선택된 카테고리 정보를 데이터베이스에서 삭제한다.
	 * @param categoryIdList 카테고리ID리스트
	 * @throws Exception
	 */
	public void deleteCategory(CategoryVO categoryVO) throws Exception {
		
		categoryDAO.deleteCategory(categoryVO);
	}
	
	/**
	 * 카테고리의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param categoryVO 카테고리 정보
	 * @throws Exception
	 */
	public String insertCategory(CategoryVO categoryVO) throws Exception {
		log.debug(categoryVO.toString());
		
		/** ID Generation Service */
    	String no = egovIdGnrService.getNextStringId();
    	categoryVO.setCtgryId(no);
    	log.debug(categoryVO.toString());
    	
		categoryDAO.insertCategory(categoryVO);
		
		return no;
	}
	
	/**
	 * 카테고리의 전체 목록을 데이터베이스에서 읽어와 화면에 출력한다.
	 * @return List 카테고리정보 리스트
	 * @throws Exception
	 */
	public List selectCategoryList() throws Exception {
//		public List selectCategoryList(SearchVO searchvo) throws Exception {
		return categoryDAO.selectCategoryList();
	}
	
	/**
	 * 화면에 조회된 카테고리 정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param categoryVO 카테고리 정보
	 * @throws Exception
	 */
	public void updateCategory(CategoryVO categoryVO) throws Exception {
		categoryDAO.updateCategory(categoryVO);
	}

	/**
	 * 조회할 카테고리 정보의 갯수를 가져온다.
	 * @param vo SearchVO
	 * @return int 카테고리 갯수
	 * @throws Exception
	 */
	public int selectCategoryListTotCnt() throws Exception {
//		public int selectCategoryListTotCnt(SearchVO searchVO) throws Exception {
		return categoryDAO.selectCategoryListTotCnt();
	}
	
	/**
	 * 카테고리의 정보를 데이터베이스에서 읽어와 화면에 출력한다.
	 * @param vo CategoryVO
	 * @return CategoryVO  카테고리 정보
	 * @throws Exception
	 */
	public CategoryVO getCategory(CategoryVO categoryVO) throws Exception {
		CategoryVO vo = categoryDAO.getCategory(categoryVO);
		if(vo==null)
			 throw processException("info.nodata.msg");
        return vo;
	}
	



}
