package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.example.entity.Employee;
import com.example.repo.EmployeeRepository;

@Controller
public class HomeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping("/")
	public String home(Model model) {
		List<Employee> listOfEmployees = employeeRepository.findAll();
		model.addAttribute("listOfEmployees", listOfEmployees);
		return "home";
	}

	@GetMapping("/createNew")
	public String createNew(Employee employeeEntity, Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "createNew";
	}

	@PostMapping("/save")
	public String save(Employee employeeEntity, Model model) {
		List<String> employeeList = employeeRepository.fetchAllNames();
		if (employeeList.contains(employeeEntity.getName())) {
			model.addAttribute("errorMessage", "Data Already Exists!!");
		} else {
			employeeRepository.save(employeeEntity);
			model.addAttribute("message", "Data Registered Successfully!!");
		}
		return "display";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(name = "id") int id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		return "edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id, Model model) {
		employeeRepository.deleteById(id);
		model.addAttribute("deleteMessage", "Data deleted Successfully!!");
		return "display";
	}

	@GetMapping("/view/{id}")
	public String view(@PathVariable(name = "id") int id, Model model) {
		Employee employee = employeeRepository.findById(id).get();
		model.addAttribute("employee", employee);
		return "view";
	}

	@GetMapping("/downloadCsv")
	public void downloadCsv(HttpServletResponse response) throws IOException {
		try {

			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; filename=users.csv");

			// write to csv file //

			ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

			String[] headings = { "ID", "Name", "Date", "Gender" };

			String[] pojoclassPropertyName = { "id", "name", "date", "gender" };

			csvWriter.writeHeader(headings);

			List<Employee> listOfEmployees = employeeRepository.findAll();

			if (null != listOfEmployees && !listOfEmployees.isEmpty()) {
				for (Employee employee : listOfEmployees) {
					csvWriter.write(employee, pojoclassPropertyName);
				}
			}
			csvWriter.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("csv report downloaded successfully...........");
	}
}
