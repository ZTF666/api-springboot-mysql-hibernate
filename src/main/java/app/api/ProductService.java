package app.api;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> ListAll(){
		return repository.findAll();
	}
	
	public void save(Product product) {
		repository.save(product);
	}
	
	public Product get(Integer id) {
		return repository.findById(id).get();
	}
	
	public ResponseEntity<?> delete(Integer id) {

		boolean exists = repository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("this id does not exist");
		}
		repository.deleteById(id);
		
		return null;
	}

	
	@Transactional
	public void update(Integer id,String name,Float price) {
		Product product=repository.findById(id).orElseThrow(()-> new IllegalStateException("does not exist"));
		if(name !=null && name.length()>0 && price !=null) {
			product.setName(name);
			product.setPrice(price);
		}
	
	}
	
	
	
	
}
