package com.theladders.solid.result;

import java.util.ArrayList;
import java.util.List;

import com.theladders.solid.srp.Result;

public class ErrorResult extends ResultWrapper
{
  public ErrorResult()
  {
    
  }

  @Override
  public Result createResult()
  {
    List<String> errList = new ArrayList<>();
    errList.add("We could not process your application.");
    return new Result("error",model,errList);
  }
}
