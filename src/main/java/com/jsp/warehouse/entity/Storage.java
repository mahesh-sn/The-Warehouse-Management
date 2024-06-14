package com.jsp.warehouse.entity;

import java.util.List;

import com.jsp.warehouse.enums.MaterialType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageId;
	private String blockName;
	private String section;
	private double lengthInMeters;
	private double heightInMeters;
	private double bredthInMeters;
	private double capacityInKg;
	private double maxAdditionalWeightInKg;
	private double availableArea;
	private List<MaterialType>  materialTypes;
	@ManyToOne
	private Warehouse warehouse;
}