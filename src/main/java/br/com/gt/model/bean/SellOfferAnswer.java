package br.com.gt.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SellOfferAnswer implements Serializable {

	private static final long serialVersionUID = 8407923515654303509L;
	
	@Id
	@GeneratedValue(generator = "sellofferanswer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sellofferanswer_sequence", sequenceName = "sellofferanswer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name = "offer_id", nullable = false)
	@JsonBackReference(value = "offerReference")
	private SellOffer offer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public SellOffer getOffer() {
		return offer;
	}

	public void setOffer(SellOffer offer) {
		this.offer = offer;
	}
	
}
