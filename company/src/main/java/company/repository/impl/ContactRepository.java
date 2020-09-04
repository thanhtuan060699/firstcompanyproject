package company.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import company.dto.ContactDTO;
import company.repository.IContactRepository;

public class ContactRepository implements IContactRepository{

	@Override
	public List<ContactDTO> findAll() {
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
			Connection connection=EntityManagerFactory.getConnection();
			String sql="select * from contact";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contactDTO=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contactDTO);
				
			}
			return contactDTOs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertContact(ContactDTO contactDTO) {
		try {
			Connection connection=EntityManagerFactory.getConnection();
			String sql="insert into contact(name,email,phonenumber) values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getName());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setString(3, contactDTO.getPhoneNumber());
			int result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editContact(ContactDTO contactDTO) {
		try {
			Connection connection=EntityManagerFactory.getConnection();
			String sql="update contact set name=?,email=?,phonenumber=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getName());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setString(3, contactDTO.getPhoneNumber());
			preparedStatement.setLong(4, contactDTO.getId());
			int result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ContactDTO findById(Long id) {
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
			Connection connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contactDTO=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				return contactDTO;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteContact(ContactDTO contactDTO) {
		try {
			Connection connection=EntityManagerFactory.getConnection();
			for(int i=0;i<contactDTO.getIds().length;i++) {
				String sql="delete from contact where id=?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setLong(1, contactDTO.getIds()[i]);
				int result=preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactDTO> findByContact(String searchKey) {
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
			Connection connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where name like '%"+searchKey+"%' or email like '%"+searchKey+"%' or phonenumber "
					+ "like '%"+searchKey+"%'";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contact);
				
			}
			return contactDTOs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
