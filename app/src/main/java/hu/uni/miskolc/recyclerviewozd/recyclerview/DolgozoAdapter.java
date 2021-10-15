package hu.uni.miskolc.recyclerviewozd.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hu.uni.miskolc.recyclerviewozd.R;
import hu.uni.miskolc.recyclerviewozd.model.Dolgozo;

public class DolgozoAdapter extends RecyclerView.Adapter<DolgozoViewHolder> {

    private final List<Dolgozo> dolgozok;
    private static ClickListener clickListener;

    public DolgozoAdapter(List<Dolgozo> dolgozok) {
        this.dolgozok = dolgozok;
    }

    @NonNull
    @Override
    public DolgozoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.dolgozosor, parent, false);
        DolgozoViewHolder vh = new DolgozoViewHolder(layout, clickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DolgozoViewHolder holder, int position) {
        Dolgozo dolgozo = dolgozok.get(position);
        holder.id.setText(String.valueOf(dolgozo.getId()));
        holder.vezeteknev.setText(dolgozo.getVezetekNev());
        holder.keresztnev.setText(dolgozo.getKeresztNev());


    }

    @Override
    public int getItemCount() {
        return dolgozok.size();
    }

    public void setOnItemClickListener(ClickListener listener){
        DolgozoAdapter.clickListener=listener;
    }

    public interface ClickListener{
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
