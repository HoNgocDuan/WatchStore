package watch.store.mnm.rest.fontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import watch.store.mnm.domain.Products;
import watch.store.mnm.dto.ProductDTO;
import watch.store.mnm.service.ProductService;

import java.util.List;

@Controller
public class ProductFontendResource {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewProduct(Model model){
        List<Products> listProducts = productService.listAll();
        model.addAttribute("listProducts",listProducts);
        return "index1";
    }
}
