package com.plantasun_ssm.web;

import com.plantasun_ssm.domain.Product;
import com.plantasun_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productLists",productList);
        mv.setViewName("product-list");
        return mv;
    }
}
