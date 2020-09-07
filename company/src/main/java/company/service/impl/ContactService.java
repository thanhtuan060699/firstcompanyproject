package company.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

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
	@Override
	public void deleteContact(ContactDTO contactDTO) {
		contactRepository.deleteContact(contactDTO);
		
	}
	@Override
	public List<ContactDTO> findByContact(String searchKey) {
		return contactRepository.findByContact(searchKey);
	}
	@Override
	public List<ContactDTO> findByEmailAndPhoneNumber(ContactDTO contactDTO) {
		return (List<ContactDTO>) contactRepository.findByEmailAndPhoneNumber(contactDTO);
	}
	@Override
	public List<ContactDTO> findByName(ContactDTO contactDTO) {
		String name=StringUtils.split(contactDTO.getName(),'(')[0];
		contactDTO.setName(name);
		return contactRepository.findByName(contactDTO);
	}
	
	@Override
	public ContactDTO findByEmailPhoneNumberAndId(ContactDTO contactDTO) {
		
		return contactRepository.findByEmailPhoneNumberAndId(contactDTO);
	}
	@Override
	public ContactDTO findByEmailPhoneNumberNotInId(ContactDTO contactDTO) {
		// TODO Auto-generated method stub
		return contactRepository.findByEmailPhoneNumberNotInId(contactDTO);
	}

}
