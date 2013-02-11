package com.theladders.solid.ocp.resume;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;
import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfileDao;
import com.theladders.solid.ocp.user.User;

public class ConfidentialResumeHandler
{
  private final JobseekerProfileManager            jobSeekerProfileManager;
  private final JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao;

  public ConfidentialResumeHandler(JobseekerProfileManager jobseekerProfileManager,
                                   JobseekerConfidentialityProfileDao jobseekerConfidentialityProfileDao)
  {
    this.jobSeekerProfileManager = jobseekerProfileManager;
    this.jobseekerConfidentialityProfileDao = jobseekerConfidentialityProfileDao;
  }

  public void makeAllCategoriesNonConfidential(JobseekerConfidentialityProfile jobseekerConfidentialityProfile)
  {
    boolean isChanged = false;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.Name) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.PhoneNumber) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.EmailAddress) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.MailingAddress) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.ContactInfo) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.CompanyName) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.WorkExperience) || isChanged;

    if (isChanged)
    {
      //generatePermanentConfidentialFiles(user, jobseekerConfidentialityProfile);
    }
  }

  public void makeAllContactInfoNonConfidential(JobseekerConfidentialityProfile jobseekerConfidentialityProfile)
  {
    boolean isChanged = false;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.PhoneNumber) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.EmailAddress) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.MailingAddress) || isChanged;
    isChanged = jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(ConfidentialPhraseCategory.ContactInfo) || isChanged;

    if (isChanged)
    {
      //generatePermanentConfidentialFiles(user, jobseekerConfidentialityProfile);
    }
  }
 
  public boolean isConfidential(User user, ConfidentialPhraseCategory confidentialPhraseCategory){
    JobseekerProfile jobseekerProfile = jobSeekerProfileManager.getJobSeekerProfile(user);
    JobseekerConfidentialityProfile jobseekerConfidentialityProfile = jobseekerConfidentialityProfileDao.fetchJobSeekerConfidentialityProfile(jobseekerProfile.getId());
    
    return jobseekerConfidentialityProfile.isConfidential(confidentialPhraseCategory);
    
  }

  private void generatePermanentConfidentialFiles(User user, JobseekerConfidentialityProfile profile)
  {
    // stub
  }
}
