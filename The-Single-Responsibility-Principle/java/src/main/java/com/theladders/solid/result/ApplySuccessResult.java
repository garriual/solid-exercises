package com.theladders.solid.result;

import java.util.Map;

import com.theladders.solid.srp.Result;

public class ApplySuccessResult extends ResultWrapper
{
  public ApplySuccessResult(Map<String,Object> model){
    this.model = model;
  }
  @Override
  public Result createResult()
  {
    return new Result("success", model);
  }

}
