package com.example.a_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class petAdapter extends RecyclerView.Adapter<petAdapter.ViewHolder> {

	private static final String TAG = "FruitAdapter";

	private Context mContext;

	private List<pet> mpetList;


	static class ViewHolder extends RecyclerView.ViewHolder {
		CardView cardView;
		ImageView fruitImage;
		TextView fruitName;

		public ViewHolder(View view) {
			super(view);
			cardView = (CardView) view;
			fruitImage = (ImageView) view.findViewById(R.id.pet_image);
			fruitName = (TextView) view.findViewById(R.id.pet_name);
		}
	}

	public petAdapter(List<pet> fruitList) {
		mpetList = fruitList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if (mContext == null) {
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
		final ViewHolder holder = new ViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		pet pet = mpetList.get(position);
		holder.fruitName.setText(pet.getName());
		Glide.with(mContext).load(pet.getImageId()).into(holder.fruitImage);
	}

	@Override
	public int getItemCount() {
		return mpetList.size();
	}

}

