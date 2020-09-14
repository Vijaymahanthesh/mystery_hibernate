package com.mystery.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystery.model.Brand;
import com.mystery.model.City;
import com.mystery.model.Helper;
import com.mystery.model.Model;
import com.mystery.model.Region;
import com.mystery.model.Section;
import com.mystery.model.State;
import com.mystery.model.Subsection;
import com.mystery.model.Variant;

public interface DatabasemanagementDao {

	/* Brand Starts */
	Brand saveBrand(Brand brand, HttpServletRequest request, HttpServletResponse response);

	Brand checkBrandExistOrNot(Brand brand);

	List<Brand> getActiveBrandList();

	List<Brand> getinactiveBrandList();

	Brand getBrandDetailsById(int brandId);

	Brand deleteBrandById(int brandId);

	Brand restoreBrandById(int brandId);
	
	/* Brand Starts */

	/* Model Starts */
	
	Model saveModel(Model model, HttpServletRequest request, HttpServletResponse response);

	List<Model> getActiveModelList();

	List<Model> getInActiveModelList();

	Model getModelDetailsById(int modelId);

	Model deleteModelById(int modelId);

	Model restoreModelById(int modelId);

	Model checkModelExistOrNot(Model model, int brand_id, String model_name);
	
	/* Model Ends */
	
	/* Variant starts */
	
	List<Model> getModelsByBrandIdbrand_id(String brand_id);
	
	Variant saveVariant(Variant variant, HttpServletRequest request, HttpServletResponse response);
 
	List<Variant> getActiveVariantList();
	
	List<Variant> getInActiveVariantList();
	
	Variant getVariantDetailsById(int variantId);
	
	Variant deleteVariantById(int variantId);
	
	Variant restoreVariantById(int variantId);
	
	Variant checkVariantExistOrNot(Variant variant, int brand_id, int model_id, String variant_name);

	/* Variant Ends */
	
	/* State Starts */

	State saveState(State state, HttpServletRequest request, HttpServletResponse response);

	List<State> getActiveStateList();

	List<State> getInactiveStateList();

	State getStateDetailsById(int stateId);

	State deleteStateById(int stateId);

	State restoreStateById(int stateId);

	State checkStateExistOrNot(State state, String state_name);
	
	/* State Ends */
	
	/* City Starts */

	City saveCity(City city, HttpServletRequest request, HttpServletResponse response);

	List<City> getActiveCityList();

	List<City> getInactivecityList();

	City getCityDetailsById(int cityId);

	City deleteCityById(int cityId);

	City restoreCityById(int cityId);

	City checkCityExistOrNot(City city, int state_id, String city_name);
	
	/* City Ends */

	Region saveRegion(Region region, HttpServletRequest request, HttpServletResponse response);

	List<Region> getActiveRegionList();

	Section saveSection(Section section, HttpServletRequest request, HttpServletResponse response);

	List<Section> getActiveSectionList();

	List<Section> getInactiveSectionList();

	Section getSectionDetailsById(int sectionId);

	Section deleteSectionById(int sectionId);

	Section restoreSectionById(int sectionId);

	Section checkSectionExistOrNot(Section section, String section_name);

	Subsection saveSubsection(Subsection subsection, HttpServletRequest request, HttpServletResponse response);

	List<Subsection> getActiveSubsectionList();

	List<Subsection> getinactiveSubsectionList();

	Subsection getSubsectionDetailsById(int subsectionId);

	Subsection deleteSubsectionById(int subsectionId);

	Subsection restoreSubsectionById(int subsectionId);

	Subsection checkSubsectionExistOrNot(Subsection subsection, String subsection_name);

	List<Region> getInActiveRegionList();

	Region getRegionDetailsById(int regionId);

	Region deleteRegionById(int regionId);

	Region restoreRegionById(int regionId);

	Region checkRegionExistOrNot(Region region, int city_id, String region_name);
	
	
}
