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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Trade implements Serializable {

	private static final long serialVersionUID = -413748945823167631L;

	@Id
	@GeneratedValue(generator = "trade_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "trade_sequence", sequenceName = "trade_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@ManyToMany(cascade = { CascadeType.REMOVE })
	@JoinTable(name = "wishlist",
        joinColumns = @JoinColumn(name = "trade_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
	private List<Game> wishList;
	
	@Column(length = 140)
	private String description;
	
	@OneToMany(mappedBy = "trade", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<TradeOffer> offers;

	@Column
	private boolean traded;
	
	public Trade() {
		super();
	}

	public Trade(User owner, Game game) {
		super();
		this.owner = owner;
		this.game = game;
	}

	public Trade(User owner, Game game, List<Game> wishList) {
		super();
		this.owner = owner;
		this.game = game;
		this.wishList = wishList;
	}

	public Trade(User owner, Game game, String description) {
		super();
		this.owner = owner;
		this.game = game;
		this.description = description;
	}

	public Trade(User owner, Game game, List<Game> wishList, String description) {
		super();
		this.owner = owner;
		this.game = game;
		this.wishList = wishList;
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

	public List<Game> getWishList() {
		return wishList;
	}

	public void setWishList(List<Game> wishList) {
		this.wishList = wishList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<TradeOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<TradeOffer> offers) {
		this.offers = offers;
	}

	public boolean isTraded() {
		return traded;
	}

	public void setTraded(boolean traded) {
		this.traded = traded;
	}
	
}
