package com.nit.service;

import java.util.List;


import com.nit.dto.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	public Contact getContactById(Integer id);
	public List<Contact> getAllContacts();
	public boolean updateContactByid(Integer id);
	public boolean deleteContactById(Integer id);
	

}
