package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "quality")
    private int quality;
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrdersEntity orders;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public OrdersEntity getOrder() {
        return orders;
    }

    public void setOrder(OrdersEntity order) {
        this.orders = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", quality=" + quality +
                ", order=" + orders +
                ", product=" + product +
                '}';
    }
}
