package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DanhSachBanBe;
import model.dao.DanhSachBanBeDao;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchBB = request.getParameter("searchBB"); 
		
		String index_page1 = request.getParameter("index_page");
		
		int index_page = 0; 
		if(index_page1 == null) {
			index_page1 = "1";
		}
		
		index_page = Integer.parseInt(index_page1);
		request.setAttribute("index_page", index_page);
		DanhSachBanBeDao danhSachBanBeDao = new DanhSachBanBeDao();
		ArrayList<DanhSachBanBe> listBB = null;
		int number_page = 0;
		if (searchBB != null && !("").equals(searchBB)) {
			listBB = danhSachBanBeDao.getPagging(searchBB, index_page);
			number_page = danhSachBanBeDao.countPage(searchBB);
			request.setAttribute("searchBB", searchBB);
		
		} else { 
			listBB = danhSachBanBeDao.getPagging(index_page);
			number_page = danhSachBanBeDao.countPage();
		}
		request.setAttribute("number_page", number_page);

		request.setAttribute("listBB", listBB);
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}

}
