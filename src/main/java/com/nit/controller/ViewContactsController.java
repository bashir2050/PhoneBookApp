package com.nit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.dto.Contact;
import com.nit.model.*;
import com.nit.service.ContactService;

@Controller
public class ViewContactsController {
	@Autowired
	private ContactService service;
	
	@RequestMapping(value="/editContact")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) {
		Contact c= service.getContactById(contactId);
		model.addAttribute("contact", c);
		
		return "contactInfo";
		
	}
	
	public String updateContact(ContactEntity c,Model model) {
		return null;
		
	}
	
	@RequestMapping(value="/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		
		boolean isDeleted=service.deleteContactById(contactId);
		if (isDeleted) {
			return "redirect:/viewContact";
		}
		return null;
		
	}

}
