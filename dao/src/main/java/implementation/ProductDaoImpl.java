package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import entities.Product;
import interfaces.ProductDao;

public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

    private static ProductDaoImpl productDao;

    private ProductDaoImpl() {
        super(Product.class);
    }

    public static ProductDao getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public Collection<Product> findByAttributes(Collection<Long> listAttributesId) {
        Collection<Product> listProducts = new ArrayList<>();
        for (Product product : getAll()) {
            if (product.getAttributes().stream().map(a -> a.getId()).collect(Collectors.toList()).containsAll(listAttributesId)) {
                listProducts.add(product);
            }
        }
        return listProducts;
    }
}
