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

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter{

	private File[] ls = null;
	private LayoutInflater inf;
	private Drawable folder;
	private Drawable file;
	public FileAdapter(Context context , File[] list) {
		// TODO Auto-generated constructor stub
		inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ls = list;
		folder = context.getResources().getDrawable(R.drawable.ic_launcher_violet_folder);
		file = context.getResources().getDrawable(R.drawable.ic_launcher_unknown);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ls.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return ls[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	class hld{
		ImageView icn;
		TextView nam;
	}
	
	@Override
	public View getView(int arg0, View view, ViewGroup v) {
		// TODO Auto-generated method stub
		hld h = new hld();
		if(view == null){
			view = inf.inflate(R.layout.row_list, v , false);
			h.icn = (ImageView)view.findViewById(R.id.fileIcon);
			h.nam = (TextView)view.findViewById(R.id.fileName);
			view.setTag(h);
		}
		else
			h = (hld) view.getTag();
		
		if(ls[arg0].isDirectory())
			h.icn.setImageDrawable(folder);
		else
			h.icn.setImageDrawable(file);
		
		h.nam.setText(ls[arg0].getName());
		return view;
	}	
}
