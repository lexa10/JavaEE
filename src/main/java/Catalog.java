import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Stateless
    public class Catalog implements CatalogService {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    @TransactionAttribute
    public void insert(Product product) {
        em.persist(product);
    }

    @Override
    @TransactionAttribute
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("from Product", Product.class).getResultList();
    }
}
