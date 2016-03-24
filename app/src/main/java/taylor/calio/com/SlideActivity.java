package taylor.calio.com;


import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class SlideActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private DrawerLayout drawer;
    ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    Toolbar mtoolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter viewPagerAdapter;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hamburger);

        mContext = getApplicationContext();

        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        mtoolbar.setTitle("CalIO");
        setSupportActionBar(mtoolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, drawer, mtoolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setCheckedItem(R.id.nav_calender);
        mNavigationView.setNavigationItemSelectedListener(new NavViewItemListener());

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout, Fragment.instantiate(getApplicationContext(), "taylor.calio.com.CalFrag"));
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        searchView.setIconifiedByDefault(true);


        return true;

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, "Searching by: "+ query, Toast.LENGTH_SHORT).show();

        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            String uri = intent.getDataString();
            Toast.makeText(this, "Suggestion: "+ uri, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        return false;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_search:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private class NavViewItemListener implements NavigationView.OnNavigationItemSelectedListener {

        String title;

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            int id = item.getItemId();
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            switch (id) {
                case R.id.nav_calender:
                    mNavigationView.setCheckedItem(R.id.nav_calender);
                    ft.replace(R.id.mainFrame, Fragment.instantiate(getApplicationContext(), "taylor.calio.com.CalFrag"));
                    ft.commit();
                    title = "CalIO - Calender";
                    break;
                case R.id.nav_message:
                    mNavigationView.setCheckedItem(R.id.nav_message);
                    ft.replace(R.id.mainFrame, Fragment.instantiate(getApplicationContext(), "taylor.calio.com.wififragment"));
                    ft.commit();
                    title = "CalIO - Messages";
                    break;
                case R.id.nav_reminders:
                    mNavigationView.setCheckedItem(R.id.nav_reminders);
                    ft.replace(R.id.mainFrame, Fragment.instantiate(getApplicationContext(), "taylor.calio.com.MessageActivity"));
                    ft.commit();
                    title = "CalIO - Reminders";
                    break;
            }

            drawer.closeDrawer(GravityCompat.START);


            return true;
        }
    }
}


