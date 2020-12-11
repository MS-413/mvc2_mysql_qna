package actions.qna;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import model.qna.QnaDAO;
import model.qna.QnaVO;

public class QnaUpdateAction implements Actions {

	private static Logger logger = LoggerFactory.getLogger(QnaUpdateAction.class);
	
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("QNA Update Actions Started :: ");
		int qno = Integer.parseInt(req.getParameter("qno"));
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String imgfile = req.getParameter("imgfile");
		String content = req.getParameter("content");
		System.out.println("Modified :: "+qno+" / "+title+" / "+content);
		QnaVO qvo = new QnaVO(writer, title, content, imgfile);
		qvo.setQno(qno);
		int result = 0;
		try {
			QnaDAO qdao = new QnaDAO();
			result = qdao.update(qvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(result==0?"수정 실패":"수정 성공");
	}

}
