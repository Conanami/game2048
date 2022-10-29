package com.jike.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

public class GameView extends GridLayout {

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.initGameView();
	}

	public GameView(Context context) {
		super(context);
		this.initGameView();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.initGameView();
	}
	
	private void initGameView()
	{
		setColumnCount(4);
		setBackgroundColor(0xffbbada0);
		setOnTouchListener(new View.OnTouchListener() {
			//��ָ����ʱ���X��Y��X��Y���˶�ֵ
			private float startX,startY,offsetX,offsetY;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction())
				{
					case MotionEvent.ACTION_DOWN:
						startX=event.getX();
						startY=event.getY();
						break;
					case MotionEvent.ACTION_UP:
						offsetX=event.getX()-startX;
						offsetY=event.getY()-startY;
						//���ж��Ƿ�ˮƽ�����ƶ�
						if(Math.abs(offsetX)>Math.abs(offsetY))
						{
							if(offsetX<-5)    //�����ƶ� 
							{
								swipeLeft();
							}
							else if(offsetX>5)   //�����ƶ�
							{
								swipeRight();
							}
						}
						else   //�����Ǵ�ֱ������ƶ�
						{
							if(offsetY<-5)    //�����ƶ� 
							{
								swipeUp();
							}
							else if(offsetY>5)   //�����ƶ�
							{
								swipeDown();
							}
						}
						break;
				}
				return true;
			}
		});
		
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		int cardwidth = (Math.min(w, h)-10)/4;
		addCards(cardwidth,cardwidth);
	}

	private void addCards(int cardWidth,int cardHeight)
	{
		Card c;
		for(int y=0;y<4;++y)
			for(int x=0;x<4;++x)
			{
				c = new Card(getContext());
				c.setNum(2);
				addView(c,cardWidth,cardHeight);
			}
	}
	
	private void swipeLeft()
	{
		System.out.println("�����ƶ�");
	}
	
	private void swipeRight()
	{
		System.out.println("�����ƶ�");
	}
	
	private void swipeUp()
	{
		System.out.println("�����ƶ�");
	}
	
	private void swipeDown()
	{
		System.out.println("�����ƶ�");
	}
}
