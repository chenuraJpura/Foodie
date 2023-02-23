/*
        AUTHORS

        S.C.R FERNANDO AS2019918
        H.R.Ranaweera  AS2019950

*/
package com.example.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class FoodItemAdapter extends FirebaseRecyclerAdapter<FoodItem, FoodItemAdapter.FoodItemViewholder> {

    private Context context;



    public FoodItemAdapter(@NonNull FirebaseRecyclerOptions<FoodItem> options,Context ctx){
            super(options);
            this.context = ctx;
    }

        @Override
        protected void onBindViewHolder(@NonNull FoodItemViewholder holder,int position, @NonNull FoodItem model) {

            holder.foodName.setText(model.getFoodName());
            holder.manufacture.setText(model.getManufacture());
            holder.netWeight.setText(model.getNetWeight()+"g");

            //ready string add to the added item

                holder.foodAddBtn.setOnClickListener(view->{

                    MainActivity.addItem(
                            model.getFoodName()+","+ //0
                            holder.noOfQty.getText().toString()+","+ //1
                            model.getManufacture()+","+ //2
                            model.getNetWeight()+","+ //3
                            Float.toString((model.getNetWeight()/model.getContainsFactor())*(model.getCarbohydrate()))+","+//4
                            Float.toString((model.getNetWeight()/model.getContainsFactor())*(model.getProtein()))+","+//5
                            Float.toString((model.getNetWeight()/model.getContainsFactor())*(model.getSalt()))+","+//6
                            Float.toString((model.getNetWeight()/model.getContainsFactor())*(model.getFat()))+","+//7
                            Float.toString((model.getNetWeight()/model.getContainsFactor())*(model.getAdditional()))//8
                            );

                });

        }

        @NonNull
        @Override
        public FoodItemViewholder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
            View ViewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
            return new FoodItemAdapter.FoodItemViewholder(ViewItem);
        }

        class FoodItemViewholder extends RecyclerView.ViewHolder {

            TextView foodName, manufacture,netWeight,nutrientsView;
            EditText noOfQty;
            Button foodAddBtn;

            public FoodItemViewholder(@NonNull View itemView){
                super(itemView);

                foodName = itemView.findViewById(R.id.foodName);
                manufacture = itemView.findViewById(R.id.manufacture);
                netWeight = itemView.findViewById(R.id.netWeight);
                foodAddBtn=itemView.findViewById(R.id.foodAddBtn);
                nutrientsView=itemView.findViewById(R.id.nutrientsView);
                noOfQty=itemView.findViewById(R.id.qty);

            }
        }
    }

