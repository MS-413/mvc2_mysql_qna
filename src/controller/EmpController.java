package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Actions;
import actions.dept.DeptDeptnoAction;
import actions.emp.EmpDeleteAction;
import actions.emp.EmpDetailAction;
import actions.emp.EmpListAction;
import actions.emp.EmpSaveAction;

public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EmpController Started :: service(req,resp)");
		req.setCharacterEncoding("UTF-8");
		String path = req.getRequestURI().substring(req.getContextPath().length()+10); // mvc2_mysql_qna + "/pages/emp
		String uri = req.getRequestURI();
		System.out.println("uri : "+ uri);
		System.out.println("getPath :: "+path);
		String destPage = "/pages/emp";
		Actions acts = null;
		switch(path) {
		case "/save.em":
			System.out.println(req.getParameter("empno"));
			System.out.println(req.getParameter("ename"));
			acts = new EmpSaveAction();
			acts.excute(req, res);
			destPage += "/list.em";
			break;
		case "/list.em":
			acts = new EmpListAction();
			acts.excute(req, res);
			destPage += "/list.jsp";
			break;
		case "/detail.em":
			acts = new EmpDetailAction();
			acts.excute(req, res);
			destPage += "/detail.jsp";
			break;
		case "/modify.em":
			acts = new EmpDetailAction();
			acts.excute(req, res);
			Actions acts2 = new DeptDeptnoAction();
			acts2.excute(req, res);
			destPage += "/modify.jsp";
			break;
		case "/delete.em":
			acts = new EmpDeleteAction();
			acts.excute(req, res);
			destPage += "/delete.jsp";
			break;
		default:
			destPage = "index.jsp";
			break; 
		}
		RequestDispatcher dsp = req.getRequestDispatcher(destPage);
		dsp.forward(req, res);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}


	
}
