package br.com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.daniel.model.WipoModel;

/**
 * Servlet implementation class BuscarWipoController
 */
@WebServlet("/BuscarWipo")
public class BuscarWipoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarWipoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WipoModel wipo = new WipoModel();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		String numeroProcesso = request.getParameter("nProcesso");
		
		//CRIA A DOC A PARTIR DO SITE
		Document doc = Jsoup.connect("https://patentscope.wipo.int/search/pt/detail.jsf").userAgent("Mozilla").data("docId",numeroProcesso, "redirectedID","true").get();		
		
		//pega os elementos a partir de ID e Class
		try {
			wipo.setN_pud(GetInf(doc,"#detailPCTtableWO"));
			wipo.setN_ped_int(GetInf(doc,"#detailPCTtableAN"));
			try {
				wipo.setDt_pub(formatter.parse(GetInf(doc,"#detailPCTtablePubDate")));
			} catch (ParseException e) {
			}
			wipo.setRequerentes(GetInf(doc,"#PCTapplicants"));
			wipo.setTitulo(GetInf(doc,".PCTtitle"));
			//.......
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(new JSONObject(wipo).toString());
		}catch (Exception e) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"msg\": \"Processo não encontrado.\"}");
		}
     }

	//busca o elemento no documento
	private String GetInf(Document doc , String el) throws Exception{
		Element masthead = doc.select(el).first();
		return masthead.text();
	}
	
}
