package br.com.gt.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.gt.model.enums.Platform;

@Entity
public class Game implements Serializable {

	private static final long serialVersionUID = -6308029365597629879L;

	@Id
	@GeneratedValue(generator = "game_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Platform platform;
	
	@Column(nullable = false)
	private byte[] cover;

	public Game() {
		super();
	}

	public Game(String name, Platform platform, byte[] cover) {
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

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", platform=" + platform + ", cover=" + cover + "]";
	}
	
}
