package com.nao20010128nao.MCPE.SC;

import android.content.*;
import android.net.*;
import android.os.*;
import com.nao20010128nao.MCPE.SC.misc.*;
import com.nao20010128nao.MC_PE.SkinChanger.REJECTED.*;
import com.nao20010128nao.ToolBox.HandledPreference.*;
import java.lang.ref.*;

public class MainActivity extends SHablePreferenceActivity {
	public static WeakReference<MainActivity> instance=new WeakReference<>(null);
	static boolean preventStart=false;
	String changeTmp=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		instance = new WeakReference<MainActivity>(this);
       	addPreferencesFromResource(R.xml.pref_main);
		/*Rejected changes*/
		
		/*Rejected changes END*/
		sH("openPlayStore",new OnClickListener(){
				public void onClick(String p1, String p2, String p3) {
					startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName())),getResources().getString(R.string.openPlayStore)));
				}
			});
    }
	void selectFileForSkin(String name){
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/png");
		changeTmp = name;
		startActivityForResult(intent, 123);
	}
	void link(String pref,String name){
		sH(pref,createListenerForPerf(name));
	}
	OnClickListener createListenerForPerf(final String name){
		return new OnClickListener(){
			public void onClick(String p1, String p2, String p3) {
				selectFileForSkin(name);
			}
		};
	}
}
