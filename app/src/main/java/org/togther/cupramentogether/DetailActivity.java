package org.togther.cupramentogether;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView dtl_ranking = (TextView)findViewById(R.id.dtl_ranking);
        ImageView dtl_img_r = (ImageView)findViewById(R.id.dtl_img_r);
        ImageView dtl_img_w = (ImageView)findViewById(R.id.dtl_img_w);
        ImageView dtl_img_c = (ImageView)findViewById(R.id.dtl_img_c);
        ImageView dtl_img_b = (ImageView)findViewById(R.id.dtl_img_b);
        TextView dtl_re_cnt = (TextView)findViewById(R.id.dtl_re_cnt);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        dtl_ranking.setText(intent.getStringExtra("ranking"));
        dtl_img_r.setImageResource(intent.getIntExtra("img_raman", 0));
        dtl_img_w.setImageResource(intent.getIntExtra("img_water", 0));
        dtl_img_c.setImageResource(intent.getIntExtra("img_rice", 0));
        dtl_img_b.setImageResource(intent.getIntExtra("img_bread", 0));
        dtl_re_cnt.setText(intent.getStringExtra("re_cnt"));


    }
}
