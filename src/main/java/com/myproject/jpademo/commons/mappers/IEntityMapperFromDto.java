package com.myproject.jpademo.commons.mappers;

public interface IEntityMapperFromDto<D, E> {

    E toEntity(D d);
}
