package company.service.impl;

import java.util.List;

import company.dto.ContactDTO;
import company.repository.impl.ContactRepository;
import company.service.IContactService;

public class ContactService implements IContactService{
	ContactRepository contactRepository=new ContactRepository();
	@Override
	public List<ContactDTO> listContact() {
		return contactRepository.findAll();
	}
	@Override
	public void insertContact(ContactDTO contactDTO) {
		contactRepository.insertContact(contactDTO);
		
	}
	@Override
	public void editContact(ContactDTO contactDTO) {
		contactRepository.editContact(contactDTO);
		
	}
	@Override
	public ContactDTO findById(Long id) {
		return contactRepository.findById(id);
	}

}
