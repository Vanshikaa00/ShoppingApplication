package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.models.users;
//import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    users findByUserId(Long id);
    //List<users> findByUserandProducts_Active(users user,int i);
    Optional <users> findByUsername(String username);
    @Override
    List<users> findAll();
}
