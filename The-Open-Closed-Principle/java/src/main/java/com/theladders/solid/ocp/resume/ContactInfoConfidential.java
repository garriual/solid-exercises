package com.theladders.solid.ocp.resume;

import java.util.HashMap;

public class ContactInfoConfidential extends ConfidentialGroup
{
  public ContactInfoConfidential(){
    phases = new HashMap<ConfidentialPhraseCategory,Boolean>();
    
    phases.put(ConfidentialPhraseCategory.PhoneNumber, false);
    phases.put(ConfidentialPhraseCategory.EmailAddress, false);
    phases.put(ConfidentialPhraseCategory.MailingAddress, false);
    phases.put(ConfidentialPhraseCategory.ContactInfo, false);
   
  }
}
