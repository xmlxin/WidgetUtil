package com.xiaoxin.xmlxin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 使TextView可以滚动(跑马灯效果) 只需要滚动效果可以使用这个简单方便
 * @author xiaoxin
 *
 */
public class FocusedTextView extends TextView {

	public FocusedTextView(Context context) {
		super(context);
	}
	
	public FocusedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FocusedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	//重写父类的方法,欺骗系统 textview直接获取到焦点的.
	@Override
	public boolean isFocused() {
		return true;
	}

}
