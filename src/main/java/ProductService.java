import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class ProductService {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;



    @Transactional
    public Product create() {
        Product product = new Product();
        product.setName("Бытовая химия");
        em.persist(product);
        return product;
    }
    @Transactional
    public Product findProduct(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }
    @Transactional
    public List<Product> findAllProducts() {
        Query query = em.createQuery("SELECT c FROM Product c", Product.class);
        List<Product> list = query.getResultList();
        return list;
    }
    @Transactional
    public void updateProductName(Long id, String newName) {
        Product product = em.find(Product.class, id);
        product.setName(newName);
        em.merge(product);
    }
    @Transactional
    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
    @Transactional
    public List<Product> findByName(String name) {
        List<Product> list = em.createQuery("SELECT c FROM Category c WHERE c.name LIKE ?1 ").setParameter(1, name).getResultList();
        return list;
    }
    @Transactional
    public List<Product> getProducts(){
        Query query = em.createNamedQuery("Product.findAll", Product.class);
        List<Product> result = query.getResultList();
        return result;
    }
    @Transactional
    public void view(String name){
        Query query = em.createNamedQuery("Product.findByName",Product.class).setParameter("name", name);
        List<Product> result = query.getResultList();
    }
    @Transactional
    public void view(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> c = query.from(Product.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        Predicate condition = cb.gt(c.get(Product.count), p);
        query.select(c).where(condition);
        TypedQuery<Product> q = em.createQuery(query);
        q.setParameter(p, 1);
        List<Product> products = q.getResultList();
    }
}
