package implementation;

import java.util.HashSet;
import java.util.Optional;

import dto.AttributeDto;
import entities.Attribute;
import interfaces.AttributeDao;
import interfaces.AttributeService;
import mappers.AttributeMapper;

public class AttributeServiceImpl implements AttributeService {

    private final AttributeDao attributeDao = AttributeDaoImpl.getAttributeDao();

    private AttributeServiceImpl() {
    }

    private static AttributeService attributeService;

    public static AttributeService getAttributeService() {
        if (attributeService == null) {
            attributeService = new AttributeServiceImpl();
        }
        return attributeService;
    }

    public Attribute add(String attributeName) {
        Attribute attribute = attributeDao.getAttrbuteByName(attributeName);
        if (attribute.getId() == null) {
            attribute = attributeDao.add(new Attribute(attributeName, new HashSet<>()));
        }
        return attribute;
    }

    public AttributeDto getById(Long id) {
        return AttributeMapper.entityToDto(getEntityById(id));
    }

    public Attribute getEntityById(Long id) {
        return Optional.ofNullable(Optional.ofNullable(this.attributeDao.get(id)).orElse(new Attribute())).get();
    }
}
