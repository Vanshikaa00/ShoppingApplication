package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<cart,Long> {
Optional<cart> findByUsersAndProducts(users u, Products products);
List<cart> findByUsersAndProducts_Active(users u, int a);
void deleteByCartId(Long id);
   List<cart> findAllByUsers(users user);
}
