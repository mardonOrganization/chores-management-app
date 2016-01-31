package com.application.choresmanagement.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;


import com.application.choresmanagement.R;
import com.facebook.login.widget.LoginButton;

public class FacebookButton extends LoginButton {
	
	public FacebookButton(Context context) {
		super(context);
		setText(R.string.log_in);
	}
	
	
	public FacebookButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		setText(R.string.log_in);
	}
	
	public FacebookButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setText(R.string.log_in);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		setText(R.string.log_in);
		
		int measuredHeight = getMeasuredHeight();
		int measuredWidth = getMeasuredWidth();
		
		int height = getHeight();
		int width = getWidth();
		
		
	}

}
