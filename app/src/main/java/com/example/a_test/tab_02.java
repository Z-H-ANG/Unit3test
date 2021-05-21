package com.example.a_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class tab_02 extends Fragment {



	private pet[] fruits = {
			new pet("kira", R.drawable.cat1),
			new pet("Demi", R.drawable.cat2),
			new pet("Kimi", R.drawable.cat3),
			new pet("Juno", R.drawable.cat4),
			new pet("Sera", R.drawable.cat5),


	};
	private List<pet> petList = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.tab_02, null);

		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int index = random.nextInt(fruits.length);
			petList.add(fruits[index]);
		}
		RecyclerView rl = (RecyclerView) view.findViewById(R.id.rl);
		GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
		rl.setLayoutManager(layoutManager);
		petAdapter adapter = new petAdapter(petList);
		rl.setAdapter(adapter);

		return view;

	}


}