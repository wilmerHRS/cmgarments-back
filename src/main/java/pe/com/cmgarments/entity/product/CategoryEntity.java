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
@Entity(name="CategoryEntity")
@Table(name="category")
public class CategoryEntity extends BaseEntity implements Serializable {

  private static final long serialVersionUID=1L;

  @Id
  @Column(name="id_category")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="name", length = 20, nullable = false)
  @NotEmpty(message = "Debe de ingresar el nombre")
  @Size(min=4,max=20,message = "El nombre debe de tener como minimo {min} y maximo {max}")
  private String name;

  @Column(name="sizes", length = 40, nullable = false)
  @NotEmpty(message = "Debe de ingresar los tamaños")
  @Size(min=1,max=40,message = "El tamaño debe de tener como minimo {min} y maximo {max}")
  private String sizes;
}
