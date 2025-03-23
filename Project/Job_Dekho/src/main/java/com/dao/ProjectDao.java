package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.ApplyJob;
import com.model.ApplyProject;
import com.model.Company;
import com.model.Freelancer;
import com.model.PostJob;
import com.model.PostProject;
import com.model.ShowJobs;

public class ProjectDao {

	JdbcTemplate t1;

	public JdbcTemplate getT1() {
		return t1;
	}

	public void setT1(JdbcTemplate t1) {
		this.t1 = t1;
	}

	// this method for register company data into database
	public void regsiterCompany(Company c1) {

		t1.update("INSERT INTO company(name, email, number, website,password,cpassword, profilec) VALUES('"
				+ c1.getName() + "','" + c1.getEmail() + "','" + c1.getNumber() + "','" + c1.getWebsite() + "','"
				+ c1.getPassword() + "','" + c1.getCpassword() + "','" + c1.getProfilec() + "')");

	}

	// this method for checking the company is present in a database or not
	public List<Company> checkLoginDetails(String email, String password) {

		return t1.query("SELECT * FROM company WHERE email='" + email + "' AND password ='" + password + "'",
				new RowMapper<Company>() {

					@Override
					public Company mapRow(ResultSet rs, int rowNum) throws SQLException {

						Company c1 = new Company();

						c1.setId(rs.getInt(1));
						c1.setName(rs.getString(2));
						c1.setEmail(rs.getString(3));
						c1.setNumber(rs.getString(4));
						c1.setWebsite(rs.getString(5));
						c1.setPassword(rs.getString(6));
						c1.setCpassword(rs.getString(7));
						c1.setProfilec(rs.getString(8));
						c1.setAbout(rs.getString(9));

						return c1;
					}
				});

	}

	// this method for update company profile
	public void updateDataOfProfileC(Company c1) {

		t1.update("UPDATE company SET name = '" + c1.getName() + "',email='" + c1.getEmail() + "',number='"
				+ c1.getNumber() + "',website='" + c1.getWebsite() + "',profilec='" + c1.getProfilec() + "',about='"
				+ c1.getAbout() + "' WHERE id = '" + c1.getId() + "' ");
	}

	/************************* Starting the methods Related to Freelancer *************************/

	// this method for register the freelancer
	public void registerFreelancer(Freelancer f1) {

		System.out.println(f1.getName());
		t1.update(
				"INSERT INTO freelancer(name,email,number,date,linkedin,education,profilef,charge,gender,skills,password,cpassword) VALUES('"
						+ f1.getName() + "','" + f1.getEmail() + "','" + f1.getNumber() + "','" + f1.getDate() + "','"
						+ f1.getLinkedin() + "','" + f1.getEducation() + "','" + f1.getProfilef() + "','"
						+ f1.getCharge() + "','" + f1.getGender() + "','" + f1.getSkills() + "','" + f1.getPassword()
						+ "','" + f1.getCpassword() + "')");

	}

	// this method for checking freelancer is register or not
	public List<Freelancer> checkDetailsOfFreelancer(String email, String password) {

		return t1.query("SELECT * FROM freelancer WHERE email = '" + email + "' AND password = '" + password + "' ",
				new RowMapper<Freelancer>() {

					@Override
					public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Freelancer f = new Freelancer();

						f.setId(rs.getInt(1));
						f.setName(rs.getString(2));
						f.setEmail(rs.getString(3));
						f.setNumber(rs.getString(4));
						f.setDate(rs.getDate(5));
						f.setLinkedin(rs.getString(6));
						f.setEducation(rs.getString(7));
						f.setProfilef(rs.getString(8));
						f.setCharge(rs.getString(9));
						f.setGender(rs.getString(10));
						f.setSkills(rs.getString(11));

						return f;
					}

				});

	}

	// Checking the email is present in table or not for duplicate entry
	public List<Freelancer> checkingEmailOfFreelancer(String email) {

		return t1.query("SELECT * FROM freelancer WHERE email = '" + email + "' ", new RowMapper<Freelancer>() {

			@Override
			public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Freelancer f = new Freelancer();

				f.setEmail(rs.getString(3));

				return f;
			}

		});

	}

	// this method for update for all data of freelancer
	public void updateDataOfFreelancer(Freelancer f1) {

		t1.update("UPDATE freelancer SET name='" + f1.getName() + "', email='" + f1.getEmail() + "', number='"
				+ f1.getNumber() + "',  linkedin='" + f1.getLinkedin() + "', education='" + f1.getEducation()
				+ "', profilef='" + f1.getProfilef() + "', charge='" + f1.getCharge() + "', skills='" + f1.getSkills()
				+ "' WHERE id='" + f1.getId() + "' ");

	}

	/************************* end of freelancer Register work *************************/

	// This is for save all the jobs into database that is post by company
	public void postJobData(PostJob pj) {

		t1.update("INSERT INTO postjob (name, email, discription, title, skills, salary, role) VALUES ('" + pj.getName()
				+ "', '" + pj.getEmail() + "', '" + pj.getDiscription() + "', '" + pj.getTitle() + "', '"
				+ pj.getSkills() + "', '" + pj.getSalary() + "', '" + pj.getRole() + "')");

	}

	// this method for showing all job data to freelancer
	public List<ShowJobs> getAllJobData() {

		return t1.query(
				"SELECT * FROM postjob RIGHT JOIN company on postjob.name = company.name WHERE postjob.name IS NOT NULL",
				new RowMapper<ShowJobs>() {

					@Override
					public ShowJobs mapRow(ResultSet rs, int rowNum) throws SQLException {

						ShowJobs sj = new ShowJobs();

						sj.setId(rs.getInt(1));
						sj.setPrfilec(rs.getString(16));
						sj.setCompanyName(rs.getString(2));
						sj.setPosition(rs.getString(5));
						sj.setSkills(rs.getString(6));

						return sj;
					}

				});

	}

	// This is for save all the project into database that is post by company
	public void postProjectData(PostProject pp) {

		t1.update(
				"INSERT INTO postproject (projectd, projectt, projectpdf, projects, projectb, cname, cemail) VALUES ('"
						+ pp.getProjectd() + "', '" + pp.getProjectt() + "', '" + pp.getProjectpdf() + "', '"
						+ pp.getProjects() + "', '" + pp.getProjectb() + "', '" + pp.getCname() + "', '"
						+ pp.getCemail() + "')");

	}

	// this method for showing all project data to freelancer
	public List<PostProject> getAllProjectData() {

		return t1.query("SELECT * FROM postproject", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostProject pp = new PostProject();
				pp.setId(rs.getInt(1));
				pp.setProjectt(rs.getString(3));
				pp.setCname(rs.getString(7));
				pp.setProjects(rs.getString(5));

				return pp;
			}

		});

	}

	// this is for getting all details of job, for user to apply on it
	public List<PostJob> getJobDetails(int id) {

		return t1.query("SELECT * FROM postjob WHERE id = '" + id + "'", new RowMapper<PostJob>() {

			@Override
			public PostJob mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostJob pj = new PostJob();
				pj.setId(rs.getInt(1));
				pj.setDiscription(rs.getString(4));
				pj.setTitle(rs.getString(5));
				pj.setRole(rs.getString(8));
				pj.setSalary(rs.getString(7));
				pj.setSkills(rs.getString(6));
				pj.setName(rs.getString(2));
				pj.setEmail(rs.getString(3));

				return pj;
			}

		});

	}

	// this is for getting all details of project, for user to apply on it
	public List<PostProject> getProjectDetails(int id) {

		return t1.query("SELECT * FROM postproject WHERE id = '" + id + "'", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostProject pp = new PostProject();
				pp.setId(rs.getInt(1));
				pp.setProjectd(rs.getString(2));
				pp.setProjectt(rs.getString(3));
				pp.setProjectpdf(rs.getString(4));
				pp.setProjects(rs.getString(5));
				pp.setProjectb(rs.getString(6));
				pp.setCname(rs.getString(7));
				pp.setCemail(rs.getString(8));

				return pp;
			}

		});

	}

	// this is for details about which job applied by freelancer
	public void getApplyJobData(ApplyJob a) {

		t1.update("INSERT INTO applyjob(cname,position,fname,femail,fresume,status) VALUES ('" + a.getCname() + "', '"
				+ a.getPosition() + "', '" + a.getFname() + "', '" + a.getFemail() + "', '" + a.getFresume() + "', '"
				+ a.getStatus() + "')");

	}

	// this is for details about which project applied by freelancer
	public void setApplyProjectData(ApplyProject p) {

		t1.update("INSERT INTO applyproject(projectt,cname,cemail,fname,femail,resumef,status) VALUES ('"
				+ p.getProjectt() + "', '" + p.getCname() + "', '" + p.getCemail() + "', '" + p.getFname() + "', '"
				+ p.getFemail() + "', '" + p.getResumef() + "', '" + p.getStatus() + "')");

	}

	// this is foe showing all details of job that they applied
	public List<ApplyJob> getMyApplicationData(String email) {

		return t1.query("SELECT * FROM applyjob WHERE femail like '" + email + "%'", new RowMapper<ApplyJob>() {

			@Override
			public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {

				ApplyJob aj = new ApplyJob();
				aj.setId(rs.getInt(1));
				aj.setCname(rs.getString(2));
				aj.setPosition(rs.getString(3));
				aj.setFname(rs.getString(4));
				aj.setFemail(rs.getString(5));
				aj.setFresume(rs.getString(6));
				aj.setStatus(rs.getString(7));

				return aj;
			}

		});

	}

	// this is foe showing all details of project that they applied
	public List<ApplyProject> getProjectApplicationData(String email) {

		return t1.query("SELECT * FROM applyproject WHERE femail LIKE  '" + email + "%'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));

						return ap;
					}

				});

	}

	// this is for showing the candidate data on company site, that applied for job
	public List<ApplyJob> getApplicationData(String name) {

		return t1.query("SELECT * FROM applyjob WHERE cname like '" + name + "%' AND status='send'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyJob aj = new ApplyJob();
						aj.setId(rs.getInt(1));
						aj.setCname(rs.getString(2));
						aj.setPosition(rs.getString(3));
						aj.setFname(rs.getString(4));
						aj.setFemail(rs.getString(5));
						aj.setFresume(rs.getString(6));
						aj.setStatus(rs.getString(7));

						return aj;
					}

				});

	}

	// this is for showing the candidate data on company site, that applied for
	// project
	public List<ApplyProject> getProjectAppliedList(String name) {

		return t1.query("SELECT * FROM applyproject WHERE cname LIKE  '%" + name + "%' AND status='send'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));

						return ap;
					}

				});

	}

	// method for updating the status of job application
	public void getJobStatus(ApplyJob c) {

		t1.update("UPDATE applyjob SET status = '" + c.getStatus() + "' WHERE id = '" + c.getId() + "'");

	}

	// method for updating the status of project application
	public void getProjectStatus(ApplyProject p) {

		t1.update("UPDATE applyproject SET status = '" + p.getStatus() + "' WHERE id = '" + p.getId() + "'");

	}

	// method for getting details accepted job application
	public List<ApplyJob> getAcceptedJobApplicationData(String cname) {

		return t1.query("SELECT * FROM applyjob WHERE cname LIKE '%" + cname + "%' AND status='Accepted'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyJob aj = new ApplyJob();
						aj.setId(rs.getInt(1));
						aj.setCname(rs.getString(2));
						aj.setPosition(rs.getString(3));
						aj.setFname(rs.getString(4));
						aj.setFemail(rs.getString(5));
						aj.setFresume(rs.getString(6));
						aj.setStatus(rs.getString(7));

						return aj;
					}
				});
	}

	// method for getting details accepted project application
	public List<ApplyProject> getAcceptedProjectApplicationData(String cname) {
		return t1.query("SELECT * FROM applyproject WHERE cname LIKE '%" + cname + "%' AND status='Accepted' ",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));

						return ap;
					}
				});
	}

	// method for getting details rejected job application
	public List<ApplyJob> getRejectedJobApplicationData(String cname) {
		return t1.query("SELECT * FROM applyjob WHERE cname LIKE '%" + cname + "%' AND status='Rejected'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyJob aj = new ApplyJob();
						aj.setId(rs.getInt(1));
						aj.setCname(rs.getString(2));
						aj.setPosition(rs.getString(3));
						aj.setFname(rs.getString(4));
						aj.setFemail(rs.getString(5));
						aj.setFresume(rs.getString(6));
						aj.setStatus(rs.getString(7));

						return aj;
					}
				});
	}

	// method for getting details rejected project application
	public List<ApplyProject> getRejectedProjectApplicationData(String cname) {
		return t1.query("SELECT * FROM applyproject WHERE cname LIKE '%" + cname + "%' AND status='Rejected'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {

						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));

						return ap;
					}
				});
	}

	// this method for checking history of jobs
	public List<PostJob> getHistoryOfJobs(String name) {
		return t1.query("SELECT * FROM postjob WHERE name LIKE '%" + name + "%' ", new RowMapper<PostJob>() {

			@Override
			public PostJob mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostJob pj = new PostJob();
				pj.setId(rs.getInt(1));
				pj.setDiscription(rs.getString(4));
				pj.setTitle(rs.getString(5));
				pj.setRole(rs.getString(8));
				pj.setSalary(rs.getString(7));
				pj.setSkills(rs.getString(6));
				pj.setName(rs.getString(2));
				pj.setEmail(rs.getString(3));

				return pj;
			}
		});
	}

	// this method for checking history of Projects
	public List<PostProject> getHistoryOfProject(String name) {
		return t1.query("SELECT * FROM postproject WHERE cname LIKE '%" + name + "%'", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostProject pp = new PostProject();
				pp.setId(rs.getInt(1));
				pp.setProjectd(rs.getString(2));
				pp.setProjectt(rs.getString(3));
				pp.setProjectpdf(rs.getString(4));
				pp.setProjects(rs.getString(5));
				pp.setProjectb(rs.getString(6));
				pp.setCname(rs.getString(7));
				pp.setCemail(rs.getString(8));

				return pp;
			}
		});
	}

	
	//this is for getting all job details to edit page for update
	public List<PostJob> getJobDataForEdit(int id) {
		return t1.query("SELECT * FROM postjob WHERE id ='" + id + "'", new RowMapper<PostJob>() {

			@Override
			public PostJob mapRow(ResultSet rs, int rowNum) throws SQLException {

				PostJob pj = new PostJob();
				pj.setId(rs.getInt(1));
				pj.setDiscription(rs.getString(4));
				pj.setTitle(rs.getString(5));
				pj.setRole(rs.getString(8));
				pj.setSalary(rs.getString(7));
				pj.setSkills(rs.getString(6));
				pj.setName(rs.getString(2));
				pj.setEmail(rs.getString(3));

				return pj;

			}
		});
	}

	//this is for update the job
	public void editJobData(PostJob pj) {
		t1.update("UPDATE postjob SET discription='" + pj.getDiscription() + "', title='" + pj.getTitle()
				+ "', skills='" + pj.getSkills() + "', salary='" + pj.getSalary() + "', role='" + pj.getRole()
				+ "', name='" + pj.getName() + "', email='" + pj.getEmail() + "' WHERE id='" + pj.getId() + "'");
	}

	
	//this is for delete the job
	public void removePostedJob(int id) {
		t1.update("DELETE FROM postjob WHERE id = '"+id+"'");
	}

	//this is for delete the project
	public void removeProject(int id) {
		t1.update("DELETE FROM postproject WHERE id ='"+id+"'");
	}

	
	//this is for get the all freelancer
	public List<Freelancer> getFreelancerList(){
		return t1.query("SELECT * FROM freelancer", new RowMapper<Freelancer>() {

			@Override
			public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Freelancer f = new Freelancer();

				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setEmail(rs.getString(3));
				f.setNumber(rs.getString(4));
				f.setDate(rs.getDate(5));
				f.setLinkedin(rs.getString(6));
				f.setEducation(rs.getString(7));
				f.setProfilef(rs.getString(8));
				f.setCharge(rs.getString(9));
				f.setGender(rs.getString(10));
				f.setSkills(rs.getString(11));

				return f;
			}});
	}

	//counting the total number of freelancer
	public int getCountFreelancer() {
		return t1.queryForObject("SELECT COUNT(*) FROM freelancer", Integer.class);
	}

	//counting the total number of job
	public int getCountJob() {
	return t1.queryForObject("SELECT COUNT(*) FROM postjob", Integer.class);
	}

	//counting the total number of project
	public int getCountProject() {
		return t1.queryForObject("SELECT COUNT(*) FROM postproject", Integer.class);
	}

	//counting the total number of company
	public int getCountComapny() {
		return t1.queryForObject("SELECT COUNT(*) FROM company", Integer.class);
	}

	//getting the all information about the job
	public List<ShowJobs> getJobInfo() {
		return t1.query("SELECT * FROM postjob RIGHT JOIN company on postjob.name = company.name WHERE postjob.name IS NOT NULL", new RowMapper<ShowJobs>() {

			@Override
			public ShowJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ShowJobs sj = new ShowJobs();

				sj.setId(rs.getInt(1));
				sj.setPrfilec(rs.getString(16));
				sj.setCompanyName(rs.getString(2));
				sj.setPosition(rs.getString(5));
				sj.setSkills(rs.getString(6));

				return sj;
			}	
		});
	}

	//getting the all information about the project
	public List<PostProject> getProjectInfo() {
		return t1.query("SELECT * FROM postproject", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				PostProject pp = new PostProject();
				pp.setId(rs.getInt(1));
				pp.setProjectd(rs.getString(2));
				pp.setProjectt(rs.getString(3));
				pp.setProjectpdf(rs.getString(4));
				pp.setProjects(rs.getString(5));
				pp.setProjectb(rs.getString(6));
				pp.setCname(rs.getString(7));
				pp.setCemail(rs.getString(8));

				return pp;
			}
		});
	}

}
