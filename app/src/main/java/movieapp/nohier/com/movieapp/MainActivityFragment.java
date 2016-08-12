package movieapp.nohier.com.movieapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Add this line in order for this fragment to handle menu events.

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        GridView mygrid = (GridView) rootView.findViewById(R.id.gridView);
        mygrid.setAdapter(new myAdapter(getContext()));

        return rootView;
    }
}

class Country{
    int CountryId;
    String CountryName;
    public Country(int id,String name){
        CountryId= id;
        CountryName = name;
    }

}
    class myAdapter extends BaseAdapter {
Context context;

// making the array list of countries
        ArrayList<Country>CountryListAdapter;

        // initialize the adapter in the contructor
   public myAdapter(Context context){
       this.context= context;

       CountryListAdapter = new ArrayList<Country>();

      Resources res = context.getResources();
       String[]items =  res.getStringArray(R.array.Items); // all teams string are saved in teams
       int [] items_icon={R.drawable.ic_accessibility_black_24dp,R.drawable.ic_accessible_black_24dp,R.drawable.ic_account_balance_black_24dp
       ,R.drawable.ic_account_box_black_24dp,R.drawable.ic_account_circle_black_24dp,R.drawable.ic_add_shopping_cart_black_24dp,R.drawable.ic_alarm_add_black_24dp
       ,R.drawable.ic_alarm_black_24dp,R.drawable.ic_assignment_black_24dp,R.drawable.ic_autorenew_black_24dp,R.drawable.ic_backup_black_24dp,R.drawable.ic_code_black_24dp
       };
       for(int i =0;i<items_icon.length;i++){
           Country tempCountry = new Country(items_icon[i],items[i]);
           CountryListAdapter.add(tempCountry);

       }


   }
        public class ViewHolder{     // this class to get the imageview
         ImageView imageView;
            public ViewHolder(View v){          // vi will be passed later as the xml file containig the imageView
                imageView = (ImageView) v.findViewById(R.id.imageView);
            }

        }

        @Override
        public int getCount() {
            return CountryListAdapter.size();
        }

        @Override
        public Object getItem(int position) {
            return CountryListAdapter.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // we don't want to get the view every time we want to inhabit the imageView so
            // we are using the inflator
View row = convertView;
            ViewHolder holder =null;
           if(row == null){ // for the first time

               LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
               row = inflater.inflate(R.layout.single_block,parent,false);

               // actually the holder to get the image view from the passed view which is an xml file and inflated
               holder = new ViewHolder(row);
               row.setTag(holder);
           }
            else{       // not the first time
   holder = (ViewHolder) row.getTag();  // in this case convertView will not be null

           }

// now the holder object holds the image view

Country temp = CountryListAdapter.get(position);
holder.imageView.setImageResource(temp.CountryId);

            return row;
        }
    }
