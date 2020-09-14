package com.mystery.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

@Repository
public class DatabaseManagementDaoImpl implements DatabasemanagementDao {
	@Autowired
	private EntityManager entityManager;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	
	/* Brand Statrs */
	
	@Transactional
	@Override
	public Brand saveBrand(Brand brand, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		int user_id=(int) session.getAttribute("userId");
		brand.setCreated_by(user_id);
		brand.setCreated_date(dateFormat.format(date));
		Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(brand);
		return brand;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Brand checkBrandExistOrNot(Brand brand) {
		Session currentSession = entityManager.unwrap(Session.class);
	    Query query = currentSession.createQuery("select count(*),b.status from Brand b where b.brand_name=:brand_name");
	    query.setParameter("brand_name",brand.getBrand_name());    
	    List<Object[]> res = query.getResultList(); 
	    List<Brand> list= new ArrayList<Brand>(); 
	    Iterator it = res.iterator();
	    while(it.hasNext()){
	         Object[] line = (Object[]) it.next();
	         Brand b = new Brand();
	         b.setBrand_status((long) line[0]);
	         b.setStatus((String) line[1]);
	         list.add(b);
	    }
	    Long count=list.get(0).getBrand_status();
	    String status="";
	    try {
	    status=list.get(0).getStatus();
	    }
	    catch (Exception e) {
			// TODO: handle exception
		}
	    System.out.println("count detail"+count);
	    System.out.println("status in detail"+status);
	    Brand brandDetails= new Brand();
	    if(count==1 && status.equals("active"))
	    {
	    	brandDetails.setStatusCode("1");
	    	brandDetails.setStatus(status);
	    	brandDetails.setStatusmessage("Brand already exist");
	    	return brandDetails;
	    }
	    else if(count==0 && status==null)
	    {

	    	brandDetails.setStatusCode("");
	    	brandDetails.setStatus("");
	    	brandDetails.setStatusmessage("");
	    	return brandDetails;
	    }
	    else 
	    {
            brandDetails.setStatusCode("0");
	    	brandDetails.setStatus(status);
	    	brandDetails.setStatusmessage("Brand already exist in inactive state");
	    	
	    	return brandDetails;
	    }
	   
	}
	@Override
	public List<Brand> getActiveBrandList() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Brand> query = currentSession.createQuery("from Brand b  where b.status='active'", Brand.class);
		List<Brand>brandList = query.getResultList();
		return brandList;
	}
	@Override
	public List<Brand> getinactiveBrandList() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Brand> query = currentSession.createQuery("from Brand b  where b.status='inactive'", Brand.class);
		List<Brand>brandList = query.getResultList();
		return brandList;
	}
	@Override
	public Brand getBrandDetailsById(int brandId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Brand brandDetails = currentSession.get(Brand.class, brandId);
		return brandDetails;
	}
	@Transactional
	@Override
	public Brand deleteBrandById(int brandId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("UPDATE Brand b SET b.status =:inactive  WHERE b.sk_brand_id= :brandId");
		query.setParameter("brandId", brandId);
		query.setParameter("inactive","inactive");
        int updateCount = query.executeUpdate();
        Brand branddetails= new Brand();
        if(updateCount==1)
        {
        	branddetails.setStatusCode("1");
        	branddetails.setStatusmessage("Deleted Successfully");
        }
		return branddetails;	
	}
	@Transactional
	@Override
	public Brand restoreBrandById(int brandId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("UPDATE Brand b SET b.status =:active  WHERE b.sk_brand_id= :brandId");
		query.setParameter("brandId", brandId);
		query.setParameter("active","active");
        int updateCount = query.executeUpdate();
        Brand branddetails= new Brand();
        if(updateCount==1)
        {
        	branddetails.setStatusCode("1");
        	branddetails.setStatusmessage("Restored Successfully");
        }
		return branddetails;
	}
	
	
	
	/* Brand Ends */
	
	/* Model Starts */ 
	
	    @Transactional
	    @Override
	    public Model saveModel(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		int user_id=(int) session.getAttribute("userId");
		model.setCreated_by(user_id);
		model.setCreated_date(dateFormat.format(date));
		Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(model);
		return model;
	}
		@Override
		public List<Model> getActiveModelList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Model> query = currentSession.createQuery("from Model m  where m.status='active'", Model.class);
			List<Model>modelList = query.getResultList();
			return modelList;
		}
		@Override
		public List<Model> getInActiveModelList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Model> query = currentSession.createQuery("from Model m  where m.status='inactive'", Model.class);
			List<Model>modelList = query.getResultList();
			return modelList;
		}
		@Override
		public Model getModelDetailsById(int modelId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Model brandDetails = currentSession.get(Model.class, modelId);
			return brandDetails;
		}
		@Transactional
		@Override
		public Model deleteModelById(int modelId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Model m SET m.status =:inactive  WHERE m.sk_model_id= : modelId");
			query.setParameter("modelId", modelId);
			query.setParameter("inactive","inactive");
	        int updateCount = query.executeUpdate();
	        Model modelDetails= new Model();
	        if(updateCount==1)
	        {
	        	modelDetails.setStatusCode("1");
	        	modelDetails.setStatusmessage("Deleted Successfully");
	        }
			return modelDetails;	
		}
		@Transactional
		@Override
		public Model restoreModelById(int modelId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Model m SET m.status =:active  WHERE m.sk_model_id= :modelId");
			query.setParameter("modelId", modelId);
			query.setParameter("active","active");
	        int updateCount = query.executeUpdate();
	        Model modeldetails= new Model();
	        if(updateCount==1)
	        {
	        	modeldetails.setStatusCode("1");
	        	modeldetails.setStatusmessage("Restored Successfully");
	        }
			return modeldetails;
		}
		@Override
		public Model checkModelExistOrNot(Model model, int brand_id, String model_name) {
			Session currentSession = entityManager.unwrap(Session.class);
		    Query query = currentSession.createQuery("select count(*),m.status from Model m where m.model_name=:modelName and m.brand_id=:brandId");
		    query.setParameter("modelName",model_name);  
		    query.setParameter("brandId",brand_id);  
		    List<Object[]> res = query.getResultList(); 
		    List<Model> list= new ArrayList<Model>(); 
		    Iterator it = res.iterator();
		    while(it.hasNext()){
		         Object[] line = (Object[]) it.next();
		         Model m = new Model();
		         m.setModel_status((long) line[0]);
		         m.setStatus((String) line[1]);
		         list.add(m);
		    }
		    Long count=list.get(0).getModel_status();
		    String status="";
		    try {
		    status=list.get(0).getStatus();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		    
		    Model modelDetails= new Model();
		    if(count==1 && status.equals("active"))
		    {
		    	modelDetails.setStatusCode("1");
		    	modelDetails.setStatus(status);
		    	modelDetails.setStatusmessage("Model already exist");
		    	return modelDetails;
		    }
		    else if(count==0 && status==null)
		    {

		    	modelDetails.setStatusCode("");
		    	modelDetails.setStatus("");
		    	modelDetails.setStatusmessage("");
		    	return modelDetails;
		    }
		    else 
		    {
		    	modelDetails.setStatusCode("0");
		    	modelDetails.setStatus(status);
		    	modelDetails.setStatusmessage("Model already exist in inactive state");
		    	return modelDetails;
		    }
		   
		    
		}
		/* Model Ends */
		
		/* Variant Starts */
		
		@Override
		public List<Model> getModelsByBrandIdbrand_id(String brand_id) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Model> query = currentSession.createQuery("Select m from Model m where m.brand_id='"+brand_id+"' and m.status='active'", Model.class);
			List<Model>modelList = query.getResultList();
			return modelList;
		}
		
		
		@Transactional
		@Override
		public Variant saveVariant(Variant variant, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			variant.setCreated_by(user_id);
			variant.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(variant);
			return variant;
		}
		
		@Override
		public List<Variant> getActiveVariantList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Variant> query = currentSession.createQuery("from Variant v  where v.status='active'", Variant.class);
			List<Variant>activeVariantList = query.getResultList();	
			return activeVariantList;
		}
		
		@Override
		public List<Variant> getInActiveVariantList() {
			
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Variant> query = currentSession.createQuery("from Variant v  where v.status='inactive'", Variant.class);
			List<Variant>inactiveVariantList = query.getResultList();
			return inactiveVariantList;
		}
		
		@Override
		public Variant getVariantDetailsById(int variantId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Variant variantDetails = currentSession.get(Variant.class, variantId);
			return variantDetails;
		}
		
		@Transactional
		@Override
		public Variant deleteVariantById(int variantId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Variant v SET v.status =:inactive  WHERE v.sk_variant_id= :variantId");
			query.setParameter("variantId", variantId);
			query.setParameter("inactive","inactive");
	        int updateCount = query.executeUpdate();
	        Variant variantDetails= new Variant();
	        if(updateCount==1)
	        {
	        	variantDetails.setStatusCode("1");
	        	variantDetails.setStatusmessage("Deleted Successfully");
	        }
			return variantDetails;
			
		}
		
		@Transactional
		@Override
		public Variant restoreVariantById(int variantId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Variant v SET v.status =:active  WHERE v.sk_variant_id= :variantId");
			query.setParameter("variantId", variantId);
			query.setParameter("active","active");
	        int updateCount = query.executeUpdate();
	        Variant variantDetails= new Variant();
	        if(updateCount==1)
	        {
	        	variantDetails.setStatusCode("1");
	        	variantDetails.setStatusmessage("Restored Successfully");
	        }
			return variantDetails;
		}
		
		@Override
		public Variant checkVariantExistOrNot(Variant variant, int brand_id, int model_id, String variant_name) {
			Session currentSession = entityManager.unwrap(Session.class);
		    Query query = currentSession.createQuery("select count(*)as variant_status,v.status from Variant v where v.variant_name=:variantName and v.brand_id=:brandId and v.model_id=:modelId");
		    query.setParameter("variantName",variant_name);  
		    query.setParameter("brandId",brand_id);
		    query.setParameter("modelId",model_id); 
		    List<Object[]> res = query.getResultList(); 
		    List<Variant> list= new ArrayList<Variant>(); 
		    Iterator it = res.iterator();
		    while(it.hasNext()){
		         Object[] line = (Object[]) it.next();
		         Variant v = new Variant();
		         System.out.println("variant"+line[0]);
		         System.out.println("variant one"+line[1]);
		         v.setVariant_status((long) line[0]);
		         v.setStatus((String) line[1]);
		         list.add(v);
		    }
		    Long count=list.get(0).getVariant_status();
		    String status="";
		    try {
		    status=list.get(0).getStatus();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		    
		    Variant variantDetails= new Variant();
		    if(count==1 && status.equals("active"))
		    {
		    	variantDetails.setStatusCode("1");
		    	variantDetails.setStatus(status);
		    	variantDetails.setStatusmessage("Variant already exist");
		    	return variantDetails;
		    }
		    else if(count==0 && status==null)
		    {

		    	variantDetails.setStatusCode("");
		    	variantDetails.setStatus("");
		    	variantDetails.setStatusmessage("");
		    	return variantDetails;
		    }
		    else 
		    {
		    	variantDetails.setStatusCode("0");
		    	variantDetails.setStatus(status);
		    	variantDetails.setStatusmessage("Variant already exist in inactive state");
		    	return variantDetails;
		    }
		   
		}
		
		
		/* Variant Ends */
		
		/* State Starts */
		
		@Transactional
		@Override
		public State saveState(State state, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			state.setCreated_by(user_id);
			state.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(state);
			return state;
			
		}
		@Override
		public List<State>getActiveStateList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<State> query = currentSession.createQuery("from State s  where s.status='active'", State.class);
			List<State>stateList = query.getResultList();
			return stateList;
		}	
		
		@Override
		public List<State>getInactiveStateList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<State> query = currentSession.createQuery("from State s  where s.status='inactive'", State.class);
			List<State>stateList = query.getResultList();
			return stateList;
		}
		@Override
		public State getStateDetailsById(int stateId) {
			Session currentSession = entityManager.unwrap(Session.class);
			State stateDetails = currentSession.get(State.class, stateId);
			return stateDetails;	
		}
		@Transactional
		@Override
		public State deleteStateById(int stateId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE State s SET s.status =:inactive  WHERE s.sk_state_id= :stateId");
			query.setParameter("stateId", stateId);
			query.setParameter("inactive","inactive");
	        int updateCount = query.executeUpdate();
	        State stateDetails= new State();
	        if(updateCount==1)
	        {
	        	stateDetails.setStatusCode("1");
	        	stateDetails.setStatusmessage("Deleted Successfully");
	        }
			return stateDetails;
		}
		@Transactional
		@Override
		public State restoreStateById(int stateId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE State s SET s.status =:active  WHERE s.sk_state_id= :stateId");
			query.setParameter("stateId", stateId);
			query.setParameter("active","active");
	        int updateCount = query.executeUpdate();
	        State stateDetails= new State();
	        if(updateCount==1)
	        {
	        	stateDetails.setStatusCode("1");
	        	stateDetails.setStatusmessage("Restored Successfully");
	        }
			return stateDetails;
			
		}
		@Override
		public State checkStateExistOrNot(State state, String state_name) {
			Session currentSession = entityManager.unwrap(Session.class);
		    Query query = currentSession.createQuery("select count(*),s.status from State s where s.state_name=:state_name");
		    query.setParameter("state_name",state_name);    
		    List<Object[]> res = query.getResultList(); 
		    List<State> list= new ArrayList<State>(); 
		    Iterator it = res.iterator();
		    while(it.hasNext()){
		         Object[] line = (Object[]) it.next();
		         State s = new State();
		         s.setState_status((long) line[0]);
		         s.setStatus((String) line[1]);
		         list.add(s);
		    }
		    Long count=list.get(0).getState_status();
		    String status="";
		    try {
		    status=list.get(0).getStatus();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		    
		    State stateDetails= new State();
		    if(count==1 && status.equals("active"))
		    {
		    	stateDetails.setStatusCode("1");
		    	stateDetails.setStatus(status);
		    	stateDetails.setStatusmessage("State already exist");
		    	return stateDetails;
		    }
		    else if(count==0 && status==null)
		    {

		    	stateDetails.setStatusCode("");
		    	stateDetails.setStatus("");
		    	stateDetails.setStatusmessage("");
		    	return stateDetails;
		    }
		    else 
		    {
	            stateDetails.setStatusCode("0");
	            stateDetails.setStatus(status);
	            stateDetails.setStatusmessage("state already exist in inactive state");
		    	return stateDetails;
		    }
		}
		

		/* State Ends */
		
		/* City Starts */
		
		@Transactional
		@Override
		public City saveCity(City city, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			city.setCreated_by(user_id);
			city.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(city);
			return city;
		}
		
		@Override
		public List<City> getActiveCityList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<City> query = currentSession.createQuery("from City c  where c.status='active'", City.class);
			List<City>activeCityList = query.getResultList();
			return activeCityList;	
		}
		
		
		@Override
		public List<City> getInactivecityList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<City> query = currentSession.createQuery("from City c  where c.status='inactive'", City.class);
			List<City>inactiveCityList = query.getResultList();
			return inactiveCityList;
		}
		
		@Override
		public City getCityDetailsById(int cityId) {
			Session currentSession = entityManager.unwrap(Session.class);
			City cityDetails = currentSession.get(City.class, cityId);
			return cityDetails;
		}
		@Transactional
		@Override
		public City deleteCityById(int cityId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE City c SET c.status =:inactive  WHERE c.sk_city_id= :cityId");
			query.setParameter("cityId", cityId);
			query.setParameter("inactive","inactive");
	        int updateCount = query.executeUpdate();
	        City cityDetails= new City();
	        if(updateCount==1)
	        {
	        	cityDetails.setStatusCode("1");
	        	cityDetails.setStatusmessage("Deleted Successfully");
	        }
			return cityDetails;	
		}
		@Transactional
		@Override
		public City restoreCityById(int cityId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE City c SET c.status =:active  WHERE c.sk_city_id= :cityId");
			query.setParameter("cityId", cityId);
			query.setParameter("active","active");
	        int updateCount = query.executeUpdate();
	        City cityDetails= new City();
	        if(updateCount==1)
	        {
	        	cityDetails.setStatusCode("1");
	        	cityDetails.setStatusmessage("Restored Successfully");
	        }
			return cityDetails;	
		}
		@Override
		public City checkCityExistOrNot(City city, int state_id, String city_name) {
			Session currentSession = entityManager.unwrap(Session.class);
		    Query query = currentSession.createQuery("select count(*),c.status from City c where c.city_name=:cityName and c.state_id=:stateId");
		    query.setParameter("cityName",city_name);  
		    query.setParameter("stateId",state_id);  
		    List<Object[]> res = query.getResultList(); 
		    List<City> list= new ArrayList<City>(); 
		    Iterator it = res.iterator();
		    while(it.hasNext()){
		         Object[] line = (Object[]) it.next();
		         City m = new City();
		         m.setCity_status((long) line[0]);
		         m.setStatus((String) line[1]);
		         list.add(m);
		    }
		    Long count=list.get(0).getCity_status();
		    String status="";
		    try {
		    status=list.get(0).getStatus();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		    
		    City cityDetails= new City();
		    if(count==1 && status.equals("active"))
		    {
		    	cityDetails.setStatusCode("1");
		    	cityDetails.setStatus(status);
		    	cityDetails.setStatusmessage("City already exist");
		    	return cityDetails;
		    }
		    else if(count==0 && status==null)
		    {

		    	cityDetails.setStatusCode("");
		    	cityDetails.setStatus("");
		    	cityDetails.setStatusmessage("");
		    	return cityDetails;
		    }
		    else 
		    {
		    	cityDetails.setStatusCode("0");
		    	cityDetails.setStatus(status);
		    	cityDetails.setStatusmessage("City already exist in inactive state");
		    	return cityDetails;
		    }
		   
		}
		
		/* City Ends */
		@Transactional
		@Override
		public Region saveRegion(Region region, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			region.setCreated_by(user_id);
			region.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(region);
			return region;
		}
		
		@Override
		public List<Region> getActiveRegionList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Region> query = currentSession.createQuery("from Region r where r.status='active'", Region.class);
			List<Region>activeRegionList = query.getResultList();
			for(Region r:activeRegionList)
			{
				
			}
			return activeRegionList;
			
		}
		
		@Transactional
		@Override
		public Section saveSection(Section section, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			section.setCreated_by(user_id);
			section.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(section);
			return section;
		}   
		@Override
		public List<Section> getActiveSectionList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Section> query = currentSession.createQuery("from Section s  where s.status='active'", Section.class);
			List<Section>sectionList = query.getResultList();
			return sectionList;
		}
		@Override
		public List<Section> getInactiveSectionList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Section> query = currentSession.createQuery("from Section s  where s.status='inactive'", Section.class);
			List<Section>sectionList = query.getResultList();
			return sectionList;
		}
		@Override
		public Section getSectionDetailsById(int sectionId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Section sectionDetails = currentSession.get(Section.class, sectionId);
			return sectionDetails;
		}
		@Transactional
		@Override
		public Section deleteSectionById(int sectionId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Section s SET s.status =:inactive  WHERE s.sk_section_id= :sectionId");
			query.setParameter("sectionId", sectionId);
			query.setParameter("inactive","inactive");
	        int updateCount = query.executeUpdate();
	        Section sectionDetails= new Section();
	        if(updateCount==1)
	        {
	        	sectionDetails.setStatusCode("1");
	        	sectionDetails.setStatusmessage("Deleted Successfully");
	        }
			return sectionDetails;	
		}
		@Transactional
		@Override
		public Section restoreSectionById(int sectionId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Section s SET s.status =:active  WHERE s.sk_section_id= :sectionId");
			query.setParameter("sectionId", sectionId);
			query.setParameter("active","active");
	        int updateCount = query.executeUpdate();
	        Section sectionDetails= new Section();
	        if(updateCount==1)
	        {
	        	sectionDetails.setStatusCode("1");
	        	sectionDetails.setStatusmessage("Restored Successfully");
	        }
			return sectionDetails;
		}
		@Override
		public Section checkSectionExistOrNot(Section section, String section_name) {
			Session currentSession = entityManager.unwrap(Session.class);
		    Query query = currentSession.createQuery("select count(*),s.status from Section s where s.section_name=:section_name");
		    query.setParameter("section_name",section_name);    
		    List<Object[]> res = query.getResultList(); 
		    List<Section> list= new ArrayList<Section>(); 
		    Iterator it = res.iterator();
		    while(it.hasNext()){
		         Object[] line = (Object[]) it.next();
		         Section s = new Section();
		         s.setSection_status((long) line[0]);
		         s.setStatus((String) line[1]);
		         list.add(s);
		    }
		    Long count=list.get(0).getSection_status();
		    String status="";
		    try {
		    status=list.get(0).getStatus();
		    }
		    catch (Exception e) {
				// TODO: handle exception
			}
		    Section sectionDetails= new Section();
		    if(count==1 && status.equals("active"))
		    {
		    	sectionDetails.setStatusCode("1");
		    	sectionDetails.setStatus(status);
		    	sectionDetails.setStatusmessage("Section already exist");
		    	return sectionDetails;
		    }
		    else if(count==0 && status==null)
		    {

		    	sectionDetails.setStatusCode("");
		    	sectionDetails.setStatus("");
		    	sectionDetails.setStatusmessage("");
		    	return sectionDetails;
		    }
		    else 
		    {
	            sectionDetails.setStatusCode("0");
		    	sectionDetails.setStatus(status);
		    	sectionDetails.setStatusmessage("Section already exist in inactive state");
		    	
		    	return sectionDetails;
		    }
		}
		@Transactional
		@Override
		public Subsection saveSubsection(Subsection subsection, HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession(true);
			int user_id=(int) session.getAttribute("userId");
			subsection.setCreated_by(user_id);
			subsection.setCreated_date(dateFormat.format(date));
			Session currentSession = entityManager.unwrap(Session.class);
	        currentSession.saveOrUpdate(subsection);
			return subsection;
		}
		    @Override
		    public List<Subsection> getActiveSubsectionList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Subsection> query = currentSession.createQuery("from Subsection s  where s.status='active'", Subsection.class);
			List<Subsection>subsectionList = query.getResultList();
			return subsectionList;
		}
		    
			@Override
			public List<Subsection> getinactiveSubsectionList() {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Subsection> query = currentSession.createQuery("from Subsection s  where s.status='inactive'", Subsection.class);
			List<Subsection>subsectionList = query.getResultList();
			return subsectionList;	
			}
			
			@Override
			public Subsection getSubsectionDetailsById(int subsectionId) {
				Session currentSession = entityManager.unwrap(Session.class);
				Subsection subsectionDetails = currentSession.get(Subsection.class, subsectionId);
				return subsectionDetails;
			}
			
			@Transactional
			@Override
			public Subsection deleteSubsectionById(int subsectionId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Subsection s SET s.status =:inactive  WHERE s.sk_subsection_id= :subsectionId");
			query.setParameter("subsectionId", subsectionId);
			query.setParameter("inactive","inactive");
		    int updateCount = query.executeUpdate();
		    Subsection subsectionDetails= new Subsection();
		    if(updateCount==1)
		     {
		    	subsectionDetails.setStatusCode("1");
		    	subsectionDetails.setStatusmessage("Deleted Successfully");
		     }
				return subsectionDetails;
			}
			
			@Transactional
			@Override
			public Subsection restoreSubsectionById(int subsectionId) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query query = currentSession.createQuery("UPDATE Subsection s SET s.status =:active  WHERE s.sk_subsection_id= :subsectionId");
			query.setParameter("subsectionId", subsectionId);
			query.setParameter("active","active");
		    int updateCount = query.executeUpdate();
		    Subsection subsectionDetails= new Subsection();
		    if(updateCount==1)
		      {
		    	    subsectionDetails.setStatusCode("1");
		    	    subsectionDetails.setStatusmessage("Restored Successfully");
		      }
				return subsectionDetails;
			}
			@Override
			public Subsection checkSubsectionExistOrNot(Subsection subsection,String subsection_name) {
				Session currentSession = entityManager.unwrap(Session.class);
			    Query query = currentSession.createQuery("select count(*),s.status from Subsection s where s.subsection_name=:subsection_name and s.section_id=:section_id");
			    query.setParameter("subsection_name",subsection_name);  
			    query.setParameter("section_id",subsection.getSection_id());  
			    List<Object[]> res = query.getResultList(); 
			    List<Subsection> list= new ArrayList<Subsection>(); 
			    Iterator it = res.iterator();
			    while(it.hasNext()){
			         Object[] line = (Object[]) it.next();
			         Subsection s = new Subsection();
			         s.setSubsection_status((long) line[0]);
			         s.setStatus((String) line[1]);
			         list.add(s);
			    }
			    Long count=list.get(0).getSubsection_status();
			    String status="";
			    try {
			    status=list.get(0).getStatus();
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			    
			    Subsection subsectionDetails= new Subsection();
			    if(count==1 && status.equals("active"))
			    {
			    	subsectionDetails.setStatusCode("1");
			    	subsectionDetails.setStatus(status);
			    	subsectionDetails.setStatusmessage("Subsection already exist");
			    	return subsectionDetails;
			    }
			    else if(count==0 && status==null)
			    {

			    	subsectionDetails.setStatusCode("");
			    	subsectionDetails.setStatus("");
			    	subsectionDetails.setStatusmessage("");
			    	return subsectionDetails;
			    }
			    else 
			    {
			    	subsectionDetails.setStatusCode("0");
			    	subsectionDetails.setStatus(status);
			    	subsectionDetails.setStatusmessage("Subsection already exist in inactive state");
			    	return subsectionDetails;
			    }
			}
			@Override
			public List<Region> getInActiveRegionList() {
				Session currentSession = entityManager.unwrap(Session.class);
				Query<Region> query = currentSession.createQuery("from Region r where r.status='inactive'", Region.class);
				List<Region>inactiveRegionList = query.getResultList();
				return inactiveRegionList;
			}
			@Override
			public Region getRegionDetailsById(int regionId) {
				Session currentSession = entityManager.unwrap(Session.class);
				Region regionDetails = currentSession.get(Region.class, regionId);
				return regionDetails;
			}
			@Transactional
			@Override
			public Region deleteRegionById(int regionId) {
				Session currentSession = entityManager.unwrap(Session.class);
				Query query = currentSession.createQuery("UPDATE Region r SET r.status =:inactive  WHERE r.sk_region_id= :regionId");
				query.setParameter("regionId", regionId);
				query.setParameter("inactive","inactive");
		        int updateCount = query.executeUpdate();
		        Region regionDetails= new Region();
		        if(updateCount==1)
		        {
		        	regionDetails.setStatusCode("1");
		        	regionDetails.setStatusmessage("Deleted Successfully");
		        }
				return regionDetails;	
			}
			@Transactional
			@Override
			public Region restoreRegionById(int regionId) {
				Session currentSession = entityManager.unwrap(Session.class);
				Query query = currentSession.createQuery("UPDATE Region r SET r.status =:active  WHERE r.sk_region_id= :regionId");
				query.setParameter("regionId", regionId);
				query.setParameter("active","active");
		        int updateCount = query.executeUpdate();
		        Region regionDetails= new Region();
		        if(updateCount==1)
		        {
		        	regionDetails.setStatusCode("1");
		        	regionDetails.setStatusmessage("Restored Successfully");
		        }
				return regionDetails;
			}
			@Override
			public Region checkRegionExistOrNot(Region region, int city_id, String region_name) {
				Session currentSession = entityManager.unwrap(Session.class);
			    Query query = currentSession.createQuery("select count(*),r.status from Region r where r.region_name=:region_name and r.city_id=:city_id");
			    query.setParameter("region_name",region_name);  
			    query.setParameter("city_id",city_id);  
			    List<Object[]> res = query.getResultList(); 
			    List<Region> list= new ArrayList<Region>(); 
			    Iterator it = res.iterator();
			    while(it.hasNext()){
			         Object[] line = (Object[]) it.next();
			         Region r = new Region();
			         r.setRegion_status((long) line[0]);
			         r.setStatus((String) line[1]);
			         list.add(r);
			    }
			    Long count=list.get(0).getRegion_status();
			    String status="";
			    try {
			    status=list.get(0).getStatus();
			    }
			    catch (Exception e) {
					// TODO: handle exception
				}
			    
			    Region regionDetails= new Region();
			    if(count==1 && status.equals("active"))
			    {
			    	regionDetails.setStatusCode("1");
			    	regionDetails.setStatus(status);
			    	regionDetails.setStatusmessage("Region already exist");
			    	return regionDetails;
			    }
			    else if(count==0 && status==null)
			    {

			    	regionDetails.setStatusCode("");
			    	regionDetails.setStatus("");
			    	regionDetails.setStatusmessage("");
			    	return regionDetails;
			    }
			    else 
			    {
			    	regionDetails.setStatusCode("0");
			    	regionDetails.setStatus(status);
			    	regionDetails.setStatusmessage("Region already exist in inactive state");
			    	return regionDetails;
			    }
			   
			}		
}
