package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.dao.EmployeeDAO;
import com.myproject.dao.UserDAO;
import com.myproject.entity.Employee;
import com.myproject.entity.User;

@Controller
public class MainController {
	
	UserDAO userDao;
	EmployeeDAO empDao;

	@RequestMapping(value = "/register")
	public ModelAndView registerUser() {
		return new ModelAndView("registerUserPage", "user", new User());
	}

	@RequestMapping(value = "/add")
	public ModelAndView addEmployee() {
		return new ModelAndView("addEmployeePage", "employee", new Employee());
	}

	@RequestMapping(value = "/forgot")
	public String forgotPassword(ModelMap map) {
		return "forgotPassword";
	}
	
	@PostMapping("/registerUser")
	public String registerSubmit( @ModelAttribute("user") final User user,final ModelMap model) throws ClassNotFoundException {
		userDao=new UserDAO();
		userDao.insertUser(user);	
		return "indexmain";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException{
		userDao=new UserDAO();
		String username=request.getParameter("user");
		String password=request.getParameter("password");	
		String dbpassword=userDao.fetchUserById(username);

		if(dbpassword.equals(password))
		{
			return "homepage";
		}
		else
		{
			return "indexmain";
		}		
	}

	@PostMapping("/saveEmployee")
	public String submit( @ModelAttribute("employee") final Employee employee,final ModelMap model) throws ClassNotFoundException { 		
		 empDao=new EmployeeDAO();
		 empDao.insertEmployee(employee);		
		 return "homepage";
	}
	
	@RequestMapping(value = "/showEmployees")
	public ModelAndView showEmployees() {
		empDao=new EmployeeDAO();
		
		ModelAndView modelAndView = new ModelAndView("showEmployeePage");
	    modelAndView.addObject("employeeList", "Baeldung");
	    return modelAndView;
		
	}

}
