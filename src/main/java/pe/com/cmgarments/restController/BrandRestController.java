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

import pe.com.cmgarments.entity.product.BrandEntity;
import pe.com.cmgarments.service.product.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandRestController {
  @Autowired
  private BrandService servicio;

  @GetMapping
  public List<BrandEntity> findAll(){
    return servicio.findAll();
  }
  @GetMapping("/custom")
  public List<BrandEntity>findAllCustom(){
    return servicio.findAllCustom();
  }
  @PostMapping
  public BrandEntity add(@RequestBody BrandEntity c){
    return servicio.add(c);
  }
  @GetMapping("/{id}")
  public Optional<BrandEntity>findById(@PathVariable long id){
    return servicio.findById(id);
  }
  @PutMapping("/{id}")
  public BrandEntity update(@PathVariable long id,@RequestBody BrandEntity c){
    c.setId(id);
    return servicio.update(c);
  }

  @DeleteMapping("/{id}")
  public BrandEntity delete(@PathVariable long id){
    BrandEntity objBrand = new BrandEntity();
    objBrand.setId(id);
    return servicio.delete(BrandEntity.builder().id(id).build());
  }
}
