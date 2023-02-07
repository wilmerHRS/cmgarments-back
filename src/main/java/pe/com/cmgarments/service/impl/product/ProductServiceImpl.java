package pe.com.cmgarments.service.impl.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cmgarments.entity.product.ProductEntity;
import pe.com.cmgarments.repository.product.ProductRepository;
import pe.com.cmgarments.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
  
  @Autowired
  private ProductRepository repositorio;

  @Override
  public List<ProductEntity> findAll() {
      return repositorio.findAll();
  }

  @Override
  public List<ProductEntity> findAllCustom() {
      return repositorio.findAllCustom();
  }

  @Override
  public ProductEntity add(ProductEntity t) {
      return repositorio.save(t);
  }

  @Override
  public Optional<ProductEntity> findById(Long id) {
      return repositorio.findById(id);
  }

  @Override
  public ProductEntity update(ProductEntity t) {
      ProductEntity objProduct = repositorio.getById(t.getId());
      BeanUtils.copyProperties(t,objProduct);
      return repositorio.save(objProduct);
  }

  @Override
  public ProductEntity delete(ProductEntity t) {
      ProductEntity objProduct = repositorio.getById(t.getId());
      objProduct.setEstado(false);
      return repositorio.save(objProduct);
  }
}
