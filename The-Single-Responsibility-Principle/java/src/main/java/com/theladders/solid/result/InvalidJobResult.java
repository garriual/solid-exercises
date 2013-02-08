package com.theladders.solid.result;


import com.theladders.solid.srp.Result;

public class InvalidJobResult extends ResultWrapper
{
  
  public InvalidJobResult(int jobId)
  {
    model.put("jobId", jobId);
  }

  @Override
  public Result createResult()
  {
    return new Result("invalidJob",model);
  }
}
