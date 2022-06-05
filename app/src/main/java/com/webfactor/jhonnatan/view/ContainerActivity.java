package com.webfactor.jhonnatan.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.webfactor.jhonnatan.MainActivity;
import com.webfactor.jhonnatan.R;
import com.webfactor.jhonnatan.view.fragments.HomeFragment;
import com.webfactor.jhonnatan.view.fragments.RegistroPizzaFragment;

public class ContainerActivity extends AppCompatActivity {
    HomeFragment firstFragment = new HomeFragment();
    RegistroPizzaFragment secondFragment = new RegistroPizzaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(firstFragment);
                    break;
                case R.id.secondFragment:
                    loadFragment(secondFragment);
                    break;
                case R.id.thirdFragment:
                    Logout();
                    break;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragmento){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragmento);
        transaction.commit();
    }

    public void Logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}