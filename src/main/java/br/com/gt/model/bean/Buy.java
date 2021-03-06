package br.com.gt.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Buy implements Serializable {

	private static final long serialVersionUID = -621327733554688497L;

	@Id
	@GeneratedValue(generator = "buy_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "buy_sequence", sequenceName = "buy_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@Column(scale = 2, nullable = false)
	private Double price;
	
	@Column(length = 140)
	private String description;
	
	@OneToMany(mappedBy = "buy", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<BuyOffer> offers;
	
	@Column
	private boolean bought;
	
	public Buy() {
		super();
	}

	public Buy(User owner, Game game, Double price) {
		super();
		this.owner = owner;
		this.game = game;
		this.price = price;
	}

	public Buy(User owner, Game game, Double price, String description) {
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
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
	
	public List<BuyOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<BuyOffer> offers) {
		this.offers = offers;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}
	
}
