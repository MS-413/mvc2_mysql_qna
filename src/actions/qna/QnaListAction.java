package actions.qna;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import model.qna.QnaDAO;
import model.qna.QnaVO;

public class QnaListAction implements Actions {

	private static Logger logger = LoggerFactory.getLogger(QnaListAction.class);
	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("QNA List Actions Started :: ");
		try {
			QnaDAO qdao = new QnaDAO();
			ArrayList<QnaVO> aqvo = qdao.selectAll(); 
			req.setAttribute("aqvo", aqvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
