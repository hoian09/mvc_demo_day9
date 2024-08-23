package mvc.main;

import mvc.configuration.JPAConfig;
import mvc.entity.OrderDetailEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrdersRepository;
import mvc.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainOrders {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrdersRepository ordersRepository = (OrdersRepository) context.getBean("ordersRepository");
    static ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
    static OrderDetailRepository orderDetailRepository = (OrderDetailRepository) context.getBean("orderDetailRepository");
    public static void main(String[] args) {
        createNewOrder();
        createNewProduct();
        createNewProductAndNewOrderWithNewOrderDetail();
        createNewOrderDetail();

    }
    public static OrdersEntity createNewOrder() {
        OrdersEntity order = new OrdersEntity();
        order.setOrderDate(LocalDate.parse("2024-08-15"));
        order.setCustomerName("Luu Quoc");
        order.setCustomerAddress("HA,QN");
        return order;
    }
    public static ProductEntity createNewProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Book Phython");
        productEntity.setUnitPrice(200.0);
        productEntity.setProductDescription("Book Phython is good");
        return productEntity;
    }

    public static void createNewProductAndNewOrderWithNewOrderDetail() {
    ProductEntity productEntity = createNewProduct();
    productRepository.save(productEntity);
    ProductEntity productEntity1 = createNewProductAnother();
    productRepository.save(productEntity1);

    OrdersEntity order = createNewOrder();
    ordersRepository.save(order);
    OrdersEntity order1 = createNewOrderAnother();
    ordersRepository.save(order1);

    OrderDetailEntity orderDetail1 = createNewOrderDetail();
    orderDetail1.setProduct(productEntity);
    orderDetail1.setOrder(order);
    orderDetailRepository.save(orderDetail1);

    }

    public static OrderDetailEntity createNewOrderDetail() {
        ProductEntity productEntity = createNewProduct();
        productEntity.setId(1);
        OrdersEntity orders = createNewOrder();
        orders.setId(2);

        OrderDetailEntity orderDetail = new OrderDetailEntity();
        orderDetail.setQuality(5);
        orderDetail.setProduct(productEntity);
        orderDetail.setOrder(orders);
        orderDetailRepository.save(orderDetail);
        return orderDetail;
    }
    public static OrdersEntity createNewOrderAnother() {
        OrdersEntity order = new OrdersEntity();
        order.setOrderDate(LocalDate.parse("2024-08-17"));
        order.setCustomerName("Nguyen Hoa");
        order.setCustomerAddress("DN,QN");
        return order;
    }
    public static ProductEntity createNewProductAnother() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Ruler");
        productEntity.setUnitPrice(300.0);
        productEntity.setProductDescription("Ruler is great");
        return productEntity;
    }

    }


