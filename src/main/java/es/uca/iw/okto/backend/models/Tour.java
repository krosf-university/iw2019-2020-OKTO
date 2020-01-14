package es.uca.iw.okto.backend.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Tour
 */
@Entity
public class Tour extends Service {
  private static final long serialVersionUID = -6774086899975203008L;

  private LocalDate start;

  private LocalDate end;

  @ManyToOne()
  @JoinColumn(name="scale_id")
  private Scale scale;

  public Tour() {
  }

  @Override
  public String toString() {
    return "Tour [description=" + getDescription() + ", end=" + end + ", scale=" + scale.getId() + ", start=" + start + "]";
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }

  public Scale getScale() {
    return scale;
  }

  public void setScale(Scale scale) {
    this.scale = scale;
  }
}