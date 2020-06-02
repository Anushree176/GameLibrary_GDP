package com.example.gdp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.library_fragment, container, false);
        recyclerView = view.findViewById(R.id.library_recycler);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        List<LibraryModel> libraryModels = new ArrayList<>();
        libraryModels.add(new LibraryModel(R.drawable.pacman, "Pacman","Google","Played 2 days ago"));
        libraryModels.add(new LibraryModel(R.drawable.chess, "Chess", "CanaryDroid","Installed 5 May 2020"));
        libraryModels.add(new LibraryModel(R.drawable.sudoku, "Sudoku", "MicroDS","Played 1 hour ago"));
        libraryModels.add(new LibraryModel(R.drawable.angrybirds, "Angry Birds", "Google","Played 4 days ago"));
        libraryModels.add(new LibraryModel(R.drawable.mahjong, "Mahjong", "CanaryDroid","Installed 22 May 2020"));
        libraryModels.add(new LibraryModel(R.drawable.freeflow, "Free Flow", "Events Pvt.","Played 30 mins ago"));
        libraryModels.add(new LibraryModel(R.drawable._2048, "2048", "Games Co.","Played 5 days ago"));
        libraryModels.add(new LibraryModel(R.drawable.crossword, "Crossword", "WEST Ltd.","Played 45 mins ago"));
        libraryModels.add(new LibraryModel(R.drawable.flappybird, "Flappy Bird", "CanaryDroid","Played 10 days ago"));
        libraryModels.add(new LibraryModel(R.drawable._null, "Game9", "lmno","Installed 22 March 2020"));
        libraryModels.add(new LibraryModel(R.drawable._null, "Game10", "aaaa","Installed 29 March 2020"));
        libraryModels.add(new LibraryModel(R.drawable._null, "Game11", "aaaa","Installed 9 April 2020"));
        libraryModels.add(new LibraryModel(R.drawable._null, "Game12", "aaaa","Installed 17 April 2020"));
        libraryModels.add(new LibraryModel(R.drawable._null, "Game13", "aaaa","Installed 3 May 2020"));


        LibraryAdapter adapter = new LibraryAdapter(libraryModels);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}

