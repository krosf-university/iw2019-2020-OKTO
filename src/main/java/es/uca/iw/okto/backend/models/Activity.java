package es.uca.iw.okto.backend.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Activity extends Service {
  private static final long serialVersionUID = 1793141522584474874L;

  @Temporal(TemporalType.DATE)
  private Date start;

  @Temporal(TemporalType.DATE)
  private Date end;

  public Activity() {
    // Empty due to JPA use of getters and setters
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
