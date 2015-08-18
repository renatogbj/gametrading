package br.com.gt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Sell implements Serializable {

	private static final long serialVersionUID = 2098224790764531510L;

	@Id
	@GeneratedValue(generator = "sell_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sell_sequence", sequenceName = "sell_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@Column(scale = 2, nullable = false)
	private Double price;
	
	@Column(length = 140)
	private String description;

	public Sell() {
		super();
	}

	public Sell(User owner, Game game, Double price) {
		super();
		this.owner = owner;
		this.game = game;
		this.price = price;
	}

	public Sell(User owner, Game game, Double price, String description) {
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
	
}
