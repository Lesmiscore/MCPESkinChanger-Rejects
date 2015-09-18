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
		link("selectSteve", "assets/images/mob/char.png");
		link("selectSteveN", "assets/images/mob/steve.png");
		link("selectAlexN", "assets/images/mob/alex.png");
		link("selectZombie", "assets/images/mob/zombie.png");
		link("selectZombiePigman", "assets/images/mob/pigzombie.png");
		link("selectCow", "assets/images/mob/cow.png");
		link("selectCreeper", "assets/images/mob/creeper.png");
		link("selectPig", "assets/images/mob/pig.png");
		link("selectSkeleton", "assets/images/mob/skeleton.png");
		link("selectSheep0", "assets/images/mob/sheep_0.png");
		link("selectSheep1", "assets/images/mob/sheep_1.png");
		link("selectSheep2", "assets/images/mob/sheep_2.png");
		link("selectSheep3", "assets/images/mob/sheep_3.png");
		link("selectSheep4", "assets/images/mob/sheep_4.png");
		link("selectSheep5", "assets/images/mob/sheep_5.png");
		link("selectSheep6", "assets/images/mob/sheep_6.png");
		link("selectSheep7", "assets/images/mob/sheep_7.png");
		link("selectSheep8", "assets/images/mob/sheep_8.png");
		link("selectSheep9", "assets/images/mob/sheep_9.png");
		link("selectSheep10", "assets/images/mob/sheep_10.png");
		link("selectSheep11", "assets/images/mob/sheep_11.png");
		link("selectSheep12", "assets/images/mob/sheep_12.png");
		link("selectSheep13", "assets/images/mob/sheep_13.png");
		link("selectSheep14", "assets/images/mob/sheep_14.png");
		link("selectSheep15", "assets/images/mob/sheep_15.png");
		
		link("selectGhastNormal", "assets/images/mob/ghast.png");
		link("selectGhastShooting", "assets/images/mob/ghast_shooting.png");
		link("selectSnowGolem", "assets/images/mob/snow_golem.png");
		link("selectIronGolem", "assets/images/mob/iron_golem.png");
		link("selectSquid", "assets/images/mob/squid.png");
		link("selectWolfNormal", "assets/images/mob/wolf.png");
		link("selectWolfAngry", "assets/images/mob/wolf_angry.png");
		link("selectBat", "assets/images/mob/bat.png");
		link("selectBlaze", "assets/images/mob/blaze.png");
		link("selectChicken", "assets/images/mob/chicken.png");
		link("selectMooshroom", "assets/images/mob/mooshroom.png");
		link("selectMagmaCube", "assets/images/mob/magmacube.png");
		link("selectSilverFish", "assets/images/mob/silverfish.png");
		link("selectSlime", "assets/images/mob/slime.png");
		link("selectWitherSkeleton", "assets/images/mob/wither_skeleton.png");
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
