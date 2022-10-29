package com.jike.game2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

	public Card(Context context) {
		super(context);
		label = new TextView(getContext());
		label.setTextSize(32);
		label.setGravity(Gravity.CENTER);
		LayoutParams lp = new LayoutParams(-1,-1);
		addView(label,lp);
		
		setNum(0);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		//int转字符串，所以要加上
		label.setText(num+"");
	}

	
	public boolean equals(Card o) {
		// TODO Auto-generated method stub
		return getNum() == o.getNum();
	}


	private int num = 0;
	

	private TextView label;
}
