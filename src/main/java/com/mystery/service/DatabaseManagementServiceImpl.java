package com.mystery.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystery.dao.DatabasemanagementDao;
import com.mystery.model.Brand;
import com.mystery.model.City;
import com.mystery.model.Helper;
import com.mystery.model.Model;
import com.mystery.model.Region;
import com.mystery.model.Section;
import com.mystery.model.State;
import com.mystery.model.Subsection;
import com.mystery.model.Variant;

@Service
public class DatabaseManagementServiceImpl  implements DatabaseManagementService{
	@Autowired
	private DatabasemanagementDao databasemanagementdao;

	/* Brand Starts */
	
	@Override
	public Brand saveBrand(Brand brand, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveBrand(brand,request,response);
	}

	@Override
	public Brand checkBrandExistOrNot(Brand brand, String brand_name) {
		return databasemanagementdao.checkBrandExistOrNot(brand);
	}

	@Override
	public List<Brand> getActiveBrandList() {
		return databasemanagementdao.getActiveBrandList();
	}

	@Override
	public List<Brand> getinactiveBrandList() {
		return databasemanagementdao.getinactiveBrandList();
	}

	@Override
	public Brand getBrandDetailsById(int brandId) {
		return databasemanagementdao.getBrandDetailsById(brandId);
	}

	@Override
	public Brand deleteBrandById(int brandId) {
		return databasemanagementdao.deleteBrandById(brandId);
	}

	@Override
	public Brand restoreBrandById(int brandId) {
		return databasemanagementdao.restoreBrandById(brandId);
	}

	/* Brand Ends */
	
	/* Model Starts */
	
	@Override
	public Model saveModel(Model model, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveModel(model,request,response);
	}

	@Override
	public List<Model> getActiveModelList() {
		return databasemanagementdao.getActiveModelList();
	}

	@Override
	public List<Model> getInActiveModelList() {
		return databasemanagementdao.getInActiveModelList();

	}

	@Override
	public Model getModelDetailsById(int modelId) {
		
		return databasemanagementdao.getModelDetailsById(modelId);

	}

	@Override
	public Model deleteModelById(int modelId) {
		
		return databasemanagementdao.deleteModelById(modelId);
	}

	@Override
	public Model restoreModelById(int modelId) {
		return databasemanagementdao.restoreModelById(modelId);
	}

	@Override
	public Model checkModelExistOrNot(Model model, int brand_id, String model_name) {
		return databasemanagementdao.checkModelExistOrNot(model,brand_id,model_name);
	}
	
	/* Model Ends */
	
	
	/* Variant Starts */
	
	@Override
	public List<Model> getModelsByBrandId(String brand_id) {
		return databasemanagementdao.getModelsByBrandIdbrand_id(brand_id);
	}
	
	@Override
	public Variant saveVariant(Variant variant, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveVariant(variant,request,response);
	}

	@Override
	public List<Variant> getActiveVariantList() {
		return databasemanagementdao.getActiveVariantList();
	}
	
	@Override
	public List<Variant> getInActiveVariantList() {
		return databasemanagementdao.getInActiveVariantList();
	}
	
	
	@Override
	public Variant variantDetailsById(int variantId) {
		return databasemanagementdao.getVariantDetailsById(variantId);
		
	}
	
	@Override
	public Variant deleteVariantById(int variantId) {
		return databasemanagementdao.deleteVariantById(variantId);
	}
	
	@Override
	public Variant restoreVariantById(int variantId) {
		return databasemanagementdao.restoreVariantById(variantId);

	}

	@Override
	public Variant checkVariantExistOrNot(Variant variant, int brand_id, int model_id, String variant_name) {
		return databasemanagementdao.checkVariantExistOrNot(variant,brand_id,model_id,variant_name);	
	}


	/* Variant Ends */
	

	/* State Starts */
	
	@Override
	public State saveState(State state, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveState(state,request,response);

	}

	@Override
	public List<State> getActiveStateList() {
		return databasemanagementdao.getActiveStateList();
	}

	@Override
	public List<State> getInactiveStateList() {
		return databasemanagementdao.getInactiveStateList();
	}

	@Override
	public State getStateDetailsById(int stateId) {
		return databasemanagementdao.getStateDetailsById(stateId);
	}

	@Override
	public State deleteStateById(int stateId) {
		return databasemanagementdao.deleteStateById(stateId);
	}

	@Override
	public State restoreStateById(int stateId) {
		return databasemanagementdao.restoreStateById(stateId);
	}

	@Override
	public State checkStateExistOrNot(State state, String state_name) {
		return databasemanagementdao.checkStateExistOrNot(state, state_name);
	}
	
	/* State Ends */


	/* City Starts */
	
	@Override
	public City saveCity(City city, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveCity(city,request,response);
	}

	@Override
	public List<City> getActiveCityList() {
		return databasemanagementdao.getActiveCityList();
	}

	@Override
	public List<City> getInactiveCityList() {
		return databasemanagementdao.getInactivecityList();
	}

	@Override
	public City getCityDetailsById(int cityId) {
		return databasemanagementdao.getCityDetailsById(cityId);
	}

	@Override
	public City deleteCityById(int cityId) {
		return databasemanagementdao.deleteCityById(cityId);
	}

	@Override
	public City restoreCityById(int cityId) {
		return databasemanagementdao.restoreCityById(cityId);
	}

	@Override
	public City checkCityExistOrNot(City city, int state_id, String city_name) {
		return databasemanagementdao.checkCityExistOrNot(city,state_id,city_name);
	}
	
	/* City Ends */

	@Override
	public Region saveRegion(Region region, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveRegion(region,request,response);
	}

	@Override
	public List<Region> getActiveRegionList() {
		return databasemanagementdao.getActiveRegionList();
	}

	@Override
	public Section saveSection(Section section, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveSection(section,request,response);
	}

	@Override
	public List<Section> getActiveSectionList() {
		return databasemanagementdao.getActiveSectionList();
	}

	@Override
	public List<Section> getInactiveSectionList() {
		return databasemanagementdao.getInactiveSectionList();
	
	}

	@Override
	public Section getSectionDetailsById(int sectionId) {
		return databasemanagementdao.getSectionDetailsById(sectionId);
	}

	@Override
	public Section deleteSectionById(int sectionId) {
		return databasemanagementdao.deleteSectionById(sectionId);
	}

	@Override
	public Section restoreSection(int sectionId) {
		return databasemanagementdao.restoreSectionById(sectionId);
	}

	@Override
	public Section checkSectionExistOrNot(Section section, String section_name) {
		return databasemanagementdao.checkSectionExistOrNot(section,section_name);
	}

	@Override
	public Subsection saveSubsection(Subsection subsection, HttpServletRequest request, HttpServletResponse response) {
		return databasemanagementdao.saveSubsection(subsection,request,response);
	}

	@Override
	public List<Subsection> getActiveSubsectionList() {
		return databasemanagementdao.getActiveSubsectionList();
	}

	@Override
	public List<Subsection> getinactiveSubsectionList() {
		return databasemanagementdao.getinactiveSubsectionList();
	}

	@Override
	public Subsection getSubsectionDetailsById(int subsectionId) {
		return databasemanagementdao.getSubsectionDetailsById(subsectionId);
	}

	@Override
	public Subsection deleteSubsectionById(int subsectionId) {
		return databasemanagementdao.deleteSubsectionById(subsectionId);
	}

	@Override
	public Subsection restoreSubsectionById(int subsectionId) {
		return databasemanagementdao.restoreSubsectionById(subsectionId);
	}

	@Override
	public Subsection checkSubsectionExistOrNot(Subsection subsection, String subsection_name) {
		return databasemanagementdao.checkSubsectionExistOrNot(subsection,subsection_name);
	}

	@Override
	public List<Region> getInActiveRegionList() {
		return databasemanagementdao.getInActiveRegionList();
	}

	@Override
	public Region getRegionDetailsById(int regionId) {
		return databasemanagementdao.getRegionDetailsById(regionId);
	}

	@Override
	public Region deleteRegionById(int regionId) {
		return databasemanagementdao.deleteRegionById(regionId);
	}

	@Override
	public Region restoreRegionById(int regionId) {
		return databasemanagementdao.restoreRegionById(regionId);
	}

	@Override
	public Region checkRegionExistOrNot(Region region, int city_id, String region_name) {
		return databasemanagementdao.checkRegionExistOrNot(region,city_id,region_name);
	}
    
}
