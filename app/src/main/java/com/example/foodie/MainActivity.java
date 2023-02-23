/*
        AUTHORS

        S.C.R FERNANDO AS2019918
        H.R.Ranaweera  AS2019950

*/
package com.example.foodie;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;//set the recycle view for realtime search
    static FoodItemAdapter adapter; // Create Object of the Adapter class
    static DatabaseReference foodbase; // Create object of the Database
    private static String searchText;//dynamically update the search text
    static FirebaseRecyclerOptions<FoodItem> options;//select the firebaseRecyclerOption

    static ListViewAdapter ListAdapter;
    static ListView listView;
    public static ArrayList<String> arrayList;
    static Context context;


    static EditText searchBoxUIobj;

    static private float totalNoOfCarbohydrate=0.0f;
    static private float totalNoOfProtein=0.0f;
    static private float totalNoOfSalt=0.0f;
    static private float totalNoOfFat=0.0f;
    static private float totalNoOfAdditional=0.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add the app logo to right
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()| ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.ic_topbar_logo);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT| Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);

        //set the Custom Text To Action Bar
        actionBar.setTitle(Html.fromHtml("<font color=\"#333333\">" + "Quick Search" + "</font>"));

        //get the our db instance
        foodbase  = FirebaseDatabase.getInstance("https://foodie-d6c53-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        recyclerView = findViewById(R.id.foodItemRecycler);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //select UI componant for iteam search
        searchBoxUIobj=findViewById(R.id.searchFoodBox);

        //select UI componant for add the selected foods
        listView=findViewById(R.id.list);

        context = getApplicationContext();

        //arraylist to feed the listView
        arrayList = new ArrayList<>();

        //create adapter to listView
        ListAdapter = new ListViewAdapter(this, arrayList);

        //set the selected adapter
        listView.setAdapter(ListAdapter);

        //set the all items for initial launch
        options = new FirebaseRecyclerOptions.Builder<FoodItem>().setQuery(foodbase.orderByChild("foodName"), FoodItem.class).build();
        // the Adapter class itself
        adapter = new FoodItemAdapter(options,MainActivity.this);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
        adapter.startListening();

        //give realtime data according to search requirement
        searchBoxUIobj.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        searchText = searchBoxUIobj.getText().toString();
                        if (searchText.matches("")) {
                            adapter.stopListening();
                        } else {
                            options = new FirebaseRecyclerOptions.Builder<FoodItem>().setQuery(foodbase.orderByChild("foodName").startAt(searchText.toUpperCase(Locale.ROOT)).endAt(searchText.toUpperCase(Locale.ROOT) + "\uf8ff"), FoodItem.class).build();
                            // the Adapter class itself
                            adapter = new FoodItemAdapter(options,MainActivity.this);
                            // Connecting Adapter class with the Recycler view*/
                            recyclerView.setAdapter(adapter);
                            adapter.startListening();
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });
  }

    public static void clearTheSearchBoxAfterSearch(){
        MainActivity.searchBoxUIobj.setText("");
    }

    // Override onDestroy() to save the contents of the grocery list right before the app is terminated
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static void setTotalNoOfCarbohydrate(String totalNoOfCarbohydrate,
                                                boolean addOrRemoveState,
                                                String StringItemQty) {
        if(getTotalNoOfCarbohydrate()<0.0f){
            MainActivity.totalNoOfCarbohydrate=0.0f;
        }

        int itemQty=Integer.valueOf(StringItemQty);

        if(addOrRemoveState==true){
            MainActivity.totalNoOfCarbohydrate = (Float.parseFloat(totalNoOfCarbohydrate)*itemQty)+getTotalNoOfCarbohydrate();
        }else{
            MainActivity.totalNoOfCarbohydrate = getTotalNoOfCarbohydrate()-(Float.parseFloat(totalNoOfCarbohydrate)*itemQty);
        }

    }

    public static void setTotalNoOfProtein(String totalNoOfProtein,boolean addOrRemoveState,String StringItemQty) {
        if(getTotalNoOfProtein()<0.0f){
            MainActivity.totalNoOfProtein=0.0f;
        }

        int itemQty=Integer.valueOf(StringItemQty);

        if(addOrRemoveState==true){
            MainActivity.totalNoOfProtein = (Float.parseFloat(totalNoOfProtein)*itemQty)+getTotalNoOfProtein();
        }else{
            MainActivity.totalNoOfProtein = getTotalNoOfProtein()-(Float.parseFloat(totalNoOfProtein)*itemQty);
        }

    }

    public static void setTotalNoOfSalt(String totalNoOfSalt,boolean addOrRemoveState,String StringItemQty) {
        if(getTotalNoOfSalt()<0.0f){
            MainActivity.totalNoOfSalt=0.0f;
        }

        int itemQty=Integer.valueOf(StringItemQty);

        if(addOrRemoveState==true){
            MainActivity.totalNoOfSalt = (Float.parseFloat(totalNoOfSalt)*itemQty)+getTotalNoOfSalt();
        }else{
            MainActivity.totalNoOfSalt = getTotalNoOfSalt()-(Float.parseFloat(totalNoOfSalt)*itemQty);
        }

    }

    public static void setTotalNoOfFat(String totalNoOfFat,boolean addOrRemoveState,String StringItemQty) {
        if(getTotalNoOfFat()<0.0f){
            MainActivity.totalNoOfFat=0.0f;
        }

        int itemQty=Integer.valueOf(StringItemQty);

        if(addOrRemoveState==true){
            MainActivity.totalNoOfFat = (Float.parseFloat(totalNoOfFat)*itemQty)+getTotalNoOfFat();
        }else{
            MainActivity.totalNoOfFat = getTotalNoOfFat()-(Float.parseFloat(totalNoOfFat)*itemQty);
        }

    }

    public static void setTotalNoOfAdditional(String totalNoOfAdditional,boolean addOrRemoveState,String StringItemQty) {
        if(getTotalNoOfAdditional()<0.0f){
            MainActivity.totalNoOfAdditional=0.0f;
        }

        int itemQty=Integer.valueOf(StringItemQty);

        if(addOrRemoveState==true){
            MainActivity.totalNoOfAdditional = (Float.parseFloat(totalNoOfAdditional)*itemQty)+getTotalNoOfAdditional();
        }else{
            MainActivity.totalNoOfAdditional = getTotalNoOfAdditional()-(Float.parseFloat(totalNoOfAdditional)*itemQty);
        }

    }

    public static float getTotalNoOfCarbohydrate() {     return MainActivity.totalNoOfCarbohydrate; }

    public static float getTotalNoOfProtein() { return MainActivity.totalNoOfProtein;}

    public static float getTotalNoOfSalt() { return MainActivity.totalNoOfSalt;}

    public static float getTotalNoOfFat() {  return MainActivity.totalNoOfFat; }

    public static float getTotalNoOfAdditional() { return MainActivity. totalNoOfAdditional; }



    // function to add an item given its name.
    public static void addItem(String item) {
        arrayList.add(item);
        listView.setAdapter(ListAdapter);
        //split the received text
        String[] arrayOfSplitString = item.split(",");
        setTotalNoOfCarbohydrate(arrayOfSplitString[4],true,arrayOfSplitString[1]);
        setTotalNoOfProtein(arrayOfSplitString[5],true,arrayOfSplitString[1]);
        setTotalNoOfSalt(arrayOfSplitString[6],true,arrayOfSplitString[1]);
        setTotalNoOfFat(arrayOfSplitString[7],true,arrayOfSplitString[1]);
        setTotalNoOfAdditional(arrayOfSplitString[8],true,arrayOfSplitString[1]);
        Toast. makeText(context.getApplicationContext(), "Items Added",Toast. LENGTH_LONG);
    }

    // function to remove an item given its index in the grocery list.
    public static void removeItem(int i) {
        //split the received text
        String[] arrayOfSplitString = arrayList.get(i).split(",");
        setTotalNoOfCarbohydrate(arrayOfSplitString[4],false,arrayOfSplitString[1]);
        setTotalNoOfProtein(arrayOfSplitString[5],false,arrayOfSplitString[1]);
        setTotalNoOfSalt(arrayOfSplitString[6],false,arrayOfSplitString[1]);
        setTotalNoOfFat(arrayOfSplitString[7],false,arrayOfSplitString[1]);
        setTotalNoOfAdditional(arrayOfSplitString[8],false,arrayOfSplitString[1]);
        arrayList.remove(i);
        listView.setAdapter(ListAdapter);
    }

    public void seeTheResult(View view){

        //check items are existed or not
        if(!ListAdapter.isEmpty()){
            //start intent to transfer the data
            Intent intentObj=new Intent(this,ResultActivity.class);

            //convert the int to string
            intentObj.putExtra("TotalNoOfCarbohydrate",String.valueOf(getTotalNoOfCarbohydrate()));
            intentObj.putExtra("TotalNoOfProtein",String.valueOf(getTotalNoOfProtein()));
            intentObj.putExtra("TotalNoOfSalt",String.valueOf(getTotalNoOfSalt()));
            intentObj.putExtra("TotalNoOfFat",String.valueOf(getTotalNoOfFat()));
            intentObj.putExtra("TotalNoOfAdditional",String.valueOf(getTotalNoOfAdditional()));

            //start the intent connection
            startActivity(intentObj);

        }


    }

    // Function to tell the app to start getting data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();

    }
    // Function to tell the app to stop getting data from database on stopping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

}