package com.theladders.solid.processor;

import java.util.HashMap;
import java.util.Map;
import com.theladders.solid.result.ApplySuccessResult;
import com.theladders.solid.result.ErrorResult;
import com.theladders.solid.result.InvalidJobResult;
import com.theladders.solid.result.ResultWrapper;
import com.theladders.solid.result.ResumeCompletionResult;
import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.jobseeker.JobseekerProfile;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.jobseeker.ProfileStatus;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class JobApplyProcessor
{
  private final JobseekerProfileManager jobseekerProfileManager;
  private final JobSearchService        jobSearchService;
  private final JobApplicationSystem    jobApplicationSystem;
  private final ResumeManager           resumeManager;
  private final MyResumeManager         myResumeManager;


  public JobApplyProcessor(JobseekerProfileManager jobseekerProfileManager,
                           JobSearchService jobSearchService,
                           JobApplicationSystem jobApplicationSystem,
                           ResumeManager resumeManager,
                           MyResumeManager myResumeManager)
  {
    this.jobseekerProfileManager = jobseekerProfileManager;
    this.jobSearchService = jobSearchService;
    this.jobApplicationSystem = jobApplicationSystem;
    this.resumeManager = resumeManager;
    this.myResumeManager = myResumeManager;
  }
  

  public ResultWrapper processRequest(HttpRequest request,
                            String origFileName)
  {
    
    Jobseeker jobseeker = request.getSession().getJobseeker(); 
    JobseekerProfile profile = jobseekerProfileManager.getJobSeekerProfile(jobseeker); 

    String jobIdString = request.getParameter("jobId"); // grab the job object by job id
    int jobId = Integer.parseInt(jobIdString);

    Job job = jobSearchService.getJob(jobId);

    if (job == null) // job doesn't exist
    {
      return new InvalidJobResult(jobId);
    }

    Map<String, Object> model = new HashMap<>();

    try
    {
      apply(request, jobseeker, job, origFileName); // apply the application
    }
    catch (Exception e)
    {
      return new ErrorResult();
    }

    model.put("jobId", job.getJobId());
    model.put("jobTitle", job.getTitle());

    if (!jobseeker.isPremium() &&   (profile.getStatus().equals(ProfileStatus.INCOMPLETE) || 
                                     profile.getStatus().equals(ProfileStatus.NO_PROFILE) || 
                                     profile.getStatus().equals(ProfileStatus.REMOVED)))
    {
      return new ResumeCompletionResult(model);
    }
    return new ApplySuccessResult(model);
  }


  private void apply(HttpRequest request,
                     Jobseeker jobseeker,
                     Job job,
                     String fileName)
  {
    Resume resume = ResumeBuilder.saveNewOrRetrieveExistingResume(fileName,
                                                                  jobseeker,
                                                                  request,
                                                                  resumeManager,
                                                                  myResumeManager);
    UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume); 
    JobApplicationResult applicationResult = jobApplicationSystem.apply(application);

    if (applicationResult.failure())
    {
      throw new ApplicationFailureException(applicationResult.toString());
    }
  }

}
