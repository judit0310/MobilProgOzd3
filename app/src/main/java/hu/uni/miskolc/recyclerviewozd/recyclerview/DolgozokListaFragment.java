package hu.uni.miskolc.recyclerviewozd.recyclerview;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.uni.miskolc.recyclerviewozd.DolgozoDetails;
import hu.uni.miskolc.recyclerviewozd.R;
import hu.uni.miskolc.recyclerviewozd.model.Dolgozo;

public class DolgozokListaFragment extends Fragment {

    private DolgozoViewModel mViewModel;
    private DolgozoAdapter adapter;

    public static DolgozokListaFragment newInstance() {
        return new DolgozokListaFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dolgozo_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DolgozoViewModel.class);
        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), Configuration.ORIENTATION_PORTRAIT));
        mViewModel.getDolgozok().observe(getViewLifecycleOwner(), dolgozok ->{
            adapter = new DolgozoAdapter(dolgozok);
            recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new DolgozoAdapter.ClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    System.out.println("Kattintottam a következőkre: "+dolgozok.get(position));
                    Intent intent = new Intent(getContext(), DolgozoDetails.class);
                    intent.putExtra("selected", dolgozok.get(position));
                    startActivity(intent);
                }

                @Override
                public void onItemLongClick(int position, View v) {
                    System.out.println("hosszan kattintottam a következőkre: "+dolgozok.get(position));
                }
            });
        });

        // TODO: Use the ViewModel
    }

}