package com.theladders.solid.workflow;

import com.theladders.solid.srp.job.Job;
import com.theladders.solid.srp.job.application.ApplicationFailureException;
import com.theladders.solid.srp.job.application.JobApplicationResult;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.job.application.UnprocessedApplication;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public abstract class ApplyJobWorkFlow
{
  protected final MyResumeManager      myResumeManager;
  protected final JobApplicationSystem system;
  protected final Job                  job;
  protected final Jobseeker            jobseeker;
  protected final ResumeManager        resumeManager;

  protected Resume                     resume;


  public ApplyJobWorkFlow(MyResumeManager myResumeManager,
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
  }


  protected abstract void setResume();


  public final void process()
  {
    setResume();
    processApplication();
  }



  protected final void processApplication()
  {
    UnprocessedApplication application = new UnprocessedApplication(jobseeker, job, resume);
    JobApplicationResult applicationResult = system.apply(application);

    if (applicationResult.failure())
    {
      throw new ApplicationFailureException(applicationResult.toString());
    }
  }

}
