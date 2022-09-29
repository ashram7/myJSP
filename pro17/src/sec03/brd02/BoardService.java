package sec03.brd02;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		/*생성자 호출시 BoardDAO 객체를 생성*/
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
}
