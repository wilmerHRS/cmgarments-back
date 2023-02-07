package pe.com.cmgarments.entity.product;

import java.io.Serializable;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.cmgarments.entity.base.BaseEntity;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name="ProductEntity")
@Table(name="product")
public class ProductEntity  extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID=1L;

  @Id
  @Column(name="id_product")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="name", length = 50, nullable = false)
  @NotEmpty(message = "Debe de ingresar el nombre")
  @Size(min=8,max=50,message = "El nombre debe de tener como minimo {min} y maximo {max}")
  private String name;

  @Column(name="size", length = 50, nullable = false)
  @NotEmpty(message = "Debe de ingresar la talla")
  @Size(min=1,max=5,message = "La talla debe de tener como minimo {min} y maximo {max}")
  private String size;

  @Column(name="color", length = 20, nullable = false)
  @NotEmpty(message = "Debe de ingresar el color")
  @Size(min=1,max=20,message = "El color debe de tener como minimo {min} y maximo {max}")
  private String color;

  @Column(name="price",nullable = false)
  @Positive(message = "El precio debe de ser mayor a 0")
  private double price;

  @Column(name="stock",nullable = false)
  @PositiveOrZero(message = "La cantidad debe de ser mayor o igual a cero")
  private int stock;

  @Column(name="gender", length = 20, nullable = false)
  @NotEmpty(message = "Debe de ingresar el género")
  @Size(min=1,max=20,message = "El género debe de tener como minimo {min} y maximo {max}")
  private String gender;

  @Column(name="description", length = 510, nullable = false)
  @NotEmpty(message = "Debe de ingresar la descripcion")
  @Size(min=1,max=510,message = "La descripcion debe de tener como minimo {min} y maximo {max}")
  private String description;

  @Column(name="url_img")
  @URL(message="Debe ingresar una URL")
  private String urlImg;

  @Column(name="state", nullable = false)
  private boolean state;

  @Column(name="sku", length = 100, nullable = false)
  @NotEmpty(message = "Debe de ingresar el género")
  @Size(min=1,max=100,message = "El género debe de tener como minimo {min} y maximo {max}")
  private String sku;

  @ManyToOne
  @JoinColumn(name="id_brand",nullable = false)
  private BrandEntity brand;

  @ManyToOne
  @JoinColumn(name="id_category",nullable = false)
  private CategoryEntity category;
}
