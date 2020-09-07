package company.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ctc.wstx.util.StringUtil;

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
		String urlViews=null;
		String url=getFullUrl(request);
		if(url.contains("action")==false) {
			List<ContactDTO> contactDTOs=contactService.listContact();
			request.setAttribute("contacts", contactDTOs);
			urlViews="/views/contact/contactlist.jsp";
		}else {
			if(action.equals("LIST")||StringUtils.isBlank(action)) {
				String searchKey=request.getParameter("searchKey");
				if(searchKey!=null) {
					List<ContactDTO> contactDTOs=new ArrayList<ContactDTO>();
					if(searchKey.contains("'")){
						request.setAttribute("emptyResults", 1);
					}
					else { 
						contactDTOs=contactService.findByContact(searchKey);
						
					}
					
					if(contactDTOs.size()==0) {
						request.setAttribute("emptyResults", 1);
					}
					
					request.setAttribute("contacts", contactDTOs);
					request.setAttribute("textSearch", searchKey);
					urlViews="/views/contact/contactlist.jsp";
				}else {
					List<ContactDTO> contactDTOs=contactService.listContact();
					request.setAttribute("contacts", contactDTOs);
					urlViews="/views/contact/contactlist.jsp";
				}
			
			}
			else if(action.equals("INSERT")) {
				urlViews="/views/contact/contactinsert.jsp";
			}
			else if(action.equals("EDIT")) {
				Long id=Long.parseLong(request.getParameter("id"));
				ContactDTO contactDTO=contactService.findById(id);
				request.setAttribute("contact", contactDTO);
			    urlViews="/views/contact/contactedit.jsp";
			}
			RequestDispatcher rd=request.getRequestDispatcher(urlViews);
			rd.forward(request, response);
		}
		
	}
	private String getFullUrl(HttpServletRequest request)
	{
		StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	    String queryString = request.getQueryString();

	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
	        return requestURL.append('?').append(queryString).toString();
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
