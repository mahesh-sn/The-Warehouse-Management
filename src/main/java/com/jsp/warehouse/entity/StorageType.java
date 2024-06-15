package com.jsp.warehouse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StorageType {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int storageTypeId;
	private double lengthInMeters;
	private double heightInMeters;
	private double bredthInMeters;
	private double capacityInKg;
	private int unitsAvailable;
}