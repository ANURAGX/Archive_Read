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

package drawnzer.anurag.rarHelper;


import com.github.junrar.rarfile.FileHeader;
import drawnzer.anurag.archiveread.Utils;


/**
 * 
 * @author Anurag
 *
 */
public class RarObj {
	
	String rarName;
	String rarPath;
	FileHeader fh;
	boolean isFile;
	String fileType;
	String headername;
	String size;
	
	
	public RarObj(FileHeader header, String name , String path ) {
		// TODO Auto-generated constructor stub
		if(header.isUnicode())
			this.headername = header.getFileNameW();
		else
			this.headername = header.getFileNameString();
		this.rarName = name;
		this.rarPath = path;
		this.fh = header;
		isFile = checkForFile();
		this.size = Utils.size(fh.getFullPackSize());
		fileType = Utils.getType(rarName, isFile);
	}

	/**
	 * 
	 * @return
	 */
	public String getFileName(){
		return this.rarName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPath(){
		if(this.rarPath.equalsIgnoreCase(""))
			return this.rarName;
		return this.rarPath+"\\"+this.rarName;
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
	public boolean isFile(){
		return this.isFile;
	}
	
	/**
	 * 
	 * @return
	 */
	public FileHeader getFileHeader(){
		return this.fh;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFileHeaderName(){
		return this.headername;
	}
	
	
	
	
	
	/**
	 * 
	 */
	public String getFileType(){
		return this.fileType;
	}
	
	
	private boolean checkForFile(){
		String str = headername.substring(rarPath.length(), headername.length());
		if(str.startsWith("\\"))
			str = str.substring(1, str.length());
		if(str.contains("\\"))
			return false;
		return true;
	}	
}
