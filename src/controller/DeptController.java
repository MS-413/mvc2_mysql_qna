package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import actions.dept.DeptDeleteAction;
import actions.dept.DeptDetailAction;
import actions.dept.DeptListAction;
import actions.dept.DeptModifyAction;
import actions.dept.DeptSaveAction;


// 항상 살아있어야 되기때문에 warnning을 띄움 -> add serialVersionUID 하면 됨
public class DeptController extends HttpServlet {
	// 서버가 시작되면 바로 static 영역에 올려 항상 살아있음. webThread라 부름
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(DeptController.class);
	// 톰켓이 web.xml을 참고하기 때문에 FrontController를 web.xml에 등록함
	/*
	 * doGet, doPost -> service 
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 여기서 모든 로직을 실행함
		// 체크용
		logger.info("DeptController Started :: service(req,resp)");
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		System.out.println("uri : "+ uri);
		String contextPath = req.getContextPath();
		
		System.out.println("CTXPATH : " + contextPath);
		String path = uri.substring(contextPath.length()+"/pages/dept".length());
		System.out.println("path : " + path);
		
		Actions acts = null;
		String destPage = "/pages/dept"; // JSP 내부에서 리다이렉션 시켜줄 페이지 정보
		
		switch(path) {
		case "/save.de":
			System.out.println(req.getParameter("dname"));
			System.out.println(req.getParameter("loc"));
			acts = new DeptSaveAction();
			acts.excute(req, res);
			destPage += "/list.de";
			break;
		case "/list.de":
			System.out.println(req.getParameter("dname"));
			System.out.println(req.getParameter("loc"));
			acts = new DeptListAction();
			acts.excute(req, res);
			destPage += "/list.jsp";
			break;
		case "/update.de":
			acts = new DeptDetailAction();
			acts.excute(req, res);
			destPage += "/update.jsp";
			break;
		case "/modify.de":
			acts = new DeptModifyAction();
			acts.excute(req, res);
			destPage += "/list.de";
			break;
		case "/delete.de":
			acts = new DeptDeleteAction();
			acts.excute(req, res);
			destPage += "/delete.jsp";
			break;

		default:
			break;
		}
		// JSP 내부에서 Redirection 시켜주는 객체. RequstDispatcher는 트랜젝션을 1번만 실행한다. 
		RequestDispatcher dsp = req.getRequestDispatcher(destPage);
		dsp.forward(req, res);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	
	
}
