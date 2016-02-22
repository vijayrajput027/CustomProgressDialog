package com.example.customprogressdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class CustomProgressDialog extends Dialog {

	private ImageView iv;
	private LayoutInflater layout_inflater;

	public CustomProgressDialog(Context context,int a) {
		super(context, R.style.TransparentProgressDialog);
		/*WindowManager.LayoutParams wlmp = getWindow().getAttributes();
		wlmp.gravity = Gravity.CENTER_HORIZONTAL;
		getWindow().setAttributes(wlmp);*/
		setTitle(null);
		setCancelable(false);
		setOnCancelListener(null);
		layout_inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rootView = layout_inflater.inflate(R.layout.spinner_layout, null);
		iv = (ImageView) rootView.findViewById(R.id.spinner_img_ring);
		setCanceledOnTouchOutside(false);
		setContentView(rootView);
	}

	@Override
	public void show() {
		super.show();
		RotateAnimation anim = new RotateAnimation(0.0f, 360.0f,
				Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF,
				.5f);
		anim.setInterpolator(new LinearInterpolator());
		anim.setRepeatCount(Animation.INFINITE);
		anim.setDuration(1800);
		iv.setAnimation(anim);
		iv.startAnimation(anim);
	}
}