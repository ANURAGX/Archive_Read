package drawnzer.anurag.archivereaddemo;

import java.io.File;

import drawnzer.anurag.archiveread.R;
import drawnzer.anurag.archiveread.Utils;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleAdapter extends BaseAdapter{

	Context ctx;
	LayoutInflater inflater;
	File[] list;
	public SimpleAdapter(Context ct , File[] files) {
		// TODO Auto-generated constructor stub
		ctx = ct;
		inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		list = files;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list[arg0];
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
		File rFile = list[pos];
		if(convertView == null){
			convertView = inflater.inflate(R.layout.row_list, arg2 , false);
			h.icon = (ImageView)convertView.findViewById(R.id.fileIcon);
			h.fName = (TextView)convertView.findViewById(R.id.fileName);
			h.fType = (TextView)convertView.findViewById(R.id.fileType);
			h.fSize = (TextView)convertView.findViewById(R.id.fileSize);
			convertView.setTag(h);
		}else
			h = (Holder) convertView.getTag();
		
		h.fName.setText(rFile.getName());
	//	h.fType.setText(rFile.getFileType());
		if(rFile.isFile())
			h.icon.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_launcher_unknown));
		else{
			h.icon.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_launcher_violet_folder));
			h.fSize.setVisibility(View.GONE);
		}
		if(rFile.isFile())
			h.fSize.setText(Utils.size(rFile.length()));
		return convertView;
	}

}
