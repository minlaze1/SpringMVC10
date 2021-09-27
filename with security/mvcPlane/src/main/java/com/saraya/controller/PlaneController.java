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

import com.saraya.model.Plane;
import com.saraya.service.PlaneService;

@Controller
public class PlaneController {

	@Autowired
	PlaneService ps;
	@RequestMapping(value="/list-plane", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("planes", ps.getAllPlanes());
		return "planeList";
	}
	//-----------------Adding method------------------
	@RequestMapping(value="/add-plane", method=RequestMethod.GET)
		public String addPlaneForm(ModelMap model) {
		model.addAttribute("aircraft", new Plane());
		return "addPlane";
	}
	
	@RequestMapping(value="/add-plane", method=RequestMethod.POST)
		public String planeAdded(ModelMap model, @Valid @ModelAttribute("aircraft")
					Plane p, BindingResult result) {
			if(result.hasErrors())
				return "addPlane";
		ps.addPlane(p.getYear(),p.getMake(),p.getModel(),p.getLength(),p.getImage());
		model.clear();
		return "redirect:/list-plane";
	}
	//------------------------End of add method-------------
	
	//-------------------------Update Method------------------
		@RequestMapping(value="/update-plane", method=RequestMethod.GET)
		public String updatePlaneForm(ModelMap model, @RequestParam int id) {
			model.addAttribute("aircraft", ps.findById(id));
			return "addPlane";
		}
		@RequestMapping(value="/update-plane", method=RequestMethod.POST)
		public String planeListUpdate(ModelMap model,@Valid @ModelAttribute("aircraft") Plane p, BindingResult result) {
			if(result.hasErrors())
				return "addPlane";
			ps.updateByPlane(p);
			model.clear();
			return "redirect:/list-plane";
		}
	//---------------------------------------------------------------
	@RequestMapping(value="/delete-plane", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id) {
		ps.deletePlane(id);
		model.clear();
		return "redirect:/list-plane";
	}

}

