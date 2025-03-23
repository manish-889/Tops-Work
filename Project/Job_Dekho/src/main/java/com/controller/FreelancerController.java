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
import com.model.ShowJobs;

@Controller
public class FreelancerController {

	@Autowired
	private ProjectDao projectDao;

	// handler for register page
	@RequestMapping("/registerFreelancer")
	public String registerFrelancer() {

		return "registerFreelancer";
	}

	// handler for login page
	@RequestMapping("/loginFreelancer")
	public String loginFreelancer() {
		return "loginFreelancer";
	}

	// Handler for registration of freelancer
	@RequestMapping(value = "/freelancerdata", method = RequestMethod.POST)
	public String freelancerRegitserData(@ModelAttribute("f1") Freelancer f1,
			@RequestParam("filenamef") MultipartFile filenamef, @RequestParam("email") String email, ModelMap m)
			throws IOException {

		// checking duplicate email
		List<Freelancer> list = projectDao.checkingEmailOfFreelancer(email);

		if (f1.getPassword().equals(f1.getCpassword()) && list.isEmpty()) {
			// file uploading code
			// for file name
			String f = filenamef.getOriginalFilename();

			// for file Storage
			String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

			// concate of file name and file storage
			BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

			byte b[] = filenamef.getBytes();

			bf.write(b);

			bf.close();

			f1.setProfilef(f);

			projectDao.registerFreelancer(f1);

			m.addAttribute("loginMsg", "Registration Successfully Done, Now Login!");

			return "loginFreelancer";

		}

		m.addAttribute("errorMsg", "Check Your password & Confirm Password, Email already Exit!!");
		return "registerFreelancer";
	}

	// Handler for checking the freelancer is register or not, if yes then login
	@RequestMapping(value = "/freelancerChecking", method = RequestMethod.POST)
	public String freelancerChecking(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap m, HttpSession s) {

		List<Freelancer> list = projectDao.checkDetailsOfFreelancer(email, password);

		if (list.isEmpty()) {
			m.addAttribute("msgLoginFreelancer", "You Don't Have An Account Register Now!");
			return "loginFreelancer";
		}

		s.setAttribute("emailOfFreelancer", email);

		// putting all the freelancer data on session for getting on the page of
		// homeFreelancer
		s.setAttribute("freelancerData", list);

		return "redirect:/homeFreelancer";
	}

	// Handler for Home page
	@RequestMapping("/homeFreelancer")
	public String homeFreelancer(HttpSession s, ModelMap m) {

		String freelancerEmail = (String) s.getAttribute("emailOfFreelancer");

		if (freelancerEmail == null) {
			return "loginFreelancer";
		}

		// this is for getting all data of freelancer from session
		List<Freelancer> detailsOfFreelancer = (List<Freelancer>) s.getAttribute("freelancerData");
		m.addAttribute("freelancerDetails", detailsOfFreelancer);

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

		List<ShowJobs> jobInfo = projectDao.getJobInfo();
		m.addAttribute("jobInfo", jobInfo);
		
		List<PostProject> projectInfo = projectDao.getProjectInfo();
		m.addAttribute("projectInfo", projectInfo);
		
		return "homeFreelancer";
	}

	// Handler for logout
	@RequestMapping("/logoutFreelancer")
	public String logoutFreelancer(HttpSession s) {

		s.invalidate();

		return "loginFreelancer";
	}

	// Handler for profile of freelancer
	@RequestMapping("/profileFreelancer")
	public String profileFreelancer(HttpSession s, ModelMap m) {

		// this is for getting all data of freelancer from session
		List<Freelancer> detailsOfFreelancer = (List<Freelancer>) s.getAttribute("freelancerData");
		m.addAttribute("freelancerDetails", detailsOfFreelancer);

		return "profileFreelancer";
	}

	// Handler for update freelancer profile
	@RequestMapping(value = "/updateProfileFreelancer", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("f1") Freelancer f1, @RequestParam("filename") MultipartFile filename)
			throws IOException {

		// for file name
		String f = filename.getOriginalFilename();

		// for file Storage
		String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

		// concate of file name and file storage
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

		byte b[] = filename.getBytes();

		bf.write(b);

		bf.close();

		f1.setProfilef(f);

		projectDao.updateDataOfFreelancer(f1);

		return "loginFreelancer";

	}

	// Handler for explore job page
	@RequestMapping("/ExploreJobs")
	public String exploreJobs(ModelMap m) {

		List<ShowJobs> showJobData = projectDao.getAllJobData();

		m.addAttribute("jobData", showJobData);

		return "ExploreJobs";
	}

	// Handler for explore project page
	@RequestMapping("/exploreProject")
	public String exploreProject(ModelMap m) {

		List<PostProject> projectData = projectDao.getAllProjectData();

		m.addAttribute("projectData", projectData);

		return "exploreProject";
	}

	// Handler for view and apply job page
	@RequestMapping(value = "/viewAndApplyJob/{id}", method = RequestMethod.GET)
	public String viewAndApplyJob(@PathVariable int id, ModelMap m, HttpSession s) {

		List<PostJob> jobData = projectDao.getJobDetails(id);

		// this is for getting all data of freelancer from session
		List<Freelancer> detailsOfFreelancer = (List<Freelancer>) s.getAttribute("freelancerData");
		m.addAttribute("freelancerDetails", detailsOfFreelancer);

		m.addAttribute("jobData", jobData);

		return "viewAndApplyJob";
	}

	// Handler for view and apply project page
	@RequestMapping(value = "/viewAndApplyProject/{id}", method = RequestMethod.GET)
	public String viewAndApplyProject(@PathVariable int id, ModelMap m, HttpSession s) {

		List<PostProject> projectData = projectDao.getProjectDetails(id);

		// this is for getting all data of freelancer from session
		List<Freelancer> detailsOfFreelancer = (List<Freelancer>) s.getAttribute("freelancerData");
		m.addAttribute("freelancerDetails", detailsOfFreelancer);

		m.addAttribute("projectData", projectData);

		return "viewAndApplyProject";
	}

	// Handler for apply job form viewAndApplyJob page
	@RequestMapping(value = "/applyForJob", method = RequestMethod.POST)
	public String applyForJob(@ModelAttribute("a") ApplyJob a, @RequestParam("resumeFile") MultipartFile filename,
			ModelMap m) throws IOException {

		// for file name
		String f = filename.getOriginalFilename();

		// for file Storage
		String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

		// concate of file name and file storage
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

		byte b[] = filename.getBytes();

		bf.write(b);

		bf.close();

		a.setFresume(f);

		projectDao.getApplyJobData(a);

		m.addAttribute("msgForSubmitJob", "Congratulations Your Application Submitted Successfully..");

		return "ExploreJobs";
	}

	// Handler for apply project from viewAndApplyProject page
	@RequestMapping(value = "/applyForProject", method = RequestMethod.POST)
	public String applyForProject(@ModelAttribute("p") ApplyProject p,
			@RequestParam("resumefile") MultipartFile filename, ModelMap m) throws IOException {

		// for file name
		String f = filename.getOriginalFilename();

		// for file Storage
		String path = "C:\\Users\\ViP\\eclipse-workspace-Project\\Job_Dekho\\src\\main\\webapp\\files\\webimages";

		// concate of file name and file storage
		BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(path + "/" + f));

		byte b[] = filename.getBytes();

		bf.write(b);

		bf.close();

		p.setResumef(f);
		
		projectDao.setApplyProjectData(p);

		m.addAttribute("msgForSubmitProject", "Congratulations Your Application Submitted Successfully..");
		
		return "exploreProject";
	}
	
	
	//Handler for showing applied job and project by freelancer
	@RequestMapping(value = "/myApplication/{email}")
	public String myApplication(@PathVariable String email, ModelMap m) {
		
		
		List<ApplyJob> myApplicationData = projectDao.getMyApplicationData(email);
		
		List<ApplyProject> getProjectList = projectDao.getProjectApplicationData(email);
		
		m.addAttribute("myApplicationList", myApplicationData);
		m.addAttribute("getProjectList",getProjectList);
		
		return "myApplication";
	}

}
