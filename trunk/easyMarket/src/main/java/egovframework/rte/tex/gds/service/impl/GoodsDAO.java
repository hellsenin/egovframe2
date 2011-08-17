package egovframework.rte.tex.gds.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.gds.service.GoodsImageVO;
import egovframework.rte.tex.gds.service.GoodsVO;

/**
 * 
 * @Class Name : GoodsDAO.java
 * @Description : GoodsDAO class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */

@Repository("goodsDAO")
public class GoodsDAO extends EgovAbstractDAO{
	
	/** 
	 * 상품정보를 조회한다
	 * @param searchVO 검색정보
	 * @return List<GoodsVO> 상품정보
	 */

	public List<GoodsVO> selectGoodsList(SearchVO searchVO) throws Exception
	{
		return list("goodsDAO.selectGoodsList", searchVO);
	}

	/** 
	 * 상품정보를 등록한다
	 * @param goodsVO 등록될 상품정보
	 * @return String 등록 결과
	 */
	public String insertGoods(GoodsVO goodsVO) throws Exception
	{

		return (String)insert("goodsDAO.insertGoods", goodsVO);
	}
	
	/**
	 * 상품 상세정보를 조회한다
	 * @param goodsVO  상품정보
	 * @return GoodsVO 상품상세정보
	 */
	public GoodsVO selectGoods(GoodsVO goodsVO) throws Exception
	{
		return (GoodsVO)selectByPk("goodsDAO.selectGoods", goodsVO);
	}
	
	/**
	 * 조회된 상품정보를 수정한다
	 * @param goodsVO 상품정보
	 */
	public void updateGoods(GoodsVO goodsVO) throws Exception
	{
		update("goodsDAO.updateGoods", goodsVO);
		update("goodsDAO.updateGoodsImage", goodsVO.getGoodsImageVO());
		update("goodsDAO.updateGoodsImage", goodsVO.getDetailImageVO());
	}
	/**
	 * 조회된 상품정보를 삭제한다 ( 플래그 값 변경)
	 * @param goodsVO  상품정보
	 */
	public void deleteGoods(GoodsVO goodsVO) throws Exception
	{
		update("goodsDAO.deleteGoods", goodsVO);
		
	}
	
	public void deleteGoodsCart(GoodsVO goodsVO) throws Exception{
		delete("goodsDAO.deleteCart", goodsVO);
	}
	
	/**
	 * 상품목록의 갯수를 조회한다
	 * @param searchVO 검색정보
	 * @return int 상품 갯수
	 */
	public int selectGoodsListTotCnt(SearchVO searchVO) {
	        return (Integer)getSqlMapClientTemplate().queryForObject("goodsDAO.selectGoodsListTotCnt", searchVO);
	    }
	
	/** 
	 * 상품이미지 정보를 등록한다
	 * @param goodsImageVO 등록될 상품이미지정보
	 * @return String 등록 결과
	 */
	public String insertGoodsImage(GoodsImageVO goodsImgaeVO) throws Exception
	{

		return (String)insert("goodsDAO.insertGoodsImage", goodsImgaeVO);
	}
	
	/**
	 * 상품이미지 정보를 삭제한다
	 * @param goodsImageId 삭제될 상품이미지ID
	 */
	public void deleteGoodsImage(String goodsImageId) throws Exception
	{
		delete("goodsDAO.deleteGoodsImage", goodsImageId);
	}
	
	/** 
	 * 상품정보를 조회한다(xml, Excel용)
	 * @param searchVO 검색정보
	 * @return List<GoodsVO> 상품정보
	 */

	public List<GoodsVO> selectGoodsXml() throws Exception
	{
		return list("goodsDAO.selectGoodsXml", new GoodsVO());
	}
}
