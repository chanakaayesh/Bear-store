package com.chanaka.bearstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.chanaka.bearstore.APi.api_utility;
import com.chanaka.bearstore.Model.bear_main_model;

import com.chanaka.bearstore._adapter.recycler_adapter;
import com.chanaka.bearstore.interfaces.jsonPlaceHolderApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static ImageView popUp_display_logo_image;
    public static TextView popUp_display_short_description, popUp_display_long_description, popUp_display_bear_name;
    public static RelativeLayout Parent_Center_id, main_container;
    private RecyclerView recyclerView_bear;
    private GridLayoutManager manager;
    public static SearchView searchView_bear;


    ProgressBar progres_bar;

    private recycler_adapter adapter;
    private List<bear_main_model> bearList;
    /*private List<db_model> bearList;*/

    private jsonPlaceHolderApi jsonPlaceHolderApi;

    /* public  static  db_model db_models;*/
    public static bear_main_model db_models;

    int page = 1, per_page = 25;
    private boolean isLoading;
    private boolean isLastpage;
    List<bear_main_model> newlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progres_bar = (ProgressBar) findViewById(R.id.progres_bar);

        popUp_display_short_description = (TextView) findViewById(R.id.popUp_display_short_description);
        popUp_display_long_description = (TextView) findViewById(R.id.popUp_display_long_description);
        popUp_display_logo_image = (ImageView) findViewById(R.id.popUp_display_logo_image);
        Parent_Center_id = (RelativeLayout) findViewById(R.id.popUp);
        main_container = (RelativeLayout) findViewById(R.id.main_container);
        popUp_display_bear_name = (TextView) findViewById(R.id.popUp_display_bear_name);
        recyclerView_bear = (RecyclerView) findViewById(R.id.recycler_bear);
        searchView_bear = (SearchView) findViewById(R.id.searchView_bear);

        manager = new GridLayoutManager(this, 1);
        bearList = new ArrayList<>();
        recyclerView_bear.setLayoutManager(manager);
        adapter = new recycler_adapter(MainActivity.this, bearList);
        recyclerView_bear.setAdapter(adapter);
        popUp_display_long_description.setMovementMethod(new ScrollingMovementMethod());

        db_models = new bear_main_model();


        searchView_bear.setIconifiedByDefault(true);
        searchView_bear.setFocusable(true);
        searchView_bear.setIconified(false);
        searchView_bear.requestFocusFromTouch();

        get_bears();
        //loard More than 25 pageers
        recyclerView_bear.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItem = manager.getChildCount();
                int totalItem = manager.getItemCount();
                int firstVisibleItempos = manager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastpage) {
                    if ((visibleItem + firstVisibleItempos >= totalItem) && firstVisibleItempos >= 0 && totalItem >= per_page) {
                        page++;
                        get_bears();
                    }
                }
            }
        });


        int searchCloseButtonId = searchView_bear.getContext().getResources()
                .getIdentifier("android:id/search_close_btn", null, null);
        ImageView closeButton = (ImageView) this.searchView_bear.findViewById(searchCloseButtonId);

        //  closeButton.setEnabled(false);
        //  closeButton.setImageDrawable(null);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // bearList.clear();


                get_bears();
                refresh_recycler();
                searchView_bear.setQuery("", true);
                searchView_bear.clearFocus();
                adapter.notifyDataSetChanged();
                bearList.clear();

            }
        });


        //popUp RelativeLayout make untouch
        Parent_Center_id.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;

            }
        });

        // searchView_bear.setVisibility(View.GONE);
        searchView_bear.clearFocus();


        searchView_bear.setQueryHint("Search");
        searchView_bear.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                if (searchView_bear.getQuery().length() == 0) {
                    //  get_bears();
                    bearList.clear();
                    Parent_Center_id.setVisibility(View.GONE);

                } else {
                    search_bear_Name(query);

                    refresh_recycler();
                }


                //  search_bear(query);

                return true;
            }
        });


    }

    public void refresh_recycler() {
        //adapter = new recycler_adapter(MainActivity.this,bearList);
        recyclerView_bear.setAdapter(adapter);

    }



    public void hideimage(View view) {
        Parent_Center_id.setVisibility(View.GONE);
    }

    private void get_bears() {
        isLoading = true;
        api_utility.getapiInterface().getmorebear(page, per_page)
                .enqueue(new Callback<List<bear_main_model>>() {
                    @Override
                    public void onResponse(Call<List<bear_main_model>> call, Response<List<bear_main_model>> response) {
                        if (response.body() != null) {

                            List<bear_main_model> posts = response.body();
                            for (bear_main_model post : posts) {
                                bearList.add(post);
                            }

                        }
                        isLoading = false;
                        progres_bar.setVisibility(View.GONE);

                        if (bearList.size() > 0) {
                            isLastpage = bearList.size() < per_page;
                        } else {
                            isLastpage = true;
                        }
                    }

                    @Override
                    public void onFailure(Call<List<bear_main_model>> call, Throwable t) {

                        progres_bar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void HidePopup_interface(View view) {

        Parent_Center_id.setVisibility(View.GONE);

        // refresh_recycler();
    }
    //search Image

    public void search_bear(String searchingkey) {

        search_bear_Name(searchingkey);
        List<bear_main_model> newbear_list = new ArrayList<>();
        newbear_list.addAll(bearList);
        bearList.removeAll(bearList);
        bearList.clear();
        for (bear_main_model object : newbear_list) {
            if (object.getName().toLowerCase().contains(searchingkey.toLowerCase())) {
                bearList.add(object);
            }
        }
        recyclerView_bear.setAdapter(adapter);
        newlist.clear();

    }

    private void search_bear_Name(String query) {
   /*     Call<List<bear_main_model>> call = jsonPlaceHolderApi.searh_bearName_(query);
        call.enqueue(new Callback<List<bear_main_model>>() {
            @Override
            public void onResponse(Call<List<bear_main_model>> call, Response<List<bear_main_model>> response) {

                if (response.body() != null) {

                    List<bear_main_model> posts = response.body();
                    bearList.clear();
                    bearList.removeAll(bearList);
                    for (bear_main_model object : posts) {

                        bearList.add(object);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<bear_main_model>> call, Throwable t) {

            }
        });*/

        api_utility.getapiInterface().searh_bearName_(query)
                .enqueue(new Callback<List<bear_main_model>>() {
                    @Override
                    public void onResponse(Call<List<bear_main_model>> call, Response<List<bear_main_model>> response) {
                        if (response.body() != null) {

                            List<bear_main_model> posts = response.body();
                            bearList.clear();
                            bearList.removeAll(bearList);
                            for (bear_main_model object : posts) {

                                bearList.add(object);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<bear_main_model>> call, Throwable t) {

                    }
                });
    }
}







