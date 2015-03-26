package com.xllyll.searchbartext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SearchBarText extends AbsoluteLayout {
	EditText editText = null;
	ImageButton searchButton = null;
	Button cancelButton = null;
	SearchImageView imageView = null;
	Boolean isFirst = true;
	Boolean isEdit = true;
	@SuppressWarnings("deprecation")
	public SearchBarText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		//this.setBackgroundColor(0X8888888);
		ViewTreeObserver vto = this.getViewTreeObserver();
		
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
            public boolean onPreDraw()
            {
            	if(isFirst == true)
            	{
            		isFirst = false;
            		int height = SearchBarText.this.getMeasuredHeight();
                    int width = SearchBarText.this.getMeasuredWidth();
                    System.out.println(width+"*******"+height);
                    createView(width, height);
            	}
                return true;
            }
        });
		
	}
    @SuppressWarnings("deprecation")
	public void  createView(int w,int h) {
    	/** 设置位移动画 向右位移150 */ 
    	final int X = w - h;
    	final int H = h;
    	final TranslateAnimation animation = new TranslateAnimation(0,150,0, 0); 
    	animation.setDuration(2000);//设置动画持续时间 
    	animation.setRepeatCount(1);//设置重复次数 
    	animation.setRepeatMode(Animation.REVERSE);//设置反方向执行
    	

    	AbsoluteLayout.LayoutParams param1 = new AbsoluteLayout.LayoutParams(w, H,0, 0);
		editText = new EditText(getContext());
		editText.setLayoutParams(param1);
		editText.setVisibility(View.INVISIBLE);
		//给编辑框添加文本改变事件
		editText.addTextChangedListener(new MyTextWatcher());
		editText.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_preference_single_normal));
		SearchBarText.this.addView(editText);
    	
		imageView = new SearchImageView(getContext());
		AbsoluteLayout.LayoutParams imageParam1 = new AbsoluteLayout.LayoutParams(H, H,X-20, 0);
		imageView.setLayoutParams(imageParam1);
		imageView.setVisibility(View.INVISIBLE);
		this.addView(imageView);
		
		cancelButton = new Button(getContext());
		//AbsoluteLayout.LayoutParams imageParam1 = new AbsoluteLayout.LayoutParams(H, H,X-20, 0);
		cancelButton.setLayoutParams(imageParam1);
		cancelButton.setVisibility(View.INVISIBLE);
		cancelButton.setBackgroundColor(0X00000000);
		cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("清楚文字");
				editText.setText("");
			}
		});
		this.addView(cancelButton);
		
    	AbsoluteLayout.LayoutParams param = new AbsoluteLayout.LayoutParams(h, h, 0, 0);
    	searchButton = new ImageButton(getContext());
		searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_blue));
		searchButton.setLayoutParams(param);
		searchButton.setBackgroundColor(0X00000000);
		//searchButton.setScaleType(ImageView.ScaleType.FIT_XY);
		this.addView(searchButton);
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				System.out.println("开始动画");
//				searchButton.setAnimation(animation);
				animation.startNow(); 
				if(isEdit == true){
					isEdit = false;
					editText.setVisibility(View.VISIBLE);
					AbsoluteLayout.LayoutParams param2 = new AbsoluteLayout.LayoutParams(H, H,X-20, 0);
					searchButton.setLayoutParams(param2);
				}else{
					isEdit = true;
					editText.setVisibility(View.INVISIBLE);
					AbsoluteLayout.LayoutParams param = new AbsoluteLayout.LayoutParams(H, H , 20, 0);
					searchButton.setLayoutParams(param);
				}
			}
		});
		
	}
  //文本观察者
  	private class MyTextWatcher implements TextWatcher {

  		@Override
  		public void afterTextChanged(Editable s) {
  			// TODO Auto-generated method stub
  			
  		}

  		@Override
  		public void beforeTextChanged(CharSequence s, int start, int count,
  				int after) {
  			// TODO Auto-generated method stub
  			
  		}
  		//当文本改变时候的操作
  		@Override
  		public void onTextChanged(CharSequence s, int start, int before,
  				int count) {
  			// TODO Auto-generated method stub
  			//如果编辑框中文本的长度大于0就显示删除按钮否则不显示
  			System.out.println(s.length());
  			if(s.length() > 0){
  				//ib_searchtext_delete.setVisibility(View.VISIBLE);
  				imageView.setVisibility(View.VISIBLE);
  				cancelButton.setVisibility(View.VISIBLE);
  				searchButton.setVisibility(View.INVISIBLE);
  			}else{
  				imageView.setVisibility(View.INVISIBLE);
  				cancelButton.setVisibility(View.INVISIBLE);
  				searchButton.setVisibility(View.VISIBLE);
  			}
  		}
  		
  	}
}

@SuppressWarnings("deprecation")
class SearchImageView extends AbsoluteLayout {
	public ImageView brugundImageView = null;
	public ImageView ImageView1 = null;
	public ImageView ImageView2 = null;
	public Button button = null;
	Boolean isFirst = true;
	public SearchImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		ViewTreeObserver vto = this.getViewTreeObserver();
		
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
            public boolean onPreDraw()
            {
            	if(isFirst == true)
            	{
            		isFirst = false;
            		int height = SearchImageView.this.getMeasuredHeight();
                    int width = SearchImageView.this.getMeasuredWidth();
                    System.out.println(width+"***22***"+height);
                    createView(width, height);
            	}
                return true;
            }
        });
	}
	public void createView(int w,int h){
		AbsoluteLayout.LayoutParams param1 = new AbsoluteLayout.LayoutParams(w/4*3, h/4*3,(w -w/4*3)/2, (h -h/4*3)/2);
		brugundImageView = new ImageView(getContext());
		brugundImageView.setImageDrawable(getResources().getDrawable(R.drawable.search_circle_blue));
		brugundImageView.setLayoutParams(param1);
		brugundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
		this.addView(brugundImageView);
		AbsoluteLayout.LayoutParams param2 = new AbsoluteLayout.LayoutParams(w/4*3/6*4, h/4*3/6*4,(w -w/4*3)/2+w/4*3/6, (h -h/4*3)/2+w/4*3/6);
		ImageView1 = new ImageView(getContext());
		ImageView1.setImageDrawable(getResources().getDrawable(R.drawable.searchbar_blueright));
		ImageView1.setLayoutParams(param2);
		ImageView1.setScaleType(ImageView.ScaleType.FIT_XY);
		this.addView(ImageView1);
		
		ImageView2 = new ImageView(getContext());
		ImageView2.setImageDrawable(getResources().getDrawable(R.drawable.searchbar_bluerleft));
		ImageView2.setLayoutParams(param2);
		ImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
		this.addView(ImageView2);
		
		button = new Button(getContext());
		button.setLayoutParams(param1);
		button.setBackgroundColor(0X00000000);
		this.addView(button);
	}
	
	
}
