package com.example.a_test;

import android.content.Context;
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


public class tab_01  extends Fragment {



	private pet[] mPets = {
			new pet("Boo",R.drawable.dog1),
			new pet("Esme",R.drawable.dog2),
			new pet("Nana",R.drawable.dog3),
			new pet("Aida",R.drawable.dog4),
			new pet("Doge",R.drawable.dog5),
	};

	private List<pet> petList = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.tab_01, null);

		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			int index = random.nextInt(mPets.length);
			petList.add(mPets[index]);
		}
		RecyclerView rl = (RecyclerView) view.findViewById(R.id.rl);
		GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
		rl.setLayoutManager(layoutManager);
		petAdapter adapter = new petAdapter(petList);
		rl.setAdapter(adapter);

		return view;

	}


}