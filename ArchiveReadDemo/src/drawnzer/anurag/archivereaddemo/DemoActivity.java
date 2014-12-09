/**
 * Copyright(c) 2014 DRAWNZER.ORG PROJECTS -> ANURAG
 * 
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
 *                             
 *                             anurag.dev1512@gmail.com
 *
 */
package drawnzer.anurag.archivereaddemo;

import com.astuetz.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


/**
 * 
 * @author Aanurag....
 *
 */
public class DemoActivity extends FragmentActivity{

	private DemoFragment fragment;
	private ViewPager pager;
	private PagerSlidingTabStrip indicator;  
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.main);
		pager = (ViewPager)findViewById(R.id.pager);
		indicator = (PagerSlidingTabStrip)findViewById(R.id.indicator);
		
		fragment = new DemoFragment(getSupportFragmentManager());
		pager.setAdapter(fragment);
		indicator.setViewPager(pager);
	}	
}
