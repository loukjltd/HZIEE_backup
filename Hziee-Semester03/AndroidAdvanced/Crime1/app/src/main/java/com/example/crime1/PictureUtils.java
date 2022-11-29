package com.example.crime1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class PictureUtils {
	public static Bitmap getScale(String path, int destWidth, int destHeight) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, options);
		
		float srcWidth = options.outWidth;
		float srcHeight = options.outHeight;
		
		int inSampleSize = 1;
		if (srcHeight > destHeight || srcWidth > destWidth) {
			float heightScale = srcHeight / destHeight;
			float widthScale = srcWidth / destWidth;
			
			inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);
		}
	}
}
