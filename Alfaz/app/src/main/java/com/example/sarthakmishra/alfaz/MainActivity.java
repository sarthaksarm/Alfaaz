package com.example.sarthakmishra.alfaz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
 Button play,pause,stop;
MediaPlayer mediaPlayer;
int curpos,curpospro;
TextView songnametxt,songauthortxt;
CircularImageView circularImageView;
    SeekBar seekBar;
Runnable runnable;
    Handler handler;
    TextView starttime,endtime;
    int min,sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.btn_play);
        pause=findViewById(R.id.btn_pause);
        stop=findViewById(R.id.btn_stop);
        songnametxt=findViewById(R.id.songname);
        songauthortxt=findViewById(R.id.songauthor);
        circularImageView=findViewById(R.id.circularImageView);
        seekBar=findViewById(R.id.seekbar);
        starttime=findViewById(R.id.start);
        endtime=findViewById(R.id.end);

        handler=new Handler();

        final String songname=getIntent().getStringExtra("songname");
        String songdetails=getIntent().getStringExtra("songdetails");

        play(songname);
        songnametxt.setText(songname);
        songauthortxt.setText(songdetails);
        if(songname.equalsIgnoreCase("wakhra swag")) {
           Picasso.with(MainActivity.this).load(R.drawable.wakhraswag).into(circularImageView);
        }

        else if(songname.equalsIgnoreCase("baapu zimidar")) {
            Picasso.with(MainActivity.this).load(R.drawable.bapuzimi).into(circularImageView);
        }
        else if(songname.equalsIgnoreCase("yaarr ni milyaa")) {
            Picasso.with(MainActivity.this).load(R.drawable.yaarnimileya).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("qismat")) {
            Picasso.with(MainActivity.this).load(R.drawable.qismat).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("girls like you")) {
            Picasso.with(MainActivity.this).load(R.drawable.girlslikeyou).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("gaal ni kadni")) {
            Picasso.with(MainActivity.this).load(R.drawable.gaalnikadni).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("paniyon sa")) {
            Picasso.with(MainActivity.this).load(R.drawable.paniyonsa).into(circularImageView);


        }
        else if(songname.equalsIgnoreCase("piya hazi ali")) {
            Picasso.with(MainActivity.this).load(R.drawable.piyahaziali).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("afreen afreen")) {
            Picasso.with(MainActivity.this).load(R.drawable.afreen).into(circularImageView);


        }
        else if(songname.equalsIgnoreCase("tajdar-e-haram")) {
            Picasso.with(MainActivity.this).load(R.drawable.tajdareharam).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("socha hai")) {
            Picasso.with(MainActivity.this).load(R.drawable.sochahai).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("badnam")) {
            Picasso.with(MainActivity.this).load(R.drawable.badnam).into(circularImageView);

        }
        else if(songname.equalsIgnoreCase("yaraan piche")) {
            Picasso.with(MainActivity.this).load(R.drawable.yaraanpeeche).into(circularImageView);


        }
        else if(songname.equalsIgnoreCase("sultan")) {
            Picasso.with(MainActivity.this).load(R.drawable.sultan).into(circularImageView);

        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(songname);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
    }

    public void changeseekbar()
    {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying())
        {
         runnable=new Runnable() {
             @Override
             public void run() {
                    changeseekbar();
                    sec=seekBar.getProgress()/1000;
                    starttime.setText(sec/60+":"+sec%60);
             }
         };
            handler.postDelayed(runnable,1000);
        }

    }
    public void play(String musicname)
    {
        if(mediaPlayer==null)
        {
            if(musicname.equalsIgnoreCase("wakhra swag")) {

                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.wakhraswag);

               mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                   @Override
                   public void onPrepared(MediaPlayer mediaPlayer) {
                       seekBar.setMax(mediaPlayer.getDuration());
                       sec=mediaPlayer.getDuration()/1000;
                       endtime.setText(sec/60+":"+sec%60);
                       starttime.setText("00:00");

                       mediaPlayer.start();
                       changeseekbar();
                   }
               });

               seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                   @Override
                   public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                       if(b)
                       {
                           sec=i/1000;
                           starttime.setText(sec/60+":"+sec%60);
                           mediaPlayer.seekTo(i);
                       }
                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {

                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {

                   }
               });
               }

            else if(musicname.equalsIgnoreCase("baapu zimidar")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.bapuzimidar);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("yaarr ni milyaa")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.yaarrnimileya);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("qismat")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.qismat);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("girls like you")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.girlslikeyou);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("gaal ni kadni")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.gaalnikadni);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("paniyon sa")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.paniyonsa);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("piya hazi ali")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.piyahaziali);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("afreen afreen")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.afreen);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("tajdar-e-haram")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.tajdareharam);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("socha hai")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sochahai);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("badnam")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.badnam);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("yaraan piche")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.yaraanpiche);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            else if(musicname.equalsIgnoreCase("sultan")) {
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.sultan);

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        seekBar.setMax(mediaPlayer.getDuration());
                        sec=mediaPlayer.getDuration()/1000;
                        endtime.setText(sec/60+":"+sec%60);
                        starttime.setText("00:00");

                        mediaPlayer.start();
                        changeseekbar();
                    }
                });

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        if(b)
                        {
                            sec=i/1000;
                            starttime.setText(sec/60+":"+sec%60);
                            mediaPlayer.seekTo(i);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        }
        else if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.seekTo(curpos);
            mediaPlayer.start();
        }
    }
    public void pause()
    {
        if(mediaPlayer!=null){

        curpos=mediaPlayer.getCurrentPosition();
        mediaPlayer.pause();

        }
    }
    public void stop()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
            starttime.setText("00:00");
            endtime.setAlpha(0);
            Intent i=new Intent(MainActivity.this,Home.class);
            startActivity(i);
        }

    }

    @Override
    public void onBackPressed() {

        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
            Intent i=new Intent(MainActivity.this,Home.class);
            startActivity(i);
        }

        super.onBackPressed();
    }
}
