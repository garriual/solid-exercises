package com.theladders.solid.dip;

import java.util.Date;

public interface Article
{
  public Integer getSuggestedArticleId();
  public void setSuggestedArticleId(Integer suggestedArticleId);
  public Integer getSubscriberId();
  public void setSubscriberId(Integer subscriberId);
  public Integer getSuggestedArticleSourceId();
  public void setSuggestedArticleSourceId(Integer suggestedArticleSourceId);
  public String getArticleExternalIdentifier();
  public void setArticleExternalIdentifier(String articleExternalIdentifier);
  public Integer getSuggestedArticleStatusId();
  public void setSuggestedArticleStatusId(Integer suggestedArticleStatusId);
  public Date getCreateTime();
  public void setCreateTime(Date createTime);
  public Integer getCreatorId();
  public void setCreatorId(Integer creatorId);
  public Date getUpdateTime();
  public void setUpdateTime(Date updateTime);
  public Integer getUpdaterId();
  public void setUpdaterId(Integer updaterId);
  public String getNote();
  public void setNote(String note);
  public ContentNode getContent();
  public void setContent(ContentNode node);
  public boolean getIsRead();
  public void setIsRead(boolean read);
}
