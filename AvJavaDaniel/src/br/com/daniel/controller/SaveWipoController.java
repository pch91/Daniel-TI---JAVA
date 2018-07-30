package br.com.daniel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import br.com.daniel.model.WipoModel;
import br.com.daniel.service.WipoService;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * Servlet implementation class SaveWipoController
 */
@WebServlet("/SaveWipo")
public class SaveWipoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveWipoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonParser parser = new JsonParser(); 

		String a = request.getParameter("wipo");
		JsonElement mJson =  parser.parse(request.getParameter("wipo"));
		Gson gson=  new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss z yyyy").create();
		WipoModel wipo = gson.fromJson(mJson, WipoModel.class);
		
		WipoService service = new WipoService();
		try{
			service.saveWipo(wipo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"msg\": \"Salvo com sucesso.\",\"sucess\":\"1\"}");
		}catch (Exception e) {
			e.printStackTrace();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"msg\": \"Não foi possivel salvar o processo.\",\"sucess\":\"0\"}");
		}
	    
		
	}

}
