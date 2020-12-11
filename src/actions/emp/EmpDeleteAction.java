package actions.emp;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import actions.qna.QnaInsertAction;
import model.emp.EmpDAO;
import model.emp.EmpVO;

public class EmpDeleteAction implements Actions {
	private static Logger logger = LoggerFactory.getLogger(QnaInsertAction.class);
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Delete Action Started :: ");
		int empno = Integer.parseInt(req.getParameter("empno"));
		int result = 0;
		try {
			EmpDAO edao = new EmpDAO();
			result = edao.delete(empno);
			req.setAttribute("result", result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
