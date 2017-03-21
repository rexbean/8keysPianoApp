package com.example.diymusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener
{

    //声明一些控件
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btn6=null;
    Button btn7=null;
    
    Button btnBackspace=null;
    Button btnPlay=null;
    Button btnDown=null;
    Button btnUp=null;
    TextView tvResult=null;
    //声明两个参数。接收tvResult前后的值
    double num1=0,num2=0;
    double Result=0;//计算结果
    int op=0;//判断操作数，
    boolean isClickEqu=false;//判断是否按了“=”按钮
    private MediaPlayer mp;  
    private int index=0;
    private String[] musicArray=null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从布局文件中获取控件，
        Log.v("1","1");
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        
        btnBackspace=(Button)findViewById(R.id.btnBackspace);
        btnDown=(Button)findViewById(R.id.btnDown);
        btnUp=(Button)findViewById(R.id.btnUp);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        
        
        tvResult=(TextView)findViewById(R.id.tvResult);
        Log.v("1","1");
        //添加监听\
        btnBackspace.setOnClickListener(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        
        btnDown.setOnClickListener(this);
        btnUp.setOnClickListener(this);
        btnPlay.setOnClickListener(this);

    }
    public String[] GetMusic()
    {
    	String music=tvResult.getText().toString();
    	String[] musicArray=music.split(",");
    	return musicArray;
    }
    public void PlayMusic(int index,String[] musicArray)
    {
    	mp.reset();
    	if(musicArray[index].equals("C"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file1);
    	}
    	if(musicArray[index].equals("C#"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file2);
    	}
    	if(musicArray[index].equals("D"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file3);
    	}
    	if(musicArray[index].equals("D#"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file4);
    	}
    	if(musicArray[index].equals("E"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file5);
    	}
    	if(musicArray[index].equals("F"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file6);
    	}
    	if(musicArray[index].equals("F#"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file7);
    	}
    	if(musicArray[index].equals("G"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file8);
    	}
    	if(musicArray[index].equals("G#"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file9);
    	}
    	if(musicArray[index].equals("A"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file10);
    	}
    	if(musicArray[index].equals("A#"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file11);
    	}
    	if(musicArray[index].equals("B"))
    	{
    		mp = MediaPlayer.create(MainActivity.this,com.example.diymusic.R.raw.file12);
    	}
    	
    	try
		{
			if(mp!=null)
			{

        		mp.stop();
        		mp.prepare();
				mp.start();
				mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	      			
	      			@Override
	      			public void onCompletion(MediaPlayer arg0) {
	      				// TODO Auto-generated method stub
	      				nextMusic();
	      			}
	      		});
			}
		}
    	catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    public void nextMusic()
    {
    	index++;
			if(index<musicArray.length)
			{
				PlayMusic(index,musicArray);
			}
			
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        //btnBackspace和CE--------------------
        case R.id.btnBackspace:
            String myStr=tvResult.getText().toString();
            try {
                tvResult.setText(myStr.substring(0, myStr.length()-1));
            } catch (Exception e) {
                tvResult.setText("");
            }

            break;
        case R.id.btnPlay:
            //2015-7-15 
        	
        	mp=new MediaPlayer();

        	musicArray=GetMusic();
        	Log.d(MainActivity.ACTIVITY_SERVICE,"1");
        	PlayMusic(index,musicArray);
            	
           	 
            
        	//tvResult.setText(null);
           
       
        break;
            //btnc--b---------------------------
        case R.id.btn1:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString1=tvResult.getText().toString();
            myString1+="C,";
            tvResult.setText(myString1);
            break;
        case R.id.btn2:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString2=tvResult.getText().toString();
            myString2+="D,";
            tvResult.setText(myString2);
            break;
        case R.id.btn3:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString3=tvResult.getText().toString();
            myString3+="E,";
            tvResult.setText(myString3);
            break;
        case R.id.btn4:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString4=tvResult.getText().toString();
            myString4+="F,";
            tvResult.setText(myString4);
            break;
        case R.id.btn5:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString5=tvResult.getText().toString();
            myString5+="G,";
            tvResult.setText(myString5);
            break;
        case R.id.btn6:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString6=tvResult.getText().toString();
            myString6+="A,";
            tvResult.setText(myString6);
            break;
        case R.id.btn7:
            if(isClickEqu)
            {
                tvResult.setText(null);
                isClickEqu=false;
            }
            String myString7=tvResult.getText().toString();
            myString7+="B,";
            tvResult.setText(myString7);
            break;
       
            //btn+-*/=--------------------------------
        case R.id.btnUp:            
            String myStringAdd=tvResult.getText().toString();
            if(myStringAdd.equals(null))
            {
                return;
            }
            String myString8=tvResult.getText().toString();
            try {
                myString8=myString8.substring(0, myString8.length()-1);
            } catch (Exception e) {
               
            }
            myString8+="#,";
            tvResult.setText(myString8);
            break;

        case R.id.btnDown:
            String myStringSub=tvResult.getText().toString();
            if(myStringSub.equals(null))
            {
                return;
            }
            String myString9=tvResult.getText().toString();
            try {
                myString9=myString9.substring(0, myString9.length()-1);
            } catch (Exception e) {
                
            }
            myString9+="b,";
            tvResult.setText(myString9);
            break;
       

        default:
            break;
        }
    } 
}