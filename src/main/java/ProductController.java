
import com.sun.istack.internal.NotNull;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductRepository productRepository;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.jsp?faces-redirect=true";
    }

@NotNull
    public List<Product> getAllProduct() throws SQLException {
        return productRepository.findAll();
    }
@NotNull
    public String editProduct(Product product) {
        this.product = product;
        return "/product.jsp?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        productRepository.delete(product.getId());
        //return "/index.xhtml?faces-redirect=true";
    }
    @NotNull
    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
