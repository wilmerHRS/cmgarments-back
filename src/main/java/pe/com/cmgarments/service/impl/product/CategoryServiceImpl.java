package pe.com.cmgarments.service.impl.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cmgarments.entity.product.CategoryEntity;
import pe.com.cmgarments.repository.product.CategoryRepository;
import pe.com.cmgarments.service.product.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository repositorio;

	@Override
	public List<CategoryEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<CategoryEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public CategoryEntity add(CategoryEntity t) {
		return repositorio.save(t);
	}

	@Override
	public Optional<CategoryEntity> findById(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public CategoryEntity update(CategoryEntity t) {
		CategoryEntity objCategory = repositorio.getById(t.getId());
		BeanUtils.copyProperties(t,objCategory);
		return repositorio.save(objCategory);
	}

	@Override
	public CategoryEntity delete(CategoryEntity t) {
		CategoryEntity objCategory = repositorio.getById(t.getId());
		objCategory.setEstado(false);
		return repositorio.save(objCategory);
	}
}
