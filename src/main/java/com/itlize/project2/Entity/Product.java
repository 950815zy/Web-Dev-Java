package com.itlize.project2.Entity;

import javax.persistence.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.query.criteria.internal.expression.function.SubstringFunction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "Product")
public class Product {
	@Id
	@Column(name = "pid", nullable = false)
	Integer pid;
	
	@Column (name = "model", nullable = false)
	String model;
	@Column (name = "manufacturer", nullable = false)
	String manufacturer;
	@Column (name = "series", nullable = false)
	String series;
	@Column (name = "use_type", nullable = false)
	String use_type;
	@Column (name = "application", nullable = false)
	String application;
	@Column (name = "mounting_location", nullable = false)
	String mountingLocation;
	@Column 
	String accessories;
	@Column (name = "model_year", nullable = false)
	String modelYear;
	@Column (name = "airflow", nullable = false)
	Integer airflow;
	@Column (name = "power_min", nullable = false)
	Integer powerMin;
	@Column (name = "power_max", nullable = false)
	Integer powerMax;
	@Column (name = "operating_voltage_min", nullable = false)
	Float pvMin;
	@Column (name = "operating_voltage_max", nullable = false)
	Float pvMax;
	@Column (name = "fan_speed_min", nullable = false)
	Float rpmMin;
	@Column (name = "fan_speed_max", nullable = false)
	Float rpmMax;
	@Column (name = "number_of_fan_speed", nullable = false)
	Float fanSpeed;
	@Column (name = "sound_at_max_speed", nullable = false)
	Float soundMaxSpeed;
	@Column (name = "fan_sweep_diameter", nullable = false)
	Float fanSweep;
	@Column (name = "height_min", nullable = false)
	Float heightMin;
	@Column (name = "height_max", nullable = false)
	Float heightMax;
	@Column (name = "weight", nullable = false)
	Float weight;
	
	
    @ManyToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private Set<UserDTO> userId = new HashSet<UserDTO>();


    public Product () {};

	public Product(Integer pid, String model, String manufacturer, String series, String useType, String application,
			String mountingLocation, String accessories, String modelYear, Integer airflow, Integer powerMin,
			Integer powerMax, Float pvMin, Float pvMax, Float rpmMin, Float rpmMax, Float fanSpeed, Float soundMaxSpeed,
			Float fanSweep, Float heightMin, Float heightMax, Float weight) {
		super();
		this.pid = pid;
		this.model = model;
		this.manufacturer = manufacturer;
		this.series = series;
		this.use_type = useType;
		this.application = application;
		this.mountingLocation = mountingLocation;
		this.accessories = accessories;
		this.modelYear = modelYear;
		this.airflow = airflow;
		this.powerMin = powerMin;
		this.powerMax = powerMax;
		this.pvMin = pvMin;
		this.pvMax = pvMax;
		this.rpmMin = rpmMin;
		this.rpmMax = rpmMax;
		this.fanSpeed = fanSpeed;
		this.soundMaxSpeed = soundMaxSpeed;
		this.fanSweep = fanSweep;
		this.heightMin = heightMin;
		this.heightMax = heightMax;
		this.weight = weight;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getMountingLocation() {
		return mountingLocation;
	}

	public void setMountingLocation(String mountingLocation) {
		this.mountingLocation = mountingLocation;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public Integer getAirflow() {
		return airflow;
	}

	public void setAirflow(Integer airflow) {
		this.airflow = airflow;
	}

	public Integer getPowerMin() {
		return powerMin;
	}

	public void setPowerMin(Integer powerMin) {
		this.powerMin = powerMin;
	}

	public Integer getPowerMax() {
		return powerMax;
	}

	public void setPowerMax(Integer powerMax) {
		this.powerMax = powerMax;
	}

	public Float getPvMin() {
		return pvMin;
	}

	public void setPvMin(Float pvMin) {
		this.pvMin = pvMin;
	}

	public Float getPvMax() {
		return pvMax;
	}

	public void setPvMax(Float pvMax) {
		this.pvMax = pvMax;
	}

	public Float getRpmMin() {
		return rpmMin;
	}

	public void setRpmMin(Float rpmMin) {
		this.rpmMin = rpmMin;
	}

	public Float getRpmMax() {
		return rpmMax;
	}

	public void setRpmMax(Float rpmMax) {
		this.rpmMax = rpmMax;
	}

	public Float getFanSpeed() {
		return fanSpeed;
	}

	public void setFanSpeed(Float fanSpeed) {
		this.fanSpeed = fanSpeed;
	}

	public Float getSoundMaxSpeed() {
		return soundMaxSpeed;
	}

	public void setSoundMaxSpeed(Float soundMaxSpeed) {
		this.soundMaxSpeed = soundMaxSpeed;
	}

	public Float getFanSweep() {
		return fanSweep;
	}

	public void setFanSweep(Float fanSweep) {
		this.fanSweep = fanSweep;
	}

	public Float getHeightMin() {
		return heightMin;
	}

	public void setHeightMin(Float heightMin) {
		this.heightMin = heightMin;
	}

	public Float getHeightMax() {
		return heightMax;
	}

	public void setHeightMax(Float heightMax) {
		this.heightMax = heightMax;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Product(Integer pid, String model, String manufacturer, String series, String useType, String application,
			String mountingLocation, String accessories, String modelYear, Integer airflow, Integer powerMin,
			Integer powerMax, Float pvMin, Float pvMax, Float rpmMin, Float rpmMax, Float fanSpeed, Float soundMaxSpeed,
			Float fanSweep, Float heightMin, Float heightMax, Float weight, Set<UserDTO> userId) {
		super();
		this.pid = pid;
		this.model = model;
		this.manufacturer = manufacturer;
		this.series = series;
		this.use_type = useType;
		this.application = application;
		this.mountingLocation = mountingLocation;
		this.accessories = accessories;
		this.modelYear = modelYear;
		this.airflow = airflow;
		this.powerMin = powerMin;
		this.powerMax = powerMax;
		this.pvMin = pvMin;
		this.pvMax = pvMax;
		this.rpmMin = rpmMin;
		this.rpmMax = rpmMax;
		this.fanSpeed = fanSpeed;
		this.soundMaxSpeed = soundMaxSpeed;
		this.fanSweep = fanSweep;
		this.heightMin = heightMin;
		this.heightMax = heightMax;
		this.weight = weight;
		this.userId = userId;
	}

	public Set<UserDTO> getUserId() {
		return userId;
	}

	public void setUserId(Set<UserDTO> userId) {
		this.userId = userId;
	} 
	
}
