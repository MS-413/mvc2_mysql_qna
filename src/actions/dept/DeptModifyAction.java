package actions.dept;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Actions;
import model.dept.DeptDAO;
import model.dept.DeptVO;

public class DeptModifyAction implements Actions {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("DeptModifyActions Started :: ");
//		int result = 0;
		DeptVO dvo = new DeptVO(Integer.parseInt(req.getParameter("deptno")),req.getParameter("dname"),req.getParameter("loc")); 
		try {
			DeptDAO ddao = new DeptDAO();
			ddao.update(dvo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(result == 0 ? "업데이트 실패" : "업데이트 성공");
	}

}
