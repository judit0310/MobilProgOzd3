package hu.uni.miskolc.recyclerviewozd.recyclerview;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.List;

import hu.uni.miskolc.recyclerviewozd.model.Dolgozo;
import hu.uni.miskolc.recyclerviewozd.service.DolgozoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DolgozoViewModel extends ViewModel {


    private MutableLiveData<List<Dolgozo>> dolgozok;


    public LiveData<List<Dolgozo>> getDolgozok(){
        if (dolgozok == null){
            dolgozok = new MutableLiveData<List<Dolgozo>>();
            loadDolgozok();
        }
        return dolgozok;
    }


    private void loadDolgozok() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl
                ("https://my-json-server.typicode.com/judit0310/dummyJsonServer/").
                addConverterFactory(GsonConverterFactory.create()).build();


        DolgozoService service = retrofit.create(DolgozoService.class);

        Call<List<Dolgozo>> call = service.dolgozokListazasa();
        call.enqueue(new Callback<List<Dolgozo>>() {
            @Override
            public void onResponse(Call<List<Dolgozo>> call, Response<List<Dolgozo>> response) {
                System.out.println("");
                dolgozok.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Dolgozo>> call, Throwable t) {

            }
        });

    }

}