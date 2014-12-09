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

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import drawnzer.anurag.archiveread.R;

/**
 * 
 * @author Anurag
 *
 */
public class RarAdapter extends BaseAdapter{

	RarObj rFile;
	Context ctx;
	ArrayList<RarObj> list;
	LayoutInflater inflater;
	
	public RarAdapter(Context cont , ArrayList<RarObj> ls) {
		// TODO Auto-generated constructor stub
		ctx = cont;
		list = ls;
		inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	class Holder{
		ImageView icon;
		TextView fName;
		TextView fType;
		TextView fSize;
	}
	@Override
	public View getView(int pos, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder h = new Holder(); 
		rFile = list.get(pos);
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_list, arg2 , false);
			h.icon = (ImageView)convertView.findViewById(R.id.fileIcon);
			h.fName = (TextView)convertView.findViewById(R.id.fileName);
			h.fType = (TextView)convertView.findViewById(R.id.fileType);
			h.fSize = (TextView)convertView.findViewById(R.id.fileSize);
			convertView.setTag(h);
		}else
			h = (Holder) convertView.getTag();
		
		h.fName.setText(rFile.getFileName());
		h.fType.setText(rFile.getFileType());
		if(rFile.isFile())
			h.icon.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_launcher_unknown));
		else{
			h.icon.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_launcher_violet_folder));
			h.fSize.setVisibility(View.GONE);
		}h.fSize.setText(rFile.getSize());
		return convertView;
	}
}
