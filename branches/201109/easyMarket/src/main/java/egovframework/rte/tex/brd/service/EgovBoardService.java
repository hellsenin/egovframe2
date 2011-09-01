package egovframework.rte.tex.brd.service;

import java.util.List; 

import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : EgovBoardInfoService.java
 * @Description : 게시판에 관한 인터페이스클래스를 정의한다.
 * @author 신혜연
 * @since 2011.05.27
 * @version 1.0
*/
public interface EgovBoardService {
    
	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @param SearchVO 검색조건
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	List selectBoardList(SearchVO searchVO) throws Exception;
	
	/**
	 * 글번호를 이용해 데이터베이스에서 글을 읽어와 화면에 출력한다.
	 * @param bbsctt_no 글번호
	 * @return 게시글 상세화면
	 * @throws Exception
	 */
	BoardVO getBoard(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시글을 데이터베이스에서 삭제한다.
	 * @param bbsctt_no 게시글번호
	 * @throws Exception
	 */
	void deleteBoard(BoardVO boardVO) throws Exception;

	/**
	 * 게시글의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	void insertBoard(BoardVO boardVO) throws Exception;

	/**
	 * 화면에 조회된 게시글 정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	void updateBoard(BoardVO boardVO) throws Exception;
	
    /**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
    int selectBoardListTotCnt(SearchVO searchVO);
    
}
