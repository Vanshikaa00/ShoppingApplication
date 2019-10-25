package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.OrderHistory;
import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

//*****************************add product to cart********************************************************

    public cart addproduct(Long productid, Long user_id) {
        users users = userRepository.findByUserId(user_id);
        Products products = productsRepository.findByProductId(productid);
        if (cartRepository.findByUsersAndProducts(users, products).isPresent()) {
            cart cartt = cartRepository.findByUsersAndProducts(users, products).get();
            cartt.setQuantity(cartt.getQuantity() + 1);
            cartt.setAmount(cartt.getQuantity()*products.getPrice());
            cartRepository.save(cartt);
        } else {
            cart c = new cart(users,products,1);
            cartRepository.save(c);
        }
        return cartRepository.findByUsersAndProducts(users,products).get();
    }



/*****************************remove product from cart********************************************************/
//public Optional<cart> removeproduct( Long user_id,Long productid) {
//    users users = userRepository.findByUserId(user_id);
//    Products products = productsRepository.findByProductId(productid);
//    if (cartRepository.findByUsersAndProducts(users, products).get().getQuantity() <= 1) {
//        cart cart = cartRepository.findByUsersAndProducts(users, products).get();
//        cartRepository.delete(cart);
//    }
//    else {
//        cart cart= cartRepository.findByUsersAndProducts(users, products).get();
//        cart.setQuantity(cart.getQuantity()-1);
//        cartRepository.save(cart);
//    }
//    return cartRepository.findByUsersAndProducts(users,products);
//}
    public String removeproduct(Long productid,Long user_id) {
        users users = userRepository.findByUserId(user_id);
        Products products = productsRepository.findByProductId(productid);
        cart cart = cartRepository.findByUsersAndProducts(users, products).get();
        cartRepository.delete(cart);
//        cartRepository.findByUsersAndProducts(users,products).get();
        return "\"product removed from cart!\"";
    }


    /**********************************show cart**************************************************/
    public List<cart> showcart(Long user_id) {
        users user = userRepository.findByUserId(user_id);
        return cartRepository.findByUsersAndProducts_Active(user,1);
    }

    /********************************clear cart*******************************************/
    public String clearCart(Long user_id,Principal principal) {
users user=userRepository.findByUserId(user_id);
List<cart> cartItems=cartRepository.findAllByUsers(user);
        for (cart cart : cartItems) {
            cartRepository.deleteById(cart.getCartId());
        }
        return "cart cleared!";
    }

/******************************decrease quantity*********************************************************/
public String decreaseQuantity(Long userid,Long productid) {
    users users = userRepository.findByUserId(userid);
    Products products = productsRepository.findByProductId(productid);
    if (cartRepository.findByUsersAndProducts(users, products).get().getQuantity() <= 1) {
        cart cart = cartRepository.findByUsersAndProducts(users, products).get();
        cartRepository.delete(cart);
    }
    else {
        cart cart= cartRepository.findByUsersAndProducts(users, products).get();
        cart.setQuantity(cart.getQuantity()-1);
        cartRepository.save(cart);
    }
    return "\"Quantity decreased\"";
}
/***********************************checkout total***********************************/
public double checkout(Long userid,Principal principal) {
    double total=0;
   users users = userRepository.findByUserId(userid);
    List <cart> cartList = cartRepository.findAllByUsers(users);
    for(cart cart: cartList) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setProducts(cart.getProducts());
        orderHistory.setUsers(cart.getUsers());
        double p=cart.getProducts().getPrice();
    orderHistory.setQuantity(cart.getQuantity());
        total = total + cart.getQuantity() * p;
    orderHistory.setPrice((int)(cart.getQuantity()*p));
    orderHistory.setDate();
  orderHistoryRepository.save(orderHistory);
    }
//    clearCart(userid,principal);
    return total;
}
/******************************show order history********************************/
public List <OrderHistory> showOrderHistory(Long userid,Principal principal) {
    users users = userRepository.findByUserId(userid);
    return orderHistoryRepository.findAllByUsers(users);
}
/****************************updated show order history****************************/
public double calPrice(Long userid,Principal principal) {
    users user = userRepository.findByUserId(userid);
    List <cart> cartItems = cartRepository.findAllByUsers(user);
    double q=0;
    for(cart c:cartItems) {
        q=q+c.getAmount();
    }
    return q;
}


}








/*


  **************************************  add Product******************************************************




    public cart addProduct(Long userid, Long productid) {
        Products product = ProductsRepository.findByProductId(productid);
        users user = UserRepository.findByUserId((userid));

        if (cartRepository.findByUserandProducts(user, product).isPresent()) {
            cart cartt = cartRepository.findByUserandProducts(user, product).get();

            cartt.setQuantity(cartt.getQuantity() + 1);
            cartRepository.save(cartt);
        } else {
            cart c = new cart(product, user, 1);
            cartRepository.save(c);
        }
        return cartRepository.findByUserandProducts(user, product).get();
    }




  **************************************  show cart******************************************************




    public List<cart> showCart(Long user_id) {
        users user = UserRepository.findByUserId(user_id);
        return CartRepository.findByUserandProducts_Active(user, 1);
    }




  **************************************  clear cart*****************************************************




    public String clearCart(Long userId) {
        users user = UserRepository.findByUserandProducts_Active(user, 1);
        for (cart cart : cartItems) {
            CartRepository.deleteById(cart.getCart_id());
        }
        // return "cart cleared!";




  **************************************  remove Product******************************************************




        public cart removeproduct (Long userid, Long productid){
            Products prod1 = productsRepository.findByProductId(productid);
            users user1 = userRepository.findByUserId(userid);

            if (cartRepository.findByUserandProducts(user1, prod1).get().getQuantity() == 1) {
                cart car1 = cartRepository.findByUserandProducts(user1, prod1).get();

                car1.setQuantity(0);
                cartRepository.save(car1);

            } else if (cartRepository.findByUserandProducts(user1, prod1).get().getQuantity() > 1) {
                cart car1 = cartRepository.findByUserandProducts(user1, prod1).get();
                car1.setQuantity(car1.getQuantity() - 1);
                cartRepository.save(car1);

            }
            return cartRepository.findByUserandProducts(user1, prod1).get();
        }





  **************************************  add to cart******************************************************




        public String addtoCart(Long userid,Long productid) {
            Products product=productsRepository.findByProductId(productid);
            users user=userRepository.findByUserId(userid);
            if(cartRepository.findByUserandProducts(user,product).isPresent()) {
                return "This item is already present in your cart!";
            }
            else
            {
                cart car1=new cart();
                car1.setProducts(product);
                car1.setUsers(user);
                car1.setQuantity(1);
                cartRepository.save(car1);





some stuff yet to be added



                return "Item is added to your cart";
            }
        }


    }
*/


