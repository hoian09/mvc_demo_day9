package mvc.formregister;
import mvc.entity.ProductEntity;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CartSession {

    private ProductEntity product;

    private int quantity;

    public CartSession(ProductEntity product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
