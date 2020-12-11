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

public class EmpSaveAction implements Actions {
	private static Logger logger = LoggerFactory.getLogger(QnaInsertAction.class);
	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Emp Save Actions Started :: ");	
		// 액션
		// 값 받기 
		int empno = Integer.parseInt(req.getParameter("empno"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String hiredate = req.getParameter("hiredate");
		int sal = Integer.parseInt(req.getParameter("sal"));
		int result = 0;
		EmpVO evo = null;
		boolean insert = true;
		evo = new EmpVO(empno, ename, job, hiredate, sal);			
		// 받은 값을 EVO에 저장
		
		// evo를 edao에 넘겨서 디비에 실행
		EmpDAO edao;
		try {
			edao = new EmpDAO();
			result = edao.insert(evo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("사원 정보 입력 " + (result > 0 ? "성공" : "실패"));
	}

}
