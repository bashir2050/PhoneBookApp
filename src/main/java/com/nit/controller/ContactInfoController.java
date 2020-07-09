package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.dto.Contact;

import com.nit.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService service;
	
	@GetMapping(value={ "/", "/addContact" })
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact",c);
		
		return "contactInfo";
	}
	@PostMapping(value="/saveContact")
	public String handaleSubmitBtn(@ModelAttribute("contact") Contact c,RedirectAttributes attributes) {
		
		boolean isSaved =service.saveContact(c);
		if(isSaved)
			attributes.addFlashAttribute("successMsg", "you inserted successfully");

		else
			attributes.addFlashAttribute("errorMsg", "Failed to insert records");
			
		return "redirect:/userAcessBtn";
	}
		
		
		
		@GetMapping(value="/userAcessBtn")
		public String userAcessBtn(@ModelAttribute("contact") Contact c,Model model) {
			
			
			model.addAttribute("contact",c);
			
			return "contactInfo";
		
	   
		
	}
	
	@GetMapping("/viewContact")
	public String handleViewContactsLink(Model model,Contact c) {
		
		List<Contact> cont= service.getAllContacts();
		
		model.addAttribute("msg",cont);
		
	    return "viewContacts";
	
	}

}
