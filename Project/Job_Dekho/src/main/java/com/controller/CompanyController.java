package com.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ProjectDao;
import com.model.ApplyJob;
import com.model.ApplyProject;
import com.model.Company;
import com.model.Freelancer;
import com.model.PostJob;
import com.model.PostProject;

@Controller
public class CompanyController {

	@Autowired
	private ProjectDao projectDao;

	// RegisterPage Handler
	@RequestMapping(value = "/registerCompany", method = RequestMethod.GET)
	public String registerPage() {
		return "registerCompany";
	}

	// LoginPage Handler
	@RequestMapping("/loginCompany")
	public String loginPage() {
		return "loginCompany";
	}

	// For CompanyRegister Handler
	@RequestMapping(value = "/registerCompanyData", method = RequestMethod.POST)
	public String registerCompanyData(@ModelAttribute("c1") Company c1,
			@RequestParam("filename") MultipartFile filename, ModelMap mm) throws IOException {

		if (c1.getPassword().equals(c1.getCpassword())) {

			// <--file uploading code start from here
			// for file name
			String f = filename.getOriginalFilename();

			// for file Storage
			String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

			// Concate of file name and file storage
			BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

			byte b[] = filename.getBytes();

			bf.write(b);

			bf.close();

			c1.setProfilec(f);
			// file uploading code end from -->

			projectDao.regsiterCompany(c1);

			mm.addAttribute("registerMsg", "Registration Successfully Completed, Now Login..");

			return "loginCompany";
		}
		mm.addAttribute("registerErr", "Something Went Wrong!!!");

		return "registerCompany";
	}

	// Handler for login company
	@RequestMapping(value = "/logincompany", method = RequestMethod.POST)
	public String loginCompany(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap mm, HttpSession s1) {

		// This is for checking the login details of user
		List<Company> companyData = projectDao.checkLoginDetails(email, password);

		if (companyData.isEmpty()) {
			mm.put("loginKey", "Something Went Wrong, Check Your Details.");
			return "loginCompany";
		} 

		// putting the email data on session
		s1.setAttribute("sessionData", email);

		// putting all the data of user on session
		s1.setAttribute("CompanyData", companyData);

		return "redirect:/homeCompany";
	}

	// Handler for Home Page
	@RequestMapping("/homeCompany")
	public String homePageCompany(HttpSession s1, ModelMap m) {

		String data = (String) s1.getAttribute("sessionData");

		if (data == null) {
			return "loginCompany";
		}

		// getting company data form session
		List<Company> companyDataList = (List<Company>) s1.getAttribute("CompanyData");

		// putting all companyDataList on MOdelMap to get the data on webpage
		m.addAttribute("CompanyKey", companyDataList);

		// count the total number of freelancer
		int countFreelancer = projectDao.getCountFreelancer();
		m.addAttribute("countFreelancer", countFreelancer);

		// count the total number of job
		int countJob = projectDao.getCountJob();
		m.addAttribute("countJob", countJob);

		// count the total number of project
		int countProject = projectDao.getCountProject();
		m.addAttribute("countProject", countProject);

		// count the total number of project
		int countCompany = projectDao.getCountComapny();
		m.addAttribute("countCompany", countCompany);

		return "homeCompany";
	}

	// Handler for logout page
	@RequestMapping("/logoutcompany")
	public String logoutCompany(HttpSession s) {
		s.invalidate();
		return "loginCompany";
	}

	// Handler for company profile
	@RequestMapping("/profilec")
	public String companyProfile(HttpSession s1, ModelMap m) {

		// getting company data form session
		List<Company> companyDataList = (List<Company>) s1.getAttribute("CompanyData");

		// putting all companyDataList on MOdelMap to get the data on webpage
		m.addAttribute("CompanyKey", companyDataList);

		return "profilec";
	}

	// Handler for update for company profile
	@RequestMapping(value = "/updateprofilec", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("c1") Company c1, @RequestParam("filename") MultipartFile filename,
			ModelMap m) throws IOException {

		// for file name
		String f = filename.getOriginalFilename();

		// for file Storage
		String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

		// Concate of file name and file storage
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

		byte b[] = filename.getBytes();

		bf.write(b);

		bf.close();

		c1.setProfilec(f);

		projectDao.updateDataOfProfileC(c1);

		m.addAttribute("UpdateMsg", "Profile is Sucessdully Updated Now Login Again.");

		return "loginCompany";
	}

	// Handler for post Job page
	@RequestMapping("/postJob")
	public String postJob(HttpSession s, ModelMap m) {

		// getting company data form session
		List<Company> companyDataList = (List<Company>) s.getAttribute("CompanyData");

		// putting all companyDataList on MOdelMap to get the data on webpage
		m.addAttribute("CompanyKey", companyDataList);

		return "postJob";
	}

	// Handler for putting all data of post job into database
	@RequestMapping(value = "/postJobData", method = RequestMethod.POST)
	public String postJobData(@ModelAttribute("pj") PostJob pj) {

		projectDao.postJobData(pj);

		return "postJob";
	}

	// Handler for post project page
	@RequestMapping("/postProject")
	public String postProject(HttpSession s, ModelMap m) {

		// getting company data form session
		List<Company> companyDataList = (List<Company>) s.getAttribute("CompanyData");

		// putting all companyDataList on MOdelMap to get the data on webpage
		m.addAttribute("CompanyKey", companyDataList);

		return "postProject";
	}

	// Handler for putting all detail of post project into a database
	@RequestMapping(value = "/postProjectData", method = RequestMethod.POST)
	public String postProjectData(@ModelAttribute("pp") PostProject pp,
			@RequestParam("projectFile") MultipartFile projectpdf) throws IOException {

		// for file name
		String f = projectpdf.getOriginalFilename();

		// for file Storage
		String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

		// Concate of file name and file storage
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

		byte b[] = projectpdf.getBytes();

		bf.write(b);

		bf.close();

		pp.setProjectpdf(f);

		projectDao.postProjectData(pp);

		return "postProject";
	}

	// Handler for view candidate job and project list that are applied by
	// freelancer
	@RequestMapping("/viewCandidateApplication/{name}")
	public String viewCandidateApplication(@PathVariable String name, ModelMap m, HttpSession s) {

		// Show Jobs Application Applied by Candidates
		List<ApplyJob> allCandidateData = projectDao.getApplicationData(name);

		m.addAttribute("allCandidateData", allCandidateData);

		// Show Projects Application Applied by Candidates
		List<ApplyProject> allProejctData = projectDao.getProjectAppliedList(name);

		m.addAttribute("allProejctData", allProejctData);

		// getting company data form session
		List<Company> companyDataList = (List<Company>) s.getAttribute("CompanyData");

		// putting all companyDataList on MOdelMap to get the data on webpage
		m.addAttribute("CompanyKey", companyDataList);

		return "viewCandidateApplication";
	}

	// update the job status
	@RequestMapping(value = "/updateJobStatus", method = RequestMethod.POST)
	public String updateJobStatus(@ModelAttribute("c") ApplyJob c, ModelMap m) {

		projectDao.getJobStatus(c);

		m.addAttribute("updateJobMsg", "Job Status Updated..");

		return "messagePageCompany";
	}

	// update the project status
	@RequestMapping(value = "/updateProjectStatus", method = RequestMethod.POST)
	public String updateProjectStatus(@ModelAttribute("p") ApplyProject p, ModelMap m) {

		projectDao.getProjectStatus(p);

		m.addAttribute("updateProjectMsg", "project Status Updated..");

		return "messagePageCompany";
	}

	// Handler for message page
	@RequestMapping("/messagePageCompany")
	public String messagePage() {
		return "messagePageCompany";
	}

	// Handler for accepted job and projects application
	@RequestMapping("/acceptedJobApplication/{cname}")
	public String acceptedJobApplication(@PathVariable String cname, ModelMap m) {

		// this is for getting the list of accepted job
		List<ApplyJob> acceptedJobApplicationData = projectDao.getAcceptedJobApplicationData(cname);
		m.addAttribute("acceptedJobData", acceptedJobApplicationData);

		// this is for getting the list of accepted project
		List<ApplyProject> acceptedProjectApplicationData = projectDao.getAcceptedProjectApplicationData(cname);
		m.addAttribute("acceptedProjectData", acceptedProjectApplicationData);

		return "acceptedJobApplication";
	}

	// Handler for rejected job and projects application
	@RequestMapping("/rejectedJobApplication/{cname}")
	public String rejectedJobApplication(@PathVariable String cname, ModelMap m) {

		// this is for getting the list of rejected job
		List<ApplyJob> rejectedJobApplicationData = projectDao.getRejectedJobApplicationData(cname);
		m.addAttribute("rejectedJobData", rejectedJobApplicationData);

		// this is for getting the list of rejected project
		List<ApplyProject> rejectedProjectApplicationData = projectDao.getRejectedProjectApplicationData(cname);
		m.addAttribute("rejectedProjectData", rejectedProjectApplicationData);

		return "rejectedJobApplication";
	}

	// Handler for checking the history of jobs and projects
	@RequestMapping("/historyJobAndProject/{name}")
	public String historyJobAndProject(@PathVariable String name, ModelMap m) {

		List<PostJob> historyOfJobs = projectDao.getHistoryOfJobs(name);
		m.addAttribute("historyJobData", historyOfJobs);

		List<PostProject> historyOfProject = projectDao.getHistoryOfProject(name);
		m.addAttribute("historyProjectData", historyOfProject);

		return "historyJobAndProject";
	}

	// this method for getting all details of job to edit page
	@RequestMapping("/editJobDetails/{id}")
	public String editJobDetails(@PathVariable int id, ModelMap m) {

		List<PostJob> jobDataForEdit = projectDao.getJobDataForEdit(id);
		m.addAttribute("jobData", jobDataForEdit);

		return "editJobDetails";
	}

	// this is update posted job details
	@RequestMapping(value = "/updateJobData", method = RequestMethod.POST)
	public String updateJobData(@ModelAttribute("c1") PostJob pj, ModelMap m) {

		projectDao.editJobData(pj);
		m.addAttribute("msgUpdate", "Job Details Updated..");

		return "messagePageCompany";
	}

	// for removing the posted job
	@RequestMapping(value = "/removeJob/{id}", method = RequestMethod.GET)
	public String removeJob(@PathVariable int id, ModelMap m) {

		projectDao.removePostedJob(id);
		m.addAttribute("msgRemoveJob", "Job Deleted..");

		return "redirect:/messagePageCompany";
	}

	// for removing the posted job
	@RequestMapping(value = "/removeProject/{id}", method = RequestMethod.GET)
	public String removeProject(@PathVariable int id, ModelMap m) {

		projectDao.removeProject(id);
		m.addAttribute("msgRemoveProject", "Project Deleted..");

		return "redirect:/messagePageCompany";
	}

	// this method for view and hire a freelancer
	@RequestMapping("/viewAllFreelancer")
	public String viewAllFreelancer(ModelMap m) {

		List<Freelancer> freelancerList = projectDao.getFreelancerList();
		m.addAttribute("getFreelancers", freelancerList);

		return "viewAllFreelancer";
	}

}
