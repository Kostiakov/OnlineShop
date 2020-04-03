package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food extends Products {
	
	@Column(name="calories")
	private Integer calories;
	
	public Food() {
		
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		return "\n" + "Food [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", calories=" + getCalories() + "]";
	}

}
