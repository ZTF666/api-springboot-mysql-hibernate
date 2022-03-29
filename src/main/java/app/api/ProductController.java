package app.api;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> list(){
		return service.ListAll();
	}
	
	@GetMapping(path="{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addProduct(@RequestBody Product product) {
		service.save(product);
	}
	
	@PutMapping(path ="{id}")
	public  ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable Integer id) {
		try {
			Product exist = service.get(id);
			service.update(id,product.getName(),product.getPrice());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="{id}")
	public void deleteProduct(@PathVariable Integer id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
