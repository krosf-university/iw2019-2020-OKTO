package es.uca.iw.okto.ui.components.crud;

import java.util.List;

import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.QuerySortOrderBuilder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;

import es.uca.iw.okto.backend.services.FilterableCrudService;
import es.uca.iw.okto.backend.utils.AbstractEntity;

public class CrudEntityDataProvider<T extends AbstractEntity> extends FilterablePageableDataProvider<T, String> {

  private static final long serialVersionUID = -7926702863523723384L;

  private final FilterableCrudService<T> crudService;
  private List<QuerySortOrder> defaultSortOrders;

  public CrudEntityDataProvider(FilterableCrudService<T> crudService) {
    this.crudService = crudService;
    setSortOrders();
  }

  private void setSortOrders() {
    QuerySortOrderBuilder builder = new QuerySortOrderBuilder();
    builder.thenAsc("id");
    defaultSortOrders = builder.build();
  }

  @Override
  protected Page<T> fetchFromBackEnd(Query<T, String> query, Pageable pageable) {
    return crudService.findAnyMatching(query.getFilter(), pageable);
  }

  @Override
  protected List<QuerySortOrder> getDefaultSortOrders() {
    return defaultSortOrders;
  }

  @Override
  protected int sizeInBackEnd(Query<T, String> query) {
    return (int) crudService.countAnyMatching(query.getFilter());
  }
}