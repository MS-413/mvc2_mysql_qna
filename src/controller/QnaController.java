package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import actions.Actions;
import actions.emp.EmpListAction;
import actions.qna.QnaDetailAction;
import actions.qna.QnaInsertAction;
import actions.qna.QnaListAction;
import actions.qna.QnaModifyAction;
import actions.qna.QnaRemoveAction;
import actions.qna.QnaUpdateAction;

public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(QnaController.class);
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("QnaController Started :: service(req,resp)");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		System.out.println("uri : "+ uri);
		String contextPath = req.getContextPath();
		System.out.println("CTXPATH : " + contextPath);
		String path = uri.substring(contextPath.length()+10);
		System.out.println("path : " + path);
		
		Actions acts = null;
		String destPage = ""; // JSP 내부에서 리다이렉션 시켜줄 페이지 정보
		
		switch(path) {
		case "/write.qn":
			acts = new EmpListAction();
			acts.excute(req, res);
			destPage = "write.jsp";
			break;
		case "/save.qn":
			acts = new QnaInsertAction();
			acts.excute(req, res);
			destPage = "list.qn";
			break;
		case "/list.qn":
			acts = new QnaListAction();
			acts.excute(req, res);
			destPage = "list.jsp";
			break;
		case "/detail.qn":
			acts = new QnaDetailAction();
			acts.excute(req, res);
			destPage = "detail.jsp";
			break;
		case "/modify.qn":
			acts = new QnaDetailAction();
			acts.excute(req, res);
			destPage = "modify.jsp";
			break;
		case "/update.qn":
			acts = new QnaUpdateAction();
			acts.excute(req, res);
			destPage = "list.qn";
			break;
		case "/delete.qn":
			acts = new QnaRemoveAction();
			acts.excute(req, res);
			destPage = "list.qn";
			break;
		default:
			break;
		}
		RequestDispatcher dsp = req.getRequestDispatcher(destPage);
		dsp.forward(req, res);
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		service(req, res);
	}

}
