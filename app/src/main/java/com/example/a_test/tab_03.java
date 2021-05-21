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


public class tab_03 extends Fragment {


	private pet[] fruits = {
			new pet("Aletta", R.drawable.bird1),
			new pet("Elina", R.drawable.bird2),
			new pet("Elodie", R.drawable.bird3),
			new pet("Gina", R.drawable.bird4),
			new pet("Ishter", R.drawable.bird5),

	};
	private List<pet> petList = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.tab_03, null);

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