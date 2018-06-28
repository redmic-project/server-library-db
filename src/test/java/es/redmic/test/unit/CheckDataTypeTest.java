package es.redmic.test.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import es.redmic.db.administrative.model.Activity;
import es.redmic.db.administrative.service.ActivityService;
import es.redmic.db.geodata.tracking.platform.service.PlatformTrackingService;
import es.redmic.db.maintenance.administrative.model.ActivityType;
import es.redmic.exception.databinding.DataTypeNotValidException;

@RunWith(MockitoJUnitRunner.class)
public class CheckDataTypeTest {
	
	@InjectMocks
	PlatformTrackingService platformTrackingService;

	@Mock
	ActivityService activityService;
	
	Activity activity;
	
	@Before
	public void setupTest() {
		
		MockitoAnnotations.initMocks(this);
		
		activity = new Activity();

		ActivityType activityType = new ActivityType();
		activity.setActivityType(activityType);
		
		when(activityService.update(any())).thenReturn(null);
		when(activityService.findById(any())).thenReturn(activity);
	}
	
	@Test(expected = DataTypeNotValidException.class)
	public void checkDataType_ThrowExpection_IfActivityCategoryIsNotValid() throws Exception {
		activity.setActivityCategory("at");
		activity.getActivityType().setId(7L);
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
	}
	
	@Test(expected = DataTypeNotValidException.class)
	public void checkDataType_ThrowExpection_IfActivityTypeIsNotValid() throws Exception {
		activity.setActivityCategory("pt");
		activity.getActivityType().setId(17L);
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
	}
	
	@Test(expected = DataTypeNotValidException.class)
	public void checkDataType_ThrowExpection_IfActivityTypeAndActivityCategoryAreNotValid() throws Exception {
		activity.setActivityCategory("at");
		activity.getActivityType().setId(17L);
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
	}
	
	@Test
	public void checkDataType_NotThrowExpection_IfActivityTypeValidAndActivityCategoryIsNotSet() throws Exception {

		activity.getActivityType().setId(7L);
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
	}
	
	@Test
	public void checkDataType_NotThrowExpection_IfActivityTypeAndActivityCategoryAreValid() throws Exception {
		activity.setActivityCategory("pt");
		activity.getActivityType().setId(7L);
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
	}
	
	@Test
	public void checkDataType_SaveActivityCategory_IfActivityTypeAreValidAndActivityCategoryIsNotSaved() throws Exception {
		//activity.setActivityCategory("pt");
		activity.getActivityType().setId(7L);
		
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
		verify(activityService, times(1)).update(any());
	}
	
	@Test
	public void checkDataType_NoSaveActivityCategory_IfActivityTypeAndActivityCategoryAreValid() throws Exception {
		activity.setActivityCategory("pt");
		activity.getActivityType().setId(7L);
		
		Whitebox.invokeMethod(platformTrackingService, "checkDataType", "2");
		verify(activityService, times(0)).update(any());
	}
}