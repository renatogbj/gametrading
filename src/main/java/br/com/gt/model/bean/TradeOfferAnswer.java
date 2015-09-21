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
public class TradeOfferAnswer implements Serializable {

	private static final long serialVersionUID = -3860321073219658565L;

	@Id
	@GeneratedValue(generator = "tradeofferanswer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tradeofferanswer_sequence", sequenceName = "tradeofferanswer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Usr author;
	
	@ManyToOne
	@JoinColumn(name = "offer_id", nullable = false)
	@JsonBackReference(value = "offerReference")
	private TradeOffer offer;

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

	public Usr getAuthor() {
		return author;
	}

	public void setAuthor(Usr author) {
		this.author = author;
	}

	public TradeOffer getOffer() {
		return offer;
	}

	public void setOffer(TradeOffer offer) {
		this.offer = offer;
	}
}
