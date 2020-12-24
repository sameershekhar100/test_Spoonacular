package com.example.food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class  adaptar extends RecyclerView.Adapter<viewholder> {
    ArrayList<food> items=new ArrayList<>();

    private final itemClicked listener;

    public adaptar( itemClicked listener) {

        this.listener = listener;
    }


     @NonNull
     @Override
     public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        viewholder v1=new viewholder(view);

        view.setOnClickListener(v -> {
             String s= items.get(v1.getAdapterPosition()).gettitle();
             listener.onitemClicked(s);
        });
         return v1;
     }




     @Override
     public int getItemCount() {

         return items.size();
     }
     void updatefood(ArrayList<food> f){
        items.clear();
        items.addAll(f);
        notifyDataSetChanged();

     }
    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        food currentItem=items.get(position);
        holder.titleView.setText(currentItem.gettitle());
        Glide.with(holder.itemView.getContext()).load(currentItem.getImageUrlUrl()).into(holder.imageView);
        holder.missed.setText(currentItem.getMissed_ind());

        holder.t.setOnClickListener(v ->
                holder.missed.setVisibility(View.VISIBLE));
    }

}
    class viewholder extends RecyclerView.ViewHolder{
        TextView titleView;
        ImageView imageView;
        TextView missed;

        TextView t;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
             titleView=itemView.findViewById(R.id.title);
            missed=itemView.findViewById(R.id.missed_ind);
            t=itemView.findViewById(R.id.aa);
    }


}
interface itemClicked{
    void onitemClicked(String item);
}
