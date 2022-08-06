package com.example.testvirtualapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AdapterItem adapterItem;
    private RecyclerView rvApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvApps = findViewById(R.id.lv_apps);

    }

    public void onClickBtListApps(View view) throws PackageManager.NameNotFoundException {
        //        getApplications(this);
//        installApps();installApps
//        getListNamePackage();
          setDataRv();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setDataRv() throws PackageManager.NameNotFoundException {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvApps.setLayoutManager(linearLayoutManager);
        adapterItem = new AdapterItem(setDataListApp());
        rvApps.setAdapter(adapterItem);
        adapterItem.notifyDataSetChanged();
    }

    public List<ItemApp> setDataListApp() throws PackageManager.NameNotFoundException {
        List<ItemApp> listItemApp = new ArrayList<>();
        List<ApplicationInfo> list = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);

        for(int i = 0; i<list.size(); i++){
            ApplicationInfo applicationInfo = list.get(i);
            String namePackage = applicationInfo.packageName.toString();
            PackageInfo nameApp = getPackageManager().getPackageInfo(namePackage, 0);
            String name = nameApp.applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable drawable = getPackageManager().getApplicationIcon(namePackage);
            listItemApp.add(new ItemApp(name, drawable));
        }
        Log.d("SIZE: ", listItemApp.size()+"");
        return listItemApp;
    }

    public void getListNamePackage() throws PackageManager.NameNotFoundException {
        List<ApplicationInfo> listApp = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        for(int i = 0; i<listApp.size(); i++){
            ApplicationInfo applicationInfo = listApp.get(i);
            String namePackage = applicationInfo.packageName.toString();
            Log.d("NAME PACKAGE "+i+": ", namePackage);
            PackageInfo nameApp = getPackageManager().getPackageInfo(namePackage, 0);
            String name = nameApp.applicationInfo.loadLabel(getPackageManager()).toString();
            Log.e("APP NAME: ", name+"");
            Drawable drawable = getPackageManager().getApplicationIcon(namePackage);
        }
    }

    public void listApp(){
        List<ApplicationInfo> listApp = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        String [] strings = new String[listApp.size()];

        int i = 0;
        for(ApplicationInfo applicationInfo:listApp){
            strings[i] = applicationInfo.packageName;
            i++;
        }
    }

    public void installApps(){
        List<PackageInfo> list = getPackageManager().getInstalledPackages(0);

        for (int i = 0; i< list.size(); i++){
            PackageInfo packageInfo  = list.get(i);
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0){
                String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Log.d("NAME APP: ", appName);
            }
        }
    }

    public void installedApps()
    {
        List<PackageInfo> packList = getPackageManager().getInstalledPackages(0);
        for (int i=0; i < packList.size(); i++)
        {
            PackageInfo packInfo = packList.get(i);
            if (  (packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
            {
                String appName = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Log.e("App  " + i, appName);
            }
        }
    }

    public static List<ApplicationInfo> getApplications(Context context) {

        return context.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
    }
}