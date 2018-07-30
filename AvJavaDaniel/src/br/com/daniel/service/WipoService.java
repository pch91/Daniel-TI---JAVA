package br.com.daniel.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.daniel.model.WipoModel;

public class WipoService {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	public void saveWipo(WipoModel wipo) {
    	
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(wipo);
        tx.commit();
        session.close();
		
	}
	
	public List<WipoModel> getAllWipo() {    	
        Session session = sessionFactory.openSession();
        
        List<WipoModel> wipolist = session.createNativeQuery(
    		    "SELECT * FROM wipo",WipoModel.class )
    		.getResultList();
		
		return wipolist;
	}
	
	public List<WipoModel> getAllWipoBy(String Pross, String req) throws Exception {    	
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM wipo where ";
        if(Pross.length() > 0) {
        	sql += "REPLACE(upper(n_pud),'/','') = upper(\"" + Pross+"\")";
        	if(req.length() > 0 ) {
        		sql += " and upper(requerentes) like upper(\"%"+req+"%\")";
        	}
        }else if(req.length() > 0 ) {
        	sql += "upper(requerentes) like upper(\"%"+req+"%\")";
        }else {
        	throw new Exception("Pelomenos um filtro deve ser feito.");
        }
        
        List<WipoModel> wipolist = session.createNativeQuery(
    		    sql,WipoModel.class )
    		.getResultList();
		
		return wipolist;
	}
	
}
