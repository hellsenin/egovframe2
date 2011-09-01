package egovframework.rte.tex.cgr.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.tex.cgr.service.CategoryVO;
import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : CategoryDAO.java
 * @Description : 카테고리에 관한 데이터 접근 클래스를 정의한다.
 * @author 신혜연
 * @since 2011.05.26
 * @version 1.0
*/
/**
 * @author SDS
 *
 */
@Repository("categoryDAO")
@Transactional
public class CategoryDAO extends HibernateDaoSupport {
	
	@Autowired
	public void setHibernateDaoSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 선택된 카테고리 정보를 데이터베이스에서 삭제한다.
	 * @param categoryIdList 카테고리ID리스트
	 * @throws Exception
	 */
	public void deleteCategory(CategoryVO categoryVO) throws Exception{
		super.getHibernateTemplate().delete(categoryVO);
	}
	
	/** 
	 * 카테고리의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param categoryVO 카테고리 정보
	 * @throws Exception
	 */
	public void insertCategory(CategoryVO categoryVO) throws Exception{
		super.getHibernateTemplate().save(categoryVO);
	}
	
	/** 
	 * 카테고리의 전체 목록을 데이터베이스에서 읽어와 화면에 출력한다.
	 * @return List<CategoryVO> 카테고리정보 리스트
	 * @throws Exception
	 */
	public List<CategoryVO> selectCategoryList() throws Exception{
//		public List<CategoryVO> selectCategoryList(SearchVO vo) throws Exception{
		return super.getHibernateTemplate().loadAll(CategoryVO.class);
	}
	
	/** 
	 * 화면에 조회된 카테고리 정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param categoryVO 카테고리 정보
	 * @throws Exception
	 */
	public void updateCategory(CategoryVO categoryVO) throws Exception{
		super.getHibernateTemplate().update(categoryVO);
	}
	
	/**
	 * 조회할 카테고리 정보의 갯수를 가져온다.
	 * @param vo SearchVO
	 * @return int 카테고리 갯수
	 * @throws Exception
	 */
	public int selectCategoryListTotCnt() throws Exception{
//		public int selectCategoryListTotCnt(SearchVO vo) throws Exception{
		return selectCategoryList().size();
	}
	
	/**
	 * 데이터베이스에서 카테고리 정보를 읽어와 화면에 출력한다.
	 * @param vo 카테고리 정보
	 * @return CategoryVO 카테고리 정보
	 * @throws Exception
	 */
	public CategoryVO getCategory(CategoryVO vo) throws Exception{
		return (CategoryVO) super.getHibernateTemplate().get(CategoryVO.class, vo.getCtgryId());
	}
}
