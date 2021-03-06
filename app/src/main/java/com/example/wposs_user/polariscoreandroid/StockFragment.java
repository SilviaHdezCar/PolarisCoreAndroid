package com.example.wposs_user.polariscoreandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StockFragment extends Fragment {


    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_stock, container, false);
        // Inflate the layout for this fragment
        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) container.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        tabs.setBackgroundColor(Color.parseColor("#45A5F3"));
        appBar.addView(tabs);

        viewPager = (ViewPager) v.findViewById(R.id.pager_stock);//*******buscar pager
        StockFragment.ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);



              return v;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }



    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String[]tituloTabs={"Terminales", "Repuestos"};



        @Override
        public Fragment getItem(int i) {

            switch (i){
                case 0:
                    Tab_terminal tb = new Tab_terminal();
                    return  tb;
                case 1:
                    Tab_repuesto tr= new Tab_repuesto();
                    return  tr;
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tituloTabs[position];
        }
    }
}
