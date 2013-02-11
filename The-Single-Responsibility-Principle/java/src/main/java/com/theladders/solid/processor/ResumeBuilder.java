package com.theladders.solid.processor;

import com.theladders.solid.srp.http.HttpRequest;
import com.theladders.solid.srp.jobseeker.Jobseeker;
import com.theladders.solid.srp.resume.MyResumeManager;
import com.theladders.solid.srp.resume.Resume;
import com.theladders.solid.srp.resume.ResumeManager;

public class ResumeBuilder
{
  // "or".....upload vs apply rollback
  public static Resume saveNewOrRetrieveExistingResume(String newResumeFileName,
                                                 Jobseeker jobseeker,
                                                 HttpRequest request,
                                                 ResumeManager resumeManager,
                                                 MyResumeManager myResumeManager)
  {
    Resume resume;

    if (!"existing".equals(request.getParameter("whichResume")))
    {
      resume = resumeManager.saveResume(jobseeker, newResumeFileName);

      if (resume != null && "yes".equals(request.getParameter("makeResumeActive")))
      {
        myResumeManager.saveAsActive(jobseeker, resume);
      }
    }
    else
    {
      resume = myResumeManager.getActiveResume(jobseeker.getId());
    }

    return resume;
  }
}
