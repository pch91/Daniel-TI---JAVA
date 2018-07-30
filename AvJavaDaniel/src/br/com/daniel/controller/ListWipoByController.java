package br.com.daniel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import br.com.daniel.model.WipoModel;
import br.com.daniel.service.WipoService;

/**
 * Servlet implementation class ListWipoByController
 */
@WebServlet("/ListWipoBy")
public class ListWipoByController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListWipoByController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nprocess = request.getParameter("nProcesso");
		String req = request.getParameter("req");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		WipoService service = new WipoService();
		try {
			response.getWriter().write(new JSONArray(service.getAllWipoBy(nprocess, req)).toString());			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("{\"msg\": "+e.getMessage()+"}");
		}
	}

}
