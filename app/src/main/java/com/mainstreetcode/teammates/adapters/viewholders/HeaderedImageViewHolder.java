package com.mainstreetcode.teammates.adapters.viewholders;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.mainstreetcode.teammates.R;
import com.mainstreetcode.teammates.fragments.headless.ImageWorkerFragment;
import com.mainstreetcode.teammates.model.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;

public class HeaderedImageViewHolder extends BaseItemViewHolder<ImageWorkerFragment.ImagePickerListener>
        implements View.OnClickListener {

    private ImageView picture;

    public HeaderedImageViewHolder(View itemView, ImageWorkerFragment.ImagePickerListener listener) {
        super(itemView, listener);
        picture = itemView.findViewById(R.id.image);
        picture.setOnClickListener(this);
    }

    @Override
    public void bind(Item item) {
        String pathOrUrl = item.getValue();

        if (!TextUtils.isEmpty(pathOrUrl)) {
            File file = new File(pathOrUrl);
            Picasso picasso = Picasso.with(itemView.getContext());
            RequestCreator creator = file.exists() ? picasso.load(file) : picasso.load(pathOrUrl);

            creator.fit().centerCrop().into(picture);
        }
    }

    @Override
    public void onClick(View view) {
        adapterListener.onImageClick();
    }

    public ImageView getPicture() {
        return picture;
    }
}