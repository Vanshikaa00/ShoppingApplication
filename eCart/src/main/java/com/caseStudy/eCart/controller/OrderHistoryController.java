package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.OrderHistory;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.repo.OrderHistoryRepository;
import com.caseStudy.eCart.service.CartService;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cartoh")
public class OrderHistoryController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @RequestMapping(value = "/checkout/receive",method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal) {
        return cartService.checkout(currentUserService.getUserIdd(principal),principal);
    }

    @RequestMapping(value = "/addproduct/receive/{productid}",method = RequestMethod.GET)
    @ResponseBody
    public cart addproduct(@PathVariable Long productid, Principal principal) {
        return cartService.addproduct(productid,currentUserService.getUserIdd(principal));
    }

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public List<OrderHistory> ordersDisplay(){
        return orderHistoryRepository.findAll();
    }

}
