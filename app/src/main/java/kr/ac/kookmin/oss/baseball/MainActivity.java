package kr.ac.kookmin.oss.baseball;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MainFragment fragMain;
    SearchFragment fragSearch;
    CompareFragment fragCompare;
    PredictFragment fragPredict;
    DictionaryFragment fragDictionary;
    static StatData statData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        statData = new StatData(MainActivity.this); // Initialize statistics data

        fragMain = MainFragment.newInstance();
        fragSearch = SearchFragment.newInstance(); // Create search fragment
        fragCompare = CompareFragment.newInstance(); // Create compare fragment
        fragPredict = PredictFragment.newInstance(); // Create predict fragment
        fragDictionary = DictionaryFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, fragMain).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragMain).commit();
        } else if (id == R.id.nav_search) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragSearch).commit();
        } else if (id == R.id.nav_compare) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragCompare).commit();
        } else if (id == R.id.nav_predict) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragPredict).commit();
        } else if (id == R.id.nav_dictionary) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragDictionary).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
