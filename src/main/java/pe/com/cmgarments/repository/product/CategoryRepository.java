package pe.com.cmgarments.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.cmgarments.entity.product.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

  @Query("select c from CategoryEntity c where c.estado=1")
  List<CategoryEntity> findAllCustom();
}
