package k.s.blackcoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottomNavigationView;
    ExploreFragment exploreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpSideNavbar();
        setUpBottomNavbar();
    }

    private void setUpBottomNavbar() {
        exploreFragment = new ExploreFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation_layout);
        bottomNavigationView.setSelectedItemId(R.id.nav_bottom_explore);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, exploreFragment).commit();
    }

    private void setUpSideNavbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.refine_icon) {
            startActivity(new Intent(MainActivity.this, RefineActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.action_navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean
//    onNavigationItemSelected(@NonNull MenuItem item)
//    {
//
//        switch (item.getItemId()) {
//            case R.id.nav_bottom_explore:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, exploreFragment)
//                        .commit();
//                return true;
//
//            case R.id.nav_bottom_network:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, exploreFragment)
//                        .commit();
//                return true;
//
//            case R.id.nav_bottom_chat:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, exploreFragment)
//                        .commit();
//                return true;
//            case R.id.nav_bottom_contacts:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, exploreFragment)
//                        .commit();
//                return true;
//            case R.id.nav_bottom_hashtags:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_layout, exploreFragment)
//                        .commit();
//                return true;
//
//        }
//        return false;
//    }

}