package actions.qna;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import model.qna.QnaDAO;
import model.qna.QnaVO;

public class QnaInsertAction implements Actions {

	private static Logger logger = LoggerFactory.getLogger(QnaInsertAction.class);
	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("QNA Insert Actions Started :: ");
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String imgfile = req.getParameter("imgfile");
		String content = req.getParameter("content");
		logger.info("Insert :: "+writer+" / "+title);
		try {
			QnaDAO qdao = new QnaDAO();
			QnaVO qvo = new QnaVO(writer, title, content, imgfile);
			qdao.insert(qvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
