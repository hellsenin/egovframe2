package egovframework.rte.tex.brd.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.brd.service.BoardVO;
import egovframework.rte.tex.com.service.SearchVO;

/**
 * @Class Name : BoardDAO.java
 * @Description : 게시판 정보에 관한 데이터 접근 클래스를 정의한다.ss
 * @author 신혜연
 * @since 2011.05.27
 * @version 1.0
*/
@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO{

	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	public List selectBoardList(SearchVO vo) throws Exception{
		List list = list("boardDAO.selectBoardList", vo);
		return list;
	}
	
	/**
	 * 글번호를 이용해 데이터베이스에서 글을 읽어와 화면에 출력한다.
	 * @param bbsctt_no 글번호
	 * @return 게시글 상세화면
	 * @throws Exception
	 */
	public BoardVO getBoard(BoardVO vo) throws Exception{
		return (BoardVO)selectByPk("boardDAO.selectBoard", vo);

	}
	
	/**
	 * 게시글을 데이터베이스에서 삭제한다.
	 * @param bbsctt_no 게시글번호
	 * @throws Exception
	 */
	public void deleteBoard(BoardVO vo) throws Exception{
		delete("boardDAO.deleteBoard", vo);
	}
	
	/**
	 * 게시글의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	public void insertBoard(BoardVO boardVO) throws Exception{
		insert("boardDAO.insertBoard", boardVO);
	}
	
	/**
	 * 화면에 조회된 게시글 정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param boardVO 게시글 정보
	 * @throws Exception
	 */
	public void updateBoard(BoardVO boardVO) throws Exception{
		update("boardDAO.updateBoard", boardVO);
	}
	
	 /**
	 * 글 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 총 갯수
	 * @exception
	 */
    public int selectBoardListTotCnt(SearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("boardDAO.selectBoardListTotCnt", searchVO);
    }
}
