package company.service;

import java.util.List;

import company.dto.ContactDTO;

public interface IContactService {
	public List<ContactDTO> listContact();
	public void insertContact(ContactDTO contactDTO);
	public void editContact(ContactDTO contactDTO);
	public ContactDTO findById(Long id);
	public void deleteContact(ContactDTO contactDTO);
	public List<ContactDTO> findByContact(String searchKey);
}
