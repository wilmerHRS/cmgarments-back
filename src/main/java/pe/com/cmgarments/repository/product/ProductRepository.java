package pe.com.cmgarments.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.cmgarments.entity.product.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  @Query("select p from ProductEntity p where p.estado=1")
  List<ProductEntity> findAllCustom();
}
