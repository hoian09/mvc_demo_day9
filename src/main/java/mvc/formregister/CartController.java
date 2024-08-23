package mvc.formregister;



import mvc.entity.ProductEntity;
import mvc.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/cartcontroller")
public class CartController {
    @Autowired
    OrdersRepository orderRepository;

    @RequestMapping(value = "/addToCart/{id}", method = GET)
    public String addToCart(@PathVariable int id, HttpSession session) {
        List<CartSession> cartList = (List<CartSession>) session.getAttribute("cartList");
        session.setAttribute("cart" , CartSession.class);
        return "formregister/cart";
    }
    @RequestMapping(value = "/session-test")
    public String showSessionTest(Model model, HttpServletRequest request){
    String cart = (String) request.getSession().getAttribute("cart");
    model.addAttribute("cart", cart);
    return "formregister/checkout";
    }
    @RequestMapping(value = "/removeItem/{id}")
    public String removeSession(Model model, HttpServletRequest request){
        request.getSession().removeAttribute("cart");
        return "redirect:/";
    }
}

