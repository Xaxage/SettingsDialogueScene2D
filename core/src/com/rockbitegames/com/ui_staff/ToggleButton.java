//package com.rockbitegames.com.ui_staff;
//
//import com.badlogic.gdx.graphics.g2d.Batch;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
//
//public class ToggleButton extends MyTextButton {
//    private final String onText = "On";
//    private final String offText = "Off";
//    private final ClickListener clickListener;
//    private boolean isClicked = false;
//
//    private NinePatchDrawable nextBackground;
//    private NinePatchDrawable nextBackgroundPressed;
//
//    public ToggleButton(String labelText, NinePatchDrawable background, NinePatchDrawable backgroundPressed,
//                        NinePatchDrawable nextBackground, NinePatchDrawable nextBackgroundPressed) {
//        super(labelText, background, backgroundPressed);
//        this.nextBackground = nextBackground;
//        this.nextBackgroundPressed = nextBackgroundPressed;
//        clickListener = new ClickListener();
//
//    }
//
//    @Override
//    public void draw(Batch batch, float parentAlpha) {
//        super.draw(batch, parentAlpha);
//
//        if(clickListener.isPressed()){
//            if(!isClicked){
//                isClicked = true;
//                buttonTextLabel.setText(onText);
//                setBackground(nextBackground);
//            }else{
//                isClicked = false;
//                buttonTextLabel.setText(offText);
//                buttonTextLabel.setText(onText);
//            }
//        }
//
//
//    }
//}
