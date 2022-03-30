package app.api;

import javax.persistence.*;

@Entity
public class Product {

	private Integer id;
	private String name;
	private float price;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;

	public Product() {
	}

	public Product(int id, String name, float price,String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	//new addition
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
