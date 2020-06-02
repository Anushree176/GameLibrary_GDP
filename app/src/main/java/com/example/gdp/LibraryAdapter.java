package com.example.gdp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> implements Filterable {

    public List<LibraryModel> libraryModels;
    private List<LibraryModel> libraryModelsFull;

    public  LibraryAdapter(List<LibraryModel>libraryModels){
        this.libraryModels = libraryModels;
        libraryModelsFull = new ArrayList<>(libraryModels);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView company;
        private TextView time;
        private ImageButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            company = itemView.findViewById(R.id.company);
            time = itemView.findViewById(R.id.last_played);
            button = itemView.findViewById(R.id.play_button);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(libraryModels.get(position).getImage());
        holder.title.setText(libraryModels.get(position).getTitle());
        holder.company.setText(libraryModels.get(position).getCompany());
        holder.time.setText(libraryModels.get(position).getTime());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Let's play " + libraryModels.get(position).getTitle() + "!" ,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return libraryModels.size();
    }

    @Override
    public Filter getFilter() {
        return libraryFilter;
    }

    private Filter libraryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            //Create new Array list to display the results
            List<LibraryModel> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filteredList.addAll(libraryModelsFull);
            }else{
                //Get the string - lowercase
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(LibraryModel item : libraryModelsFull){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            //pass these values to the publishResults below
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            libraryModels.clear();
            libraryModels.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };

}