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

import com.saraya.model.Yacht;
import com.saraya.service.YachtService;

@Controller
public class YachtController {


	@Autowired
	YachtService ys;
	@RequestMapping(value="/list-yacht", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("yachts", ys.getAllYachts());
		return "yachtList";
	}
	//---------------Add Method-------------------------
	
	@RequestMapping(value="/add-yacht", method=RequestMethod.GET)
		public String addYachtForm(ModelMap model) {
		model.addAttribute("boat", new Yacht());
		return "addYacht";
	}
	@RequestMapping(value="/add-yacht", method=RequestMethod.POST)
		public String yachtAdded(ModelMap model, @Valid @ModelAttribute("boat") Yacht y, BindingResult result) {
		if(result.hasErrors())
			return "addYacht";
		ys.addYacht(y.getYear(),y.getMake(),y.getModel(),y.getLength(),y.getImage());
		model.clear();
		return "redirect:/list-yacht";
	}
	//------------------End of Add method----------------------------
	
	//--------------------UPDATE Method----------------------------
	@RequestMapping(value="/update-yacht", method=RequestMethod.GET)
	public String updateYachtForm(ModelMap model,@RequestParam int id) {
		model.addAttribute("boat", ys.findById(id));
		return "addYacht";
	}
	
	@RequestMapping(value="/update-yacht", method=RequestMethod.POST)
	public String yachtListUpdate(ModelMap model, @Valid @ModelAttribute("boat") Yacht y,BindingResult result) {
		if(result.hasErrors())
			return "addYacht";
		ys.updateByYacht(y);
		model.clear();
		return "redirect:/list-yacht";
	}
	
	//-------------------------------------------------------------
	@RequestMapping(value="/delete-yacht", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id) {
		ys.deleteYacht(id);
		model.clear();
		return "redirect:/list-yacht";
	}
}
