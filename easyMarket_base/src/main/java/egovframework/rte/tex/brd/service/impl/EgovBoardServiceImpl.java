package egovframework.rte.tex.brd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.tex.brd.service.BoardVO;
import egovframework.rte.tex.brd.service.EgovBoardService;
import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : EgovBoardInfoServiceImpl.java
 * @Description : 게시판에 관한 비지니스클래스를 정의한다.
 * @author 신혜연
 * @since 2011.05.27 
 * @version 1.0
*/
@Service("boardService")
public class EgovBoardServiceImpl extends AbstractServiceImpl implements EgovBoardService{

	/** BoardDAO */
    @Resource(name="boardDAO")
	private BoardDAO boardDAO; //데이터베이스 접근 클래스

    /** ID Generation */
    @Resource(name="egovIdGnrServiceBrd")    
    private EgovIdGnrService egovIdGnrService;  //ID Generation
    
	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	public List selectBoardList(SearchVO searchVO) throws Exception {
		return boardDAO.selectBoardList(searchVO);
	}

	/**
	 * 글번호를 이용해 데이터베이스에서 글을 읽어와 화면에 출력한다.
	 * @param bbsctt_no 글번호
	 * @return 게시글 상세화면
	 * @throws Exception
	 */
	public BoardVO getBoard(BoardVO boardVO) throws Exception {
		BoardVO vo = boardDAO.getBoard(boardVO);
		if(vo==null)
			 throw processException("info.nodata.msg");
        return vo;
	}

	/**
	 * 게시글을 데이터베이스에서 삭제한다.
	 * @param bbsctt_no 게시글번호
	 * @throws Exception
	 */
	public void deleteBoard(BoardVO boardVO) throws Exception {
		boardDAO.deleteBoard(boardVO);
		
	}

	/**
	 * 게시글의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	public void insertBoard(BoardVO boardVO) throws Exception {
		log.debug(boardVO.toString());
		
		/** ID Generation Service */
    	String no = egovIdGnrService.getNextStringId();
    	boardVO.setbbscttNo(no);
    	log.debug(boardVO.toString());
    	
		boardDAO.insertBoard(boardVO);
		
	}

	/**
	 * 화면에 조회된 게시글 정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
		
	}

	public int selectBoardListTotCnt(SearchVO searchVO) {
		return boardDAO.selectBoardListTotCnt(searchVO);
	}

}
