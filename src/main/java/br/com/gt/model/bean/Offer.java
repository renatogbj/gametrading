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
public class Offer implements Serializable {

	private static final long serialVersionUID = -4825337334125491585L;

	@Id
	@GeneratedValue(generator = "offer_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "offer_sequence", sequenceName = "offer_sequence", allocationSize = 1)
	private Long id;
	
	@Column(length = 500)
	String description;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "bidder_id", nullable = false)
	Usr bidder;

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
	
	
}
