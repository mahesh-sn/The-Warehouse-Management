package com.jsp.warehouse.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StorageTypeResponse {
	private int storageTypeId;
	private double lengthInMeters;
	private double heightInMeters;
	private double bredthInMeters;
	private double capacityInKg;
	private int unitsAvailable;
}
