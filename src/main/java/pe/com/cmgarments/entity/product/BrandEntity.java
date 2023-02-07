package pe.com.cmgarments.entity.product;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
@Entity(name="BrandEntity")
@Table(name="brand")
public class BrandEntity extends BaseEntity implements Serializable {
  
  private static final long serialVersionUID=1L;

  @Id
  @Column(name="id_brand")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="name", length = 20, nullable = false)
  @NotEmpty(message = "Debe de ingresar el nombre")
  @Size(min=3,max=20,message = "El nombre debe de tener como minimo {min} y maximo {max}")
  private String name;
}
 
