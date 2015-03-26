package com.xllyll.searchbartext;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		final Button bt = (Button)this.findViewById(R.id.button1);
//		/** 设置位移动画 向右位移150 */ 
//		final TranslateAnimation animation = new TranslateAnimation(0, 150,0, 0); 
//		animation.setDuration(2000);//设置动画持续时间 
//		animation.setRepeatCount(2);//设置重复次数 
//		animation.setRepeatMode(Animation.REVERSE);//设置反方向执行 
//		
//		bt.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				/** 开始动画 */ 
//				bt.setAnimation(animation);
//				animation.startNow(); 
//			}
//		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
