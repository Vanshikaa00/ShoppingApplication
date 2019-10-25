package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository  extends JpaRepository<Products, Long> {
    @Override
    List<Products> findAll();
    List<Products> findAllByPrice(double productPrice);
   List<Products> findAllByProductCategory(String productCategory);
    List<Products> findAllByPriceBetween(double lowerLimitPrice,double upperLimitPrice);
    Products findByProductId(Long id);




}
