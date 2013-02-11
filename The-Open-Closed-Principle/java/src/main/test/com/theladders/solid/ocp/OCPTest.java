package com.theladders.solid.ocp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.resume.ConfidentialPhraseCategory;
import com.theladders.solid.ocp.resume.ConfidentialResumeHandler;
import com.theladders.solid.ocp.resume.JobseekerProfile;
import com.theladders.solid.ocp.resume.JobseekerProfileManager;
import com.theladders.solid.ocp.resume.ResumeConfidentialityManager;
import com.theladders.solid.ocp.user.User;

public class OCPTest
{

  public void a()
  {
    
  }


  @Test
  public void aUserShouldBeAbleToResetConfidentialityForAllCategories()
  {
    JobseekerProfileManager jobseekerProfileManager = new JobseekerProfileManager();
    JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao = new JobseekerConfidentialityProfileDao();
    ConfidentialResumeHandler confidentialResumeHandler = new ConfidentialResumeHandler(jobseekerProfileManager,
                                                                                        jobseekerConfidentialityProfileDao);
    ResumeConfidentialityManager resumeConfidentialityManager = new ResumeConfidentialityManager(confidentialResumeHandler);

    int id = 1; // get from command line?
    User user = new User(id);

    JobseekerProfile jobseekerProfile = jobseekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile jobseekerConfidentialityProfile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jobseekerProfile.getId());

    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.Name);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.MailingAddress);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.PhoneNumber);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.EmailAddress);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.ContactInfo);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.CompanyName);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.WorkExperience);

    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.Name));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.ContactInfo));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.CompanyName));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.WorkExperience));

    resumeConfidentialityManager.makeAllCategoriesNonConfidential(jobseekerConfidentialityProfile);

    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.Name));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.ContactInfo));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.CompanyName));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.WorkExperience));
  }


  // resumeConfidentialityManager.makeAllContactInfoNonConfidential(user);

  @Test
  public void aUserShouldBeAbleToReSetConfidentialityForAllContactInfo()
  {
    JobseekerProfileManager jobseekerProfileManager = new JobseekerProfileManager();
    JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao = new JobseekerConfidentialityProfileDao();
    ConfidentialResumeHandler confidentialResumeHandler = new ConfidentialResumeHandler(jobseekerProfileManager,
                                                                                        jobseekerConfidentialityProfileDao);
    ResumeConfidentialityManager resumeConfidentialityManager = new ResumeConfidentialityManager(confidentialResumeHandler);

    int id = 1; // get from command line?
    User user = new User(id);

    JobseekerProfile jobseekerProfile = jobseekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile jobseekerConfidentialityProfile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jobseekerProfile.getId());

    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.Name);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.MailingAddress);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.PhoneNumber);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.EmailAddress);
    jobseekerConfidentialityProfile.setConfidential(ConfidentialPhraseCategory.ContactInfo);

    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.Name));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.ContactInfo));

    resumeConfidentialityManager.makeAllContactInfoNonConfidential(jobseekerConfidentialityProfile);

    assertTrue(jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.Name));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.MailingAddress));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.PhoneNumber));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.EmailAddress));
    assertTrue(!jobseekerConfidentialityProfile.isConfidential(ConfidentialPhraseCategory.ContactInfo));
  }

}
