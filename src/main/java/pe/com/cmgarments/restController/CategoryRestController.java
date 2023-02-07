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

import pe.com.cmgarments.entity.product.CategoryEntity;
import pe.com.cmgarments.service.product.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
  @Autowired
  private CategoryService servicio;

  @GetMapping
  public List<CategoryEntity> findAll(){
    return servicio.findAll();
  }
  @GetMapping("/custom")
  public List<CategoryEntity>findAllCustom(){
    return servicio.findAllCustom();
  }
  @PostMapping
  public CategoryEntity add(@RequestBody CategoryEntity c){
    return servicio.add(c);
  }
  @GetMapping("/{id}")
  public Optional<CategoryEntity>findById(@PathVariable long id){
    return servicio.findById(id);
  }
  @PutMapping("/{id}")
  public CategoryEntity update(@PathVariable long id,@RequestBody CategoryEntity c){
    c.setId(id);
    return servicio.update(c);
  }

  @DeleteMapping("/{id}")
  public CategoryEntity delete(@PathVariable long id){
    CategoryEntity objCategory = new CategoryEntity();
    objCategory.setId(id);
    return servicio.delete(CategoryEntity.builder().id(id).build());
  }
}
