package com.example.user.dialogbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableActivity extends Activity {

    CustomExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    ImageView imageViewadd,imageViewminus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        imageViewadd=(ImageView)findViewById(R.id.imgadd);
        imageViewminus=(ImageView)findViewById(R.id.imgminus);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new CustomExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("What is the storage capacity of Apple iPhone 7 Plus? Can we expand it by using a dedicated MicroSD card?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("What is the storage capacity of Apple iPhone 7 Plus? Can we expand it by using a dedicated MicroSD card?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("What is the storage capacity of Apple iPhone 7 Plus? Can we expand it by using a dedicated MicroSD card?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("What is the storage capacity of Apple iPhone 7 Plus? Can we expand it by using a dedicated MicroSD card?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("What is the storage capacity of Apple iPhone 7 Plus? Can we expand it by using a dedicated MicroSD card?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");
        listDataHeader.add("How can I listen to my favorite music or videos over the phone?");

        // Adding child data
        List<String> list1 = new ArrayList<String>();
        list1.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");

        List<String> list2 = new ArrayList<String>();
        list2.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list3 = new ArrayList<String>();
        list3.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list4 = new ArrayList<String>();
        list4.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list5 = new ArrayList<String>();
        list5.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list6 = new ArrayList<String>();
        list6.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list7 = new ArrayList<String>();
        list7.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list8 = new ArrayList<String>();
        list8.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list9 = new ArrayList<String>();
        list9.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list10 = new ArrayList<String>();
        list10.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list11 = new ArrayList<String>();
        list11.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list12 = new ArrayList<String>();
        list12.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list13 = new ArrayList<String>();
        list13.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list14 = new ArrayList<String>();
        list14.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");
        List<String> list15 = new ArrayList<String>();
        list15.add("The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption The Shawshank Redemption");



        listDataChild.put(listDataHeader.get(0), list1);// Header, Child data
        listDataChild.put(listDataHeader.get(1), list2);
        listDataChild.put(listDataHeader.get(2), list3);
        listDataChild.put(listDataHeader.get(3), list4);
        listDataChild.put(listDataHeader.get(4), list5);
        listDataChild.put(listDataHeader.get(5), list6);
        listDataChild.put(listDataHeader.get(6), list7);
        listDataChild.put(listDataHeader.get(7), list8);
        listDataChild.put(listDataHeader.get(8), list9);// Header, Child data
        listDataChild.put(listDataHeader.get(9), list10);
        listDataChild.put(listDataHeader.get(10), list11);
        listDataChild.put(listDataHeader.get(11), list12);
        listDataChild.put(listDataHeader.get(12), list13);
        listDataChild.put(listDataHeader.get(13), list14);
        listDataChild.put(listDataHeader.get(14), list15);


    }
}

