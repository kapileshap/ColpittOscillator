package com.example.user.colpittoscillator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Vcc,Ic,F;
    TextView Re,Rc,Ce,C1,R1,R2,C2,L;
    Button generate;



    double vol,cur,f,r0,ca,rc,b,vbb,r1,r2,c1,c2,l,vce,ve,vb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.user.colpittoscillator.R.layout.activity_main);
        Vcc=(EditText)findViewById(com.example.user.colpittoscillator.R.id.editText2);
        Ic=(EditText)findViewById(com.example.user.colpittoscillator.R.id.editText3);
        F=(EditText)findViewById(com.example.user.colpittoscillator.R.id.editText4);
        Re=(TextView)findViewById(R.id.editRe);
        Rc=(TextView)findViewById(R.id.editRc);
        Ce=(TextView)findViewById(R.id.editC);
        C1=(TextView)findViewById(R.id.editC1);
        R1=(TextView)findViewById(R.id.editR1);
        R2=(TextView)findViewById(R.id.editR2);
        C2=(TextView)findViewById(R.id.editC2);
        L=(TextView)findViewById(R.id.editL);
        generate=(Button)findViewById(R.id.buttonPanel);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vol= Double.parseDouble(Vcc.getText().toString());
                cur=Double.parseDouble(Ic.getText().toString());
                f=Double.parseDouble(F.getText().toString());
                vce=vol/2;
                ve=vol/10;
                r0=ve/(cur*0.001);
                rc= (vol-vce-(cur*0.001*r0))/(cur*0.001);
                r2=200*r0*0.1;
                vb=0.7+ve;
                r1= ((vol*r2)/vb)-r2;
                ca=33*10^-6;
                c1=10^-8;
                c2=10^-7;
                l=(c1+c2)/(c1*c2*4*3.14*3.14*f*f);
                Rc.setText(Double.toString(rc));
                Re.setText(Double.toString(r0));
                Ce.setText(Double.toString(ca));
                C1.setText(Double.toString(c1));
                R1.setText(Double.toString(r1));
                R2.setText(Double.toString(r2));
                C2.setText(Double.toString(c2));
                L.setText(Double.toString(l));

            }
        });
    }


}
