package pe.com.cmgarments.service.impl.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cmgarments.entity.product.BrandEntity;
import pe.com.cmgarments.repository.product.BrandRepository;
import pe.com.cmgarments.service.product.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

  @Autowired
  private BrandRepository repositorio;

	@Override
	public List<BrandEntity> findAll() {
		return repositorio.findAll();
	}

	@Override
	public List<BrandEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}

	@Override
	public BrandEntity add(BrandEntity t) {
		return repositorio.save(t);
	}

	@Override
	public Optional<BrandEntity> findById(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public BrandEntity update(BrandEntity t) {
		BrandEntity objBrand = repositorio.getById(t.getId());
		BeanUtils.copyProperties(t,objBrand);
		return repositorio.save(objBrand);
	}

	@Override
	public BrandEntity delete(BrandEntity t) {
		BrandEntity objBrand = repositorio.getById(t.getId());
		objBrand.setEstado(false);
		return repositorio.save(objBrand);
	}
}
