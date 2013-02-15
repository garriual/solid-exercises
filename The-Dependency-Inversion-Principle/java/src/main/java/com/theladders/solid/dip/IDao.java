package com.theladders.solid.dip;

import java.util.List;

public interface IDao
{
  public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article);
  public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle);
  public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria);
  public void read();
  public void write();

}
