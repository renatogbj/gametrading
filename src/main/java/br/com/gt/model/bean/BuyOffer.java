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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BuyOffer implements Serializable {

	private static final long serialVersionUID = -4825337334125491585L;

	@Id
	@GeneratedValue(generator = "buyoffer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "buyoffer_sequence", sequenceName = "buyoffer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "bidder_id", nullable = false)
	private Usr bidder;
	
	@ManyToOne
	@JoinColumn(name = "buy_id", nullable = false)
	@JsonBackReference
	private Buy buy;
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.REMOVE)
	@JsonManagedReference(value = "offerReference")
	private List<BuyOfferAnswer> answers;
	
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

	public Usr getBidder() {
		return bidder;
	}

	public void setBidder(Usr bidder) {
		this.bidder = bidder;
	}

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	public List<BuyOfferAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<BuyOfferAnswer> answers) {
		this.answers = answers;
	}
	
}
