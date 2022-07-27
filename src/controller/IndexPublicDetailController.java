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
 * Servlet implementation class IndexPublicDetailController
 */
@WebServlet("/IndexPublicDetailController")
public class IndexPublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexPublicDetailController() {
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

		int idDSBB = Integer.parseInt(request.getParameter("did"));
		int fl_id = Integer.parseInt(request.getParameter("fl_id"));
		
		DanhSachBanBeDao dsbbDAO = new DanhSachBanBeDao();
		DanhSachBanBe objBB = dsbbDAO.getItem(idDSBB);
		request.setAttribute("objBB", objBB);
		dsbbDAO.updateView(idDSBB);
		
		DanhMucBanBeDao danhMucBanBeDao = new DanhMucBanBeDao();
		DanhMucBanBe danhMucBanBe = danhMucBanBeDao.getItem(fl_id);
		request.setAttribute("danhMucBanBe", danhMucBanBe);
		
		ArrayList<DanhSachBanBe>objBB1 = dsbbDAO.getItemsByID(idDSBB);
		request.setAttribute("objBB1", objBB1);
		
		ArrayList<DanhSachBanBe> listFrd = dsbbDAO.getListFriend(idDSBB, fl_id);
		request.setAttribute("listFrd", listFrd);
		
		RequestDispatcher rd = request.getRequestDispatcher("/chi-tiet.jsp");
		rd.forward(request, response);
	}
}
