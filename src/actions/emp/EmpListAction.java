package actions.emp;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import actions.qna.QnaInsertAction;
import model.emp.EmpDAO;
import model.emp.EmpVO;

public class EmpListAction implements Actions {
	private static Logger logger = LoggerFactory.getLogger(QnaInsertAction.class);
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("EMP LIST ACTION Started :: ");
		EmpDAO edao;
		try {
			edao = new EmpDAO();
			ArrayList<EmpVO> aevo  = edao.selectList();
			req.setAttribute("list", aevo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
