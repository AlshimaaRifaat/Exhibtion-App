package com.example.alshimaa.exhibtion.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.fragment.AboutUsFragment;
import com.example.alshimaa.exhibtion.fragment.CallUsFragment;
import com.example.alshimaa.exhibtion.fragment.CurrentExhibitionFragment;
import com.example.alshimaa.exhibtion.fragment.HomeFragment;
import com.example.alshimaa.exhibtion.fragment.PreviousExhibitionFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment;
    private int currentSelectedPosition=0;
    NavigationView navigationView;
    public static Toolbar toolbar;
    public static ActionBarDrawerToggle toggle;
    public  static DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        navigationView=findViewById( R.id.nav_view );
        onNavigationItemSelected( navigationView.getMenu().getItem( 0 ) );

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case  R.id.nav_Home:
                currentSelectedPosition=0;
                fragment=new HomeFragment();
                break;

            case  R.id.nav_CurrentExhibitions:
                currentSelectedPosition=1;
                fragment=new CurrentExhibitionFragment();
                break;

            case  R.id.nav_PreviousExhibitions:
                currentSelectedPosition=1;
                fragment=new PreviousExhibitionFragment();
                break;
            case R.id.nav_about_us:
                currentSelectedPosition=2;
                fragment=new AboutUsFragment();
            case R.id.nav_call_us:
                currentSelectedPosition=3;
                fragment=new CallUsFragment();
            default:
                currentSelectedPosition=0;
        }

        if (item.isChecked())
        {
            item.setChecked( false );
        }else
        {
            item.setChecked( true );
        }
        FragmentManager fragmentManager=  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.content_navigation,fragment ).addToBackStack( null )
                .commit();
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
        /*int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
*/

    }
}
