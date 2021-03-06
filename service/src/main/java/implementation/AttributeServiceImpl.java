package implementation;

import dto.AttributeDto;
import entities.Attribute;
import interfaces.AttributeDao;
import interfaces.AttributeService;
import mappers.AttributeMapper;

public class AttributeServiceImpl implements AttributeService {

    private final AttributeDao attributeDao = AttributeDaoImpl.getAttributeDao();

    private static AttributeService attributeService;

    private AttributeServiceImpl() {
    }

    public static AttributeService getAttributeService() {
        if (attributeService == null) {
            attributeService = new AttributeServiceImpl();
        }
        return attributeService;
    }

    public AttributeDto add(AttributeDto attributeDto) {
            return AttributeMapper.INSTANCE.toDto(attributeDao.add(AttributeMapper.INSTANCE.toEntity(attributeDto)));
        }

    public AttributeDto getById(Long id) {
        AttributeDto attribute = null;
        try {
            attribute = AttributeMapper.INSTANCE.toDto(getEntityById(id));
        } catch (Exception e){
            e.getStackTrace();
        }
        return attribute;
    }

    public Attribute getEntityById(Long id) {
        return attributeDao.get(id);
    }

    public AttributeDto getElseAdd(AttributeDto attributeDto){
        Attribute attribute = attributeDao.getAttrbuteByName(attributeDto.getName());
        if (attribute == null) {
            attributeDto = add(attributeDto);
        }
        return attributeDto;
    }
}
