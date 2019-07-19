package br.com.digitalhouse.desafiomarveldh.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.digitalhouse.desafiomarveldh.R;
import br.com.digitalhouse.desafiomarveldh.model.Result;

public class ActivityDetail extends AppCompatActivity {

    private ImageView imageBack;
    private ImageView imageHero;
    private ImageView imageBackground;
    private TextView textTitle;
    private TextView textViewDescription;
    private TextView textViewPublished;
    private TextView textViewPrice;
    private TextView textViewPages;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    private Result result;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        setSupportActionBar(toolbar);

        result = getIntent().getParcelableExtra("COMIC");
        String transitionName = getIntent().getStringExtra("TRANSITIONNAME");
        imageHero.setTransitionName(transitionName);

        textTitle.setText(result.getTitle());
        textViewDescription.setText(Html.fromHtml(result.getDescription()));
        textViewPrice.setText("$" + result.getPrices().get(0).getPrice());
        textViewPages.setText(result.getPageCount().toString());


        Picasso.get().load(result.getThumbnail().getPath() + "/portrait_incredible." + result.getThumbnail().getExtension());

                /*.placeholder(R.drawable.marvelcomics_logo)
                .error(R.drawable.marvelcomics_logo)
                .into(imageHero);
*/
        if (!result.getImages().isEmpty()) {
           /* Picasso.get().load(result.getImages().get(0).getPath() + "/landscape_incredible." + result.getImages().get(0).getExtension())
                    .placeholder(R.drawable.marvelcomics_logo)
                    .error(R.drawable.marvelcomics_logo)
                    .into(imageBackground);*/
        }

        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
            Date date = formatDate.parse(result.getDates().get(0).getDate());
            String dateString = format.format(date);
            textViewPublished.setText(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        imageHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDetail.this, PopImageActivity.class);
                intent.putExtra("image", result.getThumbnail().getPath() + "/detail." + result.getThumbnail().getExtension());
                startActivity(intent);
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });


        appBarLayout.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                imageHero.setVisibility(View.VISIBLE);
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                imageHero.setVisibility(View.GONE);
                toolbar.setTitle(result.getTitle());
            } else {
                imageHero.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initViews() {
        imageBack = findViewById(R.id.imageBack);
        imageHero = findViewById(R.id.imageComic);
        imageBackground = findViewById(R.id.imageBackground);
        textTitle = findViewById(R.id.textTitle);
        textViewDescription = findViewById(R.id.textViewDesciption);
        textViewPublished = findViewById(R.id.textViewPublished);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewPages = findViewById(R.id.textViewPages);
        appBarLayout = findViewById(R.id.app_bar);
        toolbar = findViewById(R.id.toolbar);
    }
}