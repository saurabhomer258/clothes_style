package com.example.saurabhomer.style2.ui.gallery;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saurabhomer.style2.HomeActivity;
import com.example.saurabhomer.style2.Model.StyleModel.StyleSheetModel;
import com.example.saurabhomer.style2.R;;
import com.example.saurabhomer.style2.ui.gallery.model.MainSeetModel2;
import com.example.saurabhomer.style2.utils.NetworkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class GalleryFragment extends Fragment implements
        View.OnClickListener  {

    private int mYear, mMonth, mDay, mHour, mMinute;
    ImageButton btnDatePicker;
    EditText txtDate;
    AutoCompleteTextView styleNu;
    AutoCompleteTextView productName;
    AutoCompleteTextView productDes;
    AutoCompleteTextView line_effi;
    AutoCompleteTextView sum;
    AutoCompleteTextView orderNumber;
    Spinner line_nu;
    AutoCompleteTextView total_man_power;
    AutoCompleteTextView shipDate;
    AutoCompleteTextView color;
    AutoCompleteTextView size;

    AutoCompleteTextView fabicDes;
    AutoCompleteTextView buyerName;
    Button submitBtn;
    String tDate;
    static StyleSheetModel styleSheetModel;
    static ArrayList<MainSeetModel2> mainSeetModel2 = new ArrayList<>();
    private ProgressDialog progressDialog;
    // this is new style

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        btnDatePicker = root.findViewById(R.id.btn_date);
        txtDate = root.findViewById(R.id.in_date);
        tDate = txtDate.getText().toString();//doubt hai empty aa rha hai
        btnDatePicker.setOnClickListener(this);
        styleNu = root.findViewById(R.id.edt_style_no).findViewById(R.id.atvCommon);
        productName = root.findViewById(R.id.edt_product_name).findViewById(R.id.atvCommon);
        buyerName = root.findViewById(R.id.edt_buyer_name).findViewById(R.id.atvCommon);
        productDes = root.findViewById(R.id.edt_product_description).findViewById(R.id.atvCommon);
        line_effi = root.findViewById(R.id.edt_lineefficency).findViewById(R.id.atvCommon);
        line_nu = root.findViewById(R.id.edt_line_nu).findViewById(R.id.spinner);
        total_man_power = root.findViewById(R.id.edt_total_man_power).findViewById(R.id.atvCommon);
        orderNumber = root.findViewById(R.id.edt_order_quality).findViewById(R.id.atvCommon);
        sum = root.findViewById(R.id.edt_sum).findViewById(R.id.atvCommon);

       // shipDate = root.findViewById(R.id.edt_shipment_date).findViewById(R.id.atvCommon);

        size = root.findViewById(R.id.edt_Size).findViewById(R.id.atvCommon);


        submitBtn = root.findViewById(R.id.btn_done1).findViewById(R.id.btnNext);
        progressDialog = new ProgressDialog(getContext());
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();
        submitBtn.
                setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                if(!NetworkUtils.isNetworkConnected(getContext()))
                                {
                                    return;
                                }
                                progressDialog.setMessage("Verificating...");
                                progressDialog.show();
                                if(styleNu.getText().toString().trim().isEmpty() || size.getText().toString().trim().isEmpty())
                                {
                                    Toast.makeText(getActivity(),"style number or size should not empty", Toast.LENGTH_LONG).show();
                                    progressDialog.hide();
                                    return;
                                }

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference users = firebaseDatabase.getReference("styles");
                                users.
                                        child(styleNu.getText().toString()).
                                        addListenerForSingleValueEvent(new ValueEventListener() {
                                                                           @Override
                                                                           public void onDataChange(DataSnapshot dataSnapshot) {
                                                                               if (dataSnapshot.getValue() == null) {

                                                                                   styleSheetModel = new StyleSheetModel(styleNu.getText().toString(),
                                                                                           buyerName.getText().toString(),
                                                                                           productName.getText().toString(),
                                                                                           productDes.getText().toString(),
                                                                                           orderNumber.getText().toString(),
                                                                                           tDate = txtDate.getText().toString(),
                                                                                           sum.getText().toString(),
                                                                                           line_nu.getSelectedItem().toString(),
                                                                                           size.getText().toString(),
                                                                                           total_man_power.getText().toString(),
                                                                                           line_effi.getText().toString()
                                                                                          );
                                                                                   //    ));


                                                                                   FirebaseDatabase.getInstance().getReference("styles")
                                                                                           .child(styleSheetModel.getSheetNumber().toString())
                                                                                           .setValue(styleSheetModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                       @Override
                                                                                       public void onComplete(@NonNull Task<Void> task) {
                                                                                           if(task.isSuccessful()|| task.isComplete()) {
                                                                                             //  startActivity(new Intent(getContext(), HomeActivity.class));

                                                                                               progressDialog.dismiss();
                                                                                               Toast.makeText(getContext(),"Data is successfully inserted ", Toast.LENGTH_SHORT).show();
                                                                                           }
                                                                                           else {
                                                                                               Toast.makeText(getContext(),"oops ! Please try again ", Toast.LENGTH_SHORT).show();

                                                                                           }
                                                                                       }
                                                                                   });
                                                                                   progressDialog.hide();
                                                                               }
                                                                               else{
                                                                                   Toast.makeText(getContext(),"Please check style Number. Style number should be unique.", Toast.LENGTH_LONG).show();;
                                                                                   progressDialog.hide();
                                                                               }

                                                                           }

                                                                           @Override
                                                                           public void onCancelled(DatabaseError databaseError) {
                                                                               progressDialog.hide();
                                                                           }
                                                                       }
                                        );

                            }
                        });
    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth)
                        {
                            txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
