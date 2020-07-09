package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dto.Contact;
import com.nit.model.ContactEntity;
import com.nit.repo.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity contact = new ContactEntity();
		BeanUtils.copyProperties(c, contact);
		ContactEntity savedEntity = repo.save(contact);
		return savedEntity.getContactId()!=null;
		
		
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById=repo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities =repo.findAll();
		List<Contact> cont = new ArrayList();
		
		/*for(ContactEntity entity:entities) {
		
		Contact c = new Contact();
		
		BeanUtils.copyProperties(entity, c);
		
		cont.add(c);
		}*/
		
		return entities. stream().map(entity ->{
			Contact c = new Contact();
			BeanUtils.copyProperties(entity,c);
			return c;
		}).collect(Collectors.toList());
		
		
		
	}


	@Override
	public boolean deleteContactById(Integer cid) {
		repo.deleteById(cid);
		return true;
	}

	@Override
	public boolean updateContactByid(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
