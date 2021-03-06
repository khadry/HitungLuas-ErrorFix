package com.nbs.app.hitungluas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang Lat1");

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        btnHitung = (Button)findViewById(R.id.btn_hitung);
        txtLuas = (TextView)findViewById(R.id.txt_luas);
        // Cek jika kosong
        if (edtPanjang.getText().toString().equals("")
                || edtLebar.getText().toString().equals("")){
            edtPanjang.setError("Tidak Boleh Kosong!!");
            edtLebar.setError("Tidak Boleh Kosong!!");
            edtPanjang.requestFocus();
            edtLebar.requestFocus();
        }
                btnHitung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String b1 = edtPanjang.getText().toString();
                    String b2 = edtLebar.getText().toString();

                    if(b1.isEmpty()||b2.isEmpty())
                    {
                        Toast emtystring = Toast.makeText(MainActivity.this,"Tidak boleh kosong!!!",Toast.LENGTH_SHORT);
                        emtystring.show();
                    }
                    else if(Character.isLetter(b1.charAt(0))||Character.isLetter(b2.charAt(0)))
                    {
                        Toast charstring = Toast.makeText(MainActivity.this, "Harus Angka !!!",Toast.LENGTH_SHORT);
                        charstring.show();
                    }
                    else {

                        String panjang = edtPanjang.getText().toString().trim();
                        String lebar = edtLebar.getText().toString().trim();

                        double p = Double.parseDouble(panjang);
                        double l = Double.parseDouble(lebar);

                        double luas = p * l;

                        txtLuas.setText("Luas : " + luas);
                    }
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
