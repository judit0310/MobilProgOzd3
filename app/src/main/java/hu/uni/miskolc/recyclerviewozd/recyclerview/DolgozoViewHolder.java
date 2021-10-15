package hu.uni.miskolc.recyclerviewozd.recyclerview;

import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import hu.uni.miskolc.recyclerviewozd.R;

public class DolgozoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    TextView id;
    TextView keresztnev;
    TextView vezeteknev;
    DolgozoAdapter.ClickListener clickListener;

    public DolgozoViewHolder(LinearLayout v, DolgozoAdapter.ClickListener listener) {
        super(v);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        id = v.findViewById(R.id.id);
        keresztnev = v.findViewById(R.id.keresztnev);
        vezeteknev = v.findViewById(R.id.vezeteknev);
        this.clickListener=listener;
        // inicializalni a viewkat
    }

    @Override
    public void onClick(View view) {
        clickListener.onItemClick(getAdapterPosition(), view);
    }

    @Override
    public boolean onLongClick(View view) {
        clickListener.onItemLongClick(getAdapterPosition(), view);
        return false;
    }
}
