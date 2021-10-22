package mx.coding.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "cita")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;
	@Column(name = "username", length = 100)
	private String username;
	@Column(name = "name", length = 100)
	private String name;
	@Column(name = "whatsapp", length = 12)
	private String whatsapp;
	// ISODATE 2019-10-01T05:00:00.000Z
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime date;
	// ISODATE 2019-10-01T05:00:00.000Z
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime hour;
	@Column(name = "description", length = 300)
	private String description;
	@Column(name = "status", length = 12)
	private String status;
	@Column(name = "idUserC")
	private int idUserC;

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getHour() {
		return hour;
	}

	public void setHour(LocalDateTime hour) {
		this.hour = hour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdUserC() {
		return idUserC;
	}

	public void setIdUserCita(int idUserC) {
		this.idUserC = idUserC;
	}

}
