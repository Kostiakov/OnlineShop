package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="nonfood")
public class Nonfood extends Products {
	
	@Getter
	@Setter
	@Column(name="life_time")
	private Integer lifeTime;
	
	public Nonfood() {
		
	}

	@Override
	public String toString() {
		return "\n" + "Nonfood [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", life time=" + getLifeTime() + "]";
	}

}
