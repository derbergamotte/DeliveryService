package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import entities.Attribute;
import entities.BaseEntity;
import entities.Category;
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

    public Collection<Product> findByAttributesId(Collection<Long> listAttributesId) {
        Collection<Product> listProducts = new ArrayList<>();
        for (Product product : getAll()) {
            if (product.getAttributes().stream().map(BaseEntity::getId).collect(Collectors.toList()).containsAll(listAttributesId)) {
                listProducts.add(product);
            }
        }
        return listProducts;
    }

    public Collection<Product> findByAttributes(Collection<Attribute> attributes){
        return getAll().stream().filter(p->p.getAttributes().containsAll(attributes)).collect(Collectors.toSet());
    }

    public Collection<Product> findByCategory(Category category){
        return getAll().stream().filter(p->p.getCategories().contains(category)).collect(Collectors.toSet());
    }
}
