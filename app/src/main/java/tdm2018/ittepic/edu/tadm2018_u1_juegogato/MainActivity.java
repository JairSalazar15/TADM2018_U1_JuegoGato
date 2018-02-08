package tdm2018.ittepic.edu.tadm2018_u1_juegogato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    TextView etiqueta;
    protected Button[] ArrButton;
    Object[][] unaMatriz;
    int contador_tiros;
    boolean esTurno;
    public void init (){
        unaMatriz=new Object[3][3];
        for (int i=0; i<3; i++){
            for (int j=0;j<3;j++){
                unaMatriz[i][j]=R.drawable.t;
            }
        }
        esTurno=true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=(Button)findViewById(R.id.btnA1);
        a2=(Button)findViewById(R.id.btnA2);
        a2=(Button)findViewById(R.id.btnA3);
        b1=(Button)findViewById(R.id.btnB1);
        b2=(Button)findViewById(R.id.btnB2);
        b3=(Button)findViewById(R.id.btnB3);
        c1=(Button)findViewById(R.id.btnC1);
        c2=(Button)findViewById(R.id.btnC2);
        c3 =(Button)findViewById(R.id.btnC3);
        etiqueta=(TextView)findViewById(R.id.textViewGato);

        ArrButton=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        for (Button b:ArrButton){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b=(Button)v;
                    this.click(b);
                }
                public void click(Button b){
                    int x=0;
                    if (esTurno){
                        x=R.drawable.x;
                        b.setBackgroundResource(x);
                    }else {
                        x=R.drawable.o;
                        b.setBackgroundResource(x);
                    }switch (b.getId()){
                        case R.id.btnA1:
                            unaMatriz[0][0]=x;
                            break;
                        case R.id.btnA2:
                            unaMatriz[0][1]=x;
                            break;
                        case R.id.btnA3:
                            unaMatriz[0][2]=x;
                            break;
                        case R.id.btnB1:
                            unaMatriz[1][0]=x;
                            break;
                        case R.id.btnB2:
                            unaMatriz[1][1]=x;
                            break;
                        case R.id.btnB3:
                            unaMatriz[1][2]=x;
                            break;
                        case R.id.btnC1:
                            unaMatriz[2][0]=x;
                            break;
                        case R.id.btnC2:
                            unaMatriz[2][1]=x;
                            break;
                        case R.id.btnC3:
                            unaMatriz[2][2]=x;
                            break;

                    }
                    esTurno = !esTurno;
                    b.setClickable(true);
                    contador_tiros++;
                    this.verificarMatriz();
                }
            });
        }
    }
}
