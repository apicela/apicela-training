package com.apicela.training.utils;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.google.android.material.imageview.ShapeableImageView;

public class GifDrawableImageViewTarget extends ImageViewTarget<Drawable> {

    private int mLoopCount = GifDrawable.LOOP_FOREVER;

    public GifDrawableImageViewTarget(ShapeableImageView view, int loopCount) {
        super(view);
        mLoopCount = loopCount;
    }

    public GifDrawableImageViewTarget(ShapeableImageView view, int loopCount, boolean waitForLayout) {
        super(view, waitForLayout);
        mLoopCount = loopCount;
    }

    @Override
    protected void setResource(@Nullable Drawable resource) {
        if (resource instanceof GifDrawable) {
            ((GifDrawable) resource).setLoopCount(mLoopCount);
        }
        view.setImageDrawable(resource);
    }
}