package com.jsp.warehouse.requestdto;

import java.util.List;

import com.jsp.warehouse.enums.MaterialType;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageRequest {
	@NotNull
	@NotEmpty(message = "Block Name Cannot Be Empty")
	private String blockName;
	@NotNull
	@NotEmpty(message = "Section Cannot Be Empty")
	private String section;
	@NotNull
	@NotEmpty(message = "Length Cannot Be Empty")
	private double lengthInMeters;
	@NotNull
	@NotEmpty(message = "Bredth Cannot Be Empty")
	private double bredthInMeters;
	@NotNull
	@NotEmpty(message = "Height Cannot Be Empty")
	private double heightInMeters;
	@NotNull
	@NotEmpty(message = "Capacity Cannot Be Empty")
	private double capacityInKg;
	
	private List<MaterialType> materialTypes;
}
