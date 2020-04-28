import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Named

public class OrderService {

        @PersistenceContext(unitName = "ds")
        private EntityManager em;

        @Transactional
        public Order create() {
            Order order = new Order();
            order.setName("Товар");
            em.persist(order);
            return order;
        }
        @Transactional
        public Order findOrder(int id) {
            Order order = em.find(Order.class, id);
            return order;
        }
        @Transactional
        public List<Order> findAllOrders() {
            Query query = em.createQuery("SELECT c FROM Order c", Order.class);
            List<Order> list = query.getResultList();
            return list;
        }
        @Transactional
        public void updateOrderName(Long id, String newName) {
           Order order = em.find(Order.class, id);
            order.setName(newName);
            em.merge(order);
        }
        @Transactional
        public void removeOrder(Long id) {
            Order order = em.find(Order.class, id);
            em.remove(order);
        }
    @Transactional
    public List<Order> findByName(String name) {
        List<Order> list = em.createQuery("SELECT c FROM Category c WHERE c.name LIKE ?1 ").setParameter(1, name).getResultList();
        return list;
    }
    }

