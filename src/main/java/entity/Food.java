package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="food")
public class Food extends Products {
	
	@Getter
	@Setter
	@Column(name="calories")
	private Integer calories;
	
	public Food() {
		
	}

	@Override
	public String toString() {
		return "\n" + "Food [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", calories=" + getCalories() + "]";
	}

}
