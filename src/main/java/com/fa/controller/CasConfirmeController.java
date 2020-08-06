package com.fa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fa.dao.ICas;
import com.fa.dao.ICasConfirme;
import com.fa.entities.Cas;
import com.fa.entities.CasConfirme;
@Controller
public class CasConfirmeController {
	@Autowired
	ICasConfirme iCa;
	
	@RequestMapping(value="/CasConfirme/add" )
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
				
		return "cas/add";
	}
	@PostMapping("/CasConfirme/add")
	public String add(@ModelAttribute("casconfirme") CasConfirme c) {
		
		CasConfirme ca = new CasConfirme();
		ca.setNom(c.getNom());
		ca.setPrenom(c.getPrenom());
		ca.setAdresse(c.getAdresse());
		ca.setDateConfirmation(c.getDateConfirmation());
		
		iCa.save(ca);
		return "redirect:/CasConfirme/liste";
		
	}
	@RequestMapping(value="/CasConfirme/liste")
	public String liste(ModelMap modelmap)
	{
	 
		List<CasConfirme> ca=iCa.findAll();
		modelmap.put("liste_casconfirme", ca);
		modelmap.put("iCas", new Cas());
		return "CasConfirme/liste";
	}
 
	 @RequestMapping(value="/CasConfirme/delete" ,method=RequestMethod.GET)
		public String delete(int id)
		{
		 try
			{
				iCa.delete(iCa.getOne(id));
				iCa.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "redirect:/CasConfirme/liste";
		}
	 @RequestMapping(value="CasConfirme/edit",method=RequestMethod.GET)
		public String edit(ModelMap modelmap,int id)
		{
			List<CasConfirme> en=iCa.findAll();
			modelmap.put("liste_casConfirme", en);
			
		 modelmap.put("en", iCa.getOne(id));
			
			return "redirect:/CasConfirme/liste";
		}

}
