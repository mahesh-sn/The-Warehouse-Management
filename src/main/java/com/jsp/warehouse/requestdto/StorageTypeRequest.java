package com.jsp.warehouse.requestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageTypeRequest {
	private double lengthInMeters;
	private double heightInMeters;
	private double bredthInMeters;
	private double capacityInKg;
}
