package com.theladders.solid.processor;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;

public class ParamExtractor
{
  private final HttpRequest request;
  private final MyResumeManager      myResumeManager;
  private final JobApplicationSystem system;
  private final Job                  job;
  private final Jobseeker            jobseeker;
  private final ResumeManager        resumeManager;

  public ParamExtractor(HttpRequest request,
                        MyResumeManager myResumeManager,
                        JobApplicationSystem jobApplicationSystem,
                        Job job,
                        Jobseeker jobseeker,
                        ResumeManager resumeManager)
  {
    this.myResumeManager = myResumeManager;
    this.system = jobApplicationSystem;
    this.job = job;
    this.jobseeker = jobseeker;
    this.resumeManager = resumeManager;

    this.request = request;
  }

  
  
  public MyResumeManager getMyResumeManager()
  {
    return myResumeManager;
  }



  public JobApplicationSystem getSystem()
  {
    return system;
  }



  public Job getJob()
  {
    return job;
  }



  public Jobseeker getJobseeker()
  {
    return jobseeker;
  }



  public ResumeManager getResumeManager()
  {
    return resumeManager;
  }



  public String getParamValue(String param)
  {
    return request.getParameter(param);
  }
}
