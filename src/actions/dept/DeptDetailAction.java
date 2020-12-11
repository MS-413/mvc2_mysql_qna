package actions.dept;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Actions;
import model.dept.DeptDAO;
import model.dept.DeptVO;

public class DeptDetailAction implements Actions {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Dept Detail Action Started :: ");

		int deptno = Integer.parseInt(req.getParameter("deptno"));
		try {
			DeptDAO ddao = new DeptDAO();
			DeptVO dvo = ddao.selectOne(deptno);
			req.setAttribute("dvo", dvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
