package com.myproject.jpademo.commons.mappers;

import java.util.List;
import java.util.Set;

public interface IEntityMapper<D, E>  extends IEntityMapperFromDto<D, E>{
    D toDto(E e);

    List<D> toDto(List<E> eList);

    List<E> toEntity(List<D> dList);

    Set<D> toDto(Set<E> eSet);

    Set<E> toEntity(Set<D> dSet);
}
