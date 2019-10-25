package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.OrderHistory;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.repo.CartRepository;
import com.caseStudy.eCart.service.CartService;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class cartController {
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private CartService cartService;
public cartController(CartService cartService,CurrentUserService currentUserService) {
    this.cartService=cartService;
    this.currentUserService=currentUserService;
}


    @RequestMapping(value = "/removeproduct/receive/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public String removeproduct(@PathVariable Long productid, Principal principal) {
         cartService.removeproduct(productid,currentUserService.getUserIdd(principal));
         return "\"removed product from cart!\"";
    }


    @RequestMapping(value = "/decreaseProductQuantity/receive/{productid}", method = RequestMethod.GET)
    @ResponseBody
    public String decreaseQuantity(@PathVariable Long productid, Principal principal) {
       return cartService.decreaseQuantity(currentUserService.getUserIdd(principal),productid);
    }


    @RequestMapping(value = "/addproduct/receive/{productid}",method = RequestMethod.GET)
    @ResponseBody
    public cart addproduct(@PathVariable Long productid,Principal principal) {
        return cartService.addproduct(productid,currentUserService.getUserIdd(principal));
    }


    @RequestMapping(value = "/showcart/receive",method = RequestMethod.GET)
    @ResponseBody
    public List<cart> showthecart(Principal principal) {
    return cartService.showcart(currentUserService.getUserIdd(principal));
    }


    @RequestMapping(value = "/clearcart/receive",method = RequestMethod.GET)
    @ResponseBody
    public String  clearcart( Principal principal) {
        return cartService.clearCart(currentUserService.getUserIdd(principal),principal);
    }

    @RequestMapping(value = "/showOrderHistory",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderHistory>  showorderhistory(Principal principal) {
        return cartService.showOrderHistory(currentUserService.getUserIdd(principal),principal);
    }

    @RequestMapping(value = "/price",method = RequestMethod.GET)
    @ResponseBody
    public double price(Principal principal) {
        return cartService.calPrice(currentUserService.getUserIdd(principal),principal);
    }


/*

    @RequestMapping(value = "/decreaseQuantity/receive/{productid}",method = RequestMethod.GET)
    @ResponseBody
    public String removefromcart(@PathVariable Long productid,Principal principal) {
        return cartService.decreaseQuantity(productid,CurrentUserService.getUserIdd(principal));
    }
*/



/*
    @RequestMapping(value = "/checkout/receive",method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal) {
        return cartService.checkout(currentUserService.getuserid(principal));
    }



    @RequestMapping(value = "/clearcart/receive",method = RequestMethod.GET)
    @ResponseBody
    public String  clearcart(Principal principal) {
        return cartService.clearcart(currentUserService.getuserid(principal));
    }
*/

}
