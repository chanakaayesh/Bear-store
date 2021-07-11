package com.chanaka.bearstore._adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chanaka.bearstore.MainActivity;
import com.chanaka.bearstore.Model.bear_main_model;
import com.chanaka.bearstore.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class recycler_adapter extends RecyclerView.Adapter<recycler_adapter.bear_image> {

    public static MainActivity mainActivity =new MainActivity();

    private Context context;
  /*  private List<db_model> list;*/
  private List<bear_main_model> list;


   /* public recycler_adapter(Context context, List<db_model> list) {
        this.context = context;
        this.list = list;
    }*/
   public recycler_adapter(Context context, List<bear_main_model> list) {
       this.context = context;
       this.list = list;
   }
    @NonNull
    @Override
    public bear_image onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_recycler_resource,parent,false);
        return new bear_image(v);
    }

    @Override
    public void onBindViewHolder(@NonNull bear_image holder, int position) {


        bear_main_model model = list.get(position);

        String bearName=model.getName();
        if(bearName.length()>25){
            bearName =bearName.substring(0,25);
        }

        holder.names_bear.setText(bearName);
        String long_description ="";
        long_description +=model.getDescription()+'\n';
        long_description +="first brewed"+model.getFirst_brewed()+'\n';
        long_description += "Vaolume_value: " + model.getVolume().getValue()+ "\n";
        long_description +="Beer abv: "+model.getAbv()+'\t'+"Beer IBU: "+model.getIbu()+'\t'+"Beer Target FG : "+model.getTarget_fg()+'\t'+"Beer Target OG: "+model.getTarget_og()+'\t'+"Beer EBC: "+model.getEbc()+'\t'+"Beer SRM: "+model.getSrm()+'\t'+"Beer PH: "+model.getPh()+'\t'+"Beer Attenuation Level: "+model.getAttenuation_level()+'\t'+
                            "Value Of Volume: "+model.getVolume().getValue()+'\t'+"Unit Of Volume: "+model.getVolume().getUnit()+'\t'+"Value Of Boil Volume: "+model.getBoil_volume().getValue()+'\t'+"Unit Of Boil Volume: "+model.getBoil_volume().getUnit()+'\t';
        //while(model.getMethod().getMash_temp().size())

        //for Method
        String methods = "";
        for(int i=0 ; i<model.getMethod().getMash_temp().size(); i++){
            methods += Integer.toString(i+1)+"Mash temp  Value: "+model.getMethod().getMash_temp().get(i).getTemp().getValue()+'\t'+"Mash Temp Unit: "+model.getMethod().getMash_temp().get(i).getTemp().getUnit()+"\t"+"Mash temp duration: "+model.getMethod().getMash_temp().get(i).getDuration()+'\n';
        }
        //System.out.println(methods);
        long_description +='\n'+methods;

        long_description += "Method Fermentation Temp Value " +model.getMethod().getFermentation().getTemp().getUnit()+ "\t"+"Method Twist: " +model.getMethod().getTwist()+ "\t";

        String ingredients_malta ="";

        for(int i=0 ;i<model.getIngredients().getMalt().size();i++){
            ingredients_malta += Integer.toString(i+1)+"\t"+"Ingredients Malt Name: " + model.getIngredients().getMalt().get(i).getName()+ "\t"+"Ingredients Malt Amount value: "+model.getIngredients().getMalt().get(i).getAmount().getValue()+'\t'+"Igediant Malt Amount Unit"+model.getIngredients().getMalt().get(i).getAmount().getUnit()+'\n';
        }
        long_description +="\n"+"Ingredients"+"\n"+ingredients_malta;
        String ingredients_hops ="";
        for(int i=0;i<model.getIngredients().getHops().size();i++){
            ingredients_hops = Integer.toString(i+1)+"\t"+"Hops Name:" +model.getIngredients().getHops().get(i).getName()+"\t"+"Hops Amount Value:"+model.getIngredients().getHops().get(i).getAmount().getValue()+"\t"+"Hops amount unit:"+model.getIngredients().getHops().get(i).getAmount().getUnit()+"\n";
        }

        long_description +="\n"+ingredients_hops;

        String food="";
        for (int i=0 ;i<model.getFood_pairing().size();i++){
            food +=Integer.toString(i)+"\t"+model.getFood_pairing().get(i)+'\n';
        }
        long_description +="\n"+"Food Pairing"+"\n"+food+"\n"+"Brewers Tips:"+model.getBrewers_tips()+"\n"+"Contributed :"+model.getContributed_by();

        final  String fin_longDescription =long_description;
        String shortdes= model.getDescription();

        if(long_description.length()>50){
            shortdes =shortdes.substring(0,50);
        }


        String shortdescription =model.getTagline();
        if(shortdescription.length()>25){
            shortdescription =shortdescription.substring(0,25);
        }

        holder.shortdescription_of_bear.setText(shortdescription+'\n'+'\n'+shortdes+"...");
        Picasso.with(context).load(model.getImage_url())
                .fit()
                .centerCrop()
                .into(holder.images_bear);
        holder.more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mainActivity.popUp_display_long_description.setText( fin_longDescription);
                mainActivity.popUp_display_bear_name.setText(model.getName());
                mainActivity.popUp_display_short_description.setText(model.getTagline());
                Picasso.with(context).load(model.getImage_url())
                        .fit()
                        .centerCrop()
                        .into(mainActivity.popUp_display_logo_image);
                mainActivity.Parent_Center_id.setVisibility(View.VISIBLE);
                mainActivity.searchView_bear.clearFocus();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class bear_image extends RecyclerView.ViewHolder{

        public ImageView images_bear;
        public TextView names_bear,shortdescription_of_bear,more_info;


        public bear_image(@NonNull View itemView) {
            super(itemView);
            names_bear =(TextView) itemView.findViewById(R.id.name_of_bear);
            shortdescription_of_bear=(TextView) itemView.findViewById(R.id.shortdescription_of_bear);

            more_info=(TextView) itemView.findViewById(R.id.more_bear);
            images_bear=(ImageView) itemView.findViewById(R.id.list_image_bear);


        }
    }

}
