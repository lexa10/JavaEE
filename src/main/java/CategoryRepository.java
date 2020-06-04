import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@Named
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT category FROM Category category"),
        @NamedQuery(name = "Category.findByName", query = "SELECT category FROM Category category WHERE category.name LIKE '%:name%'")
})

public class CategoryRepository {


    @PersistenceContext(unitName = "ds")
    private EntityManager em;



    @Transactional
    public Category create() {
        Category category = new Category();
        category.setName("Молочные продукты");
        em.persist(category);
        return category;
    }
    @Transactional
    public Category findCategory(int id) {
        Category cat = em.find(Category.class, id);
        return cat;
    }
    @Transactional
    public List<Category> findAllCategories() {
        Query query = em.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> list = query.getResultList();
        return list;
    }
    @Transactional
    public void updateCategoryName(Long id, String newName) {
        Category category = em.find(Category.class, id);
        category.setName(newName);
        em.merge(category);
    }
    @Transactional
    public void deleteCategory(Long id) {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }

    @Transactional
    public List<Category> findByName(String name) {
        List<Category> list = em.createQuery("SELECT c FROM Category c WHERE c.name LIKE :name").setParameter("name", name).getResultList();
        return list;
    }

}
