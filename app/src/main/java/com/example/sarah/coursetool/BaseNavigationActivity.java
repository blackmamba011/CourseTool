package com.example.sarah.coursetool;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class BaseNavigationActivity extends AppCompatActivity {

    private DrawerLayout navDrawerLayout;
    private MenuItem selectedMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_navigation_drawer);

        initNavigationDrawer();
        initActionToolbar();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        FrameLayout contentFrame = findViewById(R.id.content_frame);
        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(layoutResID, contentFrame);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                navDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Get a reference to the navigation drawer elements and configure a listener that will
     * navigate to the selected activity screen.
     */
    private void initNavigationDrawer(){
        // get the elements that make up the navigation menu
        navDrawerLayout = findViewById(R.id.nav_drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        // add a listener for when the user selects a navigation choice from the nav drawer
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // clear the previous selection if there was one
                if (selectedMenuItem != null){
                    selectedMenuItem.setChecked(false);
                }

                // set the chosen navigation menu item as selected and close the nav drawer
                menuItem.setChecked(true);
                selectedMenuItem = menuItem;
                navDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;
            }
        });
    }

    /**
     * Create the action toolbar with the hamburger menu
     */
    private void initActionToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_hamburger_menu);
    }

}
