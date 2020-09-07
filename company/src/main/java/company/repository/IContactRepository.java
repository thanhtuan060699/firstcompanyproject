package company.repository;

import java.util.List;

import company.dto.ContactDTO;

public interface IContactRepository {
	public List<ContactDTO> findAll();
	public void insertContact(ContactDTO contactDTO);
	public void editContact(ContactDTO contactDTO);
	public ContactDTO findById(Long id);
	public void deleteContact(ContactDTO contactDTO);
	public List<ContactDTO> findByContact(String searchKey);
	public List<ContactDTO> findByEmailAndPhoneNumber(ContactDTO contactDTO);
	public List<ContactDTO> findByName(ContactDTO contactDTO);
	public ContactDTO findByEmailPhoneNumberAndId(ContactDTO contactDTO);
	public ContactDTO findByEmailPhoneNumberNotInId(ContactDTO contactDTO);
}
