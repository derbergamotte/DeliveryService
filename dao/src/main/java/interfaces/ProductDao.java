package interfaces;

import java.util.Collection;

import entities.Product;

public interface ProductDao extends GenericDao<Product> {

	Collection<Product> findByAttributes(Collection<Long> listAttributesId);
}
