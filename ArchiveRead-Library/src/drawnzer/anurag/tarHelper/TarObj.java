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

package drawnzer.anurag.tarHelper;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import drawnzer.anurag.archiveread.Utils;

/**
 * 
 * @author ANURAG
 *
 */
public class TarObj {
	
	TarArchiveEntry ent;
	String name;
	String path;
	boolean isFile;
	String size;
	String type;
	public TarObj(TarArchiveEntry entry , String fname , String pname) {
		// TODO Auto-generated constructor stub
		this.ent = entry;
		this.name = fname;
		this.path = pname;
		this.isFile = checkForFile();
		this.size = Utils.size(entry.getSize());
		this.type = Utils.getType(this.name , isFile);
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
	public String getType(){
		return this.type;
	}
	

	/**
	 * 
	 * @return
	 */
	public String getPath(){
		if(path.equalsIgnoreCase(""))
			return this.name;
		return this.path+"/"+this.name;
	}
	
	/**
	 * 
	 * @return
	 */
	public TarArchiveEntry getEntry(){
		return this.ent;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEntryName(){
		return this.ent.getName();
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
	public String getSize(){
		return this.size;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean checkForFile(){
		String str = ent.getName().substring(path.length(), ent.getName().length());
		if(str.startsWith("/"))
			str = str.substring(1, str.length());
		if(str.contains("/"))
			return false;
		return true;
	}	
}
