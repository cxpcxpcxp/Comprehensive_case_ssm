package com.plantasun_ssm.web;

import com.plantasun_ssm.domain.Product;
import com.plantasun_ssm.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/save.do")
    public String save(@Param("product") Product product){
//        productNum产品编号
//        productName产品名称
//        departureTime出发时间
//        cityName出发城市
//        productPrice产品价格
//        productStatus产品状态
//        productDesc其他信息
        productService.save(product);
        return "redirect:findAll.do";
    }
}
