package com.theladders.solid.factory;

import com.theladders.solid.processor.ParamExtractor;
import com.theladders.solid.workflow.ApplyJobWithFileWorkFlow;
import com.theladders.solid.workflow.ApplyJobWithResumeWorkFlow;
import com.theladders.solid.workflow.ApplyJobWorkFlow;

public class ApplyJobFactory
{
  private ApplyJobFactory()
  {
  }


  public static ApplyJobWorkFlow getWorkFlow(ParamExtractor extractor)
  {
    // ApplyJobWorkFlow workflow;
    String fileName = extractor.getParamValue("fileName");
    if (fileName == null)
      return new ApplyJobWithResumeWorkFlow(extractor.getMyResumeManager(),
                                            extractor.getSystem(),
                                            extractor.getJob(),
                                            extractor.getJobseeker(),
                                            extractor.getResumeManager());
    return new ApplyJobWithFileWorkFlow(extractor.getMyResumeManager(),
                                        extractor.getSystem(),
                                        extractor.getJob(),
                                        extractor.getJobseeker(),
                                        extractor.getResumeManager(),
                                        fileName);
  }
}
