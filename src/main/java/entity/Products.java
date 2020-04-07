package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Products {
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Getter
	@Setter
	@Column(name="name")
	private String name;
	@Getter
	@Setter
	@Column(name="amount")
	private Integer amount;
	@Getter
	@Setter
	@Column(name="price")
	private Integer price;
	
	public Products() {
		
	}

}
