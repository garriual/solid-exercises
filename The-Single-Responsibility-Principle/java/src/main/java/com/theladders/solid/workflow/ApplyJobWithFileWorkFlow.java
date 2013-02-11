package com.theladders.solid.workflow;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;

public class ApplyJobWithFileWorkFlow extends ApplyJobWorkFlow
{
  private String fileName ;
  public ApplyJobWithFileWorkFlow(MyResumeManager manager,
                                  JobApplicationSystem jobApplicationSystem,
                                  Job job,
                                  Jobseeker jobseeker,
                                  ResumeManager resumeManager,
                                  String newResumeFileName)
  {
    super(manager, jobApplicationSystem, job, jobseeker, resumeManager);
    fileName = newResumeFileName;
  }

  @Override
  public void setResume()
  {
    resume = resumeManager.saveResume(jobseeker, fileName);
  }
}
