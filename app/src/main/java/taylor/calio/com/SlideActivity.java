package taylor.calio.com;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
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


public class SlideActivity extends AppCompatActivity {

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

        mtoolbar = (Toolbar) findViewById(R.id.tool_bar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        return true;

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
                    ft.replace(R.id.mainFrame, Fragment.instantiate(getApplicationContext(), "taylor.calio.com.MessageActivity"));
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


