package com.theladders.solid.srp;

import com.theladders.solid.processor.JobApplyProcessor;
import com.theladders.solid.result.ResultWrapper;
import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.http.HttpResponse;
import com.theladders.solid.srp.job.JobSearchService;
import com.theladders.solid.srp.job.application.JobApplicationSystem;
import com.theladders.solid.srp.jobseeker.JobseekerProfileManager;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.ResumeManager;


public class ApplyController
{
  JobApplyProcessor applicationProcessor;

  public ApplyController(JobseekerProfileManager jobseekerProfileManager,
                         JobSearchService jobSearchService,
                         JobApplicationSystem jobApplicationSystem,
                         ResumeManager resumeManager,
                         MyResumeManager myResumeManager)
  {

    applicationProcessor = 
        new JobApplyProcessor(jobseekerProfileManager, jobSearchService, jobApplicationSystem, resumeManager, myResumeManager);
    
  }

  //handle all the job applied request 
  public HttpResponse handle(HttpRequest request,
                             HttpResponse response,
                             String origFileName)
  {
    ResultWrapper ressultWrapper = applicationProcessor.processRequest(request, origFileName);
    Result result = ressultWrapper.createResult();
    
    response.setResult(result);
    return response;
  }
}
