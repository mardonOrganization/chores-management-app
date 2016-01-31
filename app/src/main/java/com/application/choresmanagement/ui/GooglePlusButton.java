package com.application.choresmanagement.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.Button;

import com.application.choresmanagement.R;


public class GooglePlusButton extends Button {
	
	private Paint textPaint;
	private String text;
	
	public GooglePlusButton(Context context) {
		super(context);
		init();
	}
	
	public GooglePlusButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public GooglePlusButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	public GooglePlusButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}
	
	public void init() {
		textPaint = new TextPaint();
		textPaint.setTextAlign(Paint.Align.CENTER);
		textPaint.setColor(getResources().getColor(android.R.color.white));
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(Typeface.DEFAULT_BOLD);
		
		text = getResources().getString(R.string.log_in);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		canvas.drawText(text, width/2, height/2, textPaint);
		
//		int measuredHeight = getMeasuredHeight();
//		int measuredWidth = getMeasuredWidth();
//		
//		int viewHeight = getHeight();
//		int viewWidth = getWidth();
		
		setHeight(100);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Paint getTextPaint() {
		return textPaint;
	}

	public void setTextPaint(Paint textPaint) {
		this.textPaint = textPaint;
	}

}
