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
public class TradeOffer implements Serializable {

	private static final long serialVersionUID = -5065697654581013083L;

	@Id
	@GeneratedValue(generator = "tradeoffer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tradeoffer_sequence", sequenceName = "tradeoffer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "bidder_id", nullable = false)
	private User bidder;
	
	@ManyToOne
	@JoinColumn(name = "trade_id", nullable = false)
	@JsonBackReference
	private Trade trade;
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.REMOVE)
	@JsonManagedReference(value = "offerReference")
	private List<TradeOfferAnswer> answers;
	
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

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public List<TradeOfferAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<TradeOfferAnswer> answers) {
		this.answers = answers;
	}
	
}
