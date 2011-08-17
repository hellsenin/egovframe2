package egovframework.rte.tex.gds.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.tex.com.service.SearchVO;
import egovframework.rte.tex.gds.service.EgovGoodsService;
import egovframework.rte.tex.gds.service.GoodsImageVO;
import egovframework.rte.tex.gds.service.GoodsVO;

/**
 * 
 * @Class Name : GoodsServiceImpl.java
 * @Description : GoodsServiceImpl class 
 * @author 이영진
 * @since 2011. 5. 27.
 * @version 1.0
 */
@Service("goodsService")
public class EgovGoodsServiceImpl extends AbstractServiceImpl implements EgovGoodsService{
	
	@Resource(name="goodsDAO")
	private GoodsDAO goodsDAO; // GoodsDAO
	
	@Resource(name="egovIdGnrServiceGds")
	private EgovIdGnrService egovIdGnrServiceGds; // goodsID Generation
	
	@Resource(name = "fileUploadProperties") //fileUploadProperties
	Properties fileUploadProperties;
	
	@Resource(name = "egovIdGnrServiceImage")
	private EgovIdGnrService egovIdGnrServiceImage; // goodsImageID Generation
	
	/** 
	 * 상품정보를 조회한다
	 * @param searchVO 검색정보
	 * @return List<GoodsVO> 상품정보
	 */
	public List<GoodsVO> selectGoodsList(SearchVO searchVO) throws Exception
	{
		return goodsDAO.selectGoodsList(searchVO);
	}

	/** 
	 * 상품정보를 등록한다
	 * @param goodsVO 등록되는 상품정보
	 * @return String 등록 결과
	 */
	public String insertGoods(GoodsVO goodsVO) throws Exception
	{
		log.debug(goodsVO.toString());
		
		goodsDAO.insertGoodsImage(goodsVO.getGoodsImageVO());
		goodsDAO.insertGoodsImage(goodsVO.getDetailImageVO());
		
		
		/** ID Generation Service */
    	String id = egovIdGnrServiceGds.getNextStringId();
    	goodsVO.setGoodsId(id);
		log.debug(goodsVO.toString());
		
    	goodsDAO.insertGoods(goodsVO);

		return id;
	}
	
	/**
	 * 상품 상세정보를 조회한다
	 * @param goodsVO 상품정보
	 * @return GoodsVO 상품상세정보
	 */
	public GoodsVO selectGoods(GoodsVO goodsVO) throws Exception
	{
		GoodsVO resultVO = goodsDAO.selectGoods(goodsVO);
		log.debug(resultVO);
		
		if (resultVO == null)
            throw processException("info.nodata.msg");
		
        return resultVO;
	}
	
	/**
	 * 조회된 상품정보를 수정한다
	 * @param goodsVO 상품정보
	 */
	public void updateGoods(GoodsVO goodsVO, final HttpServletRequest request) throws Exception
	{
//		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//		String imgId = goodsVO.getGoodsImageVO().getGoodsImageid();
//		String dImgId = goodsVO.getDetailImageVO().getGoodsImageid();
//
//		// extract files
//		final Map<String, MultipartFile> files = multiRequest.getFileMap();
//		Assert.notNull(files, "files is null");
//		Assert.state(files.size() > 0, "0 files exist");
//		
//
//    	//process files
//		String uploadPath = fileUploadProperties.getProperty("file.upload.path");
//
//		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//		MultipartFile file;
//		String filePath;
//
//		while (itr.hasNext()) {
//			
//			// 상품이미지를 가지고 온다
//			Entry<String, MultipartFile> entry = itr.next(); 
//			file = entry.getValue();
//
//			if (!"".equals(file.getOriginalFilename())) {
//
//				// 파일 전송
//				filePath = uploadPath + "\\" + imgId;
//				file.transferTo(new File(filePath));
//				}
//			}


//		String saveFileName = egovIdGnrServiceImage.getNextStringId();

		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		
//		List<GoodsImageVO> imageList = new ArrayList<GoodsImageVO>();
		GoodsImageVO[] imageList = new GoodsImageVO[2];
		// extract files
		final Map<String, MultipartFile> files = multiRequest.getFileMap();

		// process files
		String uploadLastPath = fileUploadProperties.getProperty("file.upload.path");
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/") + uploadLastPath;
		File saveFolder = new File(uploadPath);

		// 디렉토리 생성
		boolean isDir = false;

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}

		if (!isDir) {

			Iterator<Entry<String, MultipartFile>> itr = files.entrySet()
					.iterator();
			MultipartFile file;
			String filePath;
			int i = 0; // goodsImage,detailImage 구분용 index 
			while (itr.hasNext()) {

				// 상품이미지를 가지고 온다
				Entry<String, MultipartFile> entry = itr.next();
				file = entry.getValue();

				if (!"".equals(file.getOriginalFilename())) {

//					String saveFileName = egovIdGnrServiceImage
//						.getNextStringId();
					
					String saveFileName;
					
					if (i == 0) {
						saveFileName = goodsVO.getGoodsImageVO().getGoodsImageId();
					} else {
						saveFileName = goodsVO.getDetailImageVO().getGoodsImageId();
					}
					
					imageList[i] =  new GoodsImageVO(
							saveFileName, file
							.getOriginalFilename());
					System.out.println(imageList[i].toString());
					// 파일 전송
					filePath = uploadPath + "\\" + saveFileName;
					file.transferTo(new File(filePath));
				}
				i++;
			}
		}
		if (imageList[0] != null)
			goodsVO.setGoodsImageVO(imageList[0]);
		if (imageList[1] != null)
			goodsVO.setDetailImageVO(imageList[1]);
		
		goodsDAO.updateGoods(goodsVO);
		
	}
	
	/**
	 * 조회된 상품정보를 삭제한다
	 * @param goodsVO 상품정보, HttpServletRequest request
	 */
	public void deleteGoods(GoodsVO goodsVO, final HttpServletRequest request) throws Exception
	{
		
		/*
		 * 상품 삭제는 플래그 값만 변경하여 물품을 구매 할 수 없도록 한다.
		 */


//		String uploadLastPath = fileUploadProperties.getProperty("file.upload.path");
//		String uploadPath = request.getSession().getServletContext().getRealPath("/") + uploadLastPath;
//		String imagePath = uploadPath + "\\" + goodsVO.getGoodsImageVO().getGoodsImageId();
//		String detailImagePath = uploadPath + "\\" + goodsVO.getDetailImageVO().getGoodsImageId();
//		
//    	File imageFile, detailImageFile;
//    	
//    	imageFile = new File(imagePath);
//    	detailImageFile = new File(detailImagePath);
//		if (imageFile.exists() && detailImageFile.exists()) {
//			boolean delFlag1 = imageFile.delete();
//			boolean delFlag2 = detailImageFile.delete();
//
//			if (delFlag1 && delFlag2)
//				log.error("상품이미지 삭제 성공");
//			else
//				log.error("상품이미지 삭제 실패");
//		} else {
//			log.error("상품이미지 없음");
//		}

    	goodsDAO.deleteGoods(goodsVO); //상품삭제(플래그 변경)
    	goodsDAO.deleteGoodsCart(goodsVO); //상품이 있는 카트 모두 삭제
//    	goodsDAO.deleteGoodsImage(goodsVO.getGoodsImageVO().getGoodsImageId());
//    	goodsDAO.deleteGoodsImage(goodsVO.getDetailImageVO().getGoodsImageId());
    	
	}
	/**
	 * 상품목록의 갯수를 조회한다
	 * @param searchVO 검색정보
	 * @return int 상품 갯수
	 */
	public int selectGoodsListTotCnt(SearchVO searchVO) {
			
		return goodsDAO.selectGoodsListTotCnt(searchVO);
	}

	/** 
	 * 상품정보를 조회한다(xml, Excel용)
	 * @param searchVO 검색정보
	 * @return List<GoodsVO> 상품정보
	 */
	public List<GoodsVO> selectGoodsXml() throws Exception
	{
		return goodsDAO.selectGoodsXml();
	}
}
