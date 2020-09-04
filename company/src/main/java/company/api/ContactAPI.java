package company.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	ContactService contactService=new ContactService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ContactDTO contactDTO=HttpUtil.of(request.getReader()).toModel(ContactDTO.class);
		contactService.insertContact(contactDTO);
		objectMapper.writeValue(response.getOutputStream(), 1);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ContactDTO contactDTO=HttpUtil.of(request.getReader()).toModel(ContactDTO.class);
		contactService.editContact(contactDTO);
		objectMapper.writeValue(response.getOutputStream(), 1);
		
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
