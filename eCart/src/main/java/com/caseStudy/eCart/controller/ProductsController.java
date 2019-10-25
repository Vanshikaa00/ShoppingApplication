package com.caseStudy.eCart.controller;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.service.CartService;
import com.caseStudy.eCart.service.CurrentUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.caseStudy.eCart.exception.ResourceNotFoundException;
import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.repo.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/home")
public class ProductsController
{
    @Autowired
    ProductsRepository productRepositoryClass;
    @Autowired
    CartService cartService;
    @Autowired
    CurrentUserService currentUserService;

    //Get products
    @GetMapping(path = "/getProduct")
    public List<Products> productsDisplay(){
      return productRepositoryClass.findAll();
    }

    //Add products
    @PostMapping("/addProduct")
    public Products addProduct(@Valid @RequestBody Products products) {
        return productRepositoryClass.save(products);
    }

//    //Add products by id
//    @RequestMapping(value = "/addProductt/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public cart addProduct(@PathVariable Long product_id, Principal principal) {
//        return cartService.addproduct(currentUserService.getUserIdd(principal), product_id);
//    }

    //Get products by id
//    @GetMapping("/getProductById/{id}")
//    public Products getProductsById(@PathVariable(value = "id")long productId) {
//        return productRepositoryClass.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
//    }

    // Update Products
    @PutMapping("/updateProduct/{id}")
    public Products updateProduct(@PathVariable(value = "id") Long productId,
                           @Valid @RequestBody Products productsDetails) {
        Products products = productRepositoryClass.findByProductId(productId);
//               .orElseThrow(() -> new ResourceNotFoundException("Note", "id", productId));
       products.setProductId(productsDetails.getProductId());
        products.setProductImage(productsDetails.getProductImage());
       products.setProductName(productsDetails.getProductName());
        products.setProductQuantity(productsDetails.getProductQuantity());
        products.setPrice(productsDetails.getPrice());
        products.setProductCategory(productsDetails.getProductCategory());
        Products updatedProduct = productRepositoryClass.save(products);
        return updatedProduct;
    }

    //Delete Products
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
        Products products=productRepositoryClass.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

    productRepositoryClass.delete(products);

        return ResponseEntity.ok().build();
    }

    //Get products by price
    @GetMapping("/getProductByPrice/{price}")
    public List<Products> getProductsByPrice(@PathVariable(value = "price")double productPrice) {
        return productRepositoryClass.findAllByPrice(productPrice);
    }

    //Get products by category
    @GetMapping("/getProductByCategory/{category}")
    public List<Products> getProductsByCategory(@PathVariable(value = "category")String productCategory) {
        return  productRepositoryClass.findAllByProductCategory(productCategory);
    }

    //Get products by range
    @GetMapping("/getProductByRange/{price1}/between/{price2}")
    public List<Products> getProductsByRange(@PathVariable(value = "price1")Double lowerLimitPrice,@PathVariable(value = "price2")Double upperLimitPrice) {
        return productRepositoryClass.findAllByPriceBetween(lowerLimitPrice,upperLimitPrice);
    }


}
