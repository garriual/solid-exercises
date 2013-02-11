package com.theladders.solid.ocp.resume;

import java.util.HashMap;

public class AllCategoriesConfidential extends ConfidentialGroup
{
  public AllCategoriesConfidential(){
    phases = new HashMap<ConfidentialPhraseCategory,Boolean>();
    
    phases.put(ConfidentialPhraseCategory.Name, false);
    phases.put(ConfidentialPhraseCategory.PhoneNumber, false);
    phases.put(ConfidentialPhraseCategory.EmailAddress, false);
    phases.put(ConfidentialPhraseCategory.MailingAddress, false);
    phases.put(ConfidentialPhraseCategory.ContactInfo, false);
    phases.put(ConfidentialPhraseCategory.CompanyName, false);
    phases.put(ConfidentialPhraseCategory.WorkExperience, false);
    
  }
}
