package com.example.mvvm.adaptar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm.R;
import com.example.mvvm.model.User;

public class UserAdaptar extends RecyclerView.Adapter<UserAdaptar.UserViewHoldar> {
    User[] users;

    public UserAdaptar(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHoldar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.userlist,parent,false);

        return new UserViewHoldar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoldar holder, int position) {
        holder.txt1.setText("Name:"+users[position].getLogin());
        holder.txt2.setText("Id:"+String.valueOf(users[position].getId()));
        holder.txt3.setText("Type:"+users[position].getType());
        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHoldar extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txt1,txt2,txt3;

        public UserViewHoldar(@NonNull View itemView) {
            super(itemView);
             imageView=itemView.findViewById(R.id.imageViewUser);
             txt1=itemView.findViewById(R.id.textView);
             txt2=itemView.findViewById(R.id.textView2);
             txt3=itemView.findViewById(R.id.textView3);

        }
    }
}
