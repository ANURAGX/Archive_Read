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

package drawnzer.anurag.archiveread;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;

import drawnzer.anurag.rarHelper.RarAdapter;
import drawnzer.anurag.rarHelper.RarManager;
import drawnzer.anurag.tarHelper.TarAdapter;
import drawnzer.anurag.tarHelper.TarManager;
import drawnzer.anurag.zipHelper.ZipAdapter;
import drawnzer.anurag.zipHelper.ZipManager;
import android.content.Context;
import android.widget.BaseAdapter;

public class ReadArchive {

	private File mainFile;
	private ZipManager zManager;
	private RarManager rManager;
	private TarManager tManager;
	
	/**
	 * 
	 * @param file pointing to zip file....
	 */
	public ReadArchive(File file) {
		// TODO Auto-generated constructor stub
		this.mainFile = file;
	}
	

	
	/**
	 * 
	 * @param path to show....
	 * @param context
	 * @return adapter for list view to show....
	 * @throws ZipException
	 * @throws IOException
	 * @throws RarException 
	 */
	public BaseAdapter getAdapter(String path , Context context) throws ZipException, IOException, RarException{
		if(mainFile.getName().endsWith(".zip")){
			zManager = new ZipManager(mainFile, path);
			return new ZipAdapter(zManager.generateList(), context);
		}			
		else if(mainFile.getName().endsWith(".rar")){
			rManager = new RarManager(new Archive(mainFile), path);
			return new RarAdapter(context, rManager.generateList());
		}else if(mainFile.getName().endsWith(".tar") || mainFile.getName().endsWith(".tar.bz2")){
			tManager = new TarManager(mainFile, path);
			return new TarAdapter(context, tManager.generateList());
		}
			return null;
	}
	
}
