package actions.dept;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Actions;
import model.dept.DeptDAO;

public class DeptDeleteAction implements Actions {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Dept Delete Actions Started :: ");
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		
		int result = 0;
		try {
			DeptDAO ddao = new DeptDAO();
			result = ddao.delete(deptno);
			req.setAttribute("result", result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
