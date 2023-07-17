package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerMain extends AppCompatActivity {



    ArrayList<ContactModel> arrContacts = new ArrayList<>();

    FloatingActionButton btnOpenDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_main);



        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrContacts.add(new ContactModel(R.drawable.a,"A","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.a,"H","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"I","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.a,"A","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.a,"H","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"I","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.a,"A","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.b,"B","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"C","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.d,"D","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.e,"E","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.f,"F","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.g,"G","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.a,"H","9876543210"));
        arrContacts.add(new ContactModel(R.drawable.c,"I","9876543210"));


        RecyclerContactAdapter adapter= new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);






        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(RecyclerMain.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name="", number="";
                        if(!edtName.getText().toString().equals("")){
                            name= edtName.getText().toString();
                        }
                        else {
                            Toast.makeText(RecyclerMain.this, "Please Enter Ur Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")){
                            number= edtNumber.getText().toString();
                        }
                        else {
                            Toast.makeText(RecyclerMain.this, "Enter Ur Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(R.drawable.e,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });


    }
}