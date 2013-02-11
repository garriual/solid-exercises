package com.theladders.solid.ocp;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.resume.ConfidentialResumeHandler;
import com.theladders.solid.ocp.resume.JobseekerProfile;
import com.theladders.solid.ocp.resume.JobseekerProfileManager;
import com.theladders.solid.ocp.resume.ResumeConfidentialityManager;
import com.theladders.solid.ocp.user.User;

public class App
{
  public static void main(String[] args)
  {
    JobseekerProfileManager jobseekerProfileManager = new JobseekerProfileManager();
    JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao = new JobseekerConfidentialityProfileDao();
    ConfidentialResumeHandler confidentialResumeHandler = new ConfidentialResumeHandler(jobseekerProfileManager, jobseekerConfidentialityProfileDao);
    ResumeConfidentialityManager resumeConfidentialityManager = new ResumeConfidentialityManager(confidentialResumeHandler);

    int id = 1; // get from command line?
    User user = new User(id);
    
    JobseekerProfile jobseekerProfile = jobseekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile jobseekerConfidentialityProfile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jobseekerProfile.getId());

    //resumeConfidentialityManager.makeAllContactInfoNonConfidential(user);
    resumeConfidentialityManager.makeAllCategoriesNonConfidential(jobseekerConfidentialityProfile);
  }
}
