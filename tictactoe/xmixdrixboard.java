package com.example.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class xmixdrixboard extends View {
    private final int Xcolor;
    private final int Ocolor;
    private final int boardcolor;
    private final int winninglinecolor;
    private boolean winnigline=false;
    private final Paint paint = new Paint();
    private final Gamelocig game;
    private int cz = getWidth() / 3;


    public xmixdrixboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        game=new Gamelocig();
        TypedArray ar = context.getTheme().obtainStyledAttributes(attrs, R.styleable.xmixdrixboard, 0, 0);
        try {
            boardcolor = ar.getInteger(R.styleable.xmixdrixboard_boardcolor, 0);
            Xcolor = ar.getInteger(R.styleable.xmixdrixboard_Xcolor, 0);
            Ocolor = ar.getInteger(R.styleable.xmixdrixboard_Ocolor, 0);
            winninglinecolor = ar.getInteger(R.styleable.xmixdrixboard_winninglinecolor, 0);

        } finally {
            ar.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);


        int dimensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cz = dimensions / 3;
        setMeasuredDimension(dimensions, dimensions);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        drawGameboard(canvas);
      //   drawX(canvas, 2, 2);
        // drawO(canvas,1,1);
    drawMarkers(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x=event.getX();
        float y=event.getY();
        int action= event.getAction();
        if(action==MotionEvent.ACTION_DOWN)
        {int row = (int) Math.ceil(y/cz);
            int col =(int) Math.ceil(x/cz);
if(!winnigline) {
    if (game.updateGameBoard(row, col)) {
        invalidate();
        if (game.winnerCheck()){
            winnigline=true;
            invalidate();
        }
    }
    if (game.getPlayer() % 2 == 0) {
        game.setPlayer(game.getPlayer() - 1);
    } else {
        game.setPlayer(game.getPlayer() + 1);
    }
}
            invalidate();
            return true;
        }
return false;
    }
    private void drawGameboard(Canvas canvas) {
        paint.setColor(boardcolor);
        paint.setStrokeWidth(16);
        for (int i = 1; i < 3; i++) {
            canvas.drawLine(cz * i, 0, cz * i, canvas.getWidth(), paint);
        }

        for (int j = 1; j < 3; j++) {
            canvas.drawLine(0, cz * j, canvas.getWidth(), cz * j, paint);


        }
    }

private void drawMarkers(Canvas canvas){
for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
        if(game.getGameboard()[i][j]!=0){
            if(game.getGameboard()[i][j]!=1){
                drawX(canvas,i,j);
            }else drawO(canvas,i,j);

        }
    }
}
}

private void drawX(Canvas canvas,int row,int col){
        paint.setColor(Xcolor);
        canvas.drawLine((col+1)*cz,row*cz,col*cz,(row+1)*cz,paint);
}
    private void drawO(Canvas canvas,int row,int col){
paint.setColor(Ocolor);
        canvas.drawLine(col*cz,row*cz,(col*cz+cz),row*cz+cz,paint);
    }
    public void setUpgame(Button playAgain, Button home, TextView Display,String[] names){
        game.setPlayAgainButton(playAgain);
        game.setHomeButton(home);
        game.setPlayerturn(Display);
        game.setPlayerNames(names);

    }
    public void reset_Game(){
        game.resretGame();
    }

    }





