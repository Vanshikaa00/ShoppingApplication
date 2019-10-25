package com.caseStudy.eCart.repo;

import com.caseStudy.eCart.models.signUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository  extends JpaRepository<signUp, Long> {
}
