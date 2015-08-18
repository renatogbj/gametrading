package br.com.gt.model.bean;

import java.io.Serializable;
import java.util.Date;

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
public class Message implements Serializable {

	private static final long serialVersionUID = -3265768873208917208L;

	@Id
	@GeneratedValue(generator = "message_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
	private Long id;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "usera_id", nullable = false)
	private User userA;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "userb_id", nullable = false)
	private User userB;
	
	@Column(nullable = false)
	private Date dateTime;
	
	@Column(length = 500, nullable = false)
	private String content;

	public Message() {
		super();
	}

	public Message(User userA, User userB, Date dateTime, String content) {
		super();
		this.userA = userA;
		this.userB = userB;
		this.dateTime = dateTime;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserA() {
		return userA;
	}

	public void setUserA(User userA) {
		this.userA = userA;
	}

	public User getUserB() {
		return userB;
	}

	public void setUserB(User userB) {
		this.userB = userB;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
