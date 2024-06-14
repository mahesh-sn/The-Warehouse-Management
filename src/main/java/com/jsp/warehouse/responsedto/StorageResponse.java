package com.jsp.warehouse.responsedto;

import java.util.List;

import com.jsp.warehouse.enums.MaterialType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StorageResponse {
	private int storageId;
	private String blockname;
	private String section;
	private double capacityInKg;
	private List<MaterialType> materialTypes;
}
