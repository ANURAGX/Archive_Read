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


package drawnzer.anurag.zipHelper;
import java.util.zip.ZipEntry;
import drawnzer.anurag.archiveread.Utils;



/**
 * 
 * @author Anurag
 *
 */
public class ZipObj {

	private String path;
	private String name;
	private String entry;
	private String size;
	private boolean isFile;
	private String fileType;
	private ZipEntry z;
	
	/**
	 * 
	 * @param zPath
	 * @param zName
	 * @param zEntry
	 * @param zSize
	 * @param ctx
	 * @param entry
	 */
	public ZipObj(String zPath,String zName,String zEntry,long zSize , ZipEntry entry) {
		// TODO Auto-generated constructor stub
		this.path = zPath;
		this.name = zName;
		this.entry = zEntry;
		this.size = Utils.size(zSize);
		this.isFile = checkForFile();
		this.fileType = Utils.getType(name,isFile);
		this.z = entry;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPath(){
		String str = this.path + "/"+this.name;
		return str;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getEntry(){
		return this.entry;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSize(){
		return this.size;
	}
	
	public String getFileType(){
		return this.fileType;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFile(){
		return this.isFile;
	}
	
	/**
	 * 
	 * @return
	 */
	public ZipEntry getZipEntry(){
		return this.z;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean checkForFile(){
		String str = entry.substring(path.length(), entry.length());
		if(str.startsWith("/"))
			str = str.substring(1, str.length());
		if(str.contains("/"))
			return false;
		return true;
	}
	
		
}
