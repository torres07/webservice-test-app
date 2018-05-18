package app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "joga", 
			joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="person_id", referencedColumnName = "id"))
	private Set<Person> players;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Person> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Person> players) {
		this.players = players;
	}
}
