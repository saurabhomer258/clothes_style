package com.example.saurabhomer.style2.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.saurabhomer.style2.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.style2.R;;
import com.example.saurabhomer.style2.cardviewmenu.CardMenuP;
import com.example.saurabhomer.style2.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public static String STYLE_NUMBER;
    public static String date_in_globler;
    public static String total_order_qu;
    public static String total_man_power;
    private Button submitBtn;
    private ProgressDialog progressDialog;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_home, container, false);
         final EditText edt_styleno = root.findViewById(R.id.edt_styleno).findViewById(R.id.atvUsernameReg);
        submitBtn = root.findViewById(R.id.btnNext);
        progressDialog = new ProgressDialog(getContext());
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                if(!NetworkUtils.isNetworkConnected(getContext()))
                {
                    progressDialog.dismiss();
                    return;
                }
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference users = firebaseDatabase.getReference("styles");
                users.child(edt_styleno.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue()!=null) {
                            progressDialog.dismiss();
                           Intent i = new Intent(getContext(), CardMenuP.class);
                            STYLE_NUMBER =  edt_styleno.getText().toString().trim();

                            StyleSheetModel styleSheetModel = dataSnapshot.getValue(StyleSheetModel.class);

                            if( styleSheetModel != null && styleSheetModel.getShipmentDate() !=null){

                                date_in_globler = styleSheetModel.getShipmentDate();
                                total_order_qu = styleSheetModel.getTotalQuality();
                                total_man_power = styleSheetModel.getTotalManPower();
                            }
                            else {
                                date_in_globler  = "";
                            }

                                    i.putExtra("style",edt_styleno.getText().toString());
                           startActivity(i);
                        }
                        else {
                            Toast.makeText(getContext(),"style number is not found", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(getContext(),"oops !! try after some time", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
            }
        });
        return root;
    }
}
