package es.uca.iw.okto.ui.components;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;

public interface HasConfirmation {

  void setConfirmDialog(ConfirmDialog confirmDialog);

  ConfirmDialog getConfirmDialog();
}
