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
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
			connection=EntityManagerFactory.getConnection();
			String sql="select * from contact";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contactDTO=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contactDTO);
				
			}
			return contactDTOs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public void insertContact(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		    connection=EntityManagerFactory.getConnection();
			String sql="insert into contact(name,email,phonenumber) values(?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getName());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setString(3, contactDTO.getPhoneNumber());
			int result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		
	}

	@Override
	public void editContact(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
		    connection=EntityManagerFactory.getConnection();
			String sql="update contact set name=?,email=?,phonenumber=? where id=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getName());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setString(3, contactDTO.getPhoneNumber());
			preparedStatement.setLong(4, contactDTO.getId());
			int result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
				resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		
	}

	@Override
	public ContactDTO findById(Long id) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where id=?";
		    preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
		    resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contactDTO=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				return contactDTO;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		
		return null;
	}

	@Override
	public void deleteContact(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
		    connection=EntityManagerFactory.getConnection();
			for(int i=0;i<contactDTO.getIds().length;i++) {
				String sql="delete from contact where id=?";
			    preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setLong(1, contactDTO.getIds()[i]);
				int result=preparedStatement.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
	}

	@Override
	public List<ContactDTO> findByContact(String searchKey) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where name like '%"+searchKey+"%' or email like '%"+searchKey+"%' or phonenumber "
					+ "like '%"+searchKey+"%'";
		    preparedStatement=connection.prepareStatement(sql);
		    resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contact);
				
			}
			return contactDTOs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

	@Override
	public List<ContactDTO> findByEmailAndPhoneNumber(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where email=? or phonenumber=?";
		    preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getEmail());
			preparedStatement.setString(2, contactDTO.getPhoneNumber());
	        resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contact);
				
			}
			return contactDTOs;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

	@Override
	public List<ContactDTO> findByName(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where name like '"+contactDTO.getName()+"%'";
		    preparedStatement=connection.prepareStatement(sql);
		    resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				contactDTOs.add(contact);
				
			}
			return contactDTOs;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

	@Override
	public ContactDTO findByEmailPhoneNumberAndId(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where phonenumber=? and email=? and id=?";
		    preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getPhoneNumber());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setLong(3, contactDTO.getId());
		    resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				return contact;
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

	@Override
	public ContactDTO findByEmailPhoneNumberNotInId(ContactDTO contactDTO) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
		    connection=EntityManagerFactory.getConnection();
			String sql="select * from contact where (phonenumber=? or email=?) and id not in (?)";
		    preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, contactDTO.getPhoneNumber());
			preparedStatement.setString(2, contactDTO.getEmail());
			preparedStatement.setLong(3, contactDTO.getId());
		    resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				ContactDTO contact=new ContactDTO(resultSet.getLong("id"),resultSet.getString("name"), 
						resultSet.getString("email"), resultSet.getString("phonenumber"));
				return contact;
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				
			}
		}
		return null;
	}

}
