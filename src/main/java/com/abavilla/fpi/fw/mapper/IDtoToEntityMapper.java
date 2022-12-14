/******************************************************************************
 * FPI Application - Abavilla                                                 *
 * Copyright (C) 2022  Vince Jerald Villamora                                 *
 *                                                                            *
 * This program is free software: you can redistribute it and/or modify       *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation, either version 3 of the License, or          *
 * (at your option) any later version.                                        *
 *                                                                            *
 * This program is distributed in the hope that it will be useful,            *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 * GNU General Public License for more details.                               *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.     *
 ******************************************************************************/

package com.abavilla.fpi.fw.mapper;

import com.abavilla.fpi.fw.dto.IDto;
import com.abavilla.fpi.fw.entity.IItem;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper used for conversion and mapping fields between {@link IDto} and {@link IItem} database item.
 * @param <DTO> DTO Type
 * @param <ENTITY> Entity Type
 *
 * @author <a href="mailto:vincevillamora@gmail.com">Vince Villamora</a>
 */
public interface IDtoToEntityMapper<DTO extends IDto, ENTITY extends IItem> extends IMapper {

  DTO mapToDto(ENTITY entity);

  ENTITY mapToEntity(DTO dto);

  /**
   * Partially patch entity, skip updating null values and only update the target entity with filled values
   * from source DTO.
   *
   * @param entity Target entity
   * @param dto Source DTO
   */
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void patchEntity(@MappingTarget ENTITY entity, DTO dto);
}
