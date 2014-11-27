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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.Context;


public class MainActivity extends Activity { // >>>><< Telefonia - WERSJA 2 >><<<<<<

	
	ConnectivityManager polaczenie;
	NetworkInfo wifi, cdma;
	SignalStrength sila_sygnalu;
	WifiManager zarzadca_wifi;
	WifiInfo inf_wifi;
	
	int wifi_ip_adres, wifi_sila_sygnalu, wifi_id, wifi_speed;
	String wifi_mac_adress, wifi_ssid, wifi_bssid;
	
	
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
		
			
			ToggleButton btn_wifi_on_off = (ToggleButton)findViewById(R.id.btn_wifi_on_off);
			
			TextView text_wifi_moc = (TextView)findViewById(R.id.wifi_moc);
			TextView text_wifi_ip = (TextView)findViewById(R.id.wifi_ip);
			TextView text_wifi_mac = (TextView)findViewById(R.id.wifi_mac_adres);
			TextView text_wifi_ssid = (TextView)findViewById(R.id.wifi_ssid);
			TextView text_wifi_bssid = (TextView)findViewById(R.id.wifi_bssid);
			TextView text_wifi_id = (TextView)findViewById(R.id.wifi_id_sieci);
			TextView text_wifi_speed = (TextView)findViewById(R.id.wifi_speed);
			TextView text_wifi_status = (TextView)findViewById(R.id.wifi_status);
			
		polaczenie = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		
		zarzadca_wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
		
		inf_wifi = zarzadca_wifi.getConnectionInfo();
		
		wifi_sila_sygnalu = inf_wifi.getRssi();
		wifi_ip_adres = inf_wifi.getIpAddress();
		wifi_mac_adress = inf_wifi.getMacAddress();
		wifi_ssid = inf_wifi.getSSID();
		wifi_bssid = inf_wifi.getBSSID();
		wifi_id = inf_wifi.getNetworkId();
		wifi_speed = inf_wifi.getLinkSpeed();
		
		text_wifi_moc.setText(String.valueOf(wifi_sila_sygnalu)+ " dBm");
		text_wifi_ip.setText(String.valueOf(wifi_ip_adres));
		text_wifi_mac.setText(wifi_mac_adress);
		text_wifi_ssid.setText(wifi_ssid);
		text_wifi_bssid.setText(wifi_bssid);
		text_wifi_id.setText(String.valueOf(wifi_id));
		text_wifi_speed.setText(String.valueOf(wifi_speed)+" Mb/s");
		
		
		wifi = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		cdma = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		
		if(wifi.isConnected())
			text_wifi_status.setText("POгеCZONO");
		else
			text_wifi_status.setText("NIE POгеCZONO");
		/*{
		Toast.makeText(this, "Wifi POгеCZONA!!!!", Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Ip Adres to" + wifi_ip_adres , Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Moc sygna│u to : " + wifi_sila_sygnalu + " dbm " , Toast.LENGTH_LONG).show();}
	
	else
		Toast.makeText(this, "Wifi NIE POгеCZONA!!!!", Toast.LENGTH_LONG).show();
	
	if(cdma.isConnected())
		Toast.makeText(this, "3G/4A POгеCZONA!!!!", Toast.LENGTH_LONG).show();
	else
		Toast.makeText(this, "3G/4G NIE POгеCZONA!!!!", Toast.LENGTH_LONG).show();

		*/
	}

	
}

	

	

	

	


