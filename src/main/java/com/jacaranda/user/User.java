package com.jacaranda.user;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity (name="USUARIO")
public class User {
	@Id
	@Column (name="nickname")
	private String nickname;
	@Column (name="nombre")
	private String name;
	@Column (name="apellidos")
	private String lastName;
	@Column (name="email")
	private String email;
	@Column (name="contrasena")
	private String password;
	@Column (name="genero")
	private char gender;
	@Column (name="fecha_nac")
	private LocalDate birthDate;
	@Column (name="es_admin")
	private boolean isAdmin;
	
	
	public User(String nickname, String name, String lastName, String email, String password, char gender,
			LocalDate birthDate, Boolean isAdmin) {
		super();
		this.nickname = nickname;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.isAdmin= isAdmin;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(nickname, other.nickname);
	}
	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", birthDate=" + birthDate + ", isAdmin=" + isAdmin
				+ "]";
	}
	

	

}
