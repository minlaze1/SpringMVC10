package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.Phone;
import com.saraya.service.PhoneService;

@Controller
public class PhoneController {

	@Autowired
	PhoneService ps;
	@RequestMapping(value="/list-phone", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("phones", ps.getAllPhones());
		return "phoneList";
	}
	
	//---------------Adding method------------------
	
	
	@RequestMapping(value="/add-phone", method=RequestMethod.GET)
			public String addPhoneForm(ModelMap model) {
		model.addAttribute("smartphone", new Phone());
		return "addPhone";
	}
	
	@RequestMapping(value="/add-phone", method=RequestMethod.POST)
	public String phoneAdded(ModelMap model, @Valid @ModelAttribute("smartphone")
	Phone p, BindingResult result) {
			if(result.hasErrors())
				return "addPhone";
		ps.addPhone(p.getYear(), p.getMake(), p.getModel(), p.getColor(), p.getImage());
		model.clear();
		return "redirect:/list-phone";
	}
	//----------------------End of Adding method--------------
	
	//-----------------UPDATE Method-------------------------
	
	@RequestMapping(value="/update-phone", method=RequestMethod.GET)
	public String updatePhoneForm(ModelMap model,@RequestParam int id) {
			model.addAttribute("smartphone", ps.findById(id));
			return "addPhone";
	}
	
	@RequestMapping(value="/update-phone", method=RequestMethod.POST)
	public String phoneListUpdate(ModelMap model, @Valid @ModelAttribute("smartphone") Phone p,BindingResult result) {
		if (result.hasErrors())
			return "addPhone";
			ps.updateByPhone(p);
			model.clear();
			return "redirect:/list-phone";
	}
	//--------------------------------------------------------------
	@RequestMapping(value="/delete-phone", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		ps.deletePhone(id);
		model.clear();
		return "redirect:/list-phone";
		
	}
}
