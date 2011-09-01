package egovframework.rte.tex.gds.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.tex.com.service.SearchVO;

/**
 * 
 * @Class Name : GoodsService.java
 * @Description : GoodsService class
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
public interface EgovGoodsService {
	
	/**   
	 * 상품정보를 조회한다
	 * @param searchVO 검색정보
	 * @return List 상품정보 목록
	 */
	public List selectGoodsList(SearchVO searchVO) throws Exception;

	/** 
	 * 상품정보를 등록한다
	 * @param goodsVO 상품정보
     * @return 등록결과
	 */
	public String insertGoods(GoodsVO goodsVO) throws Exception;

	/**
	 * 상품 상세정보를 조회한다
	 * @param goodsVO 상품정보
	 * @return GoodsVO 상품정보
	 */
	public GoodsVO selectGoods(GoodsVO goodsVO) throws Exception;

	/**
	 * 조회된 상품정보를 수정한다
	 * @param goodsVO 상품정보
	 */
	public void updateGoods(GoodsVO goodsVO, final HttpServletRequest request) throws Exception;

	/**
	 * 조회된 상품정보를 삭제한다
	 * @param goodsVO 상품정보, HttpServletRequest request
	 */
	public void deleteGoods(GoodsVO goodsVO, final HttpServletRequest request) throws Exception;

    /**
     * 상품 총 갯수를 조회한다
     * @param searchVO 조회할 정보가 담긴 VO
     * @return 상품 총 갯수
     */
    int selectGoodsListTotCnt(SearchVO searchVO);
    
//    /**
//     * 상품이미지를 등록한다
//     * @param goodsImageVO 상품이미지 정보
//     * @return 등록결과
//     */
//    public String insertGoodsImage(GoodsImageVO goodsImageVO) throws Exception;
    
    /** 
	 * 상품정보를 조회한다(xml, Excel용)
	 * @param searchVO 검색정보
	 * @return List 상품정보 목록
	 */
	public List<GoodsVO> selectGoodsXml() throws Exception;
} 
