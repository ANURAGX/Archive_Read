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

/**
 * 
 * @author Anurag
 *
 */
public class Utils {
	
	/**
	 * 
	 * @param Name file name
	 * @param isFile boolean for file or directory....
	 * @return
	 */
	public static String getType(String Name , boolean isFile){
		
		/*
		 * ITS DIRECTORY CHECK......
		 */
		if(!isFile)
			return "Directory";
		
		/*
		 * NOW FILE CHECK FOR THEIR TYPES....
		 */
		
		if(Name.endsWith("jpg")||Name.endsWith(".JPG")|| Name.endsWith(".png") || Name.endsWith(".PNG") || Name.endsWith(".gif") || Name.endsWith(".GIF")
				|| Name.endsWith(".JPEG") || Name.endsWith(".jpeg") ||Name.endsWith(".bmp") ||Name.endsWith(".BMP")){
			return "Image";
		}	
		else if(Name.endsWith(".zip") || Name.endsWith(".ZIP")){
			return "Zip";
		}	
		else if( Name.endsWith("mhtml")||Name.endsWith(".MHTML")||  Name.endsWith(".HTM") || Name.endsWith(".htm") 
				||Name.endsWith(".html") || Name.endsWith(".HTML")){
			return "Saved Page";
		}			
		else if(Name.endsWith(".tar") || Name.endsWith(".TAR") || Name.endsWith(".rar") 
				|| Name.endsWith("RAR") || Name.endsWith(".7z") || Name.endsWith(".7Z")
				||Name.endsWith(".gz") || Name.endsWith(".GZ")){
			return "Compressed Archive";
		}	
		else if(Name.endsWith(".apk") || Name.endsWith(".APK")){
			return "App";
		}	
		else if(Name.endsWith(".mp3") || Name.endsWith(".MP3") || Name.endsWith(".amr") || Name.endsWith(".AMR")
				|| Name.endsWith(".ogg") || Name.endsWith(".OGG")||Name.endsWith(".m4a")||Name.endsWith(".M4A")){
			return "Music";
		}	
		else if(Name.endsWith(".doc") ||Name.endsWith(".DOC")
				|| Name.endsWith(".DOCX") || Name.endsWith(".docx") || Name.endsWith(".ppt") || Name.endsWith(".PPT")){
			return "Document";
		}	
		else if(Name.endsWith(".txt") || Name.endsWith(".TXT") || Name.endsWith(".inf") || Name.endsWith(".INF")){
			return "Text";
		}	
		else if(Name.endsWith(".mp4") || Name.endsWith(".MP4") || Name.endsWith(".avi") ||Name.endsWith(".AVI")
				|| Name.endsWith(".FLV") || Name.endsWith(".flv") || Name.endsWith(".3GP") || Name.endsWith(".3gp")
				||Name.endsWith(".mkv") || Name.endsWith(".MKV")){
			return "Video";		
		}	
		else if(Name.endsWith(".default")||Name.endsWith(".prop")||Name.endsWith(".rc")||Name.endsWith(".sh")||Name.endsWith("init")){
			return "Script";
		}	
		
		return "Unknown";
	}
	

	
	
	/**
	 * 
	 * @param size
	 * @return
	 */
	public static String size(long size ){
		if(size>Constants.GB)
			return String.format("%.2f GB", (double)size/(Constants.GB));
		
		else if(size > Constants.MB)
			return String.format("%.2f MB", (double)size/(Constants.MB));
		
		else if(size>1024)
			return String.format("%.2f KB", (double)size/(1024));
		
		else
			return String.format("%f Bytes", (double)size);
	}

}
