package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

         mainBinding.clr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mainBinding.firstInput.setText("");
                 mainBinding.secondInput.setText("");
                 mainBinding.operation.setText("");
                 mainBinding.output.setText("");
             }
         });
         // add
        mainBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("+");
                double fop = 0, sop = 0;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
                if(!mainBinding.secondInput.getText().toString().isEmpty()){
                    sop = Double.parseDouble(mainBinding.secondInput.getText().toString());
                    double res =  fop + sop;
                    mainBinding.output.setText(Double.toString(res));

                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };


            }
        });
        // sub
        mainBinding.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("-");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
                if(!mainBinding.secondInput.getText().toString().isEmpty()){
                    sop = Double.parseDouble(mainBinding.secondInput.getText().toString());
                    double res =  fop - sop;
                    mainBinding.output.setText(Double.toString(res));

                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };


            }
        });
        // mul
        mainBinding.mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("*");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
                if(!mainBinding.secondInput.getText().toString().isEmpty()){
                    sop = Double.parseDouble(mainBinding.secondInput.getText().toString());
                    double res =  fop * sop;
                    mainBinding.output.setText(Double.toString(res));

                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };


            }
        });
        // div
        mainBinding.div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("/");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };

                if(!mainBinding.secondInput.getText().toString().isEmpty()) {
                    sop = Double.parseDouble(mainBinding.secondInput.getText().toString());
                    double res = 0;
                    if (sop != 0) {
                        res = fop / sop;
                        mainBinding.output.setText(Double.toString(res));
                    } else {
                        Toast.makeText(MainActivity.this, "Not divisible", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };


            }
        });

        // mod
        mainBinding.mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("%");
                int fop = 0, sop=0;

                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Integer.parseInt(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
                if(!mainBinding.secondInput.getText().toString().isEmpty()){
                    sop = Integer.parseInt(mainBinding.secondInput.getText().toString());
                    if(sop!=0){
                        int res = fop%sop;
                         mainBinding.output.setText(Integer.toString(res));

                    }else{
                        Toast.makeText(MainActivity.this, "Indefinite", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };


            }
        });


        // square

        mainBinding.squ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("x²");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                    double res =  fop*fop;
                    mainBinding.output.setText(Double.toString(res));
                    mainBinding.secondInput.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        // cube

        mainBinding.cub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("x³");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());

                    double res =  fop*fop*fop;
                    mainBinding.output.setText(Double.toString(res));mainBinding.secondInput.setText("");

                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };

            }
        });
        // cuberoot

        mainBinding.cubRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("³√x");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                    double res = Math.cbrt(fop);
                    mainBinding.output.setText(Double.toString(res));mainBinding.secondInput.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };



            }
        });
        // pow
        mainBinding.pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("x raise to power y");
                double fop = 0, sop = 0;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
                if(!mainBinding.secondInput.getText().toString().isEmpty()){
                    sop =  Double.parseDouble(mainBinding.secondInput.getText().toString());
                    double res = Math.pow(fop,sop);
                    mainBinding.output.setText(Double.toString(res));
                }else{
                    Toast.makeText(MainActivity.this, "Please enter second number.", Toast.LENGTH_SHORT).show();
                };



            }
        });
        // fact
        mainBinding.fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("x!");
                  long fop = 0L, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Integer.parseInt(mainBinding.firstInput.getText().toString());
                    long res =fact(fop);
                    mainBinding.output.setText(Long.toString(res));mainBinding.secondInput.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };

            }
        });
         // log
        mainBinding.log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("log");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                    double res = Math.log(fop);
                    mainBinding.output.setText(Double.toString(res));mainBinding.secondInput.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };

            }
        });

        // root
        mainBinding.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainBinding.operation.setText("√x");
                double fop = 0, sop;
                if(!mainBinding.firstInput.getText().toString().isEmpty()){
                    fop = Double.parseDouble(mainBinding.firstInput.getText().toString());
                    double res = Math.sqrt(fop);
                    mainBinding.output.setText(Double.toString(res));mainBinding.secondInput.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter first number.", Toast.LENGTH_SHORT).show();
                };
            }
        });




    }

    public long fact(long fop) {
        if(fop == 0){
            return 1L;
        }else{
            return fop * fact(fop-1);
        }



    };
}