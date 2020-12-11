package actions.dept;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Actions;
import model.dept.DeptDAO;
import model.dept.DeptVO;

public class DeptSaveAction implements Actions {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("DeptSaveActopm Started :: ");
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		// 입력 정보 잘 받았는지 확인.
		System.out.println(deptno + " / " + dname + " / " + loc);
		// dvo 불러서 정보 저장
		DeptVO dvo = new DeptVO(deptno, dname, loc);
		DeptDAO ddao; // 쿼리문이 실행될 dao 부름
		int result = 0;
		try {
			ddao = new DeptDAO();
			result = ddao.insert(dvo); // insert에 객체 넣고 실행, 결과 받음. 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("부서 정보 입력 " + (result > 0 ? "성공" : "실패"));
	}

}
