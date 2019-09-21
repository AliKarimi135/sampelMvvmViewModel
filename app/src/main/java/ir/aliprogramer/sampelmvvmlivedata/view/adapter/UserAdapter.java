package ir.aliprogramer.sampelmvvmlivedata.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.aliprogramer.sampelmvvmlivedata.R;
import ir.aliprogramer.sampelmvvmlivedata.mode.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    List<User>userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(userList.get(position).getName());
        holder.city.setText(userList.get(position).getCity());
        holder.mobile.setText(userList.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,mobile,city;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            mobile=itemView.findViewById(R.id.mobile);
            city=itemView.findViewById(R.id.city);
        }
    }
}
