package org.jsp.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.jsp.E_commerce.Dao.MerchantDao;
import org.jsp.E_commerce.dto.ResponseStructure;
import org.jsp.E_commerce.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class MerchantService {
	@Autowired
  private MerchantDao dao;
   public ResponseStructure<Merchant> save(Merchant merchant) {
	   ResponseStructure<Merchant> str=new ResponseStructure();
	   str.setMessage("merchant saved successfully");
	   str.setData(dao.save_merchant(merchant));
	   str.setStatusCode(HttpStatus.CREATED.value());
	   return str;
   }
   public ResponseStructure<Merchant> updateMerchant(Merchant merchant) {
	   ResponseStructure<Merchant> str=new ResponseStructure<>();
	   Optional<Merchant> recmerchant=dao.findByID(merchant.getId());
	   if(recmerchant.isPresent()) {
		   Merchant merchantdb=recmerchant.get();
		   merchantdb.setName(merchant.getName());
		   merchantdb.setEmail(merchant.getEmail());
		   merchantdb.setGst_number(merchant.getGst_number());
		   merchantdb.setPhone(merchant.getPhone());
		   merchantdb.setPassword(merchant.getPassword());
		   merchantdb.setStatus(merchant.getStatus());
		   str.setData(dao.save_merchant(merchant));
		   str.setMessage("updated merchant ............");
		   str.setStatusCode(HttpStatus.ACCEPTED.value());
		   return str;
	   }
	str.setMessage("Invalid merchant id.......");
	str.setStatusCode(HttpStatus.NOT_FOUND.value());
	return str;
	 }
   public ResponseStructure<Merchant> findbyid(int id) {
	   ResponseStructure<Merchant> str=new ResponseStructure<>();
	   Optional<Merchant> recmerchant=dao.findByID(id);
	   if(recmerchant.isPresent()) {
		   str.setData(recmerchant.get());
		   str.setMessage("merchant found by");
		   str.setStatusCode(HttpStatus.OK.value());
		   return str;
	   }
	   str.setMessage("invalid merchant id......");
	   str.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return str;
   }
   public ResponseStructure<Merchant> deleteByID(int id){
	   ResponseStructure<Merchant> str=new ResponseStructure<>();
	   Optional<Merchant> recmerchant=dao.findByID(id);
	   if(recmerchant.isPresent()) {
		   dao.deleteById(id);
		   str.setMessage("merchant deleted sucessfully");
		   str.setStatusCode(HttpStatus.OK.value());
		   return str;
	   }
	   str.setMessage("invalid merchant id to deleted");
	   str.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return str;
	   
   }
   public ResponseStructure<List<Merchant>> findall(){
	   ResponseStructure<List<Merchant>> str=new ResponseStructure<>();
	   List<Merchant> recmerchant=dao.findall();
	   if(recmerchant.size()>0) {
		   str.setData(recmerchant);
		   str.setMessage("list of all merchant");
		   str.setStatusCode(HttpStatus.OK.value());
		   return str;
	   }
	   str.setMessage("invalid no data of your list");
	   str.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return str;
	   
   }
}
