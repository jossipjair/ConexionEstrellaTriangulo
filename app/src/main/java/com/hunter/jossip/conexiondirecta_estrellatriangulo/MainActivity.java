package com.hunter.jossip.conexiondirecta_estrellatriangulo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String datos[][] = new String[26][8];
    private String dataEstrella[][] = new String[28][8];

    private Spinner sRed;
    private Spinner sHp;
    private TextView tCol2;
    private TextView tCol3;
    private TextView tCol4;
    private TextView tCol5;
    private TextView tCol6;
    private TextView tCol7;
    private RadioButton rDirecta;
    private RadioButton rEstrella;

    private TextView txCol2;
    private TextView txCol3;
    private TextView txCol4;
    private TextView txCol5;
    private TextView txCol6;
    private TextView txCol7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
        llenarSpinnerRed();
    }

    public void inicializarElementos(){
        sRed = (Spinner) findViewById(R.id.spRed);
        sHp = (Spinner) findViewById(R.id.spHp);
        tCol2 = (TextView) findViewById(R.id.txtCol2);
        tCol3 = (TextView) findViewById(R.id.txtCol3);
        tCol4 = (TextView) findViewById(R.id.txtCol4);
        tCol5 = (TextView) findViewById(R.id.txtCol5);
        tCol6 = (TextView) findViewById(R.id.txtCol6);
        tCol7 = (TextView) findViewById(R.id.txtCol7);

        txCol2 = (TextView) findViewById(R.id.txCol2);
        txCol3 = (TextView) findViewById(R.id.txCol3);
        txCol4 = (TextView) findViewById(R.id.txCol4);
        txCol5 = (TextView) findViewById(R.id.txCol5);
        txCol6 = (TextView) findViewById(R.id.txCol6);
        txCol7 = (TextView) findViewById(R.id.txCol7);


        rDirecta = (RadioButton) findViewById(R.id.optDirecta);
        rEstrella = (RadioButton) findViewById(R.id.optEstrella);
    }

    public void llenarSpinnerRed(){
        Spinner spRed = (Spinner) findViewById(R.id.spRed);
        String red[] = {"220", "440"};
        spRed.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, red));
        limpiar();
    }

    public void llenarSpinnerHpDirecta(View v1){
        Spinner spHp =  (Spinner) findViewById(R.id.spHp);
        String hp[] = {"1", "1.5", "2", "3", "4", "5.5", "7.5", "10", "12", "15", "20", "25", "30", "40"};
        spHp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hp));
        tituloDatosDirecta();
        limpiar();
    }


    public void llenarSpinnerHpEstrella(View v){
        Spinner spHp = (Spinner) findViewById(R.id.spHp);
        String spHpEstrella[] = {"5.5", "7.5", "10", "12", "15", "20", "25", "30", "40", "50", "60", "75", "100", "125", "150", "167"};
        spHp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spHpEstrella));
        tituloDatosEstrella();
        limpiar();
    }

    public void tituloDatosDirecta(){
        txCol2.setText("Ampere:");
        txCol3.setText("AWG/mm:");
        txCol4.setText("GuardaMotor:");
        txCol5.setText("Contactor:");
        txCol6.setText("Rele:");
        txCol7.setText("kW:");
    }

    public void tituloDatosEstrella(){
        txCol2.setText("Ampere:");
        txCol3.setText("Línea AWG/mm:");
        txCol4.setText("PΔ / Y:");
        txCol5.setText("Rele:");
        txCol6.setText("Motor AWG/mm:");
        txCol7.setText("kW:");
    }

    public void limpiar(){
        tCol2.setText("");
        tCol3.setText("");
        tCol4.setText("");
        tCol5.setText("");
        tCol6.setText("");
        tCol7.setText("");
    }

    public void calcularDatos(View view){
        try {
            if(rDirecta.isChecked()){
                buscarDirecta();
            }else{
                buscarDatoEstrella();
            }
        }catch (Exception ex){

        }

    }

    public void buscarDirecta(){
        llenarMatriz();
        limpiar();
        String red = sRed.getSelectedItem().toString();
        String hp = sHp.getSelectedItem().toString();

        for (int i = 0; i <= datos.length; i++){
            if(datos[i][0].equals(red) && datos[i][1].equals(hp)){
                tCol2.setText(datos[i][2]);
                tCol3.setText(datos[i][3]);
                tCol4.setText(datos[i][4]);
                tCol5.setText(datos[i][5]);
                tCol6.setText(datos[i][6]);
                tCol7.setText(datos[i][7]);
            }
        }
    }


    public void buscarDatoEstrella(){
        llenarDatosEstrella();
        limpiar();
        String red = sRed.getSelectedItem().toString();
        String hp = sHp.getSelectedItem().toString();

        for(int i = 0; i <= dataEstrella.length; i++){
            if((dataEstrella[i][0]).equals(red) && (dataEstrella[i][1]).equals(hp)){
                tCol2.setText(dataEstrella[i][2]);
                tCol3.setText(dataEstrella[i][3]);
                tCol4.setText(dataEstrella[i][4]);
                tCol5.setText(dataEstrella[i][5]);
                tCol6.setText(dataEstrella[i][6]);
                tCol7.setText(dataEstrella[i][7]);
            }
        }
    }





    public void llenarMatriz(){

        //COLUMNA 1: RED W
        //COLUMNA 2: HP
        //COLUMNA 3: AMP
        //COLUMNA 4: AWG
        //COLUMNA 5: GUARDAMOTOR
        //COLUMNA 6: CONTACTOR
        //COLUMNA 7: RELE
        //COLUMNA 8: KW


        datos[0][0] = "220";
        datos[0][1] = "1";
        datos[0][2] = "3.5";
        datos[0][3] = "12";
        datos[0][4] = "2.5 - 4";
        datos[0][5] = "09";
        datos[0][6] = "2.5 - 4";
        datos[0][7] = "0.75";

        datos[1][0] = "440";
        datos[1][1] = "1";
        datos[1][2] = "1.75";
        datos[1][3] = "12";
        datos[1][4] = "1.6 - 2.5";
        datos[1][5] = "09";
        datos[1][6] = "1.6 - 2.5";
        datos[1][7] = "0.75";

        datos[2][0] = "220";
        datos[2][1] = "1.5";
        datos[2][2] = "4.9";
        datos[2][3] = "12";
        datos[2][4] = "4 - 6";
        datos[2][5] = "09";
        datos[2][6] = "4 - 6";
        datos[2][7] = "1.1";

        datos[3][0] = "440";
        datos[3][1] = "1.5";
        datos[3][2] = "2.49";
        datos[3][3] = "12";
        datos[3][4] = "2.5 - 4";
        datos[3][5] = "09";
        datos[3][6] = "2.5 - 4";
        datos[3][7] = "1.1";

        datos[4][0] = "220";
        datos[4][1] = "2";
        datos[4][2] = "6.4";
        datos[4][3] = "12";
        datos[4][4] = "6 - 10";
        datos[4][5] = "09";
        datos[4][6] = "5.5 -8";
        datos[4][7] = "1.5";

        datos[5][0] = "440";
        datos[5][1] = "2";
        datos[5][2] = "3.2";
        datos[5][3] = "12";
        datos[5][4] = "2.5 - 4";
        datos[5][5] = "09";
        datos[5][6] = "2.5 - 4";
        datos[5][7] = "1.5";

        datos[6][0] = "220";
        datos[6][1] = "3";
        datos[6][2] = "9.2";
        datos[6][3] = "12";
        datos[6][4] = "6 - 10";
        datos[6][5] = "12";
        datos[6][6] = "7 - 10";
        datos[6][7] = "2.2";

        datos[7][0] = "440";
        datos[7][1] = "3";
        datos[7][2] = "4.6";
        datos[7][3] = "12";
        datos[7][4] = "4 -6";
        datos[7][5] = "12";
        datos[7][6] = "4 - 6";
        datos[7][7] = "2.2";

        datos[8][0] = "220";
        datos[8][1] = "4";
        datos[8][2] = "12";
        datos[8][3] = "12";
        datos[8][4] = "9 - 14";
        datos[8][5] = "18";
        datos[8][6] = "9 - 13";
        datos[8][7] = "3";

        datos[9][0] = "440";
        datos[9][1] = "4";
        datos[9][2] = "6";
        datos[9][3] = "12";
        datos[9][4] = "6 - 10";
        datos[9][5] = "09";
        datos[9][6] = "5.5 - 8";
        datos[9][7] = "3";

        datos[10][0] = "220";
        datos[10][1] = "5.5";
        datos[10][2] = "15.8";
        datos[10][3] = "12";
        datos[10][4] = "12 - 18";
        datos[10][5] = "18";
        datos[10][6] = "12 - 18";
        datos[10][7] = "4";

        datos[11][0] = "440";
        datos[11][1] = "5.5";
        datos[11][2] = "7.9";
        datos[11][3] = "12";
        datos[11][4] = "6 - 10";
        datos[11][5] = "09";
        datos[11][6] = "7 - 10";
        datos[11][7] = "4";

        datos[12][0] = "220";
        datos[12][1] = "7.5";
        datos[12][2] = "21";
        datos[12][3] = "10";
        datos[12][4] = "20 - 25";
        datos[12][5] = "25";
        datos[12][6] = "17 - 25";
        datos[12][7] = "5.5";

        datos[13][0] = "440";
        datos[13][1] = "7.5";
        datos[13][2] = "10.5";
        datos[13][3] = "12";
        datos[13][4] = "9 - 14";
        datos[13][5] = "12";
        datos[13][6] = "9 - 13";
        datos[13][7] = "5.5";

        datos[14][0] = "220";
        datos[14][1] = "10";
        datos[14][2] = "27.5";
        datos[14][3] = "10";
        datos[14][4] = "";
        datos[14][5] = "32";
        datos[14][6] = "23 - 32";
        datos[14][7] = "7.5";

        datos[15][0] = "440";
        datos[15][1] = "10";
        datos[15][2] = "13.7";
        datos[15][3] = "12";
        datos[15][4] = "10 - 16";
        datos[15][5] = "18";
        datos[15][6] = "12 - 18";
        datos[15][7] = "7.5";

        datos[16][0] = "220";
        datos[16][1] = "12";
        datos[16][2] = "33";
        datos[16][3] = "8";
        datos[16][4] = "";
        datos[16][5] = "40";
        datos[16][6] = "30 - 40";
        datos[16][7] = "9";

        datos[17][0] = "440";
        datos[17][1] = "12";
        datos[17][2] = "16.5";
        datos[17][3] = "12";
        datos[17][4] = "17 - 25";
        datos[17][5] = "25";
        datos[17][6] = "17 - 25";
        datos[17][7] = "9";

        datos[18][0] = "220";
        datos[18][1] = "15";
        datos[18][2] = "40";
        datos[18][3] = "8";
        datos[18][4] = "";
        datos[18][5] = "50";
        datos[18][6] = "37 - 50";
        datos[18][7] = "11";

        datos[19][0] = "440";
        datos[19][1] = "15";
        datos[19][2] = "20";
        datos[19][3] = "12";
        datos[19][4] = "";
        datos[19][5] = "25";
        datos[19][6] = "17  - 25";
        datos[19][7] = "11";


        datos[20][0] = "220";
        datos[20][1] = "20";
        datos[20][2] = "52";
        datos[20][3] = "6";
        datos[20][4] = "";
        datos[20][5] = "65";
        datos[20][6] = "48 - 65";
        datos[20][7] = "15";

        datos[21][0] = "440";
        datos[21][1] = "20";
        datos[21][2] = "26";
        datos[21][3] = "10";
        datos[21][4] = "";
        datos[21][5] = "32";
        datos[21][6] = "23 - 32";
        datos[21][7] = "15";

        datos[22][0] = "220";
        datos[22][1] = "25";
        datos[22][2] = "64";
        datos[22][3] = "4";
        datos[22][4] = "";
        datos[22][5] = "65";
        datos[22][6] = "55 - 70";
        datos[22][7] = "18.5";

        datos[23][0] = "440";
        datos[23][1] = "25";
        datos[23][2] = "32";
        datos[23][3] = "10";
        datos[23][4] = "";
        datos[23][5] = "32";
        datos[23][6] = "23 - 32";
        datos[23][7] = "18.5";

        datos[24][0] = "440";
        datos[24][1] = "30";
        datos[24][2] = "37";
        datos[24][3] = "8";
        datos[24][4] = "";
        datos[24][5] = "40";
        datos[24][6] = "30 - 40";
        datos[24][7] = "22";

        datos[25][0] = "440";
        datos[25][1] = "40";
        datos[25][2] = "50";
        datos[25][3] = "6";
        datos[25][4] = "";
        datos[25][5] = "65";
        datos[25][6] = "48 - 65";
        datos[25][7] = "30";
    }


    public void llenarDatosEstrella(){

        //COLUMNA 1:	RED
        //COLUMNA 2:	HP
        //COLUMNA 3:	AMP
        //COLUMNA 4:	AWG LINEA / CABLE
        //COLUMNA 5:	PΔ / Y
        //COLUMNA 6:	RELE
        //COLUMNA 7:	AWG MOTOR
        //COLUMNA 8:	kW

        dataEstrella[0][0] = "220";
        dataEstrella[0][1] = "5.5";
        dataEstrella[0][2] = "15.8";
        dataEstrella[0][3] = "12";
        dataEstrella[0][4] = "12 / 09";
        dataEstrella[0][5] = "7 - 10";
        dataEstrella[0][6] = "12";
        dataEstrella[0][7] = "4";

        dataEstrella[1][0] = "440";
        dataEstrella[1][1] = "5.5";
        dataEstrella[1][2] = "7.9";
        dataEstrella[1][3] = "12";
        dataEstrella[1][4] = "09 / 09";
        dataEstrella[1][5] = "4 - 6";
        dataEstrella[1][6] = "12";
        dataEstrella[1][7] = "4";

        dataEstrella[2][0] = "220";
        dataEstrella[2][1] = "7.5";
        dataEstrella[2][2] = "21";
        dataEstrella[2][3] = "10";
        dataEstrella[2][4] = "18 / 09";
        dataEstrella[2][5] = "9 - 13";
        dataEstrella[2][6] = "12";
        dataEstrella[2][7] = "5.5";

        dataEstrella[3][0] = "440";
        dataEstrella[3][1] = "7.5";
        dataEstrella[3][2] = "10.5";
        dataEstrella[3][3] = "12";
        dataEstrella[3][4] = "09 / 09";
        dataEstrella[3][5] = "5.5 - 8";
        dataEstrella[3][6] = "12";
        dataEstrella[3][7] = "5.5";

        dataEstrella[4][0] = "220";
        dataEstrella[4][1] = "10";
        dataEstrella[4][2] = "27";
        dataEstrella[4][3] = "10";
        dataEstrella[4][4] = "18 / 12";
        dataEstrella[4][5] = "12 - 18";
        dataEstrella[4][6] = "12";
        dataEstrella[4][7] = "7.5";

        dataEstrella[5][0] = "440";
        dataEstrella[5][1] = "10";
        dataEstrella[5][2] = "13.7";
        dataEstrella[5][3] = "12";
        dataEstrella[5][4] = "09 / 09";
        dataEstrella[5][5] = "7 - 10";
        dataEstrella[5][6] = "12";
        dataEstrella[5][7] = "7.5";

        dataEstrella[6][0] = "220";
        dataEstrella[6][1] = "12";
        dataEstrella[6][2] = "33";
        dataEstrella[6][3] = "8";
        dataEstrella[6][4] = "25 / 12";
        dataEstrella[6][5] = "17 - 25";
        dataEstrella[6][6] = "12";
        dataEstrella[6][7] = "9";

        dataEstrella[7][0] = "440";
        dataEstrella[7][1] = "12";
        dataEstrella[7][2] = "16.5";
        dataEstrella[7][3] = "12";
        dataEstrella[7][4] = "12 / 09";
        dataEstrella[7][5] = "7 - 10";
        dataEstrella[7][6] = "12";
        dataEstrella[7][7] = "9";

        dataEstrella[8][0] = "220";
        dataEstrella[8][1] = "15";
        dataEstrella[8][2] = "40";
        dataEstrella[8][3] = "8";
        dataEstrella[8][4] = "25 / 18";
        dataEstrella[8][5] = "17 - 25";
        dataEstrella[8][6] = "10";
        dataEstrella[8][7] = "11";

        dataEstrella[9][0] = "440";
        dataEstrella[9][1] = "15";
        dataEstrella[9][2] = "20";
        dataEstrella[9][3] = "12";
        dataEstrella[9][4] = "12 / 09";
        dataEstrella[9][5] = "9 - 13";
        dataEstrella[9][6] = "12";
        dataEstrella[9][7] = "11";

        dataEstrella[10][0] = "220";
        dataEstrella[10][1] = "20";
        dataEstrella[10][2] = "52";
        dataEstrella[10][3] = "6";
        dataEstrella[10][4] = "32 / 25";
        dataEstrella[10][5] = "23 - 32";
        dataEstrella[10][6] = "10";
        dataEstrella[10][7] = "15";

        dataEstrella[11][0] = "440";
        dataEstrella[11][1] = "20";
        dataEstrella[11][2] = "26";
        dataEstrella[11][3] = "10";
        dataEstrella[11][4] = "18 / 09";
        dataEstrella[11][5] = "12 - 18";
        dataEstrella[11][6] = "12";
        dataEstrella[11][7] = "15";

        dataEstrella[12][0] = "220";
        dataEstrella[12][1] = "25";
        dataEstrella[12][2] = "64";
        dataEstrella[12][3] = "4";
        dataEstrella[12][4] = "40 / 25";
        dataEstrella[12][5] = "30 - 40";
        dataEstrella[12][6] = "8";
        dataEstrella[12][7] = "18.5";

        dataEstrella[13][0] = "440";
        dataEstrella[13][1] = "25";
        dataEstrella[13][2] = "32";
        dataEstrella[13][3] = "8";
        dataEstrella[13][4] = "25 / 12";
        dataEstrella[13][5] = "17 - 25";
        dataEstrella[13][6] = "12";
        dataEstrella[13][7] = "18.5";

        dataEstrella[14][0] = "220";
        dataEstrella[14][1] = "30";
        dataEstrella[14][2] = "77";
        dataEstrella[14][3] = "2";
        dataEstrella[14][4] = "50 / 32";
        dataEstrella[14][5] = "37 - 50";
        dataEstrella[14][6] = "6";
        dataEstrella[14][7] = "22";

        dataEstrella[15][0] = "440";
        dataEstrella[15][1] = "30";
        dataEstrella[15][2] = "38.5";
        dataEstrella[15][3] = "8";
        dataEstrella[15][4] = "25 / 18";
        dataEstrella[15][5] = "17 - 25";
        dataEstrella[15][6] = "10";
        dataEstrella[15][7] = "22";

        dataEstrella[16][0] = "220";
        dataEstrella[16][1] = "40";
        dataEstrella[16][2] = "102";
        dataEstrella[16][3] = "";
        dataEstrella[16][4] = "65 / 40";
        dataEstrella[16][5] = "48 - 65";
        dataEstrella[16][6] = "4";
        dataEstrella[16][7] = "30";

        dataEstrella[17][0] = "440";
        dataEstrella[17][1] = "40";
        dataEstrella[17][2] = "51";
        dataEstrella[17][3] = "6";
        dataEstrella[17][4] = "32 / 18";
        dataEstrella[17][5] = "23 - 32";
        dataEstrella[17][6] = "10";
        dataEstrella[17][7] = "30";

        dataEstrella[18][0] = "220";
        dataEstrella[18][1] = "50";
        dataEstrella[18][2] = "126";
        dataEstrella[18][3] = "2 / 0";
        dataEstrella[18][4] = "80 / 50";
        dataEstrella[18][5] = "66 - 80";
        dataEstrella[18][6] = "2";
        dataEstrella[18][7] = "37";

        dataEstrella[19][0] = "440";
        dataEstrella[19][1] = "50";
        dataEstrella[19][2] = "63";
        dataEstrella[19][3] = "4";
        dataEstrella[19][4] = "40 / 25";
        dataEstrella[19][5] = "30 - 40";
        dataEstrella[19][6] = "8";
        dataEstrella[19][7] = "37";

        dataEstrella[20][0] = "220";
        dataEstrella[20][1] = "60";
        dataEstrella[20][2] = "150";
        dataEstrella[20][3] = "3 / 0";
        dataEstrella[20][4] = "95 / 65";
        dataEstrella[20][5] = "75 - 105";
        dataEstrella[20][6] = "2";
        dataEstrella[20][7] = "44.8";

        dataEstrella[21][0] = "440";
        dataEstrella[21][1] = "60";
        dataEstrella[21][2] = "75";
        dataEstrella[21][3] = "2";
        dataEstrella[21][4] = "50 / 32";
        dataEstrella[21][5] = "37 - 50";
        dataEstrella[21][6] = "6";
        dataEstrella[21][7] = "44.8";

        dataEstrella[22][0] = "220";
        dataEstrella[22][1] = "75";
        dataEstrella[22][2] = "187";
        dataEstrella[22][3] = "4 / 0";
        dataEstrella[22][4] = "115 / 65";
        dataEstrella[22][5] = "95 - 125";
        dataEstrella[22][6] = "1 / 0";
        dataEstrella[22][7] = "58.25";

        dataEstrella[23][0] = "440";
        dataEstrella[23][1] = "75";
        dataEstrella[23][2] = "93";
        dataEstrella[23][3] = "1 / 0";
        dataEstrella[23][4] = "65 / 40";
        dataEstrella[23][5] = "48 - 65";
        dataEstrella[23][6] = "6";
        dataEstrella[23][7] = "56.25";

        dataEstrella[24][0] = "440";
        dataEstrella[24][1] = "100";
        dataEstrella[24][2] = "123";
        dataEstrella[24][3] = "1 / 0";
        dataEstrella[24][4] = "80 / 50";
        dataEstrella[24][5] = "66 - 80";
        dataEstrella[24][6] = "2";
        dataEstrella[24][7] = "75";

        dataEstrella[25][0] = "440";
        dataEstrella[25][1] = "125";
        dataEstrella[25][2] = "157";
        dataEstrella[25][3] = "3 / 0";
        dataEstrella[25][4] = "95 / 65";
        dataEstrella[25][5] = "75 - 105";
        dataEstrella[25][6] = "2";
        dataEstrella[25][7] = "93.75";

        dataEstrella[26][0] = "440";
        dataEstrella[26][1] = "150";
        dataEstrella[26][2] = "185";
        dataEstrella[26][3] = "4 / 0";
        dataEstrella[26][4] = "115 / 65";
        dataEstrella[26][5] = "95 - 125";
        dataEstrella[26][6] = "1 / 0";
        dataEstrella[26][7] = "112.5";

        dataEstrella[27][0] = "440";
        dataEstrella[27][1] = "167";
        dataEstrella[27][2] = "208";
        dataEstrella[27][3] = "4 / 0";
        dataEstrella[27][4] = "150 / 95";
        dataEstrella[27][5] = "100 - 160";
        dataEstrella[27][6] = "1 / 0";
        dataEstrella[27][7] = "125";
    }





}
