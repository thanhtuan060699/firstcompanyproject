package company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.dto.ContactDTO;
import company.service.impl.ContactService;

/**
 * Servlet implementation class ContactController
 */
@WebServlet(urlPatterns = {"/contact-account"})
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }
    ContactService contactService=new ContactService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("LIST")) {
			List<ContactDTO> contactDTOs=contactService.listContact();
			request.setAttribute("contacts", contactDTOs);
			RequestDispatcher rd=request.getRequestDispatcher("/views/contact/contactlist.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("INSERT")) {
			RequestDispatcher rd=request.getRequestDispatcher("/views/contact/contactinsert.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("EDIT")) {
			Long id=Long.parseLong(request.getParameter("id"));
			ContactDTO contactDTO=contactService.findById(id);
			request.setAttribute("contact", contactDTO);
			RequestDispatcher rd=request.getRequestDispatcher("/views/contact/contactedit.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
