package br.com.gt.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sell implements Serializable {

	private static final long serialVersionUID = 2098224790764531510L;

	@Id
	@GeneratedValue(generator = "sell_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sell_sequence", sequenceName = "sell_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Usr owner;
	
	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@Column(scale = 2, nullable = false)
	private Double price;
	
	@Column(length = 140)
	private String description;
	
	@OneToMany(mappedBy = "sell")
	@JsonManagedReference
	private List<SellOffer> offers;

	@Column
	private boolean sold;
	
	public Sell() {
		super();
	}

	public Sell(Usr owner, Game game, Double price) {
		super();
		this.owner = owner;
		this.game = game;
		this.price = price;
	}

	public Sell(Usr owner, Game game, Double price, String description) {
		super();
		this.owner = owner;
		this.game = game;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usr getOwner() {
		return owner;
	}

	public void setOwner(Usr owner) {
		this.owner = owner;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<SellOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<SellOffer> offers) {
		this.offers = offers;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	@Override
	public String toString() {
		return "Sell [id=" + id + ", owner=" + owner + ", game=" + game + ", price=" + price + ", description="
				+ description + "]";
	}
	
}
