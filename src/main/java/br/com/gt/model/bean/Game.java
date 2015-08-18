package br.com.gt.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Game implements Serializable {

	private static final long serialVersionUID = -6308029365597629879L;

	@Id
	@GeneratedValue(generator = "game_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String platform;
	
	@Column(nullable = false)
	private byte[] cover;

	public Game() {
		super();
	}

	public Game(String name, String platform, byte[] cover) {
		super();
		this.name = name;
		this.platform = platform;
		this.cover = cover;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
}
