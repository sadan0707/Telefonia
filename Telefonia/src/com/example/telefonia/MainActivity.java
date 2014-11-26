package com.example.telefonia;

//import com.example.lokalizacje.R;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;


public class MainActivity extends Activity { // >>>><< Telefonia - WERSJA 2 >><<<<<

	
	ConnectivityManager polaczenie;
	NetworkInfo wifi, cdma;
	SignalStrength sila_sygnalu;
	WifiManager zarzadca_wifi;
	WifiInfo inf_wifi;
	
	int wifi_ip_adres, wifi_sila_sygnalu;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn_inf_wifi = (Button)findViewById(R.id.btn_inf_wifi);
		
		btn_inf_wifi.setOnClickListener(
				new OnClickListener() {
					public void onClick(View v) {
						InformacjeWifi();
						
					}
				});

	}

		protected void InformacjeWifi() {
		
		polaczenie = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		
		zarzadca_wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
		
		inf_wifi = zarzadca_wifi.getConnectionInfo();
		
		wifi_ip_adres = inf_wifi.getIpAddress();
		wifi_sila_sygnalu = inf_wifi.getRssi();
		
		
		
		
		wifi = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		cdma = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		
		if(wifi.isConnected())
		{
		Toast.makeText(this, "Wifi PO£¥CZONA!!!!", Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Ip Adres to" + wifi_ip_adres , Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Moc sygna³u to : " + wifi_sila_sygnalu + " dbm " , Toast.LENGTH_LONG).show();}
	
	else
		Toast.makeText(this, "Wifi NIE PO£¥CZONA!!!!", Toast.LENGTH_LONG).show();
	
	if(cdma.isConnected())
		Toast.makeText(this, "3G/4A PO£¥CZONA!!!!", Toast.LENGTH_LONG).show();
	else
		Toast.makeText(this, "3G/4G NIE PO£¥CZONA!!!!", Toast.LENGTH_LONG).show();

		
	}

	
}

	

	

	

	


