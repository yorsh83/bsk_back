package mx.coding.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Informacion del servicio")
@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	
	@ApiModelProperty(notes = "Titulo del servicio")
	@Column(name = "title", length = 100)
	private String title;
	
	@ApiModelProperty(notes = "Imagen del servicio")
	@Column(name = "urlImage")
	private String urlImage;
	
	@ApiModelProperty(notes = "Descripcion del servicio")
	@Column(name = "description")
	private String description;
	
	@ApiModelProperty(notes = "Precio del servicio")
	@Column(name = "price", length = 10)
	private String price;

	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
