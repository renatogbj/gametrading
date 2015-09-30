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
public class SellOffer implements Serializable {

	private static final long serialVersionUID = 1039162770303718435L;

	@Id
	@GeneratedValue(generator = "selloffer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "selloffer_sequence", sequenceName = "selloffer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "bidder_id", nullable = false)
	private User bidder;
	
	@ManyToOne
	@JoinColumn(name = "sell_id", nullable = false)
	@JsonBackReference(value = "sellReference")
	private Sell sell;
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.REMOVE)
	@JsonManagedReference(value = "offerReference")
	private List<SellOfferAnswer> answers;
	
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

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User bidder) {
		this.bidder = bidder;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public List<SellOfferAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<SellOfferAnswer> answers) {
		this.answers = answers;
	}
	
}
