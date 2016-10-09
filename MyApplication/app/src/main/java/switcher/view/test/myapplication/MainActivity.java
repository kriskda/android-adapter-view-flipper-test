package switcher.view.test.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final List<String> urlList = Arrays.asList(
            "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01482/opgs/edr/ncam/NLB_529067238EDR_F0581530NCAM00385M_.JPG",
            "http://mars.jpl.nasa.gov/msl-raw-images/msss/01480/mcam/1480MR0074300010704008E01_DXXX.jpg",
            "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01482/opgs/edr/ncam/NLB_529068608EDR_F0581572NCAM00654M_.JPG",
            "http://mars.jpl.nasa.gov/msl-raw-images/msss/01480/mcam/1480ML0074350040603528E01_DXXX.jpg",
            "http://mars.jpl.nasa.gov/msl-raw-images/msss/01482/mcam/1482ML0074450020603580E01_DXXX.jpg",
            "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01482/opgs/edr/ncam/NLB_529068947EDR_F0581572NCAM07753M_.JPG");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticleSliderAdapter adapter = new ArticleSliderAdapter(this);
        adapter.setData(urlList);

        ArticleSlider articleSlider = (ArticleSlider) findViewById(R.id.viewFlipper);
        articleSlider.setAdapter(adapter);
    }


}
