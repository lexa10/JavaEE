import javax.ejb.Remote;
import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface ProductServiceRemote {

    List<ProductServiceRemote> findAll();

    Future<List<ProductServiceRemote>> findAllsync();
}
