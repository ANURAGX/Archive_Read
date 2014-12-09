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

import java.io.File;
import java.util.zip.ZipException;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import drawnzer.anurag.archiveread.ReadArchive;
import drawnzer.anurag.tarHelper.TarObj;

/**
 * 
 * @author Anurag....
 *
 */
public class TarFragment extends Fragment{
	
	//main object holding the archive....
	private ReadArchive read_tar;
	
	//true if archive is opened....
	private boolean opened;
	
	private String tar_path = null;
	//sdcard path....
	private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
	
	public TarFragment() {
		// TODO Auto-generated constructor stub
		opened = false;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.ls, container , false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final ListView lsView = (ListView)view.findViewById(R.id.ls);
		lsView.setSelector(R.drawable.button_click);
		lsView.setAdapter(new FileAdapter(getActivity(), new File(path).listFiles()));
		
		lsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				// TODO Auto-generated method stub
				
				if(opened){
					//zip file already opened....
					//we are selecting sub files inside of zip file....
					
					//getting selected entry from list view....
					TarObj obj = (TarObj) lsView.getAdapter().getItem(arg2);
					
					//getting path of selected folder inside zip archive....
					tar_path = obj.getPath();
					
					if(obj.isFile()){
						// a files is selected inside of archive....
						Toast.makeText(getActivity(), "A file is selected....",
								Toast.LENGTH_SHORT).show();
					}else{
						//a folder is selected inside zip archive....
						//so further listing the selected folder....
						
						if(tar_path.startsWith("/"))
							tar_path = tar_path.substring(1 , tar_path.length());
						try {
							lsView.setAdapter(read_tar.getAdapter(tar_path, getActivity()));
						} catch (ZipException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getActivity(), "Something went wrong....",
									Toast.LENGTH_SHORT).show();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getActivity(), "Something went wrong....",
									Toast.LENGTH_SHORT).show();
						}
					}				
					return;
				}
				
				
				
				//folder or some file is selected....
				//getting the file....
				File getFile = (File) lsView.getAdapter().getItem(arg2);
				
				if(getFile.isDirectory()){
					//updating th path....
					path = path + "/" + getFile.getName();
					
					//updating the listview as per new path....
					lsView.setAdapter(new FileAdapter(getActivity(), new File(path).listFiles()));
				}else{
					//file is selected....
					if(getFile.getName().endsWith(".tar") || getFile.getName().endsWith(".tar.bz2")){
						//open the zip file....
						opened = true;
						read_tar = new ReadArchive(getFile);
						
						if(tar_path == null)
							tar_path = "/";
						
						try {
							lsView.setAdapter(read_tar.getAdapter(tar_path, getActivity()));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getActivity(), "Invalid tar file....",
									Toast.LENGTH_SHORT).show();
						}
					}else
						Toast.makeText(getActivity(), "Choose a tar file to open....",
								Toast.LENGTH_SHORT).show();
				}
			}
		});		
		lsView.setOnItemLongClickListener(null);		
	}	
}
