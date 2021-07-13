package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.entities.AEntity;
import com.ak.ds.entities.Product;

public class ProductMapper {

	private ProductMapper() {
	}

	public static ProductDto entityToDto(Product entity) {
		ProductDto dto = new ProductDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategoriesId(getIds(entity.getCategories()));
		dto.setStoragesId(getIds(entity.getStorages()));
		dto.setAttributesId(getIds(entity.getAttributes()));
		dto.setInformation(entity.getInformation());
		return dto;
	}

	public static Product dtoToEntity(ProductDto dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setInformation(dto.getInformation());
		return entity;
	}

	public static Collection<ProductDto> convertList(Collection<Product> entities) {
		Collection<ProductDto> listDto = new ArrayList<>();
		for (Product entity : entities) {
			ProductDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}

	private static <T extends AEntity> Collection<Long> getIds(Collection<T> collection) {
		Collection<Long> collectionId = null;
		try {
			collectionId = collection.stream().map(c -> c.getId()).collect(Collectors.toSet());
		} catch (NullPointerException e) {
		}
		return collectionId;
	}
}
