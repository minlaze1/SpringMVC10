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

import com.saraya.model.Watch;
import com.saraya.service.WatchService;


@Controller
public class WatchController {

	@Autowired
	WatchService ws;
	@RequestMapping(value="/list-watch", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("watches", ws.getAllWatches());
		return "watchList";
	}
	//-----------------Add Method------------------------------
	
	@RequestMapping(value="/add-watch", method=RequestMethod.GET)
		public String addWatchForm(ModelMap model) {
		model.addAttribute("montre", new Watch());
		return "addWatch";
	}
	@RequestMapping(value="/add-watch", method=RequestMethod.POST)
		public String watchAdded(ModelMap model, @Valid @ModelAttribute("montre") Watch w, BindingResult result ) {
		if(result.hasErrors())
			return "addWatch";
		ws.addWatch(w.getYear(),w.getBrand(),w.getModel(),w.getImage());
		model.clear();
		return "redirect:/list-watch";
	}
	//-----------------End of add method--------------------------
	
	//----------------Update Method------------------------------
	@RequestMapping(value="/update-watch", method=RequestMethod.GET)
	public String updateWatchForm(ModelMap model,@RequestParam int id) {
		model.addAttribute("montre", ws.findById(id));
		return "addWatch";
	}
	
	@RequestMapping(value="/update-watch", method=RequestMethod.POST)
	public String planeListUpdate(ModelMap model, @Valid @ModelAttribute("montre") Watch w, BindingResult result) {
		if (result.hasErrors())
			return "addWatch";
		ws.updateByWatch(w);
		model.clear();
		return "redirect:/list-watch";
	}
	
	//-------------------------------------------------------------
	@RequestMapping(value="/delete-watch", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id) {
		ws.deleteWatch(id);
		model.clear();
		return "redirect:/list-watch";
	}

}
