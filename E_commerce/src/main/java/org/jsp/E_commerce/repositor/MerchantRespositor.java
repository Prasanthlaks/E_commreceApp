package org.jsp.E_commerce.repositor;

import org.jsp.E_commerce.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRespositor extends JpaRepository<Merchant, Integer> {
   
}
