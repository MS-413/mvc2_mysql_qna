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

public class EmpDetailAction implements Actions {
	private static Logger logger = LoggerFactory.getLogger(QnaInsertAction.class);
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Emp Detail Actions Started :: ");
		int empno = Integer.parseInt(req.getParameter("empno"));
		System.out.println("Detail empno :: "+empno);
		EmpVO evo;
		try {
			EmpDAO edao = new EmpDAO();
			evo = edao.selectOne(empno);
			System.out.println(evo.getEname()+" ::ename");
			req.setAttribute("evo", evo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
