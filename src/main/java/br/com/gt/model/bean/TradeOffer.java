package br.com.gt.model.bean;

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
	private Usr bidder;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "trade_id", nullable = false)
	private Trade trade;
	
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

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
}
