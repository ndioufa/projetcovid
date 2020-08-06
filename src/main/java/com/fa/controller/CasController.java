package com.fa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fa.dao.ICas;
import com.fa.entities.Cas;

@Controller

public class CasController {
	@Autowired
	ICas iCas;
	
	@RequestMapping(value="/Cas/add" )
	public String index(Cas cas)
	{
	 
//		try {
//			iEnt.save(en);
//			
//			
//			//model.put("message", "v");	
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
				
		return "entreprise/add";
	}
	@PostMapping("/Cas/add")
	public String add(@ModelAttribute("cas") Cas c) {
		
		Cas ca = new Cas();
		ca.setNom(c.getNom());
		ca.setPrenom(c.getPrenom());
		ca.setAdresse(c.getAdresse());
		
		iCas.save(ca);
		return "redirect:/Cas/liste";
		
	}
	@RequestMapping(value="/Cas/liste")
	public String liste(ModelMap modelmap)
	{
	 
		List<Cas> ca=iCas.findAll();
		modelmap.put("liste_entr", ca);
		modelmap.put("iCas", new Cas());
		return "Cas/liste";
	}
 
	 @RequestMapping(value="/Cas/delete" ,method=RequestMethod.GET)
		public String delete(int id)
		{
		 try
			{
				iCas.delete(iCas.getOne(id));
				iCas.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "redirect:/Cas/liste";
		}
	 @RequestMapping(value="Cas/edit",method=RequestMethod.GET)
		public String edit(ModelMap modelmap,int id)
		{
			List<Cas> en=iCas.findAll();
			modelmap.put("liste_cas", en);
			
		 modelmap.put("en", iCas.getOne(id));
			
			return "redirect:/Cas/liste";
		}

	
}
