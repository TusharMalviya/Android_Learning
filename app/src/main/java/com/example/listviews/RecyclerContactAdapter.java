package com.example.listviews;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    @NonNull
    Context context;
    ArrayList<ContactModel> arrContacts;

    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts= arrContacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        holder.row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView edtTitle = dialog.findViewById(R.id.edtTitle);

                edtTitle.setText("UPDATE CONTACT");
                btnAction.setText("Update");

                edtName.setText(arrContacts.get(position).name);
                edtNumber.setText(arrContacts.get(position).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name="", number="";
                        if(!edtName.getText().toString().equals("")){
                            name= edtName.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Please Enter Ur Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")){
                            number= edtNumber.getText().toString();
                        }
                        else {
                            Toast.makeText(context, "Enter Ur Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position,new ContactModel(R.drawable.c,name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        holder.row1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you SURE?")
                        .setIcon(R.drawable.baseline_delete_sweep_24)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }

                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();

                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout row1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName= itemView.findViewById(R.id.txtName);
            txtNumber= itemView.findViewById(R.id.txtNumber);
            imgContact= itemView.findViewById(R.id.imgContact);
            row1= itemView.findViewById(R.id.row1);

        }
    }
}
