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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Buy implements Serializable {

	private static final long serialVersionUID = -621327733554688497L;

	@Id
	@GeneratedValue(generator = "buy_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "buy_sequence", sequenceName = "buy_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id", nullable = false)
	private Usr owner;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@Column(scale = 2, nullable = false)
	private Double price;
	
	@Column(length = 140)
	private String description;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "buyoffer",
        joinColumns = @JoinColumn(name = "buy_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"))
	private List<Offer> offers;

	public Buy() {
		super();
	}

	public Buy(Usr owner, Game game, Double price) {
		super();
		this.owner = owner;
		this.game = game;
		this.price = price;
	}

	public Buy(Usr owner, Game game, Double price, String description) {
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
	
	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
}
