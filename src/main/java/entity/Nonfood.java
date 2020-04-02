package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="nonfood")
public class Nonfood extends Products {
	
	@Column(name="life_time")
	private Integer lifeTime;
	
	public Nonfood() {
		
	}

	public Integer getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(Integer lifeTime) {
		this.lifeTime = lifeTime;
	}
	
	@Override
	public String toString() {
		return "\n" + "Nonfood [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", life time=" + getLifeTime() + "]";
	}

}
