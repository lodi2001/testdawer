package com.example.android.testdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.android.testdrawer.fragment.FragmentHome;
import com.example.android.testdrawer.fragment.Fragmentcontact;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView    bottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        displayFragment(new FragmentHome());
    }
    private void displayFragment(Fragment  fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_area, fragment)
                .commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment  fragment ;

        switch (menuItem.getItemId()) {

            case R.id.Article:
            fragment = new FragmentHome();
        break;
        case R.id.Consultant:
            fragment = new Fragmentcontact();
        break;
        case R.id.Contact:
        fragment = new Fragmentcontact();
        break;
        default:
        fragment = new FragmentHome();
        break;
    }
    displayFragment(fragment);
        return true;
}
}

