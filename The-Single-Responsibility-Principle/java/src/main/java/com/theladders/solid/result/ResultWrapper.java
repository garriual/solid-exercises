package com.theladders.solid.result;

import java.util.HashMap;
import java.util.Map;

import com.theladders.solid.srp.Result;

public abstract class ResultWrapper
{
  protected Map<String, Object> model = new HashMap<>(); 
  public abstract Result createResult();
}
