package company.api;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import company.dto.ContactDTO;
import company.service.impl.ContactService;
import company.util.HttpUtil;

/**
 * Servlet implementation class ContactAPI
 */
@WebServlet(urlPatterns = {"/api-contact"})
public class ContactAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContactAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	ContactService contactService=new ContactService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ContactDTO contactDTO=HttpUtil.of(request.getReader()).toModel(ContactDTO.class);
		if(StringUtils.isBlank(contactDTO.getEmail())&&StringUtils.isBlank(contactDTO.getPhoneNumber())) {
			objectMapper.writeValue(response.getOutputStream(), 2);
		}else if(StringUtils.isBlank(contactDTO.getEmail())){
			objectMapper.writeValue(response.getOutputStream(), 3);
		}else if(StringUtils.isBlank(contactDTO.getPhoneNumber())){
			objectMapper.writeValue(response.getOutputStream(), 4);
		}else if(contactService.findByEmailAndPhoneNumber(contactDTO).size()!=0){
			objectMapper.writeValue(response.getOutputStream(), 5);
		}else if(emailRegular(contactDTO.getEmail())==false){
			objectMapper.writeValue(response.getOutputStream(), 6);
		}else if(phoneNumberRegular(contactDTO.getPhoneNumber())==false){
			objectMapper.writeValue(response.getOutputStream(), 7);
		}else if(contactService.findByName(contactDTO).size()>=1){
			String name=contactDTO.getName();
			int size=contactService.findByName(contactDTO).size();
			name=name+"("+size+")";
			contactDTO.setName(name);
			contactService.insertContact(contactDTO);
			objectMapper.writeValue(response.getOutputStream(), 1);
		}else {
			contactService.insertContact(contactDTO);
			objectMapper.writeValue(response.getOutputStream(), 1);
		}
		
		
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ContactDTO contactDTO=HttpUtil.of(request.getReader()).toModel(ContactDTO.class);
		ContactDTO contactCurrent=contactService.findById(contactDTO.getId());
		if(contactDTO.getEmail().equals(contactCurrent.getEmail())&&contactDTO.getName().equals(contactCurrent.getName())
				&&contactDTO.getPhoneNumber().equals(contactCurrent.getPhoneNumber())) {
			objectMapper.writeValue(response.getOutputStream(), 1);
		}
		else if(StringUtils.isBlank(contactDTO.getEmail())&&StringUtils.isBlank(contactDTO.getPhoneNumber())) {
			objectMapper.writeValue(response.getOutputStream(), 2);
		}else if(StringUtils.isBlank(contactDTO.getEmail())){
			objectMapper.writeValue(response.getOutputStream(), 3);
		}else if(StringUtils.isBlank(contactDTO.getPhoneNumber())){
			objectMapper.writeValue(response.getOutputStream(), 4);
		}else if(emailRegular(contactDTO.getEmail())==false){
			objectMapper.writeValue(response.getOutputStream(), 6);
		}else if(phoneNumberRegular(contactDTO.getPhoneNumber())==false){
			objectMapper.writeValue(response.getOutputStream(), 7);
		}else if(contactService.findByEmailPhoneNumberNotInId(contactDTO)!=null){
			objectMapper.writeValue(response.getOutputStream(), 5);
		}else {
			if(contactDTO.getName().equals(contactCurrent.getName())==false){
				String name=contactDTO.getName();
				int size=contactService.findByName(contactDTO).size();
				name=name+"("+size+")";
				contactDTO.setName(name);
			}
			contactService.editContact(contactDTO);
			objectMapper.writeValue(response.getOutputStream(), 1);
		}
		
		
	}
	private boolean emailRegular(String email) {
		String regex="^[0-9a-zA-Z]+@{1}[a-zA-Z0-9]+[.]{1}[a-zA-Z0-9]+$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(email);
		if(matcher.find())
			return true;
		return false;
	}
	private boolean phoneNumberRegular(String email) {
		String regex="[0-9]{10,}";
		String regrex1="^[0-9]+$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(email);
		Pattern pattern1=Pattern.compile(regrex1);
		Matcher matcher1=pattern1.matcher(email);
		if(matcher.find()&&matcher1.find())
			return true;
		return false;
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ContactDTO contactDTO=HttpUtil.of(request.getReader()).toModel(ContactDTO.class);
		contactService.deleteContact(contactDTO);
		objectMapper.writeValue(response.getOutputStream(), 1);
	}

}
