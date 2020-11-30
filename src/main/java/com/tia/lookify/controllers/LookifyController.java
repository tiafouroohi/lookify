package com.tia.lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia.lookify.models.Lookify;
import com.tia.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	@Autowired
	private LookifyService lookifyService ;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model,@ModelAttribute("song")Lookify song) {
		model.addAttribute("allSongs", lookifyService.allSongs());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/add")
	public String add(Model model, @ModelAttribute("song")Lookify song) {
		return "add.jsp";
	}
	
	@PostMapping("/song")
		public String create(@Valid @ModelAttribute("song")Lookify song, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		lookifyService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/song/{id}/delete")
	public String destroy(@PathVariable("id")Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/song/{id}")
	public String get(@PathVariable ("id")Long id, Model model) {
		model.addAttribute("song", lookifyService.findSong(id));
		return "song.jsp";
	}
	
	
}
