package com.example.telefonia;

//import com.example.lokalizacje.R;

//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.CellIdentityGsm;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;


public class MainActivity extends Activity { // >>>><< Telefonia - WERSJA 2 >><<<<<<

	
	ConnectivityManager polaczenie;
	NetworkInfo wifi, cdma;
	SignalStrength sila;
	WifiManager zarzadca_wifi;
	WifiInfo inf_wifi;
	
	SensorManager zarzadca_sensor;
	
	Sensor sensor_zyroskopX, sensor_zyroskopY, sensor_zyroskopZ;
	
	
	CellInfoGsm info_gsm;
	CellIdentityGsm identyfikator_gsm;
	
	CellSignalStrength sila_sygnalu;
	
	TelephonyManager komorka;
	
	int wifi_ip_adres, wifi_sila_sygnalu, wifi_id, wifi_speed, mobilny_typ, poziom_sygnalu_gsm;
	String wifi_mac_adress, wifi_ssid, wifi_bssid, imei;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		EkranStart();
		
		
		
		
		
	}

		private void EkranStart() {
		
			setContentView(R.layout.activity_start);
			
			Button btn_pomiary = (Button)findViewById(R.id.btn_pomiary);
			Button btn_rejestr = (Button)findViewById(R.id.btn_rejestr);
			
			btn_pomiary.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranPomiary();
						}
					});
			
		// TODO Auto-generated method stub
		
	}

		protected void EkranPomiary() {
		
			setContentView(R.layout.activity_pomiary);
			
			Button btn_wifi = (Button)findViewById(R.id.btn_wifi);
			Button btn_komorka = (Button)findViewById(R.id.btn_komorka);
			Button btn_poziomica = (Button)findViewById(R.id.btn_poziomica);
			
			Button btn_powrot_pomiary = (Button)findViewById(R.id.btn_powrot_pomiary);
			
			btn_wifi.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranWifi();
							
						}
					});
			
			btn_komorka.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranKomorka();
							
						}
					});
			
			btn_poziomica.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranPoziomica();
							
						}
					});
			


			btn_powrot_pomiary.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranStart();
							
						}
					});

		}

		protected void EkranPoziomica() {
			setContentView(R.layout.activity_poziomica);
			
			Button btn_pomiary_zyroskop = (Button)findViewById(R.id.btn_pomior_zyroskop);
			Button btn_powrot_poziomica = (Button)findViewById(R.id.btn_poziomica_powrot);
			
			btn_pomiary_zyroskop.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							InformacjeZyrokop();
						}
						
					});
			
			btn_powrot_poziomica.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranPomiary();
						}
						
					});
			
		}

		protected void InformacjeZyrokop() {
			
			TextView text_polozenieX = (TextView)findViewById(R.id.text_polozenieX); 
			TextView text_polozenieY = (TextView)findViewById(R.id.text_polozenieY);
			TextView text_polozenieZ = (TextView)findViewById(R.id.text_polozenieZ);
			
			SensorManager zarzadca_sensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
			Sensor sensor_zyroskopX = zarzadca_sensor.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
			//Sensor sensor_zyroskopY = zarzadca_sensor.getDefaultSensor(SensorManager.RAW_DATA_Y);
			//Sensor sensor_zyroskopZ = zarzadca_sensor.getDefaultSensor(SensorManager.RAW_DATA_Z);
			
			String polozenieX = sensor_zyroskopX.getName();
			//String polozenieY = sensor_zyroskopY.getName();
			//String polozenieZ = sensor_zyroskopZ.getName();
			
			text_polozenieX.setText(polozenieX);
			//text_polozenieY.setText(polozenieY);
			//text_polozenieZ.setText(polozenieZ);
		}

		protected void EkranKomorka() {
			setContentView(R.layout.activity_komorla);
			
			Button btn_komorka_info = (Button)findViewById(R.id.btn_komorka_info);
			Button btn_powrot_komorka = (Button)findViewById(R.id.btn_powrot_komorka);
			
			btn_komorka_info.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							InfoKomorka();
							
						}
					});

			btn_powrot_komorka.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranPomiary();
							
						}
					});
			
		}

		protected void InfoKomorka() {
			
			TextView text_imei = (TextView)findViewById(R.id.text_imei);
			TextView text_imei_sv = (TextView)findViewById(R.id.text_imei_sv);
			TextView text_nazwa_operatora = (TextView)findViewById(R.id.text_nazwa_operatora);
			TextView text_numer_abonenta = (TextView)findViewById(R.id.text_numer_abonenta);
			TextView text_typ_sieci = (TextView)findViewById(R.id.text_typ_sieci);
			//TextView text_poziom_sygnalu_gsm = (TextView)findViewById(R.id.text_poziom_sygnalu_gsm);
			
			TelephonyManager komorka = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
			 
			
			String imei = komorka.getDeviceId();
			String imei_sv = komorka.getDeviceSoftwareVersion();
			String nazwa_operatora = komorka.getNetworkOperatorName();
			String numer_abonenta = komorka.getLine1Number();
			
			int mobilny_typ = komorka.getNetworkType();
			//int poziom_sygnalu_gsm = sila_sygnalu.getDbm();
			
			text_imei.setText(imei);
			text_imei_sv.setText(imei_sv);
			text_nazwa_operatora.setText(nazwa_operatora);
			text_numer_abonenta.setText(numer_abonenta);
			text_typ_sieci.setText(String.valueOf(mobilny_typ));
			//text_poziom_sygnalu_gsm.setText(String.valueOf(poziom_sygnalu_gsm));
			
		}

		protected void EkranWifi() {
			setContentView(R.layout.activity_wifi);
			
			Button btn_inf_wifi = (Button)findViewById(R.id.btn_inf_wifi);
			Button btn_powrot_wifi = (Button)findViewById(R.id.btn_powrot_wifi);
			ToggleButton btn_wifi_on_off = (ToggleButton)findViewById(R.id.btn_wifi_on_off);
			
			btn_inf_wifi.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							InformacjeWifi();
							
						}
					});
			
			btn_powrot_wifi.setOnClickListener(
					new OnClickListener() {
						public void onClick(View v) {
							EkranPomiary();
							
						}
					});
			

			
						
		}

		protected void InformacjeWifi() {
		

			
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
			
			
			
			wifi = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			cdma = polaczenie.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			
			
			text_wifi_moc.setText(String.valueOf(wifi_sila_sygnalu)+ " dBm");
			text_wifi_ip.setText(String.valueOf(wifi_ip_adres));
			text_wifi_mac.setText(wifi_mac_adress);
			text_wifi_ssid.setText(wifi_ssid);
			text_wifi_bssid.setText(wifi_bssid);
			text_wifi_id.setText(String.valueOf(wifi_id));
			text_wifi_speed.setText(String.valueOf(wifi_speed)+" Mb/s");
		
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

	

	

	

	


