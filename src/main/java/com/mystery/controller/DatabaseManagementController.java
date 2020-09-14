package com.mystery.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mystery.model.Brand;
import com.mystery.model.City;
import com.mystery.model.Helper;
import com.mystery.model.Model;
import com.mystery.model.Region;
import com.mystery.model.Section;
import com.mystery.model.State;
import com.mystery.model.Subsection;
import com.mystery.model.User;
import com.mystery.model.Variant;
import com.mystery.service.DatabaseManagementService;

@Controller
public class DatabaseManagementController {
	
	@Autowired
	private  DatabaseManagementService databasemanagementservice;
	
	/* Brand Starts */
	
	@RequestMapping("/addBrand")
	public ModelAndView addBrand() {
		ModelAndView mv = new ModelAndView("add-brand");
		List<Brand>activeBrandList = databasemanagementservice.getActiveBrandList();
		mv.addObject("activeBrandList", activeBrandList);
		List<Brand>inactiveBrandList = databasemanagementservice.getinactiveBrandList();
		mv.addObject("inactiveBrandList", inactiveBrandList);
		return mv;
	}
	
	@RequestMapping(value = "/saveBrand", method = RequestMethod.POST)
	public ModelAndView save(Brand brand ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addBrand");
	    databasemanagementservice.saveBrand(brand,request,response);
		return model;
	}
	
	
	@RequestMapping("/editBrand/{brandId}")
	public ModelAndView getBrandDetailsById(@PathVariable int brandId) {
		ModelAndView model = new ModelAndView("edit-brand");
		Brand brandDetails = databasemanagementservice.getBrandDetailsById(brandId);
	    if(brandDetails == null) {
		throw new RuntimeException("User not found"+brandDetails);
	   }
	    model.addObject("brandDetails", brandDetails);
		return model;
	}
	
	@RequestMapping("/deleteBrand/{brandId}")
	public ModelAndView deleteBrand(@PathVariable  int brandId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addBrand");
		databasemanagementservice.deleteBrandById(brandId);
		return model;
	}
	
	@RequestMapping("/restoreBrand/{brandId}")
	public ModelAndView restoreBrand(@PathVariable  int brandId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addBrand");
		databasemanagementservice.restoreBrandById(brandId);
		return model;
	}
	
	@RequestMapping(value = "/checkBrandExistOrNot")
	public @ResponseBody Object checkEmailExistOrNot(HttpServletRequest request, HttpServletResponse response,Brand brand) 
	{
        String brand_name = request.getParameter("brand_name");
		Brand brandExistOrNot = databasemanagementservice.checkBrandExistOrNot(brand, brand_name);
		return brandExistOrNot;
	}
	
	
	/* Brand  Ends */
	

	/* Model Starts */
	
	@RequestMapping("/addModel")
	public ModelAndView addModel() {
		ModelAndView model = new ModelAndView("add-model");
		List<Brand>activeBrandList = databasemanagementservice.getActiveBrandList();
		model.addObject("activeBrandList", activeBrandList);
		List<Model>activeModelList = databasemanagementservice.getActiveModelList();
		model.addObject("activeModelList", activeModelList);
		List<Model>inactiveModelList = databasemanagementservice.getInActiveModelList();
		model.addObject("inactiveModelList", inactiveModelList);
		return model;
	}
	
	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public ModelAndView saveModel(Model model ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/addModel");
	    databasemanagementservice.saveModel(model,request,response);
		return mv;
	}
	
	
	@RequestMapping("/editModel/{modelId}")
	public ModelAndView editModelById(@PathVariable int modelId) {
		ModelAndView model = new ModelAndView("edit-model");
		List<Brand>activeBrandList = databasemanagementservice.getActiveBrandList();
		model.addObject("activeBrandList", activeBrandList);
		Model modelDetails = databasemanagementservice.getModelDetailsById(modelId);
	    if(modelDetails == null) {
		throw new RuntimeException("Model not found"+modelDetails);
	   }
	    model.addObject("modelDetails", modelDetails);
		return model;
	}
	
	
	@RequestMapping("/deleteModel/{modelId}")
	public ModelAndView deleteModelById(@PathVariable  int modelId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addModel");
		databasemanagementservice.deleteModelById(modelId);
		return model;
	}
	
	@RequestMapping("/restoreModel/{modelId}")
	public ModelAndView restoreModelById(@PathVariable  int modelId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addModel");
		databasemanagementservice.restoreModelById(modelId);
		return model;
	}
	
	
	@RequestMapping(value = "/checkModelExistOrNot")
	public @ResponseBody Object checkModelExistOrNot(HttpServletRequest request, HttpServletResponse response,Model model) 
	{
		String brand_id1 = request.getParameter("brand_id");
		int brand_id=Integer.parseInt(brand_id1);
        String model_name = request.getParameter("model_name");
		Model modelExistOrNot = databasemanagementservice.checkModelExistOrNot(model, brand_id,model_name);
		return modelExistOrNot;
	}
	
	/* Model Ends */
	
	
	/* Variant Starts */
	
	@RequestMapping("/addVariant")
	public ModelAndView addVariant() {
		ModelAndView mv = new ModelAndView("add-variant");
		List<Brand>activeBrandList = databasemanagementservice.getActiveBrandList();
		mv.addObject("activeBrandList", activeBrandList);
		List<Variant>activeVariantList = databasemanagementservice.getActiveVariantList();
		mv.addObject("activeVariantList", activeVariantList);
		List<Variant>inactiveVariantList = databasemanagementservice.getInActiveVariantList();
		mv.addObject("inactiveVariantList", inactiveVariantList);
		return mv;
	}
	
	@RequestMapping(value = "/getModelsByBrandId")
	public @ResponseBody Object getModelsByBrandId(HttpServletRequest request, HttpServletResponse response,Brand brand) 
	{
        String brand_id = request.getParameter("brand_id");
		List<Model>modelList = databasemanagementservice.getModelsByBrandId(brand_id);
		return modelList;
	}
	
	@RequestMapping(value = "/saveVariant", method = RequestMethod.POST)
	public ModelAndView saveVariant(Variant variant ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addVariant");
	    databasemanagementservice.saveVariant(variant,request,response);
		return model;
	}
	
	@RequestMapping("/editVariant/{variantId}")
	public ModelAndView editVariantById(@PathVariable int variantId) {
		ModelAndView model = new ModelAndView("edit-variant");
		List<Brand>activeBrandList = databasemanagementservice.getActiveBrandList();
		model.addObject("activeBrandList", activeBrandList);
		List<Model>activeModelList = databasemanagementservice.getActiveModelList();
		model.addObject("activeModelList", activeModelList);
		Variant variantDetails = databasemanagementservice.variantDetailsById(variantId);
	    if(variantDetails == null) {
		throw new RuntimeException("User not found"+variantDetails);
	   }
	    model.addObject("variantDetails", variantDetails);
		return model;
	}
	
	
	@RequestMapping("/deleteVariant/{variantId}")
	public ModelAndView deleteVariant(@PathVariable  int variantId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addVariant");
		databasemanagementservice.deleteVariantById(variantId);
		return model;
	}
	
	@RequestMapping("/restoreVariant/{variantId}")
	public ModelAndView restoreVariant(@PathVariable  int variantId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addVariant");
		databasemanagementservice.restoreVariantById(variantId);
		return model;
	}
	
	@RequestMapping(value = "/checkVariantExistOrNot")
	public @ResponseBody Object checkVariantExistOrNot(HttpServletRequest request, HttpServletResponse response,Variant variant) 
	{
		String brand_id1 = request.getParameter("brand_id");
		int brand_id=Integer.parseInt(brand_id1);
		System.out.println("brand id"+brand_id);
		String model_id1 = request.getParameter("model_id");
		int model_id=Integer.parseInt(model_id1);
		System.out.println("model id"+model_id);
        String variant_name = request.getParameter("variant_name");
		Variant variantExistOrNot = databasemanagementservice.checkVariantExistOrNot(variant, brand_id, model_id,variant_name);
		return variantExistOrNot;
	}
	
	/* Variant Ends */
	
	/*State Starts */
	
	@RequestMapping("/addState")
	public ModelAndView addState() {
		ModelAndView mv = new ModelAndView("add-state");
		List<State>activeStateList = databasemanagementservice.getActiveStateList();
		mv.addObject("activeStateList", activeStateList);
		List<State>inactiveStateList = databasemanagementservice.getInactiveStateList();
		mv.addObject("inactiveStateList", inactiveStateList);
		return mv;
	}
	
	@RequestMapping(value = "/saveState", method = RequestMethod.POST)
	public ModelAndView saveState(State state ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addState");
	    databasemanagementservice.saveState(state,request,response);
		return model;
	}
	

	@RequestMapping("/editState/{stateId}")
	public ModelAndView getStateDetailsById(@PathVariable int stateId) {
		ModelAndView model = new ModelAndView("edit-state");
		State stateDetails = databasemanagementservice.getStateDetailsById(stateId);
	    if(stateDetails == null) {
		throw new RuntimeException("User not found"+stateDetails);
	   }
	    model.addObject("stateDetails", stateDetails);
		return model;
	}
	
	@RequestMapping("/deleteState/{stateId}")
	public ModelAndView deleteState(@PathVariable  int stateId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addState");
		databasemanagementservice.deleteStateById(stateId);
		return model;
	}
	
	@RequestMapping("/restoreState/{stateId}")
	public ModelAndView restoreState(@PathVariable  int stateId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addState");
		databasemanagementservice.restoreStateById(stateId);
		return model;
	}
	
	@RequestMapping(value = "/checkStateExistOrNot")
	public @ResponseBody Object checkStateExistOrNot(HttpServletRequest request, HttpServletResponse response,State state) 
	{
        String state_name = request.getParameter("state_name");
		State stateExistOrNot = databasemanagementservice.checkStateExistOrNot(state, state_name);
		return stateExistOrNot;
	}
	
	/* State Ends */
	
	/* City Starts */
	
	@RequestMapping("/addCity")
	public ModelAndView addCity() {
		ModelAndView mv = new ModelAndView("add-city");
		List<State>activeStateList = databasemanagementservice.getActiveStateList();
		mv.addObject("activeStateList", activeStateList);
		List<City>cityActiveList = databasemanagementservice.getActiveCityList();
		mv.addObject("cityActiveList", cityActiveList);
		List<City>inactiveCityList = databasemanagementservice.getInactiveCityList();
		mv.addObject("inactiveCityList", inactiveCityList);
		return mv;
	}
	
	@RequestMapping(value = "/saveCity", method = RequestMethod.POST)
	public ModelAndView saveCity(City city ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addCity");
	    databasemanagementservice.saveCity(city,request,response);
		return model;
	}
	
	@RequestMapping("/editCity/{cityId}")
	public ModelAndView getCityDetailsById(@PathVariable int cityId) {
		ModelAndView model = new ModelAndView("edit-city");
		List<State>activeStateList = databasemanagementservice.getActiveStateList();
		model.addObject("activeStateList", activeStateList);
		City cityDetails = databasemanagementservice.getCityDetailsById(cityId);
	    if(cityDetails == null) {
		throw new RuntimeException("User not found"+cityDetails);
	   }
	    model.addObject("cityDetails", cityDetails);
		return model;
	}
	
	@RequestMapping("/deleteCity/{cityId}")
	public ModelAndView deleteCity(@PathVariable  int cityId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addCity");
		databasemanagementservice.deleteCityById(cityId);
		return model;
	}
	
	@RequestMapping("/restoreCity/{cityId}")
	public ModelAndView restoreCity(@PathVariable  int cityId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addCity");
		databasemanagementservice.restoreCityById(cityId);
		return model;
	}
	
	@RequestMapping(value = "/checkCityExistOrNot")
	public @ResponseBody Object checkCityExistOrNot(HttpServletRequest request, HttpServletResponse response,City city) 
	{
		String state_id1 = request.getParameter("state_id");
		int state_id=Integer.parseInt(state_id1);
        String city_name = request.getParameter("city_name");
		City cityExistOrNot = databasemanagementservice.checkCityExistOrNot(city, state_id,city_name);
		return cityExistOrNot;
	}
	
	/* City Ends */
	
	@RequestMapping("/addRegion")
	public ModelAndView addRegion() {
		ModelAndView mv = new ModelAndView("add-region");
		List<City>cityActiveList = databasemanagementservice.getActiveCityList();
		mv.addObject("cityActiveList", cityActiveList);
		List<Region>activeRegionList = databasemanagementservice.getActiveRegionList();
		mv.addObject("activeRegionList", activeRegionList);
		List<Region>inactiverRegionList = databasemanagementservice.getInActiveRegionList();
		mv.addObject("inactiverRegionList", inactiverRegionList);
		return mv;
	}
	
	@RequestMapping(value = "/saveRegion", method = RequestMethod.POST)
	public ModelAndView saveRegion(Region region ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addRegion");
	    databasemanagementservice.saveRegion(region,request,response);
		return model;
	}
	
	 @RequestMapping("/editRegion/{regionId}")
		public ModelAndView getRegionDetailsById(@PathVariable int regionId) {
			ModelAndView model = new ModelAndView("edit-region");
			List<City>cityActiveList = databasemanagementservice.getActiveCityList();
			model.addObject("cityActiveList", cityActiveList);
			Region regionDetails = databasemanagementservice.getRegionDetailsById(regionId);
		    if(regionDetails == null) {
			throw new RuntimeException("User not found"+regionDetails);
		   }
		    model.addObject("regionDetails", regionDetails);
			return model;
		}
	
	
	/* Section Starts */
	@RequestMapping("/addSection")
	public ModelAndView addSection() {
		ModelAndView mv = new ModelAndView("add-section");
		List<Section>activeSectionList = databasemanagementservice.getActiveSectionList();
		mv.addObject("activeSectionList", activeSectionList);
		List<Section>inactiveSectionList = databasemanagementservice.getInactiveSectionList();
		mv.addObject("inactiveSectionList", inactiveSectionList);
		return mv;
	}
	
	@RequestMapping(value = "/saveSection", method = RequestMethod.POST)
	public ModelAndView saveSection(Section section ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addSection");
	    databasemanagementservice.saveSection(section,request,response);
		return model;
	}
	
	@RequestMapping("/editSection/{sectionId}")
	public ModelAndView getSectionDetailsById(@PathVariable int sectionId) {
		ModelAndView model = new ModelAndView("edit-section");
		Section sectionDetails = databasemanagementservice.getSectionDetailsById(sectionId);
	    if(sectionDetails == null) {
		throw new RuntimeException("User not found"+sectionDetails);
	   }
	    model.addObject("sectionDetails", sectionDetails);
		return model;
	}
	
	@RequestMapping("/deleteSection/{sectionId}")
	public ModelAndView deleteSection(@PathVariable  int sectionId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addSection");
		databasemanagementservice.deleteSectionById(sectionId);
		return model;
	}
	
	@RequestMapping("/restoreSection/{sectionId}")
	public ModelAndView restoreSection(@PathVariable  int sectionId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addSection");
		databasemanagementservice.restoreSection(sectionId);
		return model;
	}
	
	
	@RequestMapping(value = "/checkSectionExistOrNot")
	public @ResponseBody Object checkSectionExistOrNot(HttpServletRequest request, HttpServletResponse response,Section section) 
	{
        String section_name = request.getParameter("section_name");
		Section sectionExistOrNot = databasemanagementservice.checkSectionExistOrNot(section, section_name);
		return sectionExistOrNot;
	}

	/* Section Ends */
	

	    @RequestMapping("/addSubsection")
	    public ModelAndView addSubsection() {
		ModelAndView mv = new ModelAndView("add-subsection");
		List<Section>activeSectionList = databasemanagementservice.getActiveSectionList();
		mv.addObject("activeSectionList", activeSectionList);
		List<Subsection>activeSubsectionList = databasemanagementservice.getActiveSubsectionList();
		mv.addObject("activeSubsectionList", activeSubsectionList);
		List<Subsection>inactiveSubsectionList = databasemanagementservice.getinactiveSubsectionList();
		mv.addObject("inactiveSubsectionList", inactiveSubsectionList);
		return mv;
	}
	    
	    @RequestMapping(value = "/saveSubsection", method = RequestMethod.POST)
		public ModelAndView saveSubsection(Subsection subsection ,HttpServletRequest request, HttpServletResponse response ,HttpSession session) {
			ModelAndView model = null;
			model = new ModelAndView("redirect:/addSubsection");
		    databasemanagementservice.saveSubsection(subsection,request,response);
			return model;
		}
	
	    @RequestMapping("/editSubsection/{subsectionId}")
		public ModelAndView getSubsectionDetailsById(@PathVariable int subsectionId) {
			ModelAndView model = new ModelAndView("edit-subsection");
			List<Section>activeSectionList = databasemanagementservice.getActiveSectionList();
			model.addObject("activeSectionList", activeSectionList);
			Subsection subsectionDetails = databasemanagementservice.getSubsectionDetailsById(subsectionId);
		    if(subsectionDetails == null) {
			throw new RuntimeException("User not found"+subsectionDetails);
		   }
		    model.addObject("subsectionDetails", subsectionDetails);
			return model;
		}
	    
	    @RequestMapping("/deleteSubsection/{subsectionId}")
		public ModelAndView deleteSubsection(@PathVariable  int subsectionId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addSubsection");
		databasemanagementservice.deleteSubsectionById(subsectionId);
		return model;
		}
	    
	    @RequestMapping("/restoreSubsection/{subsectionId}")
		public ModelAndView restoreSubsection(@PathVariable  int subsectionId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/addSubsection");
		databasemanagementservice.restoreSubsectionById(subsectionId);
		return model;
		}
	    
	    @RequestMapping(value = "/checkSubsectionExistOrNot")
		public @ResponseBody Object checkSubsectionExistOrNot(HttpServletRequest request, HttpServletResponse response,Subsection subsection) 
		{
			
	        String subsection_name = request.getParameter("subsection_name");
			Subsection subsectionExistOrNot = databasemanagementservice.checkSubsectionExistOrNot(subsection,subsection_name);
			return subsectionExistOrNot;
		}
	    
	    @RequestMapping("/deleteRegion/{regionId}")
		public ModelAndView deleteRegion(@PathVariable  int regionId) {
			ModelAndView model = null;
			model = new ModelAndView("redirect:/addRegion");
			databasemanagementservice.deleteRegionById(regionId);
			return model;
		}
	    
	    @RequestMapping("/restoreRegion/{regionId}")
		public ModelAndView restoreRegionById(@PathVariable  int regionId) {
			ModelAndView model = null;
			model = new ModelAndView("redirect:/addRegion");
			databasemanagementservice.restoreRegionById(regionId);
			return model;
		}
	   
	    @RequestMapping(value = "/CheckRegionExistOrNot")
		public @ResponseBody Object CheckRegionExistOrNot(HttpServletRequest request, HttpServletResponse response,Region region) 
		{
			String city_id1 = request.getParameter("city_id");
			int city_id=Integer.parseInt(city_id1);
	        String region_name = request.getParameter("region_name");
			Region regionExistOrNot = databasemanagementservice.checkRegionExistOrNot(region, city_id,region_name);
			return regionExistOrNot;
		}
}
