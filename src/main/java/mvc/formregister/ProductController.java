package mvc.formregister;

import mvc.entity.ProductEntity;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@Controller
@RequestMapping(value = "/")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = GET)
    public String productList(Model model) {
        List<ProductEntity> products = (List<ProductEntity>) productRepository.findAll();
        model.addAttribute("products", products);
        return "formregister/productList";
    }

}
