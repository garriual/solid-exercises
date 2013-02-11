package com.theladders.solid.ocp.resume;

import java.util.HashMap;
import java.util.Iterator;

import com.theladders.solid.ocp.jobseeker.JobseekerConfidentialityProfile;

public abstract class ConfidentialGroup
{
  protected HashMap<ConfidentialPhraseCategory,Boolean> phases;

  public final boolean makeAllNonConfidential(JobseekerConfidentialityProfile jobseekerConfidentialityProfile){
    boolean isChanged = false;
    
    Iterator<ConfidentialPhraseCategory> it = phases.keySet().iterator();
    
    while(it.hasNext()){
      ConfidentialPhraseCategory current = it.next();
      isChanged |=  jobseekerConfidentialityProfile.resetConfidentialFlagsForCategory(current);
    }
    
    return isChanged;
  }
  
  
}
