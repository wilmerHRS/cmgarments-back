package pe.com.cmgarments.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.cmgarments.entity.product.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
  @Query("select b from BrandEntity b where b.estado=1")
  List<BrandEntity> findAllCustom();
}
