package es.redmic.test.unit;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
