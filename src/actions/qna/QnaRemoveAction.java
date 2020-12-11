package actions.qna;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import model.qna.QnaDAO;

public class QnaRemoveAction implements Actions {

	private static Logger logger = LoggerFactory.getLogger(QnaRemoveAction.class);
	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("QNA Remoce Actions Started :: ");
		int qno = Integer.parseInt(req.getParameter("qno"));
		try {
			QnaDAO qdao = new QnaDAO();
			qdao.delete(qno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
