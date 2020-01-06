package es.uca.iw.okto.backend.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.uca.iw.okto.backend.utils.AbstractEntity;

/**
 * Tour
 */
@Entity
public class Tour extends AbstractEntity {
  private static final long serialVersionUID = -6774086899975203008L;

  @Temporal(TemporalType.DATE)
  private Date start;

  @Temporal(TemporalType.DATE)
  private Date end;

  private String description;

  @ManyToOne
  @JoinColumn(name="scale_id", nullable=false)
  private Scale scale;

  public Tour() {
  }

  @Override
  public String toString() {
    return "Tour [description=" + description + ", end=" + end + ", scale=" + scale.getId() + ", start=" + start + "]";
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Scale getScale() {
    return scale;
  }

  public void setScale(Scale scale) {
    this.scale = scale;
  }
}