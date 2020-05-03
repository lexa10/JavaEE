import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
public interface CatalogService {

    void insert(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(long id);

    List<Product> findAll();
}
