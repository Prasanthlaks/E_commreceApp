package org.jsp.E_commerce.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.E_commerce.model.Merchant;
import org.jsp.E_commerce.repositor.MerchantRespositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
    private MerchantRespositor merchantRespositor;
	public Merchant save_merchant(Merchant merchant) {
		return merchantRespositor.save(merchant);
	}
	public Optional<Merchant> findByID(int id){
		return merchantRespositor.findById(id);
	}
	public boolean deleteById(int id) {
		Optional<Merchant> recMerchant=merchantRespositor.findById(id);
		if(recMerchant.isPresent()) {
			merchantRespositor.delete(recMerchant.get());
			return true;
		}
		return false;
	}
	public List<Merchant> findall(){
		return merchantRespositor.findAll();
	}
	
    
}
