package com.example.d18m10y21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.d18m10y21.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner spin;
    ListView lv;
    TextView tv1,tv2,tv3,tv4;
    static String[] class1 = {"Harel/Leibovich/10.10.2005/058","Noa/lev/10.1.2005/0587"
            ,"Nom/leu/1.9.2005/05878","Yo/nav/10.11.2005/0589","Agam/tol/10.1.2005/09987","harel/nav/27.10.2005/0787"
            ,"maya/lev/5.9.2008/05873","noi/perez/10.1.2005/0897","Rom/rose/8.1.2005/0467","tal/lif/83.2005/05456"};
    static String[] class2 = {"H/L/11.10.2005/0587","N/l/11.1.2005/05876"
            ,"N/N/2.9.2005/05878","Y/n/27.10.2005/05859","A/t/11.1.2005/099187","hl/v/28.10.2005/07857"
            ,"m/l/6.9.2008/058873","n/p/11.1.2005/0897","R/r/8.1.2005/0467","t/l/2.3.2005/05456"};
    static String[] class3 = {"marom/levin/18.10.2005/05897","Noam/Levin/19.1.2005/058876"
            ,"Ilay/Shimony/2.10.2005/058788","Roni/Rosh/9.10.2005/058599","Amit/Barel/11.12.2005/0992287","Noa/Shitrit/28.11.2005/078537"
            ,"Marom/Levin/7.9.2008/05888873","Ilai/Plact/11.11.2011/0975897","Ronit/levin/9.1.2005/057867","Keren/Vintrov/2.12.2005/0545586"};
    static String[] class4 = {"m/l/18.11.2005/058917","N/L/19.11.2005/0588716"
            ,"I/S/2.8.2005/05888","R/R/9.10.2005/0599","A/B/11.8.2005/087","N/S/28.10.2005/08537"
            ,"M/L/7.9.2028/058873","I/P/11.12.2011/0975","R/l/9.1.2085/05787","K/V/2.5.2015/05455"};
    static String[] classChoose= {"choose a class:","class1","class2","class3","class4"};

    static String [] show =new String[10];
    static String [] name =new String[10];
    static String [] secondName =new String[10];
    static String [] date=new String[10];
    static String [] phone =new String[10];
    static String[][] classChoose2= {class1,class2,class3,class4};
    static String [] emp = {"-","-","-","-","-","-","-","-","-","-"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (Spinner) findViewById(R.id.spinner);
        lv = (ListView) findViewById(R.id.list);
        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv3 = (TextView) findViewById(R.id.textView2);
        tv4 = (TextView) findViewById(R.id.textView1);

        spin.setOnItemSelectedListener(this);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,classChoose);
        spin.setAdapter(adp);





    }
// spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Toast.makeText(this, "please choose a class", Toast.LENGTH_LONG).show();
            ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item,emp);
            lv.setAdapter(adp2);
            tv1.setText("name:");
            tv2.setText("second name:");
            tv3.setText("date:");
            tv4.setText("phone:");

        }
        else{
            if (position == 1){
                listOfStudents(1);
            }
            else if (position == 2){
                listOfStudents(2);
            }
            else if (position == 3){
                listOfStudents(3);
            }
            else if (position == 4){
                listOfStudents(4);
            }
            ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item,show);
            lv.setAdapter(adp2);

        }


    }
    public static void listOfStudents(int choose){
        choose-=1;
        for (int i=0;i<10;i++){
            String kid = classChoose2[choose][i];
            int k =0;
            int k2 = 0;
            int action = 0;
            while (k != kid.length()){
                if ('/' == classChoose2[choose][i].charAt(k2) || '/' == classChoose2[choose][i].charAt(k)){
                    if (action == 0){
                        name[i] = classChoose2[choose][i].substring(k2,k);
                    }
                    else if (action == 1){
                        secondName[i] = classChoose2[choose][i].substring(k2,k);
                    }
                    else if (action == 2){
                        date[i] = classChoose2[choose][i].substring(k2,k);
                    }
                    else if (action == 3){
                        phone[i] = classChoose2[choose][i].substring(k,kid.length());
                    }
                    action+=1;
                    k2 = k+1;
                }
                k+=1;
            }
            boolean good = false;
            int w =0;
            while (!good){
                if ('/' == classChoose2[choose][i].charAt(classChoose2[choose][i].length()-1-w)){
                    phone[i] = classChoose2[choose][i].substring(classChoose2[choose][i].length()-w,classChoose2[choose][i].length());
                    good = true;
                }
                w++;
            }
            show[i] = name[i]+" "+secondName[i];

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
// list view
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setText(name[position]);
        tv2.setText(secondName[position]);

        tv3.setText(date[position]);
        tv4.setText(phone[position]);


    }
}