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
public class Trade implements Serializable {

	private static final long serialVersionUID = -413748945823167631L;

	@Id
	@GeneratedValue(generator = "swap_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "swap_sequence", sequenceName = "swap_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "user_id", nullable = false)
	private User owner;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "wishlist",
        joinColumns = @JoinColumn(name = "swap_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
	private List<Game> wishList;
	
	@Column(length = 140)
	private String description;

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
	
}
