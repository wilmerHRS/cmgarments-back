package pe.com.cmgarments.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.cmgarments.entity.product.ProductEntity;
import pe.com.cmgarments.service.product.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
  
  @Autowired
  private ProductService servicio;
  
  @GetMapping
  public List<ProductEntity> findAll(){
    return servicio.findAll();
  }
  @GetMapping("/custom")
  public List<ProductEntity>findAllCustom(){
    return servicio.findAllCustom();
  }
  @PostMapping
  public ProductEntity add(@RequestBody ProductEntity p){
    return servicio.add(p);
  }
  @GetMapping("/{id}")
  public Optional<ProductEntity>findById(@PathVariable long id){
    return servicio.findById(id);
  }
  @PutMapping("/{id}")
  public ProductEntity update(@PathVariable long id,@RequestBody ProductEntity p){
    p.setId(id);
    return servicio.update(p);
  }
  @DeleteMapping("/{id}")
  public ProductEntity delete(@PathVariable long id){
    ProductEntity objProduct = new ProductEntity();
    objProduct.setId(id);
    return servicio.delete(ProductEntity.builder().id(id).build());
  }
}
