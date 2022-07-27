package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DanhMucBanBe;
import model.bean.DanhSachBanBe;

import model.dao.DanhMucBanBeDao;
import model.dao.DanhSachBanBeDao;

/**
 * Servlet implementation class PublicCatController
 */
@WebServlet("/PublicCatController")
public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicCatController() {
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
	
		String index_page1 = request.getParameter("index_page");
		
		int index_page = 0; 
		if(index_page1 == null) {
			index_page1 = "1";
		}
		index_page = Integer.parseInt(index_page1);
		request.setAttribute("index_page", index_page);
	
		DanhMucBanBeDao catDAO = new DanhMucBanBeDao();
	
		DanhSachBanBeDao danhSachBanBeDao = new DanhSachBanBeDao();
		
		int idBB = Integer.parseInt(request.getParameter("cid"));
		
		int index_li = Integer.parseInt(request.getParameter("index_li"));
		request.setAttribute("index_li", index_li);
		

		ArrayList<DanhSachBanBe> listBBByID = danhSachBanBeDao.getItemsByID(idBB);
		request.setAttribute("listBBByID", listBBByID);
		int number_page = danhSachBanBeDao.countPage1(idBB);
		
		request.setAttribute("number_page", number_page);

		DanhMucBanBe objDMBB = catDAO.getItem(idBB);
		request.setAttribute("objDMBB", objDMBB);
		
		RequestDispatcher rd = request.getRequestDispatcher("/danh-muc.jsp");
		rd.forward(request, response);
	}

}
