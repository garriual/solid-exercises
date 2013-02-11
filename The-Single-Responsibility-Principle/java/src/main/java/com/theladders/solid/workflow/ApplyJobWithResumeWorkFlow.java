package com.theladders.solid.workflow;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;

public class ApplyJobWithResumeWorkFlow extends ApplyJobWorkFlow
{

  public ApplyJobWithResumeWorkFlow(MyResumeManager myResumeManager,
                                    JobApplicationSystem jobApplicationSystem,
                                    Job job,
                                    Jobseeker jobseeker,
                                    ResumeManager resumeManager)
  {
    super(myResumeManager, jobApplicationSystem, job, jobseeker, resumeManager);
    
  }

  @Override
  public void setResume()
  {
    resume = myResumeManager.getActiveResume(jobseeker.getId());
  }

}
