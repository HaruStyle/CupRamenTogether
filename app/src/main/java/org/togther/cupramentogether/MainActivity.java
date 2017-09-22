package org.togther.cupramentogether;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listview = null;
    class Item{
        int img_raman;
        int img_water;
        int img_rice;
        int img_bread;
        String ranking;
        String re_cnt;

        Item(String ranking ,int img_raman, int img_water,int img_rice,int img_bread, String re_cnt){
            this.img_raman =img_raman;
            this.img_water =img_water;
            this.img_rice  =img_rice;
            this.img_bread =img_bread;
            this.ranking = ranking;
            this.re_cnt = re_cnt;
        }
    }
    ArrayList<Item> itemList = new ArrayList<Item>();

    class ItemAdapter extends ArrayAdapter{
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.item_list, null);
            }
            TextView ranking = (TextView)convertView.findViewById(R.id.chat_ranking);
            ImageView img_raman = (ImageView)convertView.findViewById(R.id.chat_raman);
            ImageView img_water = (ImageView)convertView.findViewById(R.id.chat_water);
            ImageView img_rice = (ImageView)convertView.findViewById(R.id.chat_rice);
            ImageView img_bread = (ImageView)convertView.findViewById(R.id.chat_bread);
            TextView re_cnt = (TextView)convertView.findViewById(R.id.chat_re_cnt);


            Item item = itemList.get(position);
            ranking.setText(item.ranking);
            img_raman.setImageResource(item.img_raman);
            img_water.setImageResource(item.img_water);
            img_rice.setImageResource(item.img_rice);
            img_bread.setImageResource(item.img_bread);
            re_cnt.setText(item.re_cnt);

            return convertView;
        }

        public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
            super(context, resource, objects);
        }
    }
    ItemAdapter itemAdpater = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView)findViewById(R.id.chat_listview);
        itemList.add(new Item("1",R.drawable.r01, R.drawable.b01,R.drawable.c01,R.drawable.r01,"100"));

        itemAdpater = new ItemAdapter(MainActivity.this, R.layout.item_list,itemList);
        //String[] items = {"item1","item2","item3","item4","item5"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,items);

        listview.setAdapter(itemAdpater);
    }
}
