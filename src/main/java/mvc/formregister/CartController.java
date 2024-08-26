package mvc.formregister;
import mvc.entity.OrderDetailEntity;
import mvc.entity.OrdersEntity;
import mvc.entity.ProductEntity;
import mvc.repository.OrderDetailRepository;
import mvc.repository.OrdersRepository;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class CartController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrdersRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @RequestMapping(value = "/addToCart/{id}")
    public String addToCart(@PathVariable int id, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new ArrayList<>();
            session.setAttribute("cartList", cartList);
        }
        ProductEntity product = productRepository.findById(id).get();
        if (product != null) {
            boolean itemexists = false;
            for (CartSession item : cartList) {
                if (item.getProduct().getId() == id) {
                    item.setProduct(product);
                    item.setQuantity(item.getQuantity() + 1);
                    itemexists = true;
                    break;
                }
            }
            if (!itemexists) {
                cartList.add(new CartSession(product, 1));
            }
        }
        return "formregister/cart";
    }
    @RequestMapping(value = "/removeItem/{id}")
    public static String removeProduct(@PathVariable int id, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        if (cartList != null) {
            cartList.removeIf(item -> item.getProduct().getId() == id);
        }
        session.setAttribute("cartList", cartList);
        return "formregister/cart";
    }

    @RequestMapping(value = "/checkOut")
    public static String checkOut(Model model, HttpSession session) {
        OrdersEntity order = new OrdersEntity();
        if (order != null) {
            model.addAttribute("orderList", new OrdersEntity());
        }
        return "formregister/checkout";
    }

    @RequestMapping(value = "/Orders")
    public String orderList(OrdersEntity orders, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        orderRepository.save(orders);
        for (CartSession item : cartList) {
            OrderDetailEntity orderDetailEntityList = new OrderDetailEntity();
            orderDetailEntityList.setProduct(item.getProduct());
            orderDetailEntityList.setQuality(item.getQuantity());
            orderDetailEntityList.setOrder(orders);
            orderDetailRepository.save(orderDetailEntityList);
        }
        session.removeAttribute("cartList");
        return "redirect:/orders";
    }

    @RequestMapping(value = "/orders")
    public String showOrders(Model model) {
        List<OrdersEntity> orderList = (List<OrdersEntity>) orderRepository.findAll();
        model.addAttribute("orderList", orderList);
        return "formregister/orders";
    }
    @RequestMapping(value = "/orderDetails/{id}", method = GET)
    public String showOrderDetails(Model model,@PathVariable int id) {
        OrdersEntity orderList = orderRepository.findById(id).get();
        List<OrderDetailEntity> orderDetails = orderList.getOrderDetails();
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("orderId", id);
        return "formregister/orderDetail";
    }
}

