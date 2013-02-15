package com.theladders.solid.dip;

import java.util.Collections;
import java.util.List;

public class SuggestedArticleDao implements IDao
{
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article) {}

  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle)
  {
    return 0;
  }

  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria)
  {
    return Collections.singletonList(new SuggestedArticle());
  }

  @Override
  public void read()
  {
   
  }

  @Override
  public void write()
  {
    
  }
}
