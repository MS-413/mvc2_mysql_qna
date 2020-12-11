package actions.dept;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import actions.Actions;
import model.dept.DeptDAO;
import model.dept.DeptVO;

public class DeptDeptnoAction implements Actions {

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Dept List Actions Started :: ");
		try {
			DeptDAO ddao = new DeptDAO();
			ArrayList<Integer> deptnos = ddao.getDeptnoList();
			req.setAttribute("deptnos", deptnos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
