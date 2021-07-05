package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.BoardDAO;
import persistance.BoardDTO;

@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	private BoardDAO boardDAO = new BoardDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BoardDTO> boardDto;		
		//boardDto = boardDAO.select();
		/*
		 * for(BoardDTO dto:boardDto) {
		 * System.out.printf("%s | %s | %s | %s | %s | %s\n", dto.getId(),
		 * dto.getTitle(), dto.getWriter(), dto.getContents(),
		 * dto.getRegdate().toString(), dto.getHit()); }
		 */
		//req.setAttribute("boardDto", boardDto);		
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/board.jsp");
//		dispatcher.forward(req, resp);
//		dispatcher.include(req, resp);
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
		System.out.println("sendRedirect");
		resp.sendRedirect("login.jsp");
	}
}
